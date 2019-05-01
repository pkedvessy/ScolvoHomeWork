package com.scolvo.homework.repository;

import com.scolvo.homework.repository.entities.Address;

import java.util.Map;
import java.util.Optional;

/**
 * Interface for {@link com.scolvo.homework.repository.entities.Address} related operations.
 */
public interface AddressRepository {

    /**
     * Insert or update {@link com.scolvo.homework.repository.entities.Address} entity.
     * @param address {@link Address}
     * @return Result
     */
    String upsert(Address address);

    /**
     * Retrieves an {@link com.scolvo.homework.repository.entities.Address} entity as an {@link Optional}
     * @param id Address id
     * @return Result
     */
    Optional<Address> get(int id);
}
