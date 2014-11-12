/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.UninformedSearch;

/**
 *
 * @author BaldEagle
 */
//import Model.graphapi.*;
import TestNode.*;
import static java.lang.System.out;
import java.util.*;
public class IterativeDeepeningSearch
{        
    public Graph _g;
    List<Node> listofTraversed = new ArrayList<>();
    public IterativeDeepeningSearch(Graph g)
    {
        this._g = g;
        
    }    
    
    public int DLS(Node start, Node goal, int limit)
    {
        Node currentNode = start;
        int depth;
        int result = 0;
        Stack<Node> searchStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<Integer>();
        List<Node> VisitedNodeList = new ArrayList<>();
        searchStack.push(start);
        depthStack.push(0);
        while(!(searchStack.empty()))
        {
            currentNode = searchStack.pop();
            VisitedNodeList.add(currentNode);
            listofTraversed.add(currentNode);
            currentNode.setVisited(true);
            depth = depthStack.pop();            
            out.println("Depth\t" + depth + "\tNode\t" + currentNode.Label());
            if(currentNode == goal)            
            {
                result = 1;
                break;
            }
            if(depth < limit)
            {
                for(Node e  : this._g.AdjacencyList2.get(currentNode))
                {
                    if(!(VisitedNodeList.contains(e)) && !(searchStack.contains(e)))
                    {
                        searchStack.push(e);
                        depthStack.push(depth+1);                        
                    }                                    
                }
            }            
        }        
        for(Node item : VisitedNodeList)
        {
            out.print(item.Label() + "\t");            
        }        
        
        return result;
    }
    
    public void IDS(Node start,Node goal)
    {
        int status;
        int depth;
        depth = 0;
        while(true)
        {
            status = this.DLS(start, goal, depth);
            if(status == 1) 
                break;
            else
                depth++;
        }        
    }
    
}
