package com.tutorial.map;

import java.util.HashMap;

public class MapEx {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Sunday",1);
        hm.put("Monday",2);
        hm.put("Tuesday",3);
        hm.put("Wednesday",4);
        hm.put("Thursday",5);
        hm.put("Friday",6);
        hm.put("Saturday",7);

        // Notice that the key, value pairs are not printed in the order of insertion. 
        hm.forEach((key, val) -> System.out.println("Key: "+key + " Value: "+val));

    }
}
