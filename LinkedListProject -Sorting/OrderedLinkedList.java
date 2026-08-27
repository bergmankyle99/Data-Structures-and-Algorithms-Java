

//Linked List with attempt at sorting
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
        }

    

        
        if (count > 0) {
            node.obj = e;
            tail.next = node;
            tail = node;
           
            LinkedListNode<E> current = head;

            for (int i = 0; i < count; i++) {
                if (((Comparable<E>) current.obj).compareTo(tail.obj) > 0) {
                    head.next = tail;
                    head = tail;
                    tail.next = current;
                    tail = current;
                    
                }
                current = head;
            }
            
             
       
        }
           
        count++;
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
