package com.scolvo.homework.service;

import com.scolvo.homework.domain.ClientAddress;
import com.scolvo.homework.repository.AddressRepository;
import com.scolvo.homework.repository.ClientRepository;
import com.scolvo.homework.repository.entities.Address;
import com.scolvo.homework.repository.entities.Client;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ClientAddressServiceTest {

    @Mock
    private ClientRepository clientRepository;
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private AddressFormatterService addressFormatterService;

    @InjectMocks
    private ClientAddressService victim;

    @Before
    public void initTests() {
        initMocks(this);

        when(addressRepository.get(Mockito.anyInt())).thenReturn(Optional.empty());
    }

    @Test
    public void shouldReturnClientAddressesAndSkipMissingAddressLines() {
        Client client = new Client(1, Arrays.asList(2, 3));
        Address address = mock(Address.class);

        when(clientRepository.get()).thenReturn(Arrays.asList(client));
        when(addressRepository.get(2)).thenReturn(Optional.of(address));
        when(addressFormatterService.getAddressAsString(address)).thenReturn("address");

        List<ClientAddress> actual = victim.getClientAddresses();
        List<ClientAddress> expected = Arrays.asList(new ClientAddress(1, Arrays.asList("address")));

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnClientAddressesWithEmptyAddressListWhenAddressesAreMissing() {
        Client client = new Client(1, Arrays.asList(2, 3));
        Address address = mock(Address.class);

        when(clientRepository.get()).thenReturn(Arrays.asList(client));

        List<ClientAddress> actual = victim.getClientAddresses();
        List<ClientAddress> expected = Arrays.asList(new ClientAddress(1, Collections.emptyList()));

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyListInCaseOfNoClient() {
        when(clientRepository.get()).thenReturn(Collections.emptyList());

        List<ClientAddress> actual = victim.getClientAddresses();
        List<ClientAddress> expected = Collections.emptyList();

        assertEquals(expected, actual);
    }
}