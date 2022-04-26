package com.app.lambdas;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ExampleLambda {
    public static void main(String[] args) {
        // Expresion lambda que nos permite pasar por argumento un solo parameter - No devuelve nada
        Consumer<String> consumer = greeting -> System.out.println(greeting);
        consumer.accept("Hello World");

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("Komi Shouko");

        // ==
        BiConsumer<Integer, String> biConsumer = (age, name) -> {
            System.out.println("Name: " + name + ", Age: " + age);
        };
        biConsumer.accept(17, "Yukinohista Yukino");

        // === No recibe ningun argumento y devuelve un valor - Only return
        Supplier<String> supplier = () -> {
            return "Lambda supplier";
        };
        System.out.println(supplier.get());

        // == Function
        Function<String, String> function = param -> {
            return "Hi, how it going, " + param + "?";
        };
        String result = function.apply("Yukari");
        System.out.println(result);

        // ==
        BiFunction<String, Integer, String> biFunction = (arg1, arg2) -> {
            return "Hi, " + arg1 + ", your age is: " + arg2;
        };
        String resultBiFunction = biFunction.apply("Makinohara Shouko", 17);
        System.out.println(resultBiFunction);

        // Test boolean expression
        Predicate<Integer> predicate = param -> param > 10;
        boolean test = predicate.test(20);
        System.out.println(test);

        // ==
        BiPredicate<String, String> biPredicate = String::equals;
        boolean test2 = biPredicate.test("Andres", "Andres");
        System.out.println(test2);
    }   
}
