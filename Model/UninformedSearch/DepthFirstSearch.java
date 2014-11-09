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
import java.util.*;
import static java.lang.System.*;
public class DepthFirstSearch
{             
    public DepthFirstSearch()
    {
    
    }       
    /**
     * This method represents the Depth First Search algorithm of a graph
     * @param g is a graph object which must not be null
     * @param start is an integer value that represents on of the nodes in the graph g
     * @param goal
     */
        
    public List<Node> DFS(Graph g, Node start)
    {
        Node currentNode;         
        //Initialize Stack
        Stack<Node> searchStack = new Stack<>();
        //Create a list to store nodes that have already been visited
        List<Node> VisitedNodeList = new ArrayList<Node>();
        
        //Push start node unto the stack
        searchStack.push(start);
        
        //Start Search
        while( !(searchStack.empty()))
        {
            currentNode = searchStack.pop();
            VisitedNodeList.add(currentNode);                                    
            /**
             * Get the neighbours of the popped node 
             * if they have not been visited and they are not on the stack         
             * Add push them to the stack             
            **/
            for(Node e : g.AdjacencyList2.get(currentNode))
            {
                if(!(VisitedNodeList.contains(e) && !(searchStack.contains(e))))
                {
                    searchStack.push(e);                    
                }                
            }                                   
        }
        for(Node item : VisitedNodeList)
        {
            out.print(item.Label() + "\t");            
        }
        return VisitedNodeList;
    }
    
    public List<Node> DFS(Graph g, Node start, Node goal )
    {
        Node currentNode;         
        //Initialize Stack
        Stack<Node> searchStack = new Stack<>();
        //Create a list to store nodes that have already been visited
        List<Node> VisitedNodeList = new ArrayList<Node>();
        
        //Push start node unto the stack
        searchStack.push(start);
        
        //Start Search
        while( !(searchStack.empty()))
        {
            currentNode = searchStack.pop();
            VisitedNodeList.add(currentNode);
            
            //if the current node is the goal node
            //Stop the search
            if(currentNode == goal)
            {
                break;
            }
            /**
             * Get the neighbours of the popped node 
             * if they have not been visited and they are not on the stack         
             * Add push them to the stack             
            **/
            for(Node e : g.AdjacencyList2.get(currentNode))
            {
                if(!(VisitedNodeList.contains(e) && !(searchStack.contains(e))))
                {
                    searchStack.push(e);                    
                }                
            }                                   
        }
        for(Node item : VisitedNodeList)
        {
            out.print(item.Label() + "\t");            
        }
        return VisitedNodeList;
    }
}
