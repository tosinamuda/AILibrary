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
    public Graph _g;
    public DepthFirstSearch( Graph g)
    {
        this._g = g;    
    }       
    /**
     * This method represents the Depth First Search algorithm of a graph
     * @param g is a graph object which must not be null
     * @param start is an integer value that represents on of the nodes in the graph g
     * @param goal
     */
        
    public List<Node> DFS(Node start)
    {
        Node currentNode = start;         
        //Initialize Stack
        Stack<Node> searchStack = new Stack<>();
        //Create a list to store nodes that have already been visited
        List<Node> VisitedNodeList = new ArrayList<Node>();
        
        //Push start node unto the stack
        searchStack.push(currentNode);
        
        //Start Search
        while( !(searchStack.empty()))
        {
            currentNode = searchStack.pop();
            currentNode.setVisited(true);
            VisitedNodeList.add(currentNode);                                    
            /**
             * Get the neighbours of the popped node 
             * if they have not been visited and they are not on the stack         
             * Add push them to the stack             
            **/
            for(Node e : this._g.AdjacencyList2.get(currentNode))
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
    
    public List<Node> DFS( Node start, Node goal )
    {
        Node currentNode = start;         
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
            currentNode.setVisited(true);
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
            for(Node e : this._g.AdjacencyList2.get(currentNode))
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
    
    public static void main(String[] args) 
    {     
        Graph g = new Graph();
        g.AddNode("1"); g.AddNode("2"); g.AddNode("3"); g.AddNode("4");
        g.AddEdge(g.getNode("1"), g.getNode("2"));
        g.AddEdge(g.getNode("1"), g.getNode("3"));
        g.AddEdge(g.getNode("2"), g.getNode("4"));
        g.AddEdge(g.getNode("3"), g.getNode("4"));   
        DepthFirstSearch bfs = new DepthFirstSearch(g);
        List<Node> lst = bfs.DFS(g.getNode("1"), g.getNode("4")) ; 
    }
}
