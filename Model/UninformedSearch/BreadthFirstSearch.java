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
    public Graph g;
   
    public BreadthFirstSearch(Graph g)
    {
        this.g = g;
    }
    
    public List<Node> BFS( Node start, Node goal)
    {
        Node currentNode = start;
        Queue<Node> searchQueue = new LinkedList<Node>();
        List<Node> VisitedNodeList = new ArrayList<Node>();
        
        searchQueue.add(start);
        while(!searchQueue.isEmpty())
        {
            currentNode = searchQueue.remove();
            currentNode.setVisited(true);
            VisitedNodeList.add(currentNode);            
            if(currentNode == goal)
            {
                break;
            }
            for(Node e : this.g.AdjacencyList2.get(currentNode))
            {
                if(!(VisitedNodeList.contains(e) && !(searchQueue.contains(e))))
                {
                    searchQueue.add(e);                    
                }                
            }                                 
        }
        for(Node e: VisitedNodeList)
        {
            System.out.print(e.Label()+"\t");
        }  
        return VisitedNodeList;
    }
    public static void main(String[] args) 
    {     
        Graph g = new Graph();
        g.AddNode("1"); 
        g.AddNode("2"); 
        g.AddNode("3"); 
        g.AddNode("4");        
        g.AddEdge(g.getNode("1"), g.getNode("2"));        
        g.AddEdge(g.getNode("1"), g.getNode("3"));
        g.AddEdge(g.getNode("2"), g.getNode("4"));
        g.AddEdge(g.getNode("3"), g.getNode("4"));   
        BreadthFirstSearch bfs = new BreadthFirstSearch(g);
        List<Node> lst = bfs.BFS( g.getNode("1"), g.getNode("4")) ; 
    }
}
