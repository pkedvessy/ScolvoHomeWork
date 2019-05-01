package com.scolvo.homework.repository;

import com.scolvo.homework.repository.entities.Address;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddressRepositoryImplTest {

    private AddressRepositoryImpl victim;

    @Before
    public void initTests() {
        victim = new AddressRepositoryImpl();
    }

    @Test
    public void shouldInsert() {
        Address address = new Address(1, "PostalCode", "City", "Address");

        String actual = victim.upsert(address);
        assertEquals("Insert done", actual);

        assertEquals(address, victim.get(address.getId()).get());
    }

    @Test
    public void shouldUpdate() {
        Address address = new Address(1, "PostalCode", "City", "Address");
        Address address2 = new Address(1, "PostalCode2", "City2", "Address2");

        victim.upsert(address);
        String actual = victim.upsert(address2);
        assertEquals("Update done", actual);

        assertEquals(address2, victim.get(address.getId()).get());
    }
}