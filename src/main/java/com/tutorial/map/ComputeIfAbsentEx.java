package com.tutorial.map;

import java.util.HashMap;

public class ComputeIfAbsentEx {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Sunday", 1);
        hm.put("Monday", 2);
        hm.put("Tuesday", 3);
        // hm.put("Wednesday", 4); We are not inserting to to check computeIfAbsent
        hm.put("Thursday", 5);
        hm.put("Friday", 6);
        hm.put("Saturday", 7);

        hm.computeIfAbsent("Wednesday", key -> 4);

        hm.forEach((k, v) -> System.out.println("Key: "+k + " Value: "+v));
    }
}
