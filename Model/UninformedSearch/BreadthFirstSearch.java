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
    
    public List<Node> BFS(Graph g, Node start, Node goal)
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
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        List<Node> lst = bfs.BFS(g, g.getNode("1"), g.getNode("4")) ; 
    }
}
