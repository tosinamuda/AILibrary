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

public class UniformCostSearch 
{
    Graph g;
    
    public UniformCostSearch(Graph g)
    {
        this.g = g;
    }
    
    public Comparator <Edge> co = new Comparator<Edge>()
    {
        @Override
        public int compare(Edge e1, Edge e2)
        {
            if (e2._weight < e1._weight)
                return +1;
            else if (e2._weight == e1._weight)
                return 0;
            return -1;
        }
    };
    
    public List<Edge> UCS(Node start, Node goal)
    {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(10, co);
        List<Edge> visited = new ArrayList<Edge>();
        
        for (Node n: g.AdjacencyList2.get(g.getNode(start.Label())))
        {
            Edge e = g.getEdge(start, n);
            pq.add(e);
        }
        while (!pq.isEmpty())
        {
            Edge e = pq.peek();
            Node no = e.otherNode(e.thisNode());
            if (no.equals(goal))
                break;
            else
            {
                e = pq.remove();
                for (Node n: g.AdjacencyList2.get(g.getNode(no.Label())))
                {
                    if (!n.equals(e.thisNode()))
                    {
                        Edge p = g.getEdge(no, n);
                        p._weight += e._weight;
                        p.parent = e;
                        pq.add(p);
                    }
                }
            }
        }
        
        Edge result = pq.remove();
        while (true)
        {
            visited.add(result);
            if (result.parent== null)
                break;
            result = result.parent;
        }
        Collections.reverse(visited);
         for (int i=0; i< visited.size(); i++)
         {
             Edge e = visited.get(i);
            System.out.println(e.thisNode().Label() + "\t" + e.otherNode(e.thisNode()).Label());
         }
        return visited;
    }
    
    public static void main(String[] args)
    {
        Graph g = new Graph(); 
        g.AddNode("1"); g.AddNode("2"); g.AddNode("3"); g.AddNode("4");
        g.AddEdge(g.getNode("1"), g.getNode("2"),1);
        g.AddEdge(g.getNode("1"), g.getNode("3"),2);
        g.AddEdge(g.getNode("2"), g.getNode("4"),5);
        g.AddEdge(g.getNode("3"), g.getNode("4"),3);
        String graphString = g.toString();
        System.out.println(graphString);
        UniformCostSearch ucs = new UniformCostSearch(g);
        ucs.UCS(g.getNode("1"), g.getNode("4"));
    }
    
}
