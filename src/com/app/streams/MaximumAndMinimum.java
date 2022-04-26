package com.app.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximumAndMinimum {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 20, 80, 25, 38, 53, 75);
		Integer min = numbers.stream().min(Comparator.naturalOrder()).get();
		System.out.println(min);
	}
}
