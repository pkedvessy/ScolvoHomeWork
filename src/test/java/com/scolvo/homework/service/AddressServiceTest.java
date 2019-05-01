package com.scolvo.homework.service;

import com.scolvo.homework.domain.Address;
import com.scolvo.homework.repository.AddressRepository;
import com.scolvo.homework.service.validation.AddressValidator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;
    @Mock
    private AddressValidator addressValidator;

    @Mock
    private Address invalidAddress;

    @InjectMocks
    private AddressService victim;

    @Before
    public void initTests() {
        initMocks(this);
    }

    @Test
    public void shouldCallRepositoryLayerWithValidAddresses() {
        Address validAddress = new Address("PostalCode", "City", "Address");
        com.scolvo.homework.repository.entities.Address repositoryAddress
                = new com.scolvo.homework.repository.entities.Address(1, validAddress.getPostalCode(), validAddress.getCity(), validAddress.getAddress());

        when(addressValidator.isValid(validAddress)).thenReturn(true);
        when(addressRepository.upsert(repositoryAddress)).thenReturn("OK");

        Map<Integer, Address> addresses = new HashMap<>();
        addresses.put(1, validAddress);

        Map<Integer, String> actual = victim.upsert(addresses);
        Map<Integer, String> expected = new HashMap<>();
        expected.put(1, "OK");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotCallRepositoryLayerWithInvalidAddresses() {
        when(addressValidator.isValid(invalidAddress)).thenReturn(false);
        when(addressValidator.getInvalidMessage(invalidAddress)).thenReturn("invalid");

        Map<Integer, Address> addresses = new HashMap<>();
        addresses.put(2, invalidAddress);

        Map<Integer, String> actual = victim.upsert(addresses);
        Map<Integer, String> expected = new HashMap<>();
        expected.put(2, "invalid");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotProcessNullValues() {
        Map<Integer, Address> addresses = new HashMap<>();
        addresses.put(1, null);

        Map<Integer, String> expected = Collections.emptyMap();
        Map<Integer, String> actual = victim.upsert(addresses);

        assertEquals(expected, actual);
    }
}