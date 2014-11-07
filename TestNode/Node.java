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

public class Node
{
    private Point _drawingLocation;
    private Point _center;
    private String _label;
    private final double _diameter;
    
    public Node(String label, double diameter, Point location)
    {
        this._drawingLocation = location;
        this._label = label;  
        this._diameter = diameter;
    }
        
}
