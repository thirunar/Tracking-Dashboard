package com.balajigrp.model;

import org.hamcrest.number.BigDecimalCloseTo;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReadingTest {

    @Test
    public void shouldBuildObjectBasedOnTheInput() throws Exception {
        Reading reading = new Reading("1", new BigDecimal("68214"), new BigDecimal("68682"),
                new BigDecimal("73"), new BigInteger("10000"), "Mohan", "Karaikal",
                new BigDecimal("500"), new BigDecimal("200"), new BigDecimal(100), new BigDecimal("500"),
                new BigDecimal(100), new BigDecimal("500"), new BigDecimal("6000"), "Balaji", new BigDecimal("0"), new BigDecimal(52.24));

        assertThat(reading.getKilometers(), is(new BigDecimal(468)));
        assertThat(reading.getMileage(), is(new BigDecimal("6.41")));
        assertThat(reading.getExpenses(), is(new BigDecimal("1900")));
        assertThat(reading.getDieselExpense(), is(new BigDecimal("3813.52")));
        assertThat(reading.getNetAmount(), is(new BigDecimal("286.48")));
        assertThat(reading.getTotalExpenses().compareTo(new BigDecimal("5713.52")), is(0));
    }

    @Test
    public void shouldConvertMapToReading() throws Exception {
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

        Reading actualReading = Reading.fromMap(map);

        Reading expectedReading = new Reading(new BigDecimal("68214"), new BigDecimal("68682"),
                new BigDecimal("73"), new BigInteger("10000"), "Mohan", "Karaikal",
                new BigDecimal("500"), new BigDecimal("200"), new BigDecimal(100), new BigDecimal("500"),
                new BigDecimal(100), new BigDecimal("500"), new BigDecimal("6000"), "Balaji",
                new BigDecimal("0"), new BigDecimal(52.24));

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
}