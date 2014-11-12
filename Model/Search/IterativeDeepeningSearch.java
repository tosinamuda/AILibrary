/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Search;

/**
 *
 * @author BaldEagle
 */
//import Model.graphapi.*;

import TestNode.*;
import static java.lang.System.out;
import java.util.*;
public class IterativeDeepeningSearch extends UninformedSearch
{        
     private int limit;
     
       public IterativeDeepeningSearch(Graph g)
    {
       super(g);
        
    } 

     public IterativeDeepeningSearch(Graph g, int limit)
    {
       super(g);
       this.limit = limit;
        
    }
    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int DLS(Node start, Node goal)
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
                for(Node e  : this.g.AdjacencyList2.get(currentNode))
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
    
    

    @Override
    public List<Node> Search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Node> Search(Node start) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Node> Search(Node start, Node goal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
