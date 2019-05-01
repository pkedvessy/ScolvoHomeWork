package com.scolvo.homework.service;

import com.scolvo.homework.domain.Client;
import com.scolvo.homework.repository.ClientRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService victim;

    @Before
    public void initTests() {
        initMocks(this);
    }

    @Test
    public void shouldCallRepositoryLayerWithClients() {
        Client client = new Client(asList(2));

        Map<Integer, Client> clients = new HashMap<>();
        clients.put(1, client);

        when(clientRepository.upsert(new com.scolvo.homework.repository.entities.Client(1, client.getAddressIds()))).thenReturn("OK");

        Map<Integer, String> actual = victim.upsert(clients);
        Map<Integer, String> expected = new HashMap<>();
        expected.put(1, "OK");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotCallRepositoryLayerWithNullClient() {
        Map<Integer, Client> clients = new HashMap<>();
        clients.put(1, null);

        Map<Integer, String> actual = victim.upsert(clients);
        Map<Integer, String> expected = emptyMap();

        assertEquals(expected, actual);
    }
}