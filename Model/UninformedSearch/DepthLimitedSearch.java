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

import Model.graphapi.*;
import static java.lang.System.out;
import java.util.*;
public class DepthLimitedSearch
{
    public DepthLimitedSearch()
    {
        
    }
    
    /**
     * 
     * 
     */
    public void DLS(Graph g, int start, int goal, int limit)
    {
        int currentNode;
        int depth;
        Stack<Integer> searchStack = new Stack<Integer>();
        Stack<Integer> depthStack = new Stack<Integer>();
        List<Integer> VisitedNodeList = new ArrayList<>();
        searchStack.push(start);
        depthStack.push(0);
        while(!(searchStack.empty()))
        {
            currentNode = searchStack.pop();
            VisitedNodeList.add(currentNode);
            depth = depthStack.pop();            
            out.println("Depth\t" + depth + "\tNode\t" + currentNode);
            if(currentNode == goal)            
            {
                break;
            }
            if(depth < limit)
            {
                for(Edge e  : g.getIncidentList(currentNode))
                {
                    if(!(VisitedNodeList.contains(e.otherVertex(currentNode))) && !(searchStack.contains(e.otherVertex(currentNode))))
                    {
                        searchStack.push(e.otherVertex(currentNode));
                        depthStack.push(depth+1);                        
                    }                                    
                }
            }            
        }        
        for(int item : VisitedNodeList)
        {
            out.print(item + "\t");            
        }        
        
        
    }
    
}
