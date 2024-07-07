import java.util.LinkedList;
import java.util.Iterator;
import java.util.Collections;
import java.lang.Comparable;
import java.util.Scanner;

public class Places {
    private LinkedList<Town> list = new LinkedList<>();

    public Places() {
        this.list.add(new Town("Adelaide", 1374));
        this.list.add(new Town("Alice Springs", 2771));
        this.list.add(new Town("Brisbane", 917));
        this.list.add(new Town("Darwin", 3972));
        this.list.add(new Town("Melbourne", 877));
        this.list.add(new Town("Perth", 3923));
    }

    public void printList() {
        Collections.sort(list);
        for (Town town : list) {
            //System.out.println(town.getName() + " " + town.getDistance());
            System.out.printf("%s20", town.getName());
            
        }
    }
}

class Town implements Comparable<Town>{
    private  String name;
    private Integer distance; // Comparable doesn't work on primitive data types

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