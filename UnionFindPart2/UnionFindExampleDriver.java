
import java.util.*;

public class UnionFindExampleDriver {

    /**
     * This is your UnionFind generic class that does Union-Find (part I of the
     * assignment). If you're not comfortable using your own Union-Find code
     * then you can use the one provided available in moodle (recommended to use
     * yours if it works
     */
    public static UnionFind<String> uf;

    /**
     * Class that contains code to produce the maze/grid randomly as well as
     * code to colorize the regions
     */
    public static Maze grid;

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            /**
             * Ask for a number between zero to one which is the probability of
             * having a wall appear or not in the grid. Used for random
             * generation of the maze/grid.
             */
            System.out.print("Enter probability of a wall (0.0 - 1.0) >> ");

            /**
             * Generate a 10x25 grid. You can change this to any size and it
             * will work *BUT* my drawMazeSets method can not display properly a
             * grid that has greater than 999 cells.
             */
            grid = new Maze(10, 25, sc.nextDouble());

            /**
             * create a new instance of your UnionFind class. Attempt to find
             * the regions of the grid.
             */
            uf = new UnionFind<String>();

            /* Display the random grid generated */
            System.out.println("Random Grid");
            grid.drawMaze();

            /* This is where you must create the code as discussed in class to find the regions */
            findRegions();

            /* Lets display the regions found using Union-Find */
            System.out.println("\nRegions found");

            /* Use the non-color version if you're editor can't handle color console */
            //grid.drawMazeSets(uf);
            grid.drawMazeSetsInColor(uf);
        }
    }

    public static void findRegions() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 25; j++) {
                    if(grid.maze[i][j]==true){
                        uf.add("#");
                    }
                    else{
                        uf.add(i+","+j);
                        if(i-1 >= 0){
                            if(grid.maze[i-1][j]==false){
                                uf.union(uf.find((i-1)+","+j), uf.find(i+","+j));
                            }
                        }
                        if(j-1>=0){
                            if(grid.maze[i][j-1]==false){
                                uf.union(uf.find(i+","+(j-1)), uf.find(i+","+j));
                            }
                        }
                    }
                }   
            }
        }
    }

