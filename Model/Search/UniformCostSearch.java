/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Search;

/**
 *
 * @author olivia
 */


import TestNode.*;
import java.util.*;

public class UniformCostSearch extends UninformedSearch
{
 
    
    public UniformCostSearch(Graph g)
    {
       super(g);
    }
    
    public Comparator <WeightedEdge> co = new Comparator<WeightedEdge>()
    {
        @Override
        public int compare(WeightedEdge e1, WeightedEdge e2)
        {
            if (e2.getWeight() < e1.getWeight())
                return +1;
            else if (e2.getWeight() == e1.getWeight())
                return 0;
            return -1;
        }
    };
    
    public List<Edge> UCS(Node start, Node goal)
    {
        PriorityQueue<WeightedEdge> pq = new PriorityQueue<WeightedEdge>(10, co);
        List<Edge> visited = new ArrayList<Edge>();
        Edge result = null;
        for (Node n: g.AdjacencyList2.get(g.getNode(start.Label())))
        {
            WeightedEdge e = (WeightedEdge)g.getEdge(start, n);
            pq.add(e);
        }
        while (!pq.isEmpty())
        {
            WeightedEdge e = pq.poll();
            Node no = e.otherNode(e.thisNode());
            if (no.equals(goal))
            {
                result = e;
                break;
            }
            else
            {
                for (Node n: g.AdjacencyList2.get(g.getNode(no.Label())))
                {
                    if (!n.equals(e.thisNode()))
                    {
                        WeightedEdge p = (WeightedEdge)g.getEdge(no, n);
                        
                        p.setWeight(p.getWeight() + e.getWeight());
                        p.parent = e;
                        pq.add(p);
                    }
                }
            }
        }
        
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
        g.AddNode("1"); g.AddNode("2"); g.AddNode("3"); g.AddNode("4"); g.AddNode("5");
        g.AddEdge(g.getNode("1"), g.getNode("2"),5);
        g.AddEdge(g.getNode("1"), g.getNode("3"),1);
        g.AddEdge(g.getNode("1"), g.getNode("4"),2);
        g.AddEdge(g.getNode("3"), g.getNode("5"),7);
        g.AddEdge(g.getNode("2") , g.getNode("5"),1);
        g.AddEdge(g.getNode("4") , g.getNode("5"),6);
        String graphString = g.toString();
        UniformCostSearch bd = new UniformCostSearch(g);
        System.out.println(graphString);
        bd.UCS( g.getNode("1"), g.getNode("5"));
    }

    @Override
    public List<Node> Search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Node> Search(Node start) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Node> Search(Node start, Node goal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
