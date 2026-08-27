
import java.util.ArrayList;
import java.util.HashSet;

public class UnionFind<E> {

    public ArrayList<HashSet<E>> sets = new ArrayList();
    int count = 0;
    public int add(E e) {
        HashSet h = new HashSet();
        h.add(e);
        sets.add(h);
        count++;
        return sets.size() - 1;
    }

    public HashSet get(int set_num) {
        return sets.get(set_num);
    }

    public boolean find(E e1, E e2) {
        for (int i = 0; i < sets.size(); i++) {
            if (sets.get(i) == e1) {
                if (sets.get(i) == e2) {
                    return true;
                }
            }else{
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
                return set1;
            }else{
                H2.addAll(H1);
                H1.clear();
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
        return (Integer)val;
        
    }
    public int count(int set){
        return count;
    }
    
}
