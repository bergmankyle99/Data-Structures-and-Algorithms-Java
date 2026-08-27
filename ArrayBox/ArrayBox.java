public class ArrayBox<E> {

    private E[] elements = (E[])(new Object[2]);
    private int end_idx = 0;
    
    public int size(){
        return end_idx;
    }
    public boolean add(E e){
        if(end_idx < elements.length){
            elements[end_idx] = e; 
        }
        
        if(end_idx >= elements.length){
            E[] temp = (E[])(new Object[end_idx*2]);
            
            for(int i = 0; i < end_idx; i++){
                temp[i] = elements[i];
            }
            temp[end_idx] = e;
            elements = (E[])(new Object[end_idx*2]);
            for(int i =0; i <= end_idx; i++){
                elements[i] = temp[i];
            }   
            System.out.println("ARRAY RESIZED TO "+ elements.length);
        }
        end_idx++;
        return true;
       
    }
    public E get(int index)throws IndexOutOfBoundsException{
            System.out.println(""+elements[index]);
        return elements[index];
    }
        
    public E set(int index, String str)throws IndexOutOfBoundsException{
            elements[index] = (E)str;
     
         return elements[index];
    }
    public E[] list(){
        for(int j = 0; j < end_idx; j++ ){
                System.out.println("Item "+j+": " + elements[j]);
            } 
        return elements;
    }
    public E remove(int index) throws IndexOutOfBoundsException{
            System.out.println("Removing index: "+ elements[index]);
            for(int i = (index + 1); i < end_idx; i++){
                elements[index] = elements[i];
                index++;
            }
            end_idx--;
            return elements[index];
        }
      
        
    
    public boolean isEmpty(){
        if(end_idx == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
