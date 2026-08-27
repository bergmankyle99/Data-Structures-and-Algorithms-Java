
import java.util.ArrayList;
import java.util.EmptyStackException;


public class Tableau<E>{
    ArrayList<E>stack = new ArrayList<E>();
    public E[] queue = (E[])(new Object[5]);
    private int front_idx = 0;
    private int rear_idx = 0;
    private int count = 0;
    
    /*ADD TO THE QUEUE*/
    public boolean addQ(E e){
        if(rear_idx < queue.length){
            queue[rear_idx] = e; 
        }
        
        if(rear_idx >= queue.length){
            E[] temp = (E[])(new Object[rear_idx*2]);
            
            for(int i = 0; i < rear_idx; i++){
                temp[i] = queue[i];
            }
            temp[rear_idx] = e;
            queue = (E[])(new Object[rear_idx*2]);
            for(int i =0; i <= rear_idx; i++){
                queue[i] = temp[i];
            }   
        }
          rear_idx++;
        count++;
        return true;
       
    }
    /*REMOVE FROM QUEUE*/
    public E remove(){
        if(rear_idx != 0 ){
            E item = queue[front_idx];
         for(int i = 0; i < rear_idx -1 ; i++){
                queue[i] = queue[i+1];
            }
            rear_idx--;
            return item;
        }
        else{
            System.out.println("Empty");
            return (E)"";
        }
          
       
    }
    
    /*ADD TO THE STACK*/
    public boolean push(E e){
        stack.add(e);
        return true;
    }

   /*REMOVE FROM STACK*/
   public E pop() throws EmptyStackException{
       E item = (E)"";
       try{
            item = stack.remove(stack.size()-1);
       }
       catch(EmptyStackException e){
           System.out.println("Stack is Empty");
       }
       return item;
   }
   public int Qsize(){
        return rear_idx;
    }
   public int Ssize(){
        return stack.size();
    }
 public E sPeek() throws EmptyStackException{
       E item = (E)"";
       try{
           item = stack.get(stack.size()-1);
       }
       catch(EmptyStackException e){
           System.out.println("Stack is Empty");
       }
       return item;
   }
 public boolean isEmpty(){
     return stack.isEmpty();
 }
 
 public void stackRefill(){
     stack.add(queue[0]);
     rear_idx--;
 }
}