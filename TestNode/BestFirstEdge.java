/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestNode;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author BaldEagle
 */
public class BestFirstEdge implements Comparable<Object>
{
    private BestFirstNode2 _v1;
    private BestFirstNode2 _v2;
    public double _weight; 
    public BestFirstEdge parent =null;
    
    public BestFirstEdge(BestFirstNode2 v1 , BestFirstNode2 v2, double weight)
    {
        this._v1 = v1;
        this._v2 = v2;
        this._weight = weight;
        
    }
    public BestFirstEdge(BestFirstNode2 v1, BestFirstNode2 v2)
    {
        this._v1 = v1;
        this._v2 = v2;        
    }
          
      /**
     * This method returns the start node of an edge
     */
    public BestFirstNode2 thisNode()
    {
        return this._v1;
    }
    /**
     * 
     */
    public BestFirstNode2 otherNode(BestFirstNode2 node)
    {
        if (node == _v1)
            return this._v2;
        else    
            return this._v1;
    }

    public double getWeight()
    {
        return this._weight;
    }
    
    
    
        
    public int compareTo(Object o) 
    {
        BestFirstEdge e = (BestFirstEdge)o;
        if (this._weight > e.getWeight())
            return 1;
        else if (this._weight < e.getWeight())
            return -1;
        else 
            return 0;                
    }
     
 
    protected void paintComponent(Graphics g) {
        //g.drawLine(1, 2, 2, 1);
    }
    
    public void drawEdge(Graphics g)
    {
        g.setColor(Color.black);
        g.drawLine((int)this._v1.Center().getX(), (int)this._v1.Center().getY(), (int)this._v2.Center().getX(), (int)this._v2.Center().getY());
    }
    
}
