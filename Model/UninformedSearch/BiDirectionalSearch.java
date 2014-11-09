/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.UninformedSearch;

/**
 *
 * @author olivia
 */

import TestNode.*;
import java.util.*;

public class BiDirectionalSearch
{
    Graph g;
    public BiDirectionalSearch(Graph g)
    {
        this.g = g;
    }
    
    public boolean contain(List m, Node n)
    {
        for (Object o : m)
        {
            if(o == null)
                return false;
            if(n.getClass() != o.getClass())
                return false;
            Node n2 = (Node)o;
            if(n.Label() != n2.Label())
                return false;
        }
        return true;
    }
    
    public List<Node> BIDI( Node start, Node goal)
    {
        Queue<Node> queue = new LinkedList<Node>();
        List<Node> visited = new ArrayList<Node>();
        
        Node current = start;
        queue.add(current); queue.add(goal);
        outerloop:
        while (!queue.isEmpty())
        {
            current = queue.poll();
            if(!visited.contains(current))
            {
                current.setVisited(true);
                visited.add(current);
            }
            for(Node n: g.AdjacencyList2.get(g.getNode(current.Label())))
            {
                if(!visited.contains(n))
                    if(!queue.contains(n))
                        queue.add(n);
                if (visited.contains(n))
                    break outerloop;
            }
        }
        for (int i=0; i< visited.size(); i++)
            System.out.print(visited.get(i).Label() + "\t");
        
        return visited;
    }
    
    public static void main (String[] args)
    {
        Graph g = new Graph(); 
        g.AddNode("1"); g.AddNode("2"); g.AddNode("3"); g.AddNode("4");
        g.AddEdge(g.getNode("1"), g.getNode("2"));
        g.AddEdge(g.getNode("1"), g.getNode("3"));
        g.AddEdge(g.getNode("2"), g.getNode("4"));
        g.AddEdge(g.getNode("3"), g.getNode("4"));
        String graphString = g.toString();
        BiDirectionalSearch bd = new BiDirectionalSearch(g);
        System.out.println(graphString);
        bd.BIDI( g.getNode("1"), g.getNode("4"));
    }
    
}
