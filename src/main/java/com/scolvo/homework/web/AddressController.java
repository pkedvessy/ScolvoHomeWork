package com.scolvo.homework.web;

import com.scolvo.homework.api.Address;
import com.scolvo.homework.converter.AddressConverter;
import com.scolvo.homework.service.AddressService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Controller to handle {@link Address} related operations.
 */
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private AddressConverter addressConverter;

    /**
     * Update or insert {@link Address}
     * @param addresses {@link Map} where the key is the ID of the given {@link Address}
     * @return Upsert result for each entries
     */
    @RequestMapping(value = "/addresses", method = RequestMethod.POST)
    @ApiOperation(value = "Persists addresses from external source")
    public @ResponseBody Map<Integer, String> postAddresses(@RequestBody Map<Integer, Address> addresses) {
        return addressService.upsert(
                addresses.entrySet().stream()
                        .filter(e -> Objects.nonNull(e.getValue()))
                        .collect(Collectors.toMap(Map.Entry::getKey, e -> addressConverter.convert(e.getValue())))
        );
    }
}
