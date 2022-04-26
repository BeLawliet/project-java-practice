package com.app.collections.list;

import java.util.*;

public class ExampleArrayList {
    public static void main(String[] args) {
        List<Integer> original = new ArrayList<>();
        original.add(1);
        original.add(2);
        original.add(3);
        original.add(4);
        original.add(5);
        System.out.println("original = " + original);
        System.out.println();

        // Agregar en la posición deseada
        original.add(2, 10);
        System.out.println("modified = " + original);
        System.out.println();

        // Convertir colección en un arreglo
        Object[] newArray = original.toArray();
        System.out.println("newArray");
        for (Object i : newArray) {
            System.out.print(i + ", ");
        }
        System.out.println();

        // Agregar all el contenido de otra colección del mismo tipo de dato
        Set<Integer> integers = new HashSet<>();
        integers.add(15);
        integers.add(28);
        integers.add(1);
        integers.add(9);
        original.addAll(integers);
        System.out.println("\noriginal = " + original);
        System.out.println();

        // Verifica que toda la colección dada estÃ© dentro de la lista
        System.out.println("containsAll = " + original.containsAll(integers));
        System.out.println();

        // Verifica que el valor dado se encuentre dentro de la lista
        System.out.println("contains = " + original.contains(1));
        System.out.println();

        // Devuelve el indice del primer elemento especificado - si no existe -> -1
        int index = original.indexOf(28);
        System.out.println("indexOf = " + index);
        System.out.println();
        
        // Devuelve el indice del primer elemento especificado desde el final hasta el primero - si no existe -> -1
        int lastIndex = original.lastIndexOf(10);
        System.out.println("lastIndexOf = " + lastIndex);
        System.out.println();
        
        // Reemplaza en la posición indicada
        original.set(1, 888);
        System.out.println(original);
        System.out.println();
        
        // Devuelve instancia de Iterator<T>
        Iterator<Integer> newIterator = original.iterator();
        System.out.println("Iterator = ");
        while (newIterator.hasNext()) {
        	System.out.print(newIterator.next() + ", ");
        }
        System.out.println("\n");
        
        // Elimina el elemento mandado si se encuentra
        original.removeIf(a -> a.equals(888));
        System.out.println("removeIf = " + original + "\n");
        
        // Ordena de acuerdo al comparator indicado
        System.out.println("Sort - Comparator");
        //customers.sort(Comparator.comparing(Customer::getNote).reversed());
      	//Collections.sort(customers, (a, b) -> a.getName().compareTo(b.getName()));
        System.out.println(original + "\n");
        
        // Mantiene en la lista solo los que se especifican
        System.out.println("retainAll = ");
        original.retainAll(integers);
        System.out.print(original + "\n");

        // Elimina todos los datos
        original.clear();
        System.out.println("\noriginal = " + original);
    }
}
