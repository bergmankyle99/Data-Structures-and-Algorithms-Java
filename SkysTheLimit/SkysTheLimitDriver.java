
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;


public class SkysTheLimitDriver {

    public static void main(String[] args) {
        GraphEdge<String> edges = new GraphEdge();
        UnionFind<String> uf = new UnionFind();
        ArrayList<GraphEdge<String>> minTree = new ArrayList();
        BinaryHeapMin<GraphEdge<String>> heap = new BinaryHeapMin();
        ArrayList<GraphEdge> spanningTree = new ArrayList();
        try {
            File file = new File("C:\\Users\\goodo\\OneDrive - Thompson Rivers University\\School\\COMP2230-DATA STRUCTURES\\JavaFiles\\SkysTheLimit\\src\\worldcities.csv");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                edges = new GraphEdge();
                String data = scan.nextLine();
                String[] vals = data.split(",");
                edges.v1 = vals[0];
                edges.v2 = vals[1];
                edges.e = Integer.parseInt(vals[2]);
                heap.add(edges);
            }
            for (int i = 0; i < heap.count; i++) {
                minTree.add(heap.remove(0));
            }
          /* for (int i = 0; i < heap.count; i++) {
                System.out.println(minTree.get(i).v1+"-----"+minTree.get(i).v2);
            }*/
            for (int i = 0; i < minTree.size(); i++) {
               Integer set1 = uf.find(minTree.get(i).v1);
               Integer set2 = uf.find(minTree.get(i).v2);
               
               if(set1 == null && set2 == null){
                   set1 = uf.add(minTree.get(i).v1);
                   set2 = uf.add(minTree.get(i).v2);
                   uf.union(set1, set2);
                   spanningTree.add(minTree.get(i));
               }else if(set1 != null && set2 == null){
                   set2 = uf.add(minTree.get(i).v2);
                   uf.union(set1, set2);
                   spanningTree.add(minTree.get(i));
               }else if(set1==null && set2 != null){
                   set1 = uf.add(minTree.get(i).v1);
                   uf.union(set1, set2);
                   spanningTree.add(minTree.get(i));
               }
               else if(set1!=null && set2!=null && set1 != set2){
                   uf.union(set1, set2);
                   spanningTree.add(minTree.get(i));
               }
               else if(set1!=null && set2!=null && set1 == set2){
                   
               }
            }
             int total = 0;
            for (int j = 0; j < spanningTree.size(); j++) {
               System.out.print(spanningTree.get(j).v1 + " <----> ");
               System.out.print(spanningTree.get(j).v2 + ", Distance = ");
               System.out.println(spanningTree.get(j).e);
                total += spanningTree.get(j).e;
            }
            System.out.println("Total Distance: "+total);

            
        } catch (FileNotFoundException e) {
            System.out.println("Not Found Matey");
            e.printStackTrace();
        }

    }

}
