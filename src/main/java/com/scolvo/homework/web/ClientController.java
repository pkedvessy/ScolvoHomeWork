package com.scolvo.homework.web;

import com.scolvo.homework.api.Client;
import com.scolvo.homework.converter.ClientConverter;
import com.scolvo.homework.service.ClientService;
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
 * Controller to handle {@link Client} related operations.
 */
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientConverter clientConverter;

    /**
     * Update or insert {@link Client}
     * @param clients {@link Map} where the key is the ID of the given {@link Client}
     * @return Upsert result for each entries
     */
    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    @ApiOperation(value = "Persists clients from external source")
    public @ResponseBody Map<Integer, String> postClients(@RequestBody Map<Integer, Client> clients) {
        return clientService.upsert(
                clients.entrySet().stream()
                        .filter(e -> Objects.nonNull(e.getValue()))
                        .collect(Collectors.toMap(Map.Entry::getKey, e -> clientConverter.convert(e.getValue())))
        );
    }
}
