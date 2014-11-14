/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Graph;

/**
 *
 * @author BaldEagle
 */
import Model.Graph.Node;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.Graphics;

public class Edge 
{
    private Node _v1;

   
    private Node _v2;
   
    public Edge parent = null;
    private boolean isVisited;


    
   
    public Edge(Node v1, Node v2)
    {
        this._v1 = v1;
        this._v2 = v2;        
    }
          
      /**
     * This method returns the start node of an edge
     */
    public Node thisNode()
    {
        return this._v1;
    }
    /**
     * 
     */
    public Node otherNode(Node node)
    {
        if (node == _v1)
            return this._v2;
        else    
            return this._v1;
    }

     public Node getV1() {
        return _v1;
    }

    public void setV1(Node _v1) {
        this._v1 = _v1;
    }

    public Node getV2() {
        return _v2;
    }

    public void setV2(Node _v2) {
        this._v2 = _v2;
    }
  
    
    
    
        
 
     
         public boolean getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
 
    protected void paintComponent(Graphics g) {
        //g.drawLine(1, 2, 2, 1);
    }
    
    public void drawEdge(Graphics2D g)
    {
        g.setColor(Color.black);
        g.drawLine((int)this._v1.Center().getX(), (int)this._v1.Center().getY(), (int)this._v2.Center().getX(), (int)this._v2.Center().getY());
    }
}
