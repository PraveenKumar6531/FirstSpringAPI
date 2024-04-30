package com.example.FirstSpringAPI.representingInheritance.singleTable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TA extends User {
    private int noOfSession;
    private double avgRating;
}
