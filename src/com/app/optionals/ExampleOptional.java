package com.app.optionals;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ExampleOptional {
	public static Optional<String> searchByName(String param) {
		Set<String> data = new HashSet<>();
		data.add("Yukinoshita Yukino");
		data.add("Yuigahama Yui");
		data.add("Ishiki Iroha");
		data.add("Makinohara Shouko");
		data.add("Nico Robin");
		
		Optional<String> result = data.stream().filter(d -> d.equals(param)).findAny();
		
		if (result.isPresent()) {
			return result;
		}
		
		return Optional.empty();
	}
	
	public static void main(String[] args) {
		String result = searchByName("Hikari").orElseGet(() -> "Default name");
		System.out.println("===> " + result.toUpperCase() + " <===");
	}
}
