package com.example.productservice.InheritenceExamples.Joined;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "joined_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserJoined {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;

}
/**
 *
 * Single table will crate one table which will have all the columns from all the child clases
 *
 *
 *
 * **/