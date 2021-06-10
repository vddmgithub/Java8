package com.tutorial.map.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    String name;
    int age;
}
