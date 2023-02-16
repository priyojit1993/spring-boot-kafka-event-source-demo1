package com.springLearning.springboot.producer;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class WikiMediaChangesProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${kafka-topic-wikimedia:wikiemedia_recentChange}")
    private String kafkaTopicWikimedia;

    public WikiMediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {
        //to read real time stream data from wikimedia ,we use an event source.
        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, kafkaTopicWikimedia);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource eventSource = new EventSource.Builder(eventHandler, URI.create(url)).build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);


    }

}
