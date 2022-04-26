package com.app.lambdas.custom;

public class TestCalculable {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Calculable calculable = new Calculable() {
			@Override
			public double avg(double... values) {
					double sum = 0.0;
					for (int i = 0; i < values.length; i++) {
						sum += values[i];
					}
					return sum / values.length;
			}
		};
		
		Calculable calculable2 = (values) -> {
			double sum = 0.0;
			for (int i = 0; i < values.length; i++) {
				sum += values[i];
			}
			return sum / values.length;
		};
		
		System.out.println(calculable2.avg(10, 20, 30));
	}
}
