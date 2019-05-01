package com.scolvo.homework.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Objects;

/**
 * Client POJO for the API.
 */
public class Client {

    @JsonProperty("addressIds")
    @ApiModelProperty(example = "[1, 2, 3]")
    private List<Integer> addressIds;

    public List<Integer> getAddressIds() {
        return addressIds;
    }

    public void setAddressIds(List<Integer> addressIds) {
        this.addressIds = addressIds;
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
