package com.springLearning.springboot.repositories;

import com.springLearning.springboot.model.WikiMediaEvent;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface WikiMediaRepository extends CrudRepository<WikiMediaEvent, UUID> {
}
