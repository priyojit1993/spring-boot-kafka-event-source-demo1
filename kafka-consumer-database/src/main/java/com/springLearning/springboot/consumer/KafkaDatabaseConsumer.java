package com.springLearning.springboot.consumer;

import com.springLearning.springboot.model.WikiMediaEvent;
import com.springLearning.springboot.repositories.WikiMediaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class KafkaDatabaseConsumer {

    private final WikiMediaRepository wikiMediaRepository;

    public KafkaDatabaseConsumer(WikiMediaRepository wikiMediaRepository) {
        this.wikiMediaRepository = wikiMediaRepository;
    }

    @KafkaListener(topics = "wikiemedia_recentChange", groupId = "myGroup")
    public void consumer(String message) {
        log.info(String.format("Message received -> %s", message));
        //insert the data into DB
        WikiMediaEvent wikiMediaEvent = new WikiMediaEvent();
        wikiMediaEvent.setId(UUID.randomUUID());
        wikiMediaEvent.setEventDataString(message);
        wikiMediaRepository.save(wikiMediaEvent);
        log.info("Saved to DB");

    }


}
