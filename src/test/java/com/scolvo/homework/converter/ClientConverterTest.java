package com.scolvo.homework.converter;

import com.scolvo.homework.api.Client;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ClientConverterTest {

    private ClientConverter victim;

    @Before
    public void initTests() {
        victim = new ClientConverter();
    }

    @Test
    public void shouldConvert() {
        Client apiClient = new Client();
        apiClient.setAddressIds(Arrays.asList(1, 2));

        com.scolvo.homework.domain.Client actual = victim.convert(apiClient);

        assertEquals(apiClient.getAddressIds(), actual.getAddressIds());
    }
}