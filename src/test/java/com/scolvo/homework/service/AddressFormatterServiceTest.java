package com.scolvo.homework.service;


import com.scolvo.homework.repository.entities.Address;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddressFormatterServiceTest {

    private AddressFormatterService victim;

    @Before
    public void initTests() {
        victim = new AddressFormatterService();
    }

    @Test
    public void shouldRetrieveAddressAsStringWithoutAddress() {
        Address address = new Address(1, "postal code", "city", null);

        String expected = "postal code city";
        String actual = victim.getAddressAsString(address);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldRetrieveAddressAsStringWithAddress() {
        Address address = new Address(1, "postal code", "city", "address");

        String expected = "postal code city, address";
        String actual = victim.getAddressAsString(address);

        assertEquals(expected, actual);
    }
}