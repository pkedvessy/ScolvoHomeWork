package com.scolvo.homework.service;

import com.scolvo.homework.domain.ClientAddress;
import com.scolvo.homework.repository.AddressRepository;
import com.scolvo.homework.repository.ClientRepository;
import com.scolvo.homework.repository.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientAddressService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressFormatterService addressFormatterService;

    public List<ClientAddress> getClientAddresses() {
        List<Client> client = clientRepository.get();

        return client.stream().map(c -> new ClientAddress(c.getId(), c.getAddressIds().stream()
                        .map(ai -> addressRepository.get(ai))
                        .filter(ai -> ai.isPresent()).map(Optional::get)
                        .map(addressFormatterService::getAddressAsString)
                        .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

}
