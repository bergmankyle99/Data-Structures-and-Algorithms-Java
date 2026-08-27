/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author goodo
 */
public class GraphEdge<V> implements Comparable<GraphEdge> {
    public V v1;
    public V v2;
    public int e;
    
    public int compareTo(GraphEdge edge){
        if(this.e<edge.e)return -1;//e is less than
        if(this.e>edge.e)return 1;//e is greater
        
        return 0;//e is equal to edge.e
    }
}
