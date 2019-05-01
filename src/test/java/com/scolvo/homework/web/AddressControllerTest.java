package com.scolvo.homework.web;

import com.scolvo.homework.api.Address;
import com.scolvo.homework.converter.AddressConverter;
import com.scolvo.homework.service.AddressService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AddressControllerTest {

    @Mock
    private AddressService addressService;
    @Mock
    private AddressConverter addressConverter;

    @Mock
    private Address address1;
    @Mock
    private Address address2;

    @Mock
    private com.scolvo.homework.domain.Address convertedAddress1;
    @Mock
    private com.scolvo.homework.domain.Address convertedAddress2;

    @InjectMocks
    private AddressController victim;

    @Before
    public void initTests() {
        initMocks(this);
    }

    @Test
    public void shouldConvertRequestParamsAndCallAddressServiceInCaseOfNonNullMapValue() {
        Map<Integer, Address> data = new HashMap<>();
        data.put(1, address1);
        data.put(2, address2);
        data.put(3, null);

        Map<Integer, com.scolvo.homework.domain.Address> expectedServiceParameter = new HashMap<>();
        expectedServiceParameter.put(1, convertedAddress1);
        expectedServiceParameter.put(2, convertedAddress2);

        Map<Integer, String> expected = mock(Map.class);

        when(addressConverter.convert(address1)).thenReturn(convertedAddress1);
        when(addressConverter.convert(address2)).thenReturn(convertedAddress2);
        when(addressService.upsert(expectedServiceParameter)).thenReturn(expected);

        Map<Integer, String> actual = victim.postAddresses(data);

        assertEquals(expected, actual);
    }
}