package com.balajigrp.service;

import com.balajigrp.model.Reading;
import com.balajigrp.repository.ReadingRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReadingService {

    @Autowired
    private ReadingRepository repository;

    public Reading addReading(Map map) {
        return repository.save(Reading.fromMap(map));
    }

    public List<Reading> getAll() {
        return Lists.newArrayList(repository.findAll());
    }
}
