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
class Edge 
{
    public final int v1, v2;

    
    
    public Edge(int v1, int v2)
    {
        this.v1 = v1;
        this.v2 = v2;
        
    }
    
  
     
    public int thisVertex()
    {
        return this.v1;
    }
    
    public int otherVertex(int vertex)
    {
        if (vertex == v1)
            return this.v2;
        else    
            return this.v1;
    }

  
    
    
    @Override
    public String toString()
    {
        return this.v1 + "-" + this.v2;
    }

    
   
}
