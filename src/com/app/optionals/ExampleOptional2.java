package com.app.optionals;

import java.util.Optional;

public class ExampleOptional2 {
    public static void main(String[] args) {
        Optional<String> optionalString = Optional.of("Yukinoshita Yukino");
        
        if (optionalString.isPresent()) {
            System.out.println(optionalString.orElse("Hello World"));
            System.out.println(optionalString.orElseGet(() -> "¡Hello World!"));
            System.out.println(optionalString.orElseThrow(() -> new IllegalStateException("Couldn't be found item")));
        }

        optionalString.ifPresent(v -> System.out.println("Hello, " + v));
    }
}
