package com.app.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import com.app.models.Customer;

public class ExampleSet {
	public static void main(String[] args) {
		// ================= Example HashSet<>
		String[] fish = { "Corvina", "Lenguado", "Pejerrey", "Robalo", "Atún", "Lenguado", "Corvina" };
		Set<String> unique = new HashSet<>();
		Set<String> duplicates = new HashSet<>();

		for (String i : fish) {
			if (!(unique.add(i))) {
				duplicates.add(i);
			}
		}
		unique.removeAll(duplicates);

		System.out.println("Uniques: " + unique);
		System.out.println("Duplicates: " + duplicates + "\n");

		// ================= Example TreeSet<>
		Set<Customer> treeSet = new TreeSet<>();
		treeSet.add(new Customer("Yukino", 5));
		treeSet.add(new Customer("Yui", 6));
		treeSet.add(new Customer("Robin", 4));
		treeSet.add(new Customer("Scarlet", 7));
		treeSet.add(new Customer("Yukari", 3));
		treeSet.add(new Customer("Shouko", 2));
		System.out.println(treeSet);

		System.out.println("\n=== With Foreach ===");
		for (Customer i : treeSet) {
			System.out.println(i);
		}

		System.out.println("\n=== With Iterator and While ===");
		Iterator<Customer> iteratorCustomer = treeSet.iterator();
		while (iteratorCustomer.hasNext()) {
			Customer c = iteratorCustomer.next();
			System.out.println(c.getName());
		}

		System.out.println("\n=== With stream().foreach() ===");
		treeSet.forEach(c -> System.out.println(c.getName()));
	}
}
