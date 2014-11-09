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

import TestNode.*;
import static java.lang.System.out;
import java.util.*;
public class DepthLimitedSearch
{
    public Graph _g;
    public DepthLimitedSearch(Graph g)
    {
       this._g = g; 
    }
    
    public List<Node> DLS(Node start, int Limit)
    {
        Node currentNode = start;
        int depth;
        Stack<Node> searchStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<Integer>();
        List<Node> VisitedNodeList = new ArrayList<>();
        searchStack.push(start);
        depthStack.push(0);
        while(!(searchStack.empty()))
        {
            currentNode = searchStack.pop();
            VisitedNodeList.add(currentNode);
            depth = depthStack.pop();            
            out.println("Depth\t" + depth + "\tNode\t" + currentNode.Label());
           
            if(depth < Limit)
            {
                for(Node e  : this._g.AdjacencyList2.get(currentNode))
                {
                    if(!(VisitedNodeList.contains(e)) && !(searchStack.contains(e)))
                    {
                        searchStack.push(e);
                        depthStack.push(depth+1);                        
                    }                                    
                }
            }            
        }        
        for(Node item : VisitedNodeList)
        {
            out.print(item.Label() + "\t");            
        }        
        return VisitedNodeList;
        
    }
    
    public List<Node> DLS( Node start, Node goal, int limit)
    {
        Node currentNode = start;
        int depth;
        Stack<Node> searchStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<Integer>();
        List<Node> VisitedNodeList = new ArrayList<>();
        searchStack.push(start);
        depthStack.push(0);
        while(!(searchStack.empty()))
        {
            currentNode = searchStack.pop();
            currentNode.setVisited(true);
            VisitedNodeList.add(currentNode);
            depth = depthStack.pop();            
            out.println("Depth\t" + depth + "\tNode\t" + currentNode.Label());
            if(currentNode == goal)            
            {
                break;
            }
            if(depth < limit)
            {
                for(Node e  : this._g.AdjacencyList2.get(currentNode))
                {
                    if(!(VisitedNodeList.contains(e)) && !(searchStack.contains(e)))
                    {
                        searchStack.push(e);
                        depthStack.push(depth+1);                        
                    }                                    
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
        DepthLimitedSearch bfs = new DepthLimitedSearch(g);
        List<Node> lst = bfs.DLS( g.getNode("1"), g.getNode("4"), 1) ; 
    }
    
}
