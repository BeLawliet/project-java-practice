package com.app.collections.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ExampleHashMap {
    public static void main(String[] args) {
        Map<String, String> customers = new HashMap<>();
        customers.put("one", "Yukino");
        customers.put("two", "Yui");
        customers.put("three", "Shouko");
        customers.put("four", "Mai");
        customers.put("five", "Kaede");
        customers.put("six", "Hikari");
        customers.forEach((key, value) -> System.out.println(key + " => " + value));
        System.out.println();
        
        // Devuelve todos los valores
        Collection<String> collections = customers.values();
        collections.forEach(System.out::println);
        System.out.println();
        
        // Devuelve todas las llaves
        Set<String> keys = customers.keySet();
        keys.forEach(System.out::println);
        System.out.println();
        
        for (Entry<String, String> i : customers.entrySet()) {
            System.out.println(i.getKey() + " = " + i.getValue());
        }
    }
}
