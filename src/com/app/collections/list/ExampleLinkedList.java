package com.app.collections.list;

import java.util.*;

public class ExampleLinkedList {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Yukino Yukinoshita");
        linkedList.add("Yui Yuigahama");
        linkedList.add("Komachi Hikigaya");
        System.out.println("Lista original = " + linkedList);
        
        // Añade al principio de la lista - Los métodos add sí lanzan exceptions
        linkedList.addFirst("Komi Shouko");
        System.out.println("\naddFirt() = " + linkedList);
        
        // Añade al final de la lista
        linkedList.addLast("Hikari Kongou");
        System.out.println("\naddLast() = " + linkedList);
        
        // Devuelve el orden inverso de los valores
        Iterator<String> inverseOrder = linkedList.descendingIterator();
        System.out.println("\ndescendingIterator() = ");
        while (inverseOrder.hasNext()) {
        	System.out.print(inverseOrder.next() + ", ");
        }
        
        // Devuelve el primer valor de la lista, sin eliminarlo - Si falla lanza una exception
        String firtElement = linkedList.element();
        System.out.println("\n\nelement() = " + firtElement);
        
        // Compara dos listas con los mismos elementos
        List<String> linkedList2 = new ArrayList<>();        
        linkedList2.add("Shouko Komi");
        linkedList2.add("Yukino Yukinoshita");
        linkedList2.add("Yui Yuigahama");
        linkedList2.add("Komachi Hikigaya");
        linkedList2.add("Hikari Kogou");
        System.out.println(linkedList.equals(linkedList2));
        
        // Obtiene el primer valor de la lista - Manda exceptions
        System.out.println("\ngetFirt() = " + linkedList.getFirst());
        
        // Obtiene el último valor de la lista
        System.out.println("\ngetLast() = " + linkedList.getLast());
        
        // Los métodos offer no lanzan exceptiones
        linkedList.offer("Nico Robin");
        System.out.println("\noffer() = " + linkedList);
        
        // Los métodos peek() - No lanzan exceptions - Devuelven null en caso de fallar
        System.out.println("\npeek() = " + linkedList.peek());
        
        // Elimina y devuelve el primer elemento de esta lista - Devuelve null si falla
        System.out.println("\npoll() = " + linkedList.poll());
        System.out.println(linkedList);
        
        System.out.println("\npollFirst() = " + linkedList.pollFirst());
        System.out.println(linkedList);
        
        System.out.println("\npollLast() = " + linkedList.pollLast());
        System.out.println(linkedList);
        
        // Lanza exception si falla
        System.out.println("\npop() = " + linkedList.pop());
        System.out.println(linkedList);
        
        // Empuja al principio de la lista
        linkedList.push("Andrés Suárez");
        System.out.println("\npush() = " + linkedList);
    }
}

















