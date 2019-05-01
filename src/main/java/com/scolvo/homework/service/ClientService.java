package com.scolvo.homework.service;

import com.scolvo.homework.domain.Client;
import com.scolvo.homework.domain.IdWithResult;
import com.scolvo.homework.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Service to handle {@link Client} related operations.
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    /**
     * Upsert clients.
     * @param clients {@link Map} where the key is the ID of the given {@link Client}
     * @return Upsert result for each entries
     */
    public Map<Integer, String> upsert(Map<Integer, Client> clients) {
        return clients.entrySet().stream()
                .filter(e -> Objects.nonNull(e.getValue()))
                .map(e -> new com.scolvo.homework.repository.entities.Client(e.getKey(), e.getValue().getAddressIds()))
                .map(c -> new IdWithResult(c.getId(), clientRepository.upsert(c)))
                .collect(Collectors.toMap(c -> c.getId(), c -> c.getResult()));
    }
}
