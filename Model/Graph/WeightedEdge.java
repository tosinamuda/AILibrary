/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Graph;

import Model.Graph.Node;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author tosinamuda
 */
public class WeightedEdge extends Edge implements Comparable<Object>
{
    private double _weight; 

   

    public WeightedEdge(Node v1, Node v2, double weight) {
        super(v1, v2);
        this._weight = weight;
    }
    
     public double getWeight() {
        return _weight;
    }

    public void setWeight(double _weight) {
        this._weight = _weight;
    }
    
    @Override
       public int compareTo(Object o) 
    {
        WeightedEdge e = (WeightedEdge)o;
        if (this._weight > e.getWeight())
            return 1;
        else if (this._weight < e.getWeight())
            return -1;
        else 
            return 0;                
    }
    
    @Override
         public void drawEdge(Graphics2D g)
    {
        
        
        
          
         if(this.getIsVisited()){
            g.setColor(Color.blue);
            g.setBackground(Color.white);
            g.drawLine((int)this.getV1().Center().getX(), (int)this.getV1().Center().getY(), (int)this.getV2().Center().getX(), (int)this.getV2().Center().getY());
            
        }       
        else
        {             
        super.drawEdge(g);
        g.setColor(Color.red);
        g.drawString(String.valueOf(this._weight), (int)((this.getV1().Center().getX() +  this.getV2().Center().getX())/ 2), (int)((this.getV1().Center().getY() +  this.getV2().Center().getY())/ 2));  
        
        }          
    }
         
}
