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
    public final java.util.List<Edge> ListofEdges = new ArrayList<Edge>();
    public final java.util.List<Node> ListofNodes = new ArrayList<Node>();
    public static int countNode = 1;
    
    
   public final HashMap<Node,java.util.List<Node>> AdjacencyList2 = new HashMap<Node,java.util.List<Node>>();
    
    public Graph()
    {
        
    }
    
//    public void AddNode(String Label)
//    {
//        Node n = new Node(Label);
//        AdjacencyList2.put(n.Label(), new ArrayList<Node>());        
//    }
    
    public void AddNode(String Label)
    {
       
        Node n = new Node(Label);
        ListofNodes.add(n);
        AdjacencyList2.put(n, new ArrayList<Node>());   
        countNode++;
    }
    
    public void AddNode(Node newNode)
    {
        
        ListofNodes.add(newNode);
        AdjacencyList2.put(newNode,  new ArrayList<Node>());
        countNode++;
    }
    
//    public void AddEdge(String to, String from)
//    {
//        Node v1 = new Node(to);
//        Node v2 = new Node(from);
//        Edge e = new Edge(v1,v2);
//        if(AdjacencyList.containsKey(v1.Label()) && AdjacencyList.containsKey(v2.Label()))
//        {  
//            AdjacencyList2.get(v1.Label()).add(v2);
//            AdjacencyList2.get(v2.Label()).add(v1);
//            ListofEdges.add(e);
//            
////           java.util.List<Node> v1V = (java.util.List)AdjacencyList2.get(v1.Label());
////           java.util.List<Node> v2V = (java.util.List)AdjacencyList2.get(v2.Label());
////           v1V.add(v2);
////           v2V.add(v1);
////           ListofEdges.add(e);                               
//        }
//        else
//        {
//            System.out.println("You cannot add an edge between nodes that are not in the graph");
//        }
//    }
    
    private boolean check(Node a, HashMap v)
    {
        Iterator it = v.keySet().iterator();
        while (it.hasNext())
        {
            Node b = (Node) it.next();
            if (a == b)
            {
                return true;
            }
        }
        return false;
    }
    
    public void AddEdge(Node from, Node to)
    {
        from = getNode(from.Label());
        to = getNode(to.Label());
        Edge e = new Edge(from, to);
        if(check(from, AdjacencyList2) && check(to, AdjacencyList2))
        {  
            AdjacencyList2.get(from).add(to);
            AdjacencyList2.get(to).add(from);
            ListofEdges.add(e);                              
        }
        else
        {
            System.out.println("You cannot add an edge between nodes that are not in the graph");
        }
    }
    
//    public void AddEdge(String to, String from, double weight)
//    {
//        Node v1 = new Node(to);
//        Node v2 = new Node(from);
//        Edge e = new Edge(v1,v2,weight);
//        if(AdjacencyList.containsKey(v1.Label()) && AdjacencyList.containsKey(v2.Label()))
//        {  
//           java.util.List<Node> v1V = (java.util.List)AdjacencyList2.get(v1.Label());
//           java.util.List<Node> v2V = (java.util.List)AdjacencyList2.get(v2.Label());
//           v1V.add(v2);
//           v2V.add(v1);
//           ListofEdges.add(e);                               
//        }
//        else
//        {
//            System.out.println("You cannot add an edge between nodes that are not in the graph");
//        }
//        
//    }
       
    public void AddEdge(Node from, Node to, double weight)
    {
        from = getNode(from.Label());
        to = getNode(to.Label());
        Edge e = new Edge(from, to,weight);
        if(check(from, AdjacencyList2) && check(to, AdjacencyList2))
        {  
            AdjacencyList2.get(from).add(to);
            AdjacencyList2.get(to).add(from);
           ListofEdges.add(e);                               
        }
        else
        {
            System.out.println("You cannot add an edge between nodes that are not in the graph");
        }
        
    }
    
    public Node getNode(String value)
    {
     Set keys = AdjacencyList2.keySet();
     Iterator iterator = keys.iterator();
     Node n = null;
     while(iterator.hasNext())
     {
        Node  foundNode = (Node)iterator.next();
         if (foundNode.Label().equals(value) )
         {
             n = foundNode;
             break;
         }
         
     }
     
     return n;
    }
    
    public Edge getEdge(Node v1, Node v2)
    {
        for(Edge e: ListofEdges)
        {
            if (e.thisNode().equals(v1) && e.otherNode(v1).equals(v2))
                return e;
        }
        return null;
    }
    
    @Override
    public String toString()
    {
        String graph = "";
        Iterator it = this.AdjacencyList2.keySet().iterator();
        while(it.hasNext())
        {
            Node n = (Node)it.next();
            graph += "Node " + n.Label() + ": ";
            java.util.List <Node> adjacentNode = (java.util.List<Node>)AdjacencyList2.get(this.getNode(n.Label()));
            for (Node others : adjacentNode)
            {
                Node otherNode = getNode(others.Label());
                graph += otherNode.Label() + " ";
            }
            graph += "\n";
        }
        return graph;
    }
    
//    public static void main(String[] args)
//    {
//        Graph g = new Graph();
//        g.AddNode("1"); g.AddNode("2"); g.AddNode("3"); g.AddNode("4");
//        g.AddEdge(g.getNode("1"), g.getNode("2"));
//        g.AddEdge(g.getNode("1"), g.getNode("3"));
//        g.AddEdge(g.getNode("2"), g.getNode("4"));
//        g.AddEdge(g.getNode("3"), g.getNode("4"));
//        String graphString = g.toString();
//        System.out.println(graphString);
//    }
//    
}
