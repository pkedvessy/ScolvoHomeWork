package com.scolvo.homework.repository;

import com.scolvo.homework.repository.entities.Client;

import java.util.List;
import java.util.Map;

/**
 * Interface for {@link com.scolvo.homework.repository.entities.Client} related operations.
 */
public interface ClientRepository {

    /**
     * Insert or update {@link com.scolvo.homework.repository.entities.Client} entity.
     * @param client {@link Client}
     * @return Result
     */
    String upsert(Client client);

    /**
     * Retrieves {@link com.scolvo.homework.repository.entities.Client}s from the repository
     * @return Result
     */
    List<Client> get();
}
