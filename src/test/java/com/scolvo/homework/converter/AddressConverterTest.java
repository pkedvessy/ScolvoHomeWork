package com.scolvo.homework.converter;

import com.scolvo.homework.api.Address;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddressConverterTest {

    private AddressConverter victim;

    @Before
    public void intiTests() {
        victim = new AddressConverter();
    }

    @Test
    public void shouldConvert() {
        Address apiAddress = new Address();
        apiAddress.setPostalCode("Postal Code");
        apiAddress.setCity("City");
        apiAddress.setAddress("Address");

        com.scolvo.homework.domain.Address actual = victim.convert(apiAddress);

        assertEquals(apiAddress.getPostalCode(), actual.getPostalCode());
        assertEquals(apiAddress.getCity(), actual.getCity());
        assertEquals(apiAddress.getAddress(), actual.getAddress());
    }
}