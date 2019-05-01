package com.scolvo.homework.web;

import com.scolvo.homework.converter.ClientAddressConverter;
import com.scolvo.homework.domain.ClientAddress;
import com.scolvo.homework.service.ClientAddressService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ClientAddressControllerTest {

    @Mock
    private ClientAddressService clientAddressService;
    @Mock
    private ClientAddressConverter clientAddressConverter;

    @Mock
    private ClientAddress clientAddress1;
    @Mock
    private ClientAddress clientAddress2;

    @Mock
    private com.scolvo.homework.api.ClientAddress convertedClientAddress1;
    @Mock
    private com.scolvo.homework.api.ClientAddress convertedClientAddress2;


    @InjectMocks
    private ClientAddressController victim;

    @Before
    public void initTests() {
        initMocks(this);
    }

    @Test
    public void shouldCallClientAddressServiceAndConvertTheResult() {
        List<ClientAddress> clientAddresses = asList(clientAddress1, clientAddress2);

        when(clientAddressService.getClientAddresses()).thenReturn(clientAddresses);
        when(clientAddressConverter.conver(clientAddress1)).thenReturn(convertedClientAddress1);
        when(clientAddressConverter.conver(clientAddress2)).thenReturn(convertedClientAddress2);

        List<com.scolvo.homework.api.ClientAddress> expected = asList(convertedClientAddress1, convertedClientAddress2);

        List<com.scolvo.homework.api.ClientAddress> actual = victim.getAddresses();

        Assert.assertEquals(expected, actual);
    }
}