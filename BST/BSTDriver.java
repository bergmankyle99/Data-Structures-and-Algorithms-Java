
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author goodo
 */
public class BSTDriver {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        Scanner scan = new Scanner(System.in);
        int input = 0;
        
        while (input != 6) {
            System.out.println("===============================");
            System.out.println("=======Binary Search Tree======");
            System.out.println("===============================");
            System.out.println("Choose...");
            System.out.println("1. Add Integer(s) to the tree");
            System.out.println("2. Display Tree");
            System.out.println("3. Find an element");
            System.out.println("4. Perform a tree sort on the elements");
            System.out.println("5. Remove an Integer(element) from the tree");
            System.out.println("6. Exit...");
            input = scan.nextInt();
            if (input == 1) {
                System.out.print("Enter Integer to add to the tree (type 'STOP' to exit)>> ");
                String val = scan.next();
                while(val.equalsIgnoreCase("STOP")==false){
                    System.out.print("Enter Integer to add to the tree (type 'STOP' to exit)>> ");
                    tree.add(Integer.parseInt(val)); 
                    val = scan.next();
                }   
            }
            if (input == 2) {
                System.out.print("PARENT\t");
                System.out.print("NODE.E\t");
                System.out.print("NODE.LEFT ");
                System.out.println("NODE.RIGHT");
                BinarySearchTreeVertex<Integer> current = tree.root;
                tree.treeWriter(current);
            }
            if (input == 3) {
                System.out.println("What value are you looking for?>> ");
                Integer val = scan.nextInt();
                System.out.println("Is Value in the tree?: "+tree.find(val));
            }
            if (input == 4){
                System.out.println("SORTING...");
                tree.traverse(tree.root);
                System.out.println();
            }
            if (input == 5){
                System.out.println("REMOVE STATUS = Not working :(");
            }
        }

    }

    
    
}
