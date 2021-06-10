package com.tutorial.stream;

import com.tutorial.map.domain.Person;

import java.util.List;
import java.util.stream.Stream;

public class BuildingStream {

    public static void main(String[] args) {
        Person p1 = Person.builder().name("Sathya").age(20).build();
        Person p2 = Person.builder().name("Sai").age(1).build();
        List<Person> personList = List.of(p1, p2);
        System.out.println("List holds data: "+personList.size());
        Stream<Person> personStream = personList.stream();
        System.out.println("Count of elements in stream: "+personStream.count());
    }
}
