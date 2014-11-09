/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Search;

import TestNode.Graph;
import TestNode.Node;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author tosinamuda
 */
public class DepthFirstSearch  extends UninformedSearch{

      public DepthFirstSearch(Graph g)
    {
        super(g);
        
        
    }
    
    @Override
    public List<Node> Search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    @Override
    public List<Node> Search(Node start)
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
           // currentNode.setVisited(true);
            VisitedNodeList.add(currentNode);                                    
            /**
             * Get the neighbours of the popped node 
             * if they have not been visited and they are not on the stack         
             * Add push them to the stack             
            **/
            for(Node e : this.g.AdjacencyList2.get(currentNode))
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
    
      @Override
    public List<Node> Search( Node start, Node goal )
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
            for(Node e : this.g.AdjacencyList2.get(currentNode))
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
