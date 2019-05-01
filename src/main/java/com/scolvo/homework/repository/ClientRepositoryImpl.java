package com.scolvo.homework.repository;

import com.scolvo.homework.repository.entities.Client;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * {@link ClientRepository} implementation.
 */
@Repository
public class ClientRepositoryImpl implements ClientRepository {

    Map<Integer, Client> repository;

    public ClientRepositoryImpl() {
        repository = new ConcurrentHashMap<>();
    }

    @Override
    public String upsert(Client client) {
        boolean entityExists = repository.containsKey(client.getId());

        repository.put(client.getId(), client);

        return entityExists ? "Update done": "Insert done";
    }

    @Override
    public List<Client> get() {
        return repository.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
