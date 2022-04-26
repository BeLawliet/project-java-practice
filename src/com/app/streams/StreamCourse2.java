package com.app.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.app.models.User;

public class StreamCourse2 {
	public static void main(String[] args) {
		// Formas de crear un stream
		Stream<String> data = Stream.of("Yukinoshita Yukino", "Yuigamaha Yui", "Makinohara Shouko", "Nico Robin");
		data.forEach(System.out::println);
		System.out.println();
		
		String[] array = {"Hikari Kongou", "Sakurajima Mai", "Komi Shouko", "Shinobu Koshou"};
		Arrays.stream(array).forEach(System.out::println);
		System.out.println();
		
		// Operador MAP()
		List<String> registers = new ArrayList<>();
		registers.addAll(Arrays.asList("Yukinoshita Yukino", "Yuigamaha Yui", "Makinohara Shouko", "Nico Robin", "Komi Shouko"));
		registers.stream().map(String::toUpperCase).forEach(System.out::println);
		System.out.println();
		
		Stream<User> userStream = registers.stream().map(r -> new User(r.split(" ")[1], r.split(" ")[0]));
		List<User> users = userStream.collect(Collectors.toList());
		users.forEach(System.out::println);
		System.out.println();
		
		List<User> userEquals = users.stream().filter(u -> u.getName().equalsIgnoreCase("shouko")).collect(Collectors.toList());
		userEquals.forEach(System.out::println);
		System.out.println();
		
		// Operador FILTER()
		Optional<User> firstMatch = userEquals.stream().filter(u -> u.getName().equalsIgnoreCase("Shouko")).findFirst();
		firstMatch.ifPresent(System.out::println);
		System.out.println();
		
		Optional<User> firstMatchId = users.stream().filter(u -> u.getId().equals(4)).findAny();
		firstMatchId.ifPresent(System.out::println);
		System.out.println();
		
		// Operador ANYMATCH()
		boolean exist = users.stream().anyMatch(u -> u.getId().equals(2));
		System.out.println(exist);
		System.out.println();
		
		// Operador COUNT()
		long count = users.stream().count();
		System.out.println(count);
		System.out.println();
		
		// Operador DISTINCT()
		Stream<String> data2 = Stream.of("Yukinoshita Yukino", "", "Yuigamaha Yui", "Makinohara Shouko", "", "Nico Robin", "", "Makinohara Shouko").distinct();
		data2.forEach(System.out::println);
		System.out.println();
		
		// Operador REDUCE()
		Stream<String> data3 = Stream.of("Yukinoshita Yukino", "Yuigamaha Yui", "Makinohara Shouko", "Nico Robin");
		String finalResult = data3.reduce("Final Result -> ", (a, b) -> a + ", "+b);
		System.out.println(finalResult);
		System.out.println();
		
		Stream<Integer> data4 = Stream.of(5, 10, 20, 30, 40, 50);
		//int sum = data4.reduce(0, (a, b) -> a + b);
		int sum2 = data4.reduce(0, Integer::sum);
		System.out.println(sum2);
		System.out.println();
		
		// Stream primitivo
		IntStream data5 = IntStream.range(1, 21);
		//IntStream data5 = IntStream.rangeClosed(1, 20);
		//int sum3 = data5.sum();
		//System.out.println(sum3);
		
		OptionalDouble average = data5.average();
		System.out.println(average.getAsDouble());
		
		// MAYOR, MENOR, PROMEDIO
		IntStream data6 = IntStream.range(1, 21);
		IntSummaryStatistics stats = data6.summaryStatistics();
		System.out.println("Average: " + stats.getAverage());
		System.out.println();
		
		// Operador MAPTOINT()
		IntStream data7 = users.stream().mapToInt(u -> u.getLastName().length());
		data7.forEach(System.out::println);
		System.out.println();
		
		// Operador FLATMAP()
		Stream<User> userStream2 = registers.stream().map(r -> new User(r.split(" ")[1], r.split(" ")[0])).flatMap(u -> {
			if (u.getName().equals("Shouko")) {
				return Stream.of(u);
			}
			
			return Stream.empty();
		});
		userStream2.forEach(System.out::println);
		System.out.println();
	}
}



























