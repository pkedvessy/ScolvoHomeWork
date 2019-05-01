package com.scolvo.homework.repository;

import com.scolvo.homework.repository.entities.Address;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * {@link AddressRepository} implementation.
 */
@Repository
public class AddressRepositoryImpl implements AddressRepository {

    Map<Integer, Address> repository;

    public AddressRepositoryImpl() {
        repository = new ConcurrentHashMap<>();
    }

    @Override
    public String upsert(Address address) {
        boolean entityExists = repository.containsKey(address.getId());

        repository.put(address.getId(), address);

        return entityExists ? "Update done": "Insert done";
    }

    @Override
    public Optional<Address> get(int id) {
        return Optional.ofNullable(repository.get(id));
    }
}
