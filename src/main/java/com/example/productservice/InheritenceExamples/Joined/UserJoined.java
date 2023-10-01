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
 * joined table will create one table user in this it has id name and email,
 * another table for mentor in which we extend userjoined,
 * all the details of mentor like id ,name and email will store in usertbale along with id,
 * and this id will be mapped with mentor tabl
 *
 *
 *
 * **/