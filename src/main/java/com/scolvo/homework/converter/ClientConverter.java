package com.scolvo.homework.converter;

import com.scolvo.homework.domain.Client;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * Converter for internal data processing.
 */
@Component
public class ClientConverter {

    /**
     * Converts POJO to an internal one.
     * @param client
     * @return Domain object
     */
    public Client convert(@NonNull com.scolvo.homework.api.Client client) {
        return new Client(client.getAddressIds());
    }
}
