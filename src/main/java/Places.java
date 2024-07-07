import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Collections;
import java.lang.Comparable;
import java.util.Scanner;

public class Places {
    private final LinkedList<Town> list = new LinkedList<>();

    public Places() {

        this.list.add(new Town("Adelaide", 1374));
        this.list.add(new Town("Alice Springs", 2771));
        this.list.add(new Town("Brisbane", 917));
        this.list.add(new Town("Darwin", 3972));
        this.list.add(new Town("Melbourne", 877));
        this.list.add(new Town("Perth", 3923));
        this.list.add(new Town("Sydney", 0));
        Collections.sort(list);
    }

    private void printList() {

        for (Town town : list) {
            //System.out.println(town.getName() + " " + town.getDistance());
            System.out.printf("%-15s %4d%n", town.getName(), town.getDistance());
            System.out.println("-".repeat(20));
        }
    }

    public void menu() {
         String selection;
        boolean      quit = false;
            var  iterator = list.listIterator(1);
         String printMenu = """
                Available actions (select word or letter)
                (F)orward
                (B)ackwards
                (L)ist places
                (M)enu
                (Q)uit""";

        System.out.println(printMenu);
        do {do { selection = getString(); } while (selection.isEmpty());
            switch (selection.toLowerCase().charAt(0)) {
                case ('f') -> {
                    if (iterator.hasNext()) {
                        var nextTown = iterator.next();
                        System.out.printf("%s (%d km away from Sydney)%n", nextTown.getName(), nextTown.getDistance());
                    } else {
                        System.out.println("You reached the end");
                    }
                }
                case ('b') -> {
                    if (iterator.hasPrevious()) {
                        var previousTown = iterator.previous();
                        System.out.printf("%s (%d km away from Sydney)%n", previousTown.getName(), previousTown.getDistance());
                    } else {
                        System.out.println("You're at the beginning");
                    }
                }
                case ('l') -> { printList(); }
                case ('m') -> { System.out.println(printMenu); }
                case ('q') -> { quit = true; }
            }
        } while (!quit);
    }

    private static String getString() {
        var s = new Scanner(System.in);

        System.out.print("# ");
        return s.nextLine();
    }
}

class Town implements Comparable<Town>{
    private final String name;
    private final Integer distance; // Comparable doesn't work on primitive data types

    public Town(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    @Override
    public int compareTo(Town town) {
        return distance.compareTo(town.distance);
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}