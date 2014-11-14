/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Graph;

/**
 *
 * @author BaldEagle
 */

import java.util.*;
import java.io.*;

public class Graph implements Cloneable
{
    //Okoro's    
    //End of Okoro's
    public final java.util.List<Edge> ListofEdges = new ArrayList<Edge>();
    public final java.util.List<Node> ListofNodes = new ArrayList<Node>();
    public static int countNode = 1;
    
    
   public final TreeMap<Node,java.util.List<Node>> AdjacencyList = new TreeMap<Node,java.util.List<Node>>();
    
    public Graph()
    {
        countNode = 1;
    }
    
    
    public void AddNode(String Label)
    {       
        Node n = new Node(Label);                
        ListofNodes.add(n);
        AdjacencyList.put(n, new ArrayList<Node>());   
        countNode++;            

    }
    
    public void AddNode(Node newNode)
    {
                
        ListofNodes.add(newNode);
        AdjacencyList.put(newNode,  new ArrayList<Node>());
        countNode++;        
        
    }
    
    
    public double[][] readDistances(String file)
    {
        BufferedReader br = null; 
        String[][] cities = new String[ListofNodes.size()][ListofNodes.size()];
        double[][] distance = new double[ListofNodes.size()][ListofNodes.size()];
        
        
        for (double[] i: distance)
            for (double j: i)
                j=0.0;
        
        
        try
        {
            br= new BufferedReader(new FileReader(file));
            for (int i=0; i<ListofNodes.size(); i++)
            {
                cities[i] = br.readLine().split("\\s+");
                
            }
            br.close();
            for (int i=0; i< cities.length; i++)
            {
                for (int j=0; j< cities.length; j++)
                {
                    if (i!= j)
                    {
                        distance[i][j] = (Double.parseDouble(cities[i][j]));
                    }
                }
            }
        }
        catch(FileNotFoundException f){f.printStackTrace();}
        catch(IOException e){e.printStackTrace();}
        
        return distance;
    }
        
    public void getEdges(double[][] distance)
    {
        for (int i=0; i< distance.length; i++)
        {
            for(int j=0; j< distance.length; j++)
            {
                if (i!= j)
                {
                    AddEdge(getNode(String.valueOf(i+1)), getNode(String.valueOf(j+1)), distance[i][j]);
                }
            }
        }
    }
    
    private boolean check(Node a, TreeMap v)
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
        if(check(from, AdjacencyList) && check(to, AdjacencyList))
        {  
            AdjacencyList.get(from).add(to);
            AdjacencyList.get(to).add(from);
            ListofEdges.add(e);                              
        }
        else
        {
            System.out.println("You cannot add an edge between nodes that are not in the graph");
        }
    }
    
       
    public void AddEdge(Node from, Node to, double weight)
    {
        from = getNode(from.Label());
        to = getNode(to.Label());
        Edge e = new WeightedEdge(from, to,weight);
        if(check(from, AdjacencyList) && check(to, AdjacencyList))
        {  
            AdjacencyList.get(from).add(to);
            //AdjacencyList2.get(to).add(from);
           ListofEdges.add(e);                               
        }
        else
        {
            System.out.println("You cannot add an edge between nodes that are not in the graph");
        }
        
    }
    
    @Override
    public Graph clone() throws CloneNotSupportedException
    {
        return (Graph)super.clone();
    }
    
    public Node getNode(String value)
    {
     Set keys = AdjacencyList.keySet();
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
            if (e.thisNode().equals(v1) && e.otherNode(v1).equals(v2) || 
                    e.thisNode().equals(v2) && e.otherNode(v2).equals(v1))
                return e;
        }
        return null;
    }
    
    @Override
    public String toString()
    {
        String graph = "";
        Iterator it = this.AdjacencyList.keySet().iterator();
        while(it.hasNext())
        {
            Node n = (Node)it.next();
            graph += "Node " + n.Label() + ": ";
            java.util.List <Node> adjacentNode = (java.util.List<Node>)AdjacencyList.get(this.getNode(n.Label()));
            for (Node others : adjacentNode)
            {
                Node otherNode = getNode(others.Label());
                graph += otherNode.Label() + " ";
            }
            graph += "\n";
        }
        return graph;
    }
    
    public static void main(String[] args)
    {
        Graph g = new Graph();
        g.AddNode("1"); g.AddNode("2");g.AddNode("3");
        g.AddNode("4");g.AddNode("5");g.AddNode("6");
        g.AddNode("7");g.AddNode("8");g.AddNode("9");
        g.AddNode("10");g.AddNode("11");
        g.AddNode("12");g.AddNode("13");g.AddNode("14");
        g.AddNode("15");
        System.out.println(g.toString());
        g.getEdges(g.readDistances("C:\\Users\\olivia\\Documents\\weights.txt"));
        
        System.out.println(g.toString());
    }
//    
}
