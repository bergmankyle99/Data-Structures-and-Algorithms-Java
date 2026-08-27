import java.util.ArrayList;
import java.util.Random;

public class FinalExamDriver {

    public static void main(String[] args) {
        GraphEdge<String> edgesV = new GraphEdge();
        GraphEdge<String> edgesH = new GraphEdge();
        UnionFind<String> uf = new UnionFind();
        BinaryHeapMin<GraphEdge<String>> heap = new BinaryHeapMin();
        ArrayList<GraphEdge<String>> minTree = new ArrayList();
        ArrayList<GraphEdge> spanningTree = new ArrayList();
        String[][] maze = new String[21][75];
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 75; j++) {
                maze[i][j] = i + "," + j;

            }
            System.out.println();
        }
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 75; j++) {
                Random rand = new Random();
                edgesH = new GraphEdge();
                edgesH.v1 = maze[i][j];
                if (j + 2 < 75) {
                    edgesH.v2 = maze[i][j + 2];
                } else {
                    edgesH.v2 = null;
                }

                edgesH.e = rand.nextInt(1000);
                heap.add(edgesH);
                j++;
            }
            i++;
        }
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 75; j++) {
                Random rand = new Random();
                edgesV = new GraphEdge();
                edgesV.v1 = maze[i][j];
                if (i + 2 < 21) {
                    edgesV.v2 = maze[i + 2][j];
                } else {
                    edgesV.v2 = null;
                }
                edgesV.e = rand.nextInt(1000);
                heap.add(edgesV);
                j++;
            }
            i++;
        }
        for (int i = 0; i < heap.count; i++) {
            minTree.add(heap.remove(0));
            

        }
        for (int i = 0; i < minTree.size(); i++) {
            Integer set1 = uf.find(minTree.get(i).v1);
            Integer set2 = uf.find(minTree.get(i).v2);

            if (set1 == null && set2 == null) {
                set1 = uf.add(minTree.get(i).v1);
                set2 = uf.add(minTree.get(i).v2);
                uf.union(set1, set2);
                spanningTree.add(minTree.get(i));
            } else if (set1 != null && set2 == null) {
                set2 = uf.add(minTree.get(i).v2);
                uf.union(set1, set2);
                spanningTree.add(minTree.get(i));
            } else if (set1 == null && set2 != null) {
                set1 = uf.add(minTree.get(i).v1);
                uf.union(set1, set2);
                spanningTree.add(minTree.get(i));
            } else if (set1 != null && set2 != null && set1.equals(set2) == false) {
                uf.union(set1, set2);
                spanningTree.add(minTree.get(i));
            } else if (set1 != null && set2 != null && set1.equals(set2)) {

            }
        }
        for (int j = 0; j < spanningTree.size(); j++) {
            System.out.print(j + ": ");
            System.out.print(spanningTree.get(j).v1 + " <----> ");
            System.out.print(spanningTree.get(j).v2 + ", Weight = ");
            System.out.println(spanningTree.get(j).e);
        }
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 75; j++) {
                maze[i][j] = i + "," + j;
                
            }
            
        }
        ArrayList<String> mids = FindMids(spanningTree);
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 75; j++) {
                if (TreeCheck(spanningTree, (i + "," + j))) {
                    maze[i][j] = ".";
                }
                else if(mids.contains((i + "," + j))){
                   
                     maze[i][j] = ".";
                }
                else{
                    maze[i][j] = "#";
                }
            }
        }
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 75; j++) {
                System.out.print(maze[i][j]);
            }System.out.println();
        }
    }

    public static boolean TreeCheck(ArrayList<GraphEdge> spanningTree, String mazeSpot) {
        for (int i = 0; i < spanningTree.size(); i++) {
            if (spanningTree.get(i).v1.equals(mazeSpot)) {
                return true;
            }
        }
        return false;
    }
public static ArrayList<String> FindMids(ArrayList<GraphEdge> spanningTree) {
        ArrayList<String> tree = new ArrayList();
        for (int i = 0; i < spanningTree.size(); i++) {
            String[] split = ((String) spanningTree.get(i).v1).split(",");
            int i1 = Integer.parseInt(split[0]);
            int j1 = Integer.parseInt(split[1]);
            int i2 = 0;
            int j2 = 0;
            if (spanningTree.get(i).v2 == null) {
            } else {

                String[] split2 = ((String) spanningTree.get(i).v2).split(",");
                i2 = Integer.parseInt(split2[0]);
                j2 = Integer.parseInt(split2[1]);
                if (i1 == i2) {
                    int iMid = i1;
                    int jMid = j1 + 1;
                    String middle = iMid + "," + jMid;
                    tree.add(middle);
                }
                if (j1 == j2) {
                    int iMid = i1 + 1;
                    int jMid = j1;
                    String middle = iMid + "," + jMid;
                    tree.add(middle);
                }
            }

        }
        return tree;
    }

}
