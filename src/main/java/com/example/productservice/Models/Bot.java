package com.example.productservice.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bot extends Player{

    private long ranking;

    public Bot() {

    }
}
