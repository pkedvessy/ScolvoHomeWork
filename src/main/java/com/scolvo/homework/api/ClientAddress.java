package com.scolvo.homework.api;

import java.util.List;
import java.util.Objects;

public class ClientAddress {

    private final int clientId;
    private final List<String> addresses;

    public ClientAddress(int clientId, List<String> addresses) {
        this.clientId = clientId;
        this.addresses = addresses;
    }

    public int getClientId() {
        return clientId;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientAddress that = (ClientAddress) o;
        return clientId == that.clientId &&
                Objects.equals(addresses, that.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, addresses);
    }

    @Override
    public String toString() {
        return "ClientAddress{" +
                "clientId=" + clientId +
                ", addresses=" + addresses +
                '}';
    }
}
