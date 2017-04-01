package com.balajigrp.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

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
}