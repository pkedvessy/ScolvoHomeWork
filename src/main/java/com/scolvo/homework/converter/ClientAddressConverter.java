package com.scolvo.homework.converter;

import com.scolvo.homework.api.ClientAddress;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * Converter for internal data processing.
 */
@Component
public class ClientAddressConverter {

    /**
     * Converts internal POJO to an API one.
     * @param clientAddress
     * @return API object
     */
    public ClientAddress conver(@NonNull com.scolvo.homework.domain.ClientAddress clientAddress) {
        return new ClientAddress(clientAddress.getClientId(), clientAddress.getAddresses());
    }
}
