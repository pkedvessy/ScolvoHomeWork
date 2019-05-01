package com.scolvo.homework.domain;

import java.util.List;
import java.util.Objects;

/**
 * Client POJO for internal processing.
 */
public class Client {

    private final List<Integer> addressIds;

    /**
     * Constructor
     * @param addressIds Address IDs
     */
    public Client(List<Integer> addressIds) {
        this.addressIds = addressIds;
    }

    public List<Integer> getAddressIds() {
        return addressIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(addressIds, client.addressIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressIds);
    }

    @Override
    public String toString() {
        return "Client{" +
                "addressIds=" + addressIds +
                '}';
    }
}
