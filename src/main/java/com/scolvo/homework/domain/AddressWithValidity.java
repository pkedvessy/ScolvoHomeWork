package com.scolvo.homework.domain;

import java.util.Objects;

public class AddressWithValidity {

    private final int id;
    private final Address address;
    private final boolean valid;

    public AddressWithValidity(int id, Address address, boolean valid) {
        this.id = id;
        this.address = address;
        this.valid = valid;
    }

    public int getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public boolean isValid() {
        return valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressWithValidity that = (AddressWithValidity) o;
        return valid == that.valid &&
                Objects.equals(address, that.address) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, valid);
    }

    @Override
    public String toString() {
        return "AddressWithValidity{" +
                "id=" + id +
                ",address=" + address +
                ", valid=" + valid +
                '}';
    }
}
