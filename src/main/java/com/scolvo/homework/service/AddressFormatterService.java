package com.scolvo.homework.service;

import com.google.common.base.Strings;
import com.scolvo.homework.repository.entities.Address;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class AddressFormatterService {

    /**
     * Retrieves the string representation of the given {@link com.scolvo.homework.domain.Address}
     * @param address
     * @return Result
     */
    public String getAddressAsString(@NonNull Address address) {
        StringBuffer sb = new StringBuffer();
        sb.append(address.getPostalCode());
        sb.append(' ');
        sb.append(address.getCity());
        if (!Strings.isNullOrEmpty(address.getAddress())) {
            sb.append(", ");
            sb.append(address.getAddress());
        }

        return sb.toString();
    }
}
