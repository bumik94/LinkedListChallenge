import java.util.LinkedList;
import java.util.Iterator;

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
        for (Town town : list) {
            System.out.println(town.getName() + " " + town.getDistance());
            
        }
    }
}

class Town {
    private String name;
    private    int distance;

    public Town(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}