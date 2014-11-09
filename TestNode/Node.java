/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestNode;

/**
 *
 * @author BaldEagle
 */
import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Node implements Comparable<Object>
{
    private Point _drawingLocation;
    private Point _center;
    private String _label;
    private double _diameter;
    private boolean _visited;
    
    /**
     * Constructors
     * @param label
     * @param diameter
     * @param location
     */
    public Node(String label, double diameter, Point location)
    {
        this._drawingLocation = location;
        this._label = label;  
        this._diameter = diameter;
    }
    
     public Node(String label, double diameter)
    {
      
        this._label = label;  
        this._diameter = diameter;
    }
    
    public Node(String label)
    {
        this._label = label;
        this._drawingLocation = new Point(0,0);
        this._diameter = 20;
    }
    
    /**
     * Properties
     * @return 
     */
    public double Diameter()
    {
        return this._diameter;
    }
    
    public String Label()
    {
        return this._label;        
    }
    
    
    public Point Center()
    {
        //return this._center;
        //center equals (x+radius,y+radius) where x and y is the upper left corner of the rectangle for a circle
        return new Point((int)(this._drawingLocation.getX() + this._diameter / 2), (int)(this._drawingLocation.getY() + this._diameter / 2));
    }

    public void setCenter(Point center) {
        this._center = center;
    }

    public void setDrawingLocation(Point _drawingLocation) {
        this._drawingLocation = _drawingLocation;
    }

    public void setLabel(String _label) {
        this._label = _label;
    }

    public void setDiameter(double _diameter) {
        this._diameter = _diameter;
    }
    
    
    
     
    @Override
    public int compareTo(Object o) throws ArithmeticException {
        Node node = (Node)o;
        
        if (Integer.parseInt(this._label) > Integer.parseInt(node.Label()))
            return 1;
        else if (Integer.parseInt(this._label) < Integer.parseInt(node.Label()))
            return -1;
        else 
            return 0;
        }
       
     public void drawCircle(Graphics g)
     {
         
          int diameter = (int)this._diameter;
         if(this.isVisited()){
            g.setColor(Color.green);
            g.fillOval((int)this._drawingLocation.getX(), (int)this._drawingLocation.getY(), diameter, diameter);
            g.setColor(Color.red);
            g.drawString(this._label, (int)this.Center().getX() - 5, (int)this.Center().getY()+ 5);
         }
         
         else
         {
             
          g.setColor(Color.black);
        g.fillOval((int)this._drawingLocation.getX(), (int)this._drawingLocation.getY(), diameter, diameter);
       g.setColor(Color.red);
        g.drawString(this._label, (int)this.Center().getX() - 5, (int)this.Center().getY()+ 5);
             
         }
         
        
     }   
    
     protected void paintComponent(Graphics g) {
         drawCircle(g);
    }   

    /**
     * @return the _visited
     */
    public boolean isVisited()
    {
        return _visited;
    }

    /**
     * @param _visited the _visited to set
     */
    public void setVisited(boolean _visited)
    {
        this._visited = _visited;
    }

    /**
     * @return the _visited
     */    
}
