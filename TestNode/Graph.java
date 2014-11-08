/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestNode;

/**
 *
 * @author BaldEagle
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Graph 
{
    java.util.List<Edge> ListofEdges = new ArrayList<Edge>();
    private HashMap AdjacencyList = new HashMap();
    
    private HashMap<String,java.util.List<Node>> AdjacencyList2 = new HashMap<String,java.util.List<Node>>();
    
    public Graph()
    {
        
    }
    
    public void AddNode(String Label)
    {
        Node n = new Node(Label);
        AdjacencyList2.put(n.Label(), new ArrayList<Node>());        
    }
    
    public void AddEdge(String to, String from)
    {
        Node v1 = new Node(to);
        Node v2 = new Node(from);
        Edge e = new Edge(v1,v2);
        if(AdjacencyList.containsKey(v1.Label()) && AdjacencyList.containsKey(v2.Label()))
        {  
           java.util.List<Node> v1V = (java.util.List)AdjacencyList2.get(v1.Label());
           java.util.List<Node> v2V = (java.util.List)AdjacencyList2.get(v2.Label());
           v1V.add(v2);
           v2V.add(v1);
           ListofEdges.add(e);                               
        }
        else
        {
            System.out.println("You cannot add an edge between nodes that are not in the graph");
        }
    }
    
    public void AddEdge(String to, String from, double weight)
    {
        Node v1 = new Node(to);
        Node v2 = new Node(from);
        Edge e = new Edge(v1,v2,weight);
        if(AdjacencyList.containsKey(v1.Label()) && AdjacencyList.containsKey(v2.Label()))
        {  
           java.util.List<Node> v1V = (java.util.List)AdjacencyList2.get(v1.Label());
           java.util.List<Node> v2V = (java.util.List)AdjacencyList2.get(v2.Label());
           v1V.add(v2);
           v2V.add(v1);
           ListofEdges.add(e);                               
        }
        else
        {
            System.out.println("You cannot add an edge between nodes that are not in the graph");
        }
        
    }
       
    
}
