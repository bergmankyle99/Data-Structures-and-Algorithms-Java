package SkysTheLimit;
import java.util.ArrayList;

public class BinaryHeapMin<E> {

    private ArrayList<E> nodes = new ArrayList<E>();
    public int count = 0;

    public boolean add(E e) {
        if (nodes.size() == 0) {
            nodes.add(e);
        } else {
            nodes.add(e);
        }

        if (nodes.size() > 1) {
            bubble_up(nodes.size() - 1);
        }
        count++;
        return true;
    }

    public void bubble_up(int idx) {
        if (idx == 0) {
            return;
        } else {
            E nv = nodes.get(idx);
            int p_idx = (int) ((idx - 1) / 2);
            E pv = nodes.get(p_idx);
            if ((((Comparable)pv).compareTo(nv)) > 0) {
                nodes.set(p_idx, nv);
                nodes.set(idx, pv);
                bubble_up(p_idx);
            }
        }
    }

    public void bubble_down(int idx) {
        E nv = nodes.get(idx);
        E child;
        int child_idx2 = ((idx + 1) * 2) - 1;
        int child_idx1 = (idx + 1) * 2;
        int child_idx = 0;
        try {
            if ((((Comparable)nodes.get(child_idx1)).compareTo(nodes.get(child_idx2))) > 0) {
                child = nodes.get(child_idx2);
                child_idx = child_idx2;
            } else {
                child = nodes.get(child_idx1);
                child_idx = child_idx1;
            }
            if ((((Comparable)nv).compareTo(child)) > 0) {
                nodes.set(child_idx, nv);
                nodes.set(idx, child);
                bubble_down(child_idx);
            }
        } catch (IndexOutOfBoundsException e) {
            //System.out.println("this");
            return;
        }

    }

    public E remove(int idx) {
        if (nodes.isEmpty()) {
            return (E) "0";
        } else {
            E prevVal = nodes.get(idx);
            E leaf = nodes.remove(nodes.size() - 1);
            nodes.set(idx, leaf);
            bubble_down(idx);
            count--;
            return prevVal;
        }

    }

    public E get(int val) {
        return nodes.get(val);
    }

    public Integer find(E e) {
        Integer val = 0;
        for (int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i).equals(e)) {
                val = i;
                return val;
            }
            if((i*2+1) < nodes.size()){
                int leftIdx = 2*i+1;
                int rightIdx = 2*i+1;
                if(((Comparable)nodes.get(leftIdx)).compareTo(e)>0 && ((Comparable)nodes.get(rightIdx)).compareTo(e)>0){
                    return null;
                }
                if(((Comparable)nodes.get(leftIdx)).compareTo(e)<0 && ((Comparable)nodes.get(rightIdx)).compareTo(e)>0){
                    val = 2*leftIdx+1;
                    
                }
                if(((Comparable)nodes.get(leftIdx)).compareTo(e)>0 && ((Comparable)nodes.get(rightIdx)).compareTo(e)<0){
                    val = 2*rightIdx+1;
                    
                }
            }
        }
        return val;
    }
}
