package com.scolvo.homework.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * Adress POJO for the API.
 */
public class Address {

    @JsonProperty("PostalCode")
    @ApiModelProperty(example = "6727")
    private String postalCode;

    @JsonProperty("City")
    @ApiModelProperty(example = "Szeged")
    private String city;

    @JsonProperty("Address")
    @ApiModelProperty(example = "Cserfa utca 2/E 2")
    private String address;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
