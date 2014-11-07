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
public class IterativeDeepeningSearch
{        
    
    public IterativeDeepeningSearch()
    {
        
    }
    
    private int DLS(Graph g, int start, int goal, int limit)
    {
        int currentNode;
        int depth;
        int result = 0;
        Stack<Integer> searchStack = new Stack<Integer>();
        Stack<Integer> depthStack = new Stack<Integer>();
        List<Integer> VisitedNodeList = new ArrayList<Integer>();
        searchStack.push(start);
        depthStack.push(0);
        out.println();
        while(!(searchStack.empty()))
        {
            currentNode = searchStack.pop();
            VisitedNodeList.add(currentNode);
            depth = depthStack.pop();
            
            out.println("Depth\t" + depth + "\tNode\t" + currentNode );
            if(currentNode == goal)            
            {
                result = 1;
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
        return result;
    }    
    
    public void IDS(Graph g, int start,int goal)
    {
        int status;
        int depth;
        depth = 0;
        while(true)
        {
            status = this.DLS(g, start, goal, depth);
            if(status == 1) 
                break;
            else
                depth++;
        }        
    }
    
}
