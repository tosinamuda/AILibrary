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
     */
    public void DFS(Graph g, int start)
    {                          
        //Initialize Stack
        int node;
        Stack<Integer> myStack = new Stack<Integer>(); 
        List<Integer> visited = new ArrayList<Integer>();
        myStack.push(start);
        while(!(myStack.isEmpty()))
        {
            node = myStack.pop();
            visited.add(node);
            for(Edge e: g.getIncidentList(node))
            {
                boolean check = visited.contains(e.otherVertex(node));
                boolean checker = myStack.contains(e.otherVertex(node));                
                if ((!(check)) && (!(checker)))
                {
                    myStack.push(e.otherVertex(node));
                }
            }
        }
        
        for(int a: visited)
        {
            System.out.print(a + "\t");
        }
    }
    
    public void DFS(Graph g, int start, int goal)
    {
        int currentNode;
        //Initialize Stack
        Stack<Integer> searchStack = new Stack<Integer>();
        //Create a list to store nodes that have already been visited
        List<Integer> VisitedNodeList = new ArrayList<Integer>();
        
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
            for(Edge e : g.getIncidentList(currentNode))                
            {
                if(!(VisitedNodeList.contains(e.otherVertex(currentNode))) && !(searchStack.contains(e.otherVertex(currentNode))))
                {
                    searchStack.push(e.otherVertex(currentNode));
                    
                }                
            }                                    
        }
        for(int item : VisitedNodeList)
        {
            out.print(item + "\t");            
        }
        
        
    }
    
}