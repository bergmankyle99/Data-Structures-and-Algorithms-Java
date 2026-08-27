package ZooKeeper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import static ZooKeeper.Maze.animalList;
public class ZooKeeperDriver {

    public static UnionFind<String> uf;
    public static Maze grid;
    public static Scanner scan = new Scanner(System.in);
    int regionCount = 0;
    public static ArrayList regions = new ArrayList();
    public static ArrayList<String> animals = new ArrayList();
    public static ArrayList<Integer> areas = new ArrayList();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        grid = new Maze(25, 25, 0.5);
        uf = new UnionFind<String>();
        findRegions();
        int input = 0;

        while (input != 5) {
            System.out.println("=[==[==[=[=================================]=]==]==]=");
            System.out.println("=[==[==[=[     Welcome to ZooKeeper        ]=]==]==]=");
            System.out.println("=[==[==[=[=================================]=]==]==]=");

            System.out.println("Choose...");
            System.out.println("1. Show MAP of Zoo.");
            System.out.println("2. Place Zoo ANIMAL in the MAP.");
            System.out.println("3. Show region CAPACITY.");
            System.out.println("4. Move ANIMAL to another ENCLOSURE");
            System.out.println("5. Exit program");
            input = scan.nextInt();
            if (input == 1) {
                grid.drawMazeSetsInColor(uf);
            }
            if (input == 2) {
                System.out.println("What animal would you like to add?");
                String animal = scan.next().toUpperCase();
                if (animals.contains(animal)) {
                    System.out.println(animal + " already in!");
                } else {
                    System.out.println("How many " + animal + "s would you like to add?");
                    int amt = scan.nextInt();
                    getRegions(amt);
                    System.out.println("Which area would you like to add " + animal + " to?");
                    int area = scan.nextInt();
                    if (areas.contains(area)) {
                        System.out.println(area + " already taken!");
                    } else {
                        String aFix = animal.substring(0, 3);

                        grid.animalAdd(aFix, amt, area);
                        animals.add(animal);
                        areas.add(area);
                    }

                }

            }
            if (input == 3) {
                System.out.println("How many spaces do you need?");
                int amt = scan.nextInt();
                getRegions(amt);
            }
            if (input == 4) {
                System.out.println("Which region would you like to move?");
                int region = scan.nextInt();
                if (areas.contains(region)) {
                    getRegions(grid.animalCount.get(grid.regionsWithAnimals.indexOf(region)));
                    System.out.println("Move to what region?");
                    int region2 = scan.nextInt();
                    if (areas.contains(region2)) {
                        System.out.println("This area already has " + animalList.get(areas.indexOf(region2)));
                    } else if (grid.regionList.contains(region2)) {
                        grid.moveAnimal(region, region2);
                        areas.remove(areas.indexOf(region));
                        areas.add(region2);
                    }else{
                        System.out.println("This area doesn't exist");
                    }

                } else {
                    System.out.println("Region has nothing in it");
                }

            }
            if (input == 5) {
                continue;
            }

        }

    }

    public static void findRegions() {

        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                if (grid.maze[i][j] == true) {
                    //uf.add("#");
                } else {
                    uf.add(i + "," + j);
                    if (i - 1 >= 0) {
                        if (grid.maze[i - 1][j] == false) {
                            uf.union(uf.find(i + "," + j), uf.find((i - 1) + "," + j));

                        }
                    }
                    if (j - 1 >= 0) {
                        if (grid.maze[i][j - 1] == false) {
                            uf.union(uf.find(i + "," + j), uf.find(i + "," + (j - 1)));

                        }
                    }

                }
            }

        }

    }

    public static void getRegions(int amt) {
        System.out.print("Region\t\t");
        System.out.print("Capacity\t");
        System.out.println("Animal\t");
        for (int i = 0; i < uf.sets.size(); i++) {
            if (uf.sets.get(i).size() > amt) {
                System.out.println(i + "\t\t" + uf.get(i).size() + "\t\t" + grid.getAnimal(i));
            }

        }

    }

}
