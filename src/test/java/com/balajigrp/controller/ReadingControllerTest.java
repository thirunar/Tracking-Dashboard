package com.balajigrp.controller;

import com.balajigrp.service.ReadingService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.HashMap;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class ReadingControllerTest {

    @InjectMocks
    private ReadingController controller;

    @Mock
    private ReadingService service;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldInvokeReadingServiceToAddReading() throws Exception {
        HashMap map = new HashMap();

        controller.add(map);

        verify(service).addReading(map);
    }

    @Test
    public void shouldInvokeReadAllService() throws Exception {
        controller.all();

        verify(service).getAll();
    }
}