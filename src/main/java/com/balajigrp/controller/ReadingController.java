package com.balajigrp.controller;

import com.balajigrp.model.Reading;
import com.balajigrp.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController("/reading")
public class ReadingController {

    @Autowired
    private ReadingService readingService;

    @RequestMapping(method = POST, consumes = "application/json")
    public ResponseEntity add(@RequestBody Map request) {
        readingService.addReading(request);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = GET, produces = "application/json")
    public List<Reading> all() {
        return readingService.getAll();
    }
}
