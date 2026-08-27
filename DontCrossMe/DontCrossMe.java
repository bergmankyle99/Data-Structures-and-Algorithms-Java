/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dontcrossme;

/**
 *
 * @author Kyle Bergman
 */
public class DontCrossMe {

    public static void main(String[] args) {
     //Array Declaration
     int a[] = {2,3};
     int b[] = {6,7,8};
     //Display Arrays
     System.out.print("A = {");
     for(int i =0; i<a.length;i++){
         System.out.print(a[i]);
     }
     System.out.print("}");
     System.out.print("\nB = {");
     for(int i =0; i<b.length;i++){
         System.out.print(b[i]);
     }
     System.out.println("}");
     //Get Cross Product of A[0]X B
     xProduct(a,b,0,0);
     //Get Cross Product of A[1]X B
     xProduct(a,b,1,0);
     
        }
    public static void xProduct(int[]a, int[]b, int aPos, int bPos){
        if(bPos < b.length && aPos < a.length){
            System.out.println("\n" + a[aPos]+"X"+b[bPos] +"="+(a[aPos]*b[bPos]));
            xProduct(a,b,aPos,bPos+1);
           return;
        }
        return;
    }
   
    }
    
    

