package QueueBox;
public class QueueBox<E>{
    public E[] elements = (E[])(new Object[5]);
    private int front_idx = 0;
    private int rear_idx = 0;
    private int count = 0;
    
    
    public boolean add(E e){
        if(rear_idx < elements.length){
            elements[rear_idx] = e; 
        }
        
        if(rear_idx >= elements.length){
            E[] temp = (E[])(new Object[rear_idx*2]);
            
            for(int i = 0; i < rear_idx; i++){
                temp[i] = elements[i];
            }
            temp[rear_idx] = e;
            elements = (E[])(new Object[rear_idx*2]);
            for(int i =0; i <= rear_idx; i++){
                elements[i] = temp[i];
            }   
            System.out.println("QUEUE RESIZED TO "+ elements.length);
        }
          rear_idx++;
        count++;
        return true;
       
    }
      
    public E remove(){
        E item = elements[front_idx];
         for(int i = 0; i < rear_idx -1 ; i++){
                elements[i] = elements[i+1];
            }
            rear_idx--;
            return item;
    }
    
    public E element(){
        return elements[front_idx];
    }
     public boolean isEmpty(){
        if(rear_idx == 0){
            return true;
        }
        else{
            return false;
        }
     }
    public int size(){
        return rear_idx;
    }
}

