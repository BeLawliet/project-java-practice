package com.app.streams;

import java.util.stream.IntStream;

public class PrimitiveStreams {
	public static void main(String[] args) {
		IntStream.range(0, 10).forEach(System.out::println);
		IntStream.of(120).forEach(System.out::println);
	}
}
