package zookeeper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import static zookeeper.ZooKeeperDriver.uf;

/**
 *
 * @author goodo
 */
public class Maze {

    public boolean[][] maze;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String BG_ANSI_BLACK = "\u001B[40m";
    public static final String BG_ANSI_RED = "\u001B[41m";
    public static final String BG_ANSI_GREEN = "\u001B[42m";
    public static final String BG_ANSI_YELLOW = "\u001B[43m";
    public static final String BG_ANSI_BLUE = "\u001B[44m";
    public static final String BG_ANSI_PURPLE = "\u001B[45m";
    public static final String BG_ANSI_CYAN = "\u001B[46m";
    public static final String BG_ANSI_WHITE = "\u001B[47m";
    public static String a;
    public static ArrayList<Integer> regionsWithAnimals= new ArrayList();
    public static ArrayList<String> animalList = new ArrayList();
    public static ArrayList<Integer> animalCount = new ArrayList();
    public static ArrayList<Integer> regionList= new ArrayList();
    public static final String[] colors = new String[]{
        BG_ANSI_RED,
        BG_ANSI_GREEN,
        BG_ANSI_YELLOW,
        BG_ANSI_BLUE,
        BG_ANSI_PURPLE,
        BG_ANSI_CYAN};

    public Maze(int rows, int cols, double prob) {
        maze = new boolean[rows][cols];
        create(prob);
    }

    private void create(double prob) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (Math.random() < prob) {
                    maze[i][j] = true;
                }
            }
        }
    }

    public void drawMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] ? "#  " : ".  ");
            }

            System.out.println();
        }
    }

    
    public void drawMazeSets(UnionFind uf)
    {
        for(int i=0; i<maze.length; i++)
        {
            for(int j=0; j<maze[0].length; j++)
            {
                
                Integer in_set = uf.find(i+","+j);
                System.out.printf( "%-3s", in_set==null ? "#" : ". ");
            }
            System.out.println();
        }
    }
     
    public void drawMazeSetsInColor(UnionFind uf) {
        String[] use_color = new String[maze.length * maze[0].length];

        int color_loop = 0;
        String color;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {

                Integer in_set = uf.find(i + "," + j);
                
                if (in_set != null) {
                    color = use_color[in_set];
                    if (color == null) {
                        color = colors[color_loop++ % colors.length];
                        use_color[in_set] = color;
                    }

                } else {
                    color = "";
                }

                if (in_set == null) {
                    System.out.printf(color + "%-3s" + ANSI_RESET, in_set == null ? "#" : in_set);
                } else {
                    regionList.add(in_set);
                    if ((i + "," + j).equals(SetHead(in_set))) {
                        System.out.printf(color + "%-3s" + ANSI_RESET, in_set == null ? "#" : in_set);
                    } else {
                        if (regionsWithAnimals.contains(uf.find(i + "," + j))) {
                            String animal = "";
                            ArrayList<String> list = randomize(in_set, animalCount.get(regionsWithAnimals.indexOf(in_set)));
                            for (int g = 0; g < list.size(); g++) {
                                if ((i + "," + j).equals(list.get(g))) {
                                    animal = animalList.get(regionsWithAnimals.indexOf(in_set));
                                    
                                }
                            }
                            System.out.printf(color + "%-3s" + ANSI_RESET, in_set == null ? "#" : animal);
                        } else {
                            System.out.printf(color + "%-3s" + ANSI_RESET, in_set == null ? "#" : ". ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public static String SetHead(int area) {
        HashSet<String> set = new HashSet<String>();
        set.addAll(uf.sets.get(area));
        Iterator<String> itr = set.iterator();
        String obj;
        ArrayList<String> list = new ArrayList();
        while (itr.hasNext()) {

            obj = itr.next();
            //System.out.println(obj);
            list.add(obj);

            //System.out.println(list.get(0));
        }
        return HeadHunter(list);
    }

    public static String HeadHunter(ArrayList list) {
        String str1 = list.get(0).toString();
        int str1Head = Integer.parseInt(list.get(0).toString().split(",")[0]);
        ArrayList<String> intList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str2 = list.get(i).toString();
            int str2Head = Integer.parseInt(list.get(i).toString().split(",")[0]);
            if (str1Head > str2Head) {
                str1 = str2;
                str1Head = str2Head;
            }
        }
        return str1;
    }

    public static void animalAdd(String animal, int amt, int area) {
        regionsWithAnimals.add(area);
        animalList.add(animal);
        animalCount.add(amt);

    }

    public static ArrayList randomize(int area, int amt) {
        HashSet<String> set = new HashSet<String>();
        set.addAll(uf.sets.get(area));
        Iterator<String> itr = set.iterator();
        String obj;
        ArrayList<String> list = new ArrayList();
        ArrayList<String> list2 = new ArrayList();
        while (itr.hasNext()) {

            obj = itr.next();
            //System.out.println(obj);
            list.add(obj);

        }
        Random rand = new Random();

        for (int i = 0; i < amt; i++) {
            if (list.size() > 0) {
                int num = rand.nextInt(list.size());
                list2.add(list.remove(num));
            }

        }
        //System.out.println(list2);
        return list2;
    }
   public static String getAnimal(int area){
       if(regionsWithAnimals.contains(area)){
           return animalList.get(regionsWithAnimals.indexOf(area));
       }else{
          return "--"; 
       }
       
   }
   public static void moveAnimal(int area1, int area2){
       regionsWithAnimals.set(regionsWithAnimals.indexOf(area1), area2);
   }

}
