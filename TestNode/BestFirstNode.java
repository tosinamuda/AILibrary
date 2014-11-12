/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestNode;
import java.util.*;
import java.awt.Point;

/**
 *
 * @author BaldEagle
 */
public class BestFirstNode  extends TestNode.Node
{
    public int costFunction;
    public int depth;
    
    public int heuristic = costFunction + depth;
    //OR
    public int heuristicValue;
    
    public List<BestFirstNode> children = new ArrayList<BestFirstNode>();
    
    
    public BestFirstNode(String label, double diameter, Point location)
    {
        super(label, diameter, location);
    }
    public BestFirstNode(String Label)
    {
        super(Label);
    }     
    
    @Override
    public int compareTo(Object o) throws ArithmeticException 
    {
        BestFirstNode node = (BestFirstNode)o;
        
        if (this.heuristic > node.heuristic)
            return 1;
        else if (this.heuristic < node.heuristic)
            return -1;
        else 
            return 0;
    }
}
