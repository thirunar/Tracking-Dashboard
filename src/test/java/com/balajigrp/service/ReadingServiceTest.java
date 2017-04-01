package com.balajigrp.service;

import com.balajigrp.model.Reading;
import com.balajigrp.repository.ReadingRepository;
import org.hamcrest.number.BigDecimalCloseTo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class ReadingServiceTest {

    @InjectMocks
    private ReadingService service;

    @Mock
    private ReadingRepository repository;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldSaveReadingRepository() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("omr", "68214");
        map.put("cmr", "68682");
        map.put("litres", "73");
        map.put("ton", "10000");
        map.put("driverName", "Mohan");
        map.put("destination", "Karaikal");
        map.put("tollFee", "500");
        map.put("tiffinCost", "200");
        map.put("personalCost", "100");
        map.put("unloadingCost", "500");
        map.put("rtoFee", "100");
        map.put("weighBridge", "500");
        map.put("rent", "6000");
        map.put("companyName", "Balaji");
        map.put("maintenance", "0");
        map.put("dieselPrice", "52.24");

        service.addReading(map);

        ArgumentCaptor<Reading> argumentCaptor = ArgumentCaptor.forClass(Reading.class);
        verify(repository).save(argumentCaptor.capture());
        Reading actualReading = argumentCaptor.getValue();
        assertThat(actualReading.getOmr(), is(new BigDecimalCloseTo(new BigDecimal("68214"), new BigDecimal(0))));
        assertThat(actualReading.getCmr(), is(new BigDecimalCloseTo(new BigDecimal("68682"), new BigDecimal(0))));
        assertThat(actualReading.getLitres(), is(new BigDecimal("73")));
        assertThat(actualReading.getTon(), is(new BigInteger("10000")));
        assertThat(actualReading.getDriverName(), is("Mohan"));
        assertThat(actualReading.getDestination(), is("Karaikal"));
        assertThat(actualReading.getTollFee(), is(new BigDecimal("500")));
        assertThat(actualReading.getTiffinCost(), is(new BigDecimal("200")));
        assertThat(actualReading.getPersonalCost(), is(new BigDecimal("100")));
        assertThat(actualReading.getUnloadingCost(), is(new BigDecimal("500")));
        assertThat(actualReading.getRtoFee(), is(new BigDecimal("100")));
        assertThat(actualReading.getWeighBridge(), is(new BigDecimal("500")));
        assertThat(actualReading.getRent(), is(new BigDecimal("6000")));
        assertThat(actualReading.getCompanyName(), is("Balaji"));
        assertThat(actualReading.getMaintenance(), is(new BigDecimal("0")));
        assertThat(actualReading.getDieselUnitPrice(), is(new BigDecimalCloseTo(new BigDecimal(52.24), new BigDecimal(0.0001))));

    }

    @Test
    public void shouldInvokeFindAllInRepository() throws Exception {
        service.getAll();

        verify(repository).findAll();
    }
}