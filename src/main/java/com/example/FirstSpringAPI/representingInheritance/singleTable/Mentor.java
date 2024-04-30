package com.example.FirstSpringAPI.representingInheritance.singleTable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mentor extends User {
    private double mentorRating;
}
