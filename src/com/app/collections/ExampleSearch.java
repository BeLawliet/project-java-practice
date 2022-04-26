package com.app.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExampleSearch {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Yukari Yukino");
		names.add("Komi Shouko");
		names.add("Kongou Hikari");
		
		// Organizar por orden natural
		Collections.sort(names);
		System.out.println(names);
		
		// Buscar dentro de la lista - No se puede hacer si la lista no está ordenada de forma ascedente
		int index = Collections.binarySearch(names, "Komi Shouko");
		System.out.println(index);
		System.out.println(names.get(index));
	}
}
