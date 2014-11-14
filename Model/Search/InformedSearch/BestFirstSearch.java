/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Model.Search.InformedSearch;

/**
 *
 * @author BaldEagle
 */
import Model.Graph.BestFirstNode;
import Model.Graph.BestFirstGraph;
import java.util.AbstractQueue;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Predicate;
public class BestFirstSearch
{
    BestFirstGraph _g;
    
    public BestFirstSearch(BestFirstGraph g)
    {
        this._g = g;
    }
    
    
    public List<BestFirstNode> BestFS(BestFirstNode start)
    {
        BestFirstNode currentNode = start;
        PriorityQueue<BestFirstNode> open = new PriorityQueue<>();
        PriorityQueue<BestFirstNode> closed = new PriorityQueue<>();
        List<BestFirstNode> VisitedNodeList = new ArrayList<>();
        open.add(start);
        while(!open.isEmpty())
        {
            currentNode = open.remove();
            closed.add(currentNode);
            VisitedNodeList.add(currentNode);  
//            if(currentNode == Goal)
//            {
//                break;
//            }
            
            for(BestFirstNode node : this._g.AdjacencyList2.get(currentNode))
            {
                if(!open.contains(node) && !closed.contains(node) && !VisitedNodeList.contains(node))
                {
                    open.add(node);
                }
            }
        }
        for(BestFirstNode item : VisitedNodeList)
        {
            System.out.print(item.Label() + "\t");            
        }
        return VisitedNodeList;
    }
    
     public static void main(String[] args) 
    {     
        
        BestFirstGraph g = new BestFirstGraph();
        BestFirstSearch bts = new BestFirstSearch(g);
        g.AddNode("1",1.2); g.AddNode("2",2.3);
        g.AddNode("3",3.1); g.AddNode("4",4.4); g.AddNode("5", 5.0); g.AddNode("6", 6.10);
        g.AddEdge(g.getNode("1"), g.getNode("3"));
        g.AddEdge(g.getNode("1"), g.getNode("4"));
        g.AddEdge(g.getNode("1"), g.getNode("6"));
        
        g.AddEdge(g.getNode("2"), g.getNode("4"));
        g.AddEdge(g.getNode("2"), g.getNode("5"));
        g.AddEdge(g.getNode("2"), g.getNode("6"));
        
        g.AddEdge(g.getNode("3"), g.getNode("1"));        
        g.AddEdge(g.getNode("3"), g.getNode("4"));   
        
        g.AddEdge(g.getNode("4"), g.getNode("1"));       
        g.AddEdge(g.getNode("4"), g.getNode("2"));
        g.AddEdge(g.getNode("4"), g.getNode("3"));
        g.AddEdge(g.getNode("4"), g.getNode("5"));
        
        g.AddEdge(g.getNode("5"), g.getNode("2"));
        g.AddEdge(g.getNode("5"), g.getNode("4"));
        
        g.AddEdge(g.getNode("6"), g.getNode("1"));
        g.AddEdge(g.getNode("6"), g.getNode("2"));
        
        List<BestFirstNode> lst = bts.BestFS(g.getNode("6"));
    }
    
}
