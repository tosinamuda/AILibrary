/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.UninformedSearch;

/**
 *
 * @author Tosin Amuda
 */
import TestNode.*;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
public class BreadthFirstSearch 
{
   
    public BreadthFirstSearch()
    {
        
    }
    
    public void BFS(Graph g, Node start, Node goal)
    {
        Node currentNode;
        Queue<Node> searchQueue = new LinkedList<Node>();
        List<Node> VisitedNodeList = new ArrayList<Node>();
        
        searchQueue.add(start);
        while(!searchQueue.isEmpty())
        {
            currentNode = searchQueue.remove();
            VisitedNodeList.add(currentNode);
            System.out.println("\n "+ currentNode.Label()); 
            if(currentNode == goal)
            {
                break;
            }
            for(Node e : g.AdjacencyList2.get(currentNode))
            {
                if(!(VisitedNodeList.contains(e) && !(searchQueue.contains(e))))
                {
                    searchQueue.add(e);                    
                }                
            }                                 
        }
        for(Node e: VisitedNodeList)
        {
            System.out.println(e.Label()+"\t");
        }                                        
    }
        
}
