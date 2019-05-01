package com.scolvo.homework.service.validation;

import com.google.common.base.Strings;
import com.scolvo.homework.domain.Address;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressValidator {

    public boolean isValid(@NonNull Address address) {
        return !Strings.isNullOrEmpty(address.getCity()) &&
                !Strings.isNullOrEmpty(address.getPostalCode());
    }

    public String getInvalidMessage(@NonNull Address address) {
        List<String> errors = new ArrayList<>();

        if (Strings.isNullOrEmpty(address.getCity())) {
            errors.add("City is null or empty.");
        }

        if (Strings.isNullOrEmpty(address.getPostalCode())) {
            errors.add("PostalCode is null or empty.");
        }

        return errors.stream().collect(Collectors.joining(" "));
    }
}
