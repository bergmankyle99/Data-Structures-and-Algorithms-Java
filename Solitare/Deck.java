

import java.util.ArrayList;
import java.util.EmptyStackException;


public class Deck <E>{
    ArrayList<E>stack = new ArrayList<E>();
    
    public boolean isEmpty(){
       return stack.isEmpty();
    }
   public E push(E item){
       stack.add(item);
       return item;
    }
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
    public E peek() throws EmptyStackException{
       E item = (E)"";
       try{
           item = stack.get(stack.size()-1);
       }
       catch(EmptyStackException e){
           System.out.println("Stack is Empty");
       }
       return item;
    }
    public int size(){
       return stack.size();
   }
}
