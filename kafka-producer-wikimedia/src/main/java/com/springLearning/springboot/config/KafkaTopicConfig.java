package com.springLearning.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka-topic-wikimedia:wikiemedia_recentChange}")
    private String kafkaTopicWikimedia;

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(kafkaTopicWikimedia).build();
    }

}
