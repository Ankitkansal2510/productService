package com.example.productservice.InheritenceExamples.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_mentor")
public class MentorTPC extends UserTPC {
    private double averageRating;
}
