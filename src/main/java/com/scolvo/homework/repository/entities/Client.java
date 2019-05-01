package com.scolvo.homework.repository.entities;

import java.util.List;
import java.util.Objects;

/**
 * Client POJO for persistance.
 */
public class Client {

    private final int id;
    private final List<Integer> addressIds;

    /**
     * Constructor
     * @param id Entity ID
     * @param addressIds Address IDs
     */
    public Client(int id, List<Integer> addressIds) {
        this.id = id;
        this.addressIds = addressIds;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getAddressIds() {
        return addressIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(addressIds, client.addressIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addressIds);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", addressIds=" + addressIds +
                '}';
    }
}
