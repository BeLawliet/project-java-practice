package com.app.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
		
		// Operador ANYMATCH()
	}
}
