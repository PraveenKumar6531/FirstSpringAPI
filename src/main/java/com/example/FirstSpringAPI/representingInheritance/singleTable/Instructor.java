package com.example.FirstSpringAPI.representingInheritance.singleTable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Instructor extends User {
    private String specialization;
}
