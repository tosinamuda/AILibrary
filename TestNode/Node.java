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
    
    /**
     * Constructors
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
    }
    
    /**
     * Properties
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
        g.fillOval((int)this._drawingLocation.getX(), (int)this._drawingLocation.getY(), diameter, diameter);
     }   
    
     protected void paintComponent(Graphics g) {
         drawCircle(g);
    }   
}
