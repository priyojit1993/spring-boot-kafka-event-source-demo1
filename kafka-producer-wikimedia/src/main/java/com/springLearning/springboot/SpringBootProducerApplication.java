package com.springLearning.springboot;

import com.springLearning.springboot.producer.WikiMediaChangesProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner {

    private final WikiMediaChangesProducer wikiMediaChangesProducer;

    public SpringBootProducerApplication(WikiMediaChangesProducer wikiMediaChangesProducer) {
        this.wikiMediaChangesProducer = wikiMediaChangesProducer;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducerApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        wikiMediaChangesProducer.sendMessage();
    }
}
