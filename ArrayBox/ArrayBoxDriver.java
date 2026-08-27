import java.util.Scanner;
/**
 *
 * @author goodo
 */
public class ArrayBoxDriver extends ArrayBox{
    public static void main(String[] args){
            mainMenu();    
    }
    public static void mainMenu(){
        
        Scanner scan = new Scanner(System.in);
        ArrayBox<String>box = new ArrayBox<String>();
    
        int input = 0; 
        
        while(input != 5){
            try{
                if(input == 0){
                    System.out.println("===============================");
                    System.out.println("============Array Box==========");
                    System.out.println("===============================");
                    System.out.println("Input Number to Select...");
                    System.out.println("1. Add element(String) to the Box");
                    System.out.println("2. Remove an element(String) from the Box");
                    System.out.println("3. Replace(set) an element(String) from the Box");
                    System.out.println("4. List the items inside the Box");
                    System.out.println("5. Get item from the Box at given index");
                    System.out.println("6. Check if Box is empty");
                    System.out.println("7. To Exit...");
                    input = scan.nextInt(); 
                }
            
                if(input == 1){
                    System.out.println("Input String to add: ");
                    String e = scan.next();
                    box.add(e);         
                }
                if(input == 2){
                    System.out.println("Input index of item to remove:");
                    int index = scan.nextInt();
                    if(box.isEmpty() == true){
                        System.out.println("ERROR! Box EMPTY!");
                    }
                    else if(index > box.size()||index < 0){
                        System.out.println("ERROR! Index must be between 0 and "+ (box.size() -1));
                    }
                    else{
                        box.remove(index);
                    }
                }
                if(input == 3){
                    System.out.println("Input index of item to replace: ");
                    int index = scan.nextInt();
                    System.out.println("Enter String: ");
                    String str = scan.next();
                    box.set(index, str);
                }
                if(input == 4){
                    System.out.println("Listing Items:");
                    box.list();
                }
                if(input == 5){
                    System.out.println("Enter index of item in box");
                    int index = scan.nextInt();
                    box.get(index);
                }
                if(input == 6){
                    System.out.println("Is Empty?: "+ box.isEmpty());
                }
                if(input == 7){
                    System.exit(0);
                }
        
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Index out of Bounds, try again");
            }
            input = 0;
         }
        
        }
    }
