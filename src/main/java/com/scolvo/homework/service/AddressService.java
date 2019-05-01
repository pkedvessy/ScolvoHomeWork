package com.scolvo.homework.service;

import com.scolvo.homework.domain.Address;
import com.scolvo.homework.domain.AddressWithValidity;
import com.scolvo.homework.domain.IdWithResult;
import com.scolvo.homework.repository.AddressRepository;
import com.scolvo.homework.service.validation.AddressValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Service to handle {@link Address} related operations.
 */
@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressValidator addressValidator;

    /**
     * Upsert adresses.
     * @param addresses {@link Map} where the key is the ID of the given {@link Address}
     * @return Upsert result for each entries
     */
    public Map<Integer, String> upsert(@NonNull Map<Integer, Address> addresses) {

        Map<Boolean, List<AddressWithValidity>> addressPartitionsByValidity = addresses.entrySet().stream()
                .filter(e -> Objects.nonNull(e.getValue()))
                .map(e -> new AddressWithValidity(e.getKey(), e.getValue(), addressValidator.isValid(e.getValue())))
                .collect(Collectors.partitioningBy(AddressWithValidity::isValid));


        Map<Integer, String> result = new HashMap<>(addresses.size());
        result.putAll(saveAndGetResult(addressPartitionsByValidity.get(true)));
        result.putAll(getInvalidMessages(addressPartitionsByValidity.get(false)));

        return result;
    }

    private Map<Integer, String> saveAndGetResult(List<AddressWithValidity> addresses) {
        return addresses.stream()
                .map(a -> new com.scolvo.homework.repository.entities.Address(a.getId(), a.getAddress().getPostalCode(), a.getAddress().getCity(), a.getAddress().getAddress()))
                .map(a -> new IdWithResult(a.getId(), addressRepository.upsert(a)))
                .collect(Collectors.toMap(a -> a.getId(), a -> a.getResult()))
        ;
    }

    private Map<Integer, String> getInvalidMessages(List<AddressWithValidity> addresses) {
        return addresses.stream()
                .map(a -> new IdWithResult(a.getId(), addressValidator.getInvalidMessage(a.getAddress())))
                .collect(Collectors.toMap(IdWithResult::getId, IdWithResult::getResult));
    }
}
