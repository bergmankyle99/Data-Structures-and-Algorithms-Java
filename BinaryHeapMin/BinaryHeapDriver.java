
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author goodo
 */
public class BinaryHeapDriver {

    public static void main(String[] args) {
        BinaryHeapMin<String>heap = new BinaryHeapMin<String>();
        Scanner scan = new Scanner(System.in);
        System.out.println("How many random doubles?");
        int amt = scan.nextInt();
        long startTime = System.nanoTime();
        for(int i = 0; i < amt; i++){
            double rand = Math.random();
            heap.add(rand+"");
        }
        System.out.println("Items Added: "+heap.count);
        System.out.println("Sorting Items..");
        System.out.println("First 10: ");
         for(int i = 0; i < 10; i++){
            System.out.println((i+1)+":"+heap.remove(0));
        }
        // Calculate the estimatedTime in seconds (convert the time from nanoseconds).
        double estimatedTime = (System.nanoTime() - startTime) / 1e+9;
        System.out.println("DONE "+estimatedTime+" SECONDS");
// remove and display the root element of the heap (index 0) ten times.
// Display estimatedTime
    }
}
