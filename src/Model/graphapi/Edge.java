/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.graphapi;

/**
 *
 * @author Tosin AMUDA
 */
public class Edge implements Comparable<Object>
{
    public final int v1, v2;
    public final double weight;
    
    public Edge(int v1, int v2, double weight)
    {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }
    
  
    /**
     * This method returns the start node of an edge
     */
    public int thisVertex()
    {
        return this.v1;
    }
    /**
     * 
     */
    public int otherVertex(int vertex)
    {
        if (vertex == v1)
            return this.v2;
        else    
            return this.v1;
    }

    public double getWeight()
    {
        return this.weight;
    }
    
    
    @Override
    public String toString()
    {
        return this.v1 + "-" + this.v2;
    }

    
    @Override
    public int compareTo(Object o) {
        Edge e = (Edge)o;
        if (this.weight > e.weight)
            return 1;
        else if (this.weight < e.weight)
            return -1;
        else 
            return 0;
        
        
    }
}
