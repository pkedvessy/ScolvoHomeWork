package com.scolvo.homework.repository;

import com.scolvo.homework.repository.entities.Client;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClientRepositoryImplTest {

    private ClientRepositoryImpl victim;

    @Before
    public void initTest() {
        victim = new ClientRepositoryImpl();
    }

    @Test
    public void shouldInsert() {
        Client client = new Client(1, asList(1, 2));

        String actual = victim.upsert(client);
        assertEquals("Insert done", actual);

        assertTrue(victim.get().contains(client));
    }

    @Test
    public void shouldUpdate() {
        Client client = new Client(1, asList(1, 2));
        Client client2 = new Client(1, asList(2, 3));

        victim.upsert(client);
        String actual = victim.upsert(client2);
        assertEquals("Update done", actual);

        assertFalse(victim.get().contains(client));
        assertTrue(victim.get().contains(client2));
    }
}