package com.scolvo.homework.domain;

import java.util.Objects;

/**
 * Address POJO for internal processing.
 */
public class Address {

    private final String postalCode;
    private final String city;
    private final String address;

    /**
     * Constructor
     * @param postalCode Portal Code
     * @param city City
     * @param address Address
     */
    public Address(String postalCode, String city, String address) {
        this.postalCode = postalCode;
        this.city = city;
        this.address = address;
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
        return Objects.equals(postalCode, address1.postalCode) &&
                Objects.equals(city, address1.city) &&
                Objects.equals(address, address1.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postalCode, city, address);
    }

    @Override
    public String toString() {
        return "Address{" +
                "postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
