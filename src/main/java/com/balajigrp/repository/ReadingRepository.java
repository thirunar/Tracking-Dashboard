package com.balajigrp.repository;

import com.balajigrp.model.Reading;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ReadingRepository extends ElasticsearchRepository<Reading,String> {
}
