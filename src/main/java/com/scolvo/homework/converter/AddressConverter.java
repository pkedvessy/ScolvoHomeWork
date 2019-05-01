package com.scolvo.homework.converter;

import com.scolvo.homework.domain.Address;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * Converter for internal data processing.
 */
@Component
public class AddressConverter {

    /**
     * Converts API POJO to an internal one.
     * @param address
     * @return Domain object
     */
    public Address convert(@NonNull com.scolvo.homework.api.Address address) {
        return new Address(address.getPostalCode(), address.getCity(), address.getAddress());
    }
}
