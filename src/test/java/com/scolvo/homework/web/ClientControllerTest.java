package com.scolvo.homework.web;

import com.scolvo.homework.api.Client;
import com.scolvo.homework.converter.ClientConverter;
import com.scolvo.homework.service.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ClientControllerTest {
    @Mock
    private ClientService clientService;
    @Mock
    private ClientConverter clientConverter;

    @Mock
    private Client client1;
    @Mock
    private Client client2;

    @Mock
    private com.scolvo.homework.domain.Client convertedClient1;
    @Mock
    private com.scolvo.homework.domain.Client convertedClient2;

    @InjectMocks
    private ClientController victim;

    @Before
    public void initTests() {
        initMocks(this);
    }

    @Test
    public void shouldConvertRequestParamsAndCallClientServiceInCaseOfNonNullMapValue() {
        Map<Integer, Client> data = new HashMap<>();
        data.put(1, client1);
        data.put(2, client2);
        data.put(3, null);

        Map<Integer, com.scolvo.homework.domain.Client> expectedServiceParameter = new HashMap<>();
        expectedServiceParameter.put(1, convertedClient1);
        expectedServiceParameter.put(2, convertedClient2);

        Map<Integer, String> expected = mock(Map.class);

        when(clientConverter.convert(client1)).thenReturn(convertedClient1);
        when(clientConverter.convert(client2)).thenReturn(convertedClient2);
        when(clientService.upsert(expectedServiceParameter)).thenReturn(expected);

        Map<Integer, String> actual = victim.postClients(data);

        assertEquals(expected, actual);
    }
}