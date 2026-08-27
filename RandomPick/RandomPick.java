package RandomPick;

import java.util.Random;
import java.util.Scanner;


public class RandomPick {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //O(1)
        System.out.println("Enter Integer");//O(1)
        int input = scan.nextInt();//O(1)
        Random rand = new Random();//O(1)
        int r1 = rand.nextInt(input);//O(1)
        randomChecker(r1,input);
        
        }
        
      public static void randomChecker(int r1, int input) {
          
        Random rand = new Random();//O(1)
        int r2 = rand.nextInt(input);//O(1)
        int r3 = rand.nextInt(input);//O(1)
        System.out.println("Random Number 1: "+ r1 +"\nRandom Number 2: "+ r2 +"\nRandom Number 3: "+r3);//O(1)
        System.out.println("----");//O(1)
        if(r1 != r2 || r1 != r3){//O(1)
            randomChecker(r1, input); //O(n^2)
         }
         return;//O(1)
      }
            
       
        
    }
    

