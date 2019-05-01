package com.scolvo.homework.web;

import com.scolvo.homework.api.ClientAddress;
import com.scolvo.homework.converter.ClientAddressConverter;
import com.scolvo.homework.service.ClientAddressService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller to handle {@link com.scolvo.homework.api.ClientAddress} related operations.
 */
@RestController
public class ClientAddressController {

    @Autowired
    private ClientAddressService clientAddressService;
    @Autowired
    private ClientAddressConverter clientAddressConverter;

    /**
     * Retrieves client addresses
     * @return Client addresses list
     */
    @RequestMapping(value = "/addresses", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves client addresses")
    public @ResponseBody
    List<ClientAddress> getAddresses() {
        return clientAddressService.getClientAddresses().stream()
                .map(clientAddressConverter::conver)
                .collect(Collectors.toList());
    }
}
