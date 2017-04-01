package com.balajigrp.repository;

import com.balajigrp.config.Config;
import com.balajigrp.model.Reading;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class ReadingRepositoryTest {

    @Autowired
    private ReadingRepository repository;

    @Test
    public void shouldTestSaveAndRetrievalInElasticSearch() throws Exception {
        Reading reading = new Reading("1", new BigDecimal("68214"), new BigDecimal("68682"),
                new BigDecimal("73"), new BigInteger("10000"), "Mohan", "Karaikal",
                new BigDecimal("500"), new BigDecimal("200"), new BigDecimal(100), new BigDecimal("500"),
                new BigDecimal(100), new BigDecimal("500"), new BigDecimal("6000"), "Balaji", new BigDecimal("0"), new BigDecimal(52.24));
        repository.save(reading);

        assertThat(repository.findOne("1").get(), is(reading));
    }
}