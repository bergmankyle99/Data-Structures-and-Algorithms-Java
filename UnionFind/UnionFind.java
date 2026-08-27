/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unionfind;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author goodo
 */
public class UnionFind<E> {

    public ArrayList<HashSet<E>> sets = new ArrayList();
    int count = 0;
    public int add(E e) {
        HashSet h = new HashSet();
        h.add(e);
        sets.add(h);
        System.out.println(e+" was added to set#: "+ count);
        count++;
        return sets.size() - 1;
    }

    public HashSet get(int set_num) {
        System.out.println(set_num+": "+sets.get(set_num));
        return sets.get(set_num);
    }

    public boolean find(E e1, E e2) {
        for (int i = 0; i < sets.size(); i++) {
            if (sets.get(i) == e1) {
                if (sets.get(i) == e2) {
                    System.out.println(e1+" and "+e2+" are in the same set");
                    return true;   
                }
            }else{
                System.out.println(e1+" and "+e2+" are NOT in the same set");
                return false;
            }

        }
        return true;
    }
    public int union(int set1,int set2){
        if(sets.get(set1) == sets.get(set2)){
            return set1;
            
        }else{
            HashSet H1 = sets.get(set1);
            HashSet H2 = sets.get(set2);
            if(H1.size()>H2.size()){
                H1.addAll(H2);
                H2.clear();
                System.out.println("Items moved to Set#: "+set1);
                return set1;
            }else{
                H2.addAll(H1);
                H1.clear();
                System.out.println("Items moved to Set#: "+set2);
                return set2;
            }
        }
       
    }
    public Integer find(E e1){
        int val= 0;
        for(int i = 0; i < sets.size();i++){
            for(int j = 0; j < sets.get(i).size();j++){
                if(sets.get(i).contains(e1)){
                   val = i;
                }
            }
        }
        System.out.println(e1 +" is in set#: "+val);
        return (Integer)val;
        
    }
    public int count(int set){
        return count;
    }
    
}
