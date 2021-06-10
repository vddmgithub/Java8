package com.tutorial.map;

import com.tutorial.map.domain.City;
import com.tutorial.map.domain.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MergingMaps {
    public static void main(String[] args) {
        Person p1m1 = Person.builder().name("Sathya").age(20).build();
        Person p2m1 = Person.builder().name("Sai").age(1).build();
        City c1= City.builder().cityName("Prashanthi Nilayam").build();
        HashMap<City, List<Person>> m1 = new HashMap<>();
        m1.put(c1, List.of(p1m1, p2m1));

        Person p1m2 = Person.builder().name("Sathya Sai").age(25).build();
        Person p2m2 = Person.builder().name("Baba").age(14).build();
        HashMap<City, List<Person>> m2 = new HashMap<>();
        List<Person> m2l1= List.of(p1m2, p2m2);
        m2.put(c1, m2l1);


        crudeMerging(m1, m2);

        m1.forEach((k, v) -> m2.merge(k, v, (existing, newPeople) -> {
            existing.addAll(newPeople);
            return existing;
        }));

        System.out.println("\n\n\nUsing Merge API");
        printMap(m2);
    }

    private static void printMap(HashMap<City, List<Person>> m2) {
        m2.forEach((key, value) -> {
            System.out.println("Key: "+key);
            System.out.println("Value: "+value);
        });
    }

    private static void crudeMerging(HashMap<City, List<Person>> m1, HashMap<City, List<Person>> m2) {
        m2.forEach((k2, l2) -> {
            if(m1.containsKey(k2)){
                List<Person> newList = new ArrayList<>();
                newList.addAll(m1.get(k2));
                newList.addAll(l2);
                // l2.addAll(m1.get(k2)); Immutable collection
                m2.put(k2,newList);
            }
        });
        System.out.println("\n\nFinal map after merging");
        printMap(m2);
    }
}
