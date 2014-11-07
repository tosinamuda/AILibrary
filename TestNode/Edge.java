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

public class Edge 
{
    private Node _v1;
    private Node _v2;
    private double _weight;            
    
    public Edge(Node v1 , Node v2, double weight)
    {
        this._v1 = v1;
        this._v2 = v2;
        this._weight = weight;
        
    }
    
    public Edge() 
    {
        this(null,null,2);
    }
    
    
    
}
