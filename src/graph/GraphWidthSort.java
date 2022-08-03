package graph;

import java.util.*;

public class GraphWidthSort {

    public static void main(String[] args) {
        Hashtable<Person, List<Person>> graph = new Hashtable<>();

        Person teddy = new Person("Teddy", "friend");
        Person alice = new Person("Alice", "friend");
        Person bob = new Person("Bob", "friend");
        Person clare = new Person("Clare", "friend");

        graph.put(teddy, new ArrayList<Person>(Arrays.asList(alice, bob, clare)));

        Person peggy = new Person("Peggy", "gangsta");
        Person anuj = new Person("Anuj", "mangoSeller");
        Person tom = new Person("Tom", "friend");
        Person johny = new Person("Johny", "friend");

        graph.put(alice, new ArrayList<Person>(Arrays.asList(peggy)));
        graph.put(bob, new ArrayList<Person>(Arrays.asList(peggy, anuj)));
        graph.put(clare, new ArrayList<Person>(Arrays.asList(tom, johny)));

        graph.put(peggy, new ArrayList<>());
        graph.put(anuj, new ArrayList<>());
        graph.put(tom, new ArrayList<>());
        graph.put(johny, new ArrayList<>());

        Queue<Person> personQueue = new LinkedList<>();
        personQueue.add(teddy);

        Person mangoSeller = findMangoSeller(personQueue, graph);
        if (mangoSeller != null) {
            System.out.println("Mango seller has found: " + mangoSeller.getName());
        } else {
            System.out.println("There is no mango seller...");
        }

    }

    public static Person findMangoSeller(Queue<Person> personQueue, Hashtable<Person, List<Person>> graph) {
        List<Person> wasChecked = new ArrayList<>();
        while (!personQueue.isEmpty()) {
            Person person = personQueue.remove();
            if (!wasChecked.contains(person)) {
                if ("mangoSeller".equals(person.getActivity())) {
                    return person;
                }
                wasChecked.add(person);
                List<Person> personFriends = graph.get(person);
                for (Person friend : personFriends) {
                    if (!personQueue.contains(friend)) {
                        personQueue.add(friend);
                    }
                }
            }

        }
        return null;
    }

}
