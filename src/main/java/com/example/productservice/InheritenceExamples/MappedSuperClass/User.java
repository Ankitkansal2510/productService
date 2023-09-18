package com.example.productservice.InheritenceExamples.MappedSuperClass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@MappedSuperclass
public class User {
    @Id
    private long id;
    private String name;
    private String email;

}
/**
 * Mapped super class mean , all the child class will have table but in the child class table
 * it will have all the attributes of the parent class
 * But no table for the parent
 *
 *
 * **/