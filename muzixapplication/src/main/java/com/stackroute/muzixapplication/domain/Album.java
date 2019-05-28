package com.stackroute.muzixapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



//@Entity
@Document
@Data

public class Album {
@Id
    private int trackid;
    private String trackname;
    private String trackartist;
    private String genre;


}
