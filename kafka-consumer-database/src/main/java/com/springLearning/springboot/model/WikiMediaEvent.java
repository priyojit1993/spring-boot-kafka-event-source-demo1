package com.springLearning.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Getter
@Setter
@NoArgsConstructor
public class WikiMediaEvent {
    @Id
    private UUID id;

    private String eventDataString;

}
