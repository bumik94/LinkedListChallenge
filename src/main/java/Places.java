import java.util.LinkedList;
import java.util.Scanner;

record City(String name, int distance) {}

public class Places {
    private final LinkedList<City> places = new LinkedList<>();

    public Places() {

        addPlace(new City("Adelaide", 1374));
        addPlace(new City("Alice Springs", 2771));
        addPlace(new City("Brisbane", 917));
        addPlace(new City("Darwin", 3972));
        addPlace(new City("Melbourne", 877));
        addPlace(new City("Perth", 3923));
        addPlace(new City("Sydney", 0));
    }

    private void addPlace(City city) {

        if (places.contains(city)) {
            System.out.println("Duplicate found");
            return;
        }
        if (places.isEmpty()) {
            places.add(city);
            return;
        }
        for (var place : places) {
            if (place.distance() > city.distance()) {
                places.add(places.indexOf(place) , city);
                return;
            }
        }
        places.add(city);
    }

    public void printList() {

        for (City city : places) {
            //System.out.println(town.getName() + " " + town.getDistance());
            System.out.printf("%-15s %4d%n", city.name(), city.distance());
            System.out.println("-".repeat(20));
        }
    }

    public void menu() {
        var      iterator  = places.listIterator();
        boolean  quit      = false;
        boolean  forward   = true;
        String   selection;
        String   printMenu = """
                Available actions (select word or letter)
                (F)orward
                (B)ackwards
                (L)ist places
                (M)enu
                (Q)uit""";

        System.out.println(printMenu);
        do {do { selection = getString(); } while (selection.isEmpty());
            if (!iterator.hasPrevious()) {
                System.out.printf("Originating from %s%n", iterator.next().name());
            }
            if (!iterator.hasNext()) {
                System.out.printf("Finishing in %s%n", iterator.previous().name());
            }
            switch (selection.toLowerCase().charAt(0)) {
                case ('f') -> {
                    if (!forward) {
                        forward = true;
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                    }
                    if (iterator.hasNext()) {
                        var nextTown = iterator.next();
                        System.out.printf("%s (%d km away from Sydney)%n", nextTown.name(), nextTown.distance());
                    } else {
                        System.out.println("You reached the end");
                    }
                }
                case ('b') -> {
                    if (forward) {
                        forward = false;
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                    }
                    if (iterator.hasPrevious()) {
                        var previousTown = iterator.previous();
                        System.out.printf("%s (%d km away from Sydney)%n", previousTown.name(), previousTown.distance());
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
