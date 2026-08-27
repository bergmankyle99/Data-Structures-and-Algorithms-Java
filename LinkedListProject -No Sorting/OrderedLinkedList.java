/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kyle
 */

//Normal Functioning Linked List with No Sorting
public class OrderedLinkedList<E> {

    private LinkedListNode<E> head = null;
    private LinkedListNode<E> tail = null;
    private int count = 0;

    
       public boolean add(E e) {
        LinkedListNode<E> node = new LinkedListNode<E>();
        if (count == 0) {
            node.obj = e;
            head = node;
            tail = node;
            count++;
        }
        else{
            node.obj = e;
            tail.next = node;
            tail = node;
            count++;
            
        }

    

        
      
            
             
       
        
           
   
        return true;
    }
    public E get(int index) throws IndexOutOfBoundsException {
        return (E) gotoidx(index).obj;
    }

    private LinkedListNode gotoidx(int idx) {
        LinkedListNode<E> current = head;
        for (int i = 0; i < idx; i++) {
            current = current.next;
        }
        return current;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

}
