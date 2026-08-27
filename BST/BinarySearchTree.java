
import java.util.List;
import java.lang.Comparable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author goodo
 */
public class BinarySearchTree<E> {
    ArrayList<BinarySearchTreeVertex<E>> tree = new ArrayList<>();
    public BinarySearchTreeVertex<E> root = null;
    int count = 0;

    public boolean add(E e) {
        if (root == null) {
            root = new BinarySearchTreeVertex<E>();
            root.e = e;
            return true;
        }
        BinarySearchTreeVertex<E> current = root;

        while (current != null) {
            if (((Comparable) e).compareTo(current.e) <= 0) {
                if (current.left_child == null) {
                    current.left_child = new BinarySearchTreeVertex<E>();
                    current.left_child.e = e;
                    current.left_child.parent = current;
                    count++;
                    return true;
                }
                current = current.left_child;
            }
            if (((Comparable) e).compareTo(current.e) > 0) {
                if (current.right_child == null) {
                    current.right_child = new BinarySearchTreeVertex<E>();
                    current.right_child.e = e;
                    current.right_child.parent = current;
                    count++;
                    return true;
                }
                current = current.right_child;
            }
        }
        return false;
    }

    public boolean find(E e) {
        BinarySearchTreeVertex<E> current = root;
        while (current != null) {
            if (((Comparable) e).compareTo(current.e) == 0) {
                return true;
            } else if (((Comparable) e).compareTo(current.e) < 0) {
                current = current.left_child;
            } else {
                current = current.right_child;
            }
        }

        return false;
    }

    

    public static void traverse(BinarySearchTreeVertex current) {

        if (current.left_child != null) {
            traverse(current.left_child);
        }
        System.out.print(current.e + " ");
        if (current.right_child != null) {
            traverse(current.right_child);
        }
    }

    public static void treeWriter(BinarySearchTreeVertex current) {
        //System.out.println(current.e);
        if (current.parent == null) {
            System.out.print("null\t");
        } else {
            System.out.print(current.parent.e + "\t");
        }
        if (current.e == null) {
            System.out.print("null\t");
        } else {
            System.out.print(current.e + "\t");
        }
        if (current.left_child == null) {
            System.out.print("null\t");
        } else {
            System.out.print(current.left_child.e + "\t");
        }
        if (current.right_child == null) {
            System.out.println("  null\t");
        } else {
            System.out.println("  " + current.right_child.e + "\t");
        }

        if (current.left_child != null) {
            treeWriter(current.left_child);
        }
        if (current.right_child != null) {
            treeWriter(current.right_child);
        }

    }

   

}
