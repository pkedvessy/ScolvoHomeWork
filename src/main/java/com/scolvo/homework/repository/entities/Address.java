package com.scolvo.homework.repository.entities;

import java.util.Objects;

/**
 * Address POJO for persistance.
 */
public class Address {

    private final int id;
    private final String postalCode;
    private final String city;
    private final String address;

    /**
     * Constructor
     * @param id ID
     * @param postalCode Portal Code
     * @param city City
     * @param address Address
     */
    public Address(int id, String postalCode, String city, String address) {
        this.id = id;
        this.postalCode = postalCode;
        this.city = city;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return id == address1.id &&
                Objects.equals(postalCode, address1.postalCode) &&
                Objects.equals(city, address1.city) &&
                Objects.equals(address, address1.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postalCode, city, address);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
