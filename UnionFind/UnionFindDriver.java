/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unionfind;

import java.util.Scanner;

/**
 *
 * @author goodo
 */
public class UnionFindDriver {

    public static void main(String[] args) {
        UnionFind uf = new UnionFind();
        Scanner scan = new Scanner(System.in);
        int input = 0;
        while (input != 7) {
            System.out.println("=[==[==[=[=================================]=]==]==]=");
            System.out.println("=[==[==[=[     Welcome to Union-Find       ]=]==]==]=");
            System.out.println("=[==[==[=[=================================]=]==]==]=");
            System.out.println("Choose...");
            System.out.println("1. ADD a String element");
            System.out.println("2. UNION(join) two sets.");
            System.out.println("3. FIND the set# for a STRING.");
            System.out.println("4. GET the set given the set#");
            System.out.println("5. TEST(FIND) if STRING s1 and STRING s2 are in the same set");
            System.out.println("6. Display Union Find Sets");
            System.out.println("7. Exit...");
            input = scan.nextInt();
            if (input == 1) {
                System.out.println("Enter String you would like to add: ");
                String val = scan.next();
                uf.add(val);
            }
            if (input == 2) {
                System.out.println("Which sets would you like to join?:(0-"+(uf.count-1)+")");
                System.out.println("Set1: ");
                int v1 = scan.nextInt();
                System.out.println("Set2: ");
                int v2 = scan.nextInt();
                uf.union(v1,v2);
            }
            if (input == 3) {
                System.out.println("What value?(String): ");
                String v2 = scan.next(); 
                uf.find(v2); 
            }
            if (input == 4) {
                System.out.println("Which set?:(0-"+(uf.count -1)+")");
                int set = scan.nextInt();
                uf.get(set);
            }
            if (input == 5) {
                System.out.println("String 1: ");
                String v1 = scan.next(); 
                System.out.println("String 2: ");
                String v2 = scan.next();
                if(uf.find(v1)==uf.find(v2)){
                    System.out.println("TRUE");
                }
                else{
                    System.out.println("FALSE");
                }
                
            }
            if (input == 6) {
                System.out.println(uf.count);
                for(int i = 0; i < uf.count; i++){
                    System.out.println(uf.get(i));
                }   
            }

        }
    
    }
}

