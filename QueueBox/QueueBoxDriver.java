/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuebox;

/**
 *
 * @author goodo
 */
public class QueueBoxDriver extends QueueBox{
    
    public static void main(String[]args){
        go();
    }
    public static void go(){
     QueueBox<Integer> box = new QueueBox<Integer>();
     for(int i = 0; i < 60000; i++){
         box.add(i);
     }
     System.out.println("Total Items: "+ box.size());
     for(int i = 0; i < 50000; i++){
        box.remove();
    }
       
     while(box.isEmpty() != true){
          System.out.println(box.remove());
     }
    }
}
