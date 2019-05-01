package com.scolvo.homework.converter;

import com.scolvo.homework.domain.ClientAddress;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ClientAddressConverterTest {

    private ClientAddressConverter victim;

    @Before
    public void initTests() {
        victim = new ClientAddressConverter();
    }

    @Test
    public void shouldConvert() {
        ClientAddress clientAddress = new ClientAddress(1, Arrays.asList("address 1", "address 2"));

        com.scolvo.homework.api.ClientAddress actual = victim.conver(clientAddress);

        assertEquals(clientAddress.getClientId(), actual.getClientId());
        assertEquals(clientAddress.getAddresses(), actual.getAddresses());
    }
}