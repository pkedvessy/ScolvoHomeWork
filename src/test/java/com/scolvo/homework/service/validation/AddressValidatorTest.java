package com.scolvo.homework.service.validation;

import com.scolvo.homework.domain.Address;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddressValidatorTest {

    private AddressValidator victim;

    @Before
    public void initTests() {
        victim = new AddressValidator();
    }

    @Test
    public void addressWithoutCityShouldBeInvalid() {
        Address address = new Address("PostCode", null, null);

        assertFalse(victim.isValid(address));
    }

    @Test
    public void addressWithoutPostCodeShouldBeInvalid() {
        Address address = new Address(null, "City", null);

        assertFalse(victim.isValid(address));
    }

    @Test
    public void addressWithoutCityAndPostCodeShouldBeInvalid() {
        Address address = new Address(null, null, null);

        assertFalse(victim.isValid(address));
    }

    @Test
    public void addressWithCityAndPostCodeShouldBeValid() {
        Address address = new Address("PostCode", "City", null);

        assertTrue(victim.isValid(address));
    }

    @Test
    public void shouldRetrieveInvalidMessageInCaseOfMissingPostalCode() {
        Address address = new Address(null, "City", null);

        String actual = victim.getInvalidMessage(address);
        String expected = "PostalCode is null or empty.";

        assertEquals(expected, actual);
    }

    @Test
    public void shouldRetrieveInvalidMessageInCaseOfMissingCity() {
        Address address = new Address("PostalCode", null, null);

        String actual = victim.getInvalidMessage(address);
        String expected = "City is null or empty.";

        assertEquals(expected, actual);
    }

    @Test
    public void shouldRetrieveInvalidMessageInCaseOfMissingCityAndPostalCode() {
        Address address = new Address(null, null, null);

        String actual = victim.getInvalidMessage(address);
        String expected = "City is null or empty. PostalCode is null or empty.";

        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRetrieveInvalidMessageInCaseOfValidAddress() {
        Address address = new Address("PostalCode", "City", null);

        String actual = victim.getInvalidMessage(address);
        String expected = "";

        assertEquals(expected, actual);
    }
}