package com.tutorial.map;

import com.tutorial.map.domain.City;
import com.tutorial.map.domain.Person;

import java.util.*;

public class VarietyOfWaysToPutIntoHashMap {

    public static void main(String[] args) {
        Person p1 = Person.builder().name("Sathya").age(20).build();
        Person p2 = Person.builder().name("Sai").age(1).build();

        City prashanthi= City.builder().cityName("Prashanthi Nilayam").build();
        City brindavan= City.builder().cityName("Brindavan").build();

        getOrDefault(prashanthi);

        HashMap<City, List<Person>> cityMap = putIfAbsent(p1, brindavan);

        computeIfAbsent(p2, prashanthi, cityMap);
        System.out.println("Number of people living in Prashanthi: "+cityMap.get(prashanthi).size());
    }

    private static void getOrDefault(City prashanthi) {
        HashMap<City, List<Person>> cityMap1 = new HashMap<>();
        cityMap1.getOrDefault(prashanthi, Collections.EMPTY_LIST);
    }

    private static HashMap<City, List<Person>> putIfAbsent(Person p1, City brindavan) {
        HashMap<City, List<Person>> cityMap = new HashMap<City, List<Person>>();
        cityMap.putIfAbsent(brindavan, new ArrayList<>());
        cityMap.get(brindavan).add(p1);
        return cityMap;
    }

    private static void computeIfAbsent(Person p2, City prashanthi, HashMap<City, List<Person>> cityMap) {
    /* cityMap.computeIfAbsent(prashanthi, p -> {
         return new ArrayList<>();
     }).add(p2);*/



        cityMap.computeIfAbsent(prashanthi, p -> new ArrayList<>()).add(p2);
    }
}
