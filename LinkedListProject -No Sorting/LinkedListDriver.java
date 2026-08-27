
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kyle
 */
public class LinkedListDriver {

    private static OrderedLinkedList<String> linked = new OrderedLinkedList<String>();

    public static void main(String[] args) {
        /**
         * A list of most popular north american men names according to some
         * website
         */

        linked.add("James");
        linked.add("David");
        linked.add("Christopher");
        linked.add("George");
        linked.add("Ronald");
        linked.add("John");
        linked.add("Richard");
        linked.add("Daniel");
        linked.add("Kenneth");
        linked.add("Anthony");
        linked.add("Robert");
        linked.add("Charles");
        linked.add("Paul");
        linked.add("Steven");
        linked.add("Kevin");
        linked.add("Michael");
        linked.add("Joseph");
        linked.add("Mark");
        linked.add("Edward");
        linked.add("Jason");
        linked.add("William");
        linked.add("Thomas");
        linked.add("Donald");
        linked.add("Brian");
        linked.add("Jeff");

        /**
         * A list of most popular north american women names according to some
         * website
         */
        linked.add("Mary");
        linked.add("Jennifer");
        linked.add("Lisa");
        linked.add("Sandra");
        linked.add("Michelle");
        linked.add("Patricia");
        linked.add("Maria");
        linked.add("Nancy");
        linked.add("Donna");
        linked.add("Laura");
        linked.add("Linda");
        linked.add("Susan");
        linked.add("Karen");
        linked.add("Carol");
        linked.add("Sarah");
        linked.add("Barbara");
        linked.add("Margaret");
        linked.add("Betty");
        linked.add("Ruth");
        linked.add("Kimberly");
        linked.add("Elizabeth");
        linked.add("Dorothy");
        linked.add("Helen");
        linked.add("Sharon");
        linked.add("Deborah");
        Scanner scan = new Scanner(System.in);
        int input = 0;
        while (input != 11) {
            System.out.println("=[==[==[=[=================================]=]==]==]=");
            System.out.println("=[==[==[=[=======Welcome to OrderedLinkedList========]=]==]==]=");
            System.out.println("=[==[==[=[=================================]=]==]==]=");
            System.out.println("");
            System.out.println("Choose...");
            System.out.println("");
            System.out.println("1. Add an element(String) to our box.");
            System.out.println("2. Get Number of Items in List");
            System.out.println("3. Get Item from the List");
            System.out.println("4. Return All Items");
            System.out.println("5. Exit");
            input = scan.nextInt();
            if(input == 1){
                System.out.println("What do you want to add?");
                String val = scan.next();
                linked.add(val);
            }
            if(input == 2){
                System.out.println(linked.size());
            }
            if(input == 3){
                System.out.println("Which Item? (index)");
                int idx = scan.nextInt();
                System.out.println(linked.get(idx));
            }
            if(input == 4){
                  for( int i=0; i<linked.size(); i++ )
                    System.out.println( i + "\t" + linked.get(i) );
            }
            if(input == 5){
                input = 11;
            }
        }
        
        /* print the names. Should come out as alphabetical */

    }

}
