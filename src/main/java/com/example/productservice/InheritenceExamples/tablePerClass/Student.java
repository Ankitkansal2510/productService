package com.example.productservice.InheritenceExamples.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_student")
public class Student extends UserTPC {
    private double psp;
    private double attendance;
}
