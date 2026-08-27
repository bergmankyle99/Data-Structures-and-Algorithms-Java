
package ReHash;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        HashBox<String, Integer> map = new HashBox<String, Integer>();

        Scanner scan = new Scanner(System.in);
        int input = 0;

        while (input != 5) {
            System.out.println("=[==[==[=[=================================]=]==]==]=");
            System.out.println("=[==[==[=[     Welcome to HashBox          ]=]==]==]=");
            System.out.println("=[==[==[=[=================================]=]==]==]=");
            System.out.println("There are currently " + map.size() + " items in the box");
            System.out.println("Choose...");
            System.out.println("1. PUT an element(<String,Integer>) to our box.");
            System.out.println("2. REMOVE an element(<String,Integer>) from our box.");
            System.out.println("3. List the contents of the box.");
            System.out.println("4. GET an element (<String,Integer>)");
            System.out.println("5. Exit program");
            input = scan.nextInt();
            if (input == 1) {
                System.out.println("What would you like to add?");
                System.out.println("Key?(String): ");
                String key = scan.next();
                System.out.println("Value?(int): ");
                int value = scan.nextInt();
                map.put(key, value);
            }
            if (input == 2) {
                System.out.println("Key?(String): ");
                String key = scan.next();
                map.remove(key);
            }
            if (input == 3) {
                map.List();
            }
            if (input == 4) {
                System.out.println("What would you like to get?");
                System.out.println("Key?(String): ");
                String key = scan.next();
                System.out.println("Key: "+key+": "+map.get(key));
            }
            if (input == 5) {
                continue;
            }

        }
       

    }

    
}
