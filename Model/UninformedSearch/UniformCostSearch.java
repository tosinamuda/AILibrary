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
                return 1;
            else if (e2._weight == e1._weight)
                return 0;
            return -1;
        }
    };
    
    public List<Node> UCS(Node start, Node goal)
    {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(10, co);
        PriorityQueue<Node> pr = new PriorityQueue<Node>();
        
        for (Node n: g.AdjacencyList2.get(g.getNode(start.Label())))
        {
            Edge e = g.getEdge(start, n);
            pq.add(e);
        }
        while (!pq.isEmpty())
        {
            Edge e = pq.poll();
            Node no = e.otherNode(e.thisNode());
            if (no.equals(goal))
            {
                System.out.println("Path Cost is " +e._weight);
            }
            else
            {
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
        
        
        
    }
}
