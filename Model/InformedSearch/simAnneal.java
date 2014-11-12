/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.InformedSearch;

/**
 *
 * @author olivia
 */
import TestNode.*;
import java.util.*;

public class simAnneal 
{
    Graph g ;
    List<Node> currentOrder;  
    List<Node> nextOrder = new ArrayList<>();
    double[][] distances;
    Random rand = new Random();
    
    public simAnneal(Graph g, String file)
    {
        this.g = g;
        currentOrder = new ArrayList<>();
        Iterator it = g.AdjacencyList2.keySet().iterator();
        while(it.hasNext())
            currentOrder.add((Node) it.next());
        distances = g.readDistances(file);
        g.getEdges(distances);
    }
    
    public double compute_tour(List<Node> order)
    {
        double tour_length =0;
        
        for (int i=0; i< order.size()-1; i++)
        {
            int val1 = Integer.parseInt(order.get(i).Label());
            int val2 = Integer.parseInt(order.get(i+1).Label());
            tour_length += distances[val1-1][val2-1];
        }
        
        if (order.size() >0)
        {
            int last = Integer.parseInt(order.get(order.size()-1).Label());
            int first = Integer.parseInt(order.get(0).Label());
            tour_length += distances[last-1][first-1];
        }
        
        return tour_length;
    }
    
    public List<Node> perturb_tour(List<Node> order)
    {
        int p1 =0, p2 =0;
        do 
        {
            p1 = rand.nextInt((order.size()-1 -1) + 1) +1;
            p2 = rand.nextInt((order.size()-1 -1) + 1) +1;
        } while (p1 == p2);
        
        //System.out.println(p1 + " " +p2);
        
        List<Node> newOrder = new ArrayList<>();
        for (Node n : order)
            newOrder.add(n);
        
        Node n = newOrder.get(p1);
        newOrder.set(p1, newOrder.get(p2));
        newOrder.set(p2, n);
        
        return newOrder;
    }
    
    public List<Edge> graphEdge(List<Node> order)
    {
        List<Edge> newPath = new ArrayList<>();
        for (int i=0; i < order.size()-1; i++)
        {
            Edge e = g.getEdge(order.get(i), order.get(i+1));
            newPath.add(e);
        }
        
        Edge e = g.getEdge(order.get(order.size()-1), order.get(0));
        newPath.add(e);
        
        return newPath;
    }
    
    public List<List<Edge>> sAnneal()
    {
        double temperature = 27.0;
        double coolRate = 0.999;
        double delta = 0;
        
        List<List<Edge>> newPath = new ArrayList<>();
        
        double tourLength = compute_tour(currentOrder);
        newPath.add(graphEdge(currentOrder));
        
        while (temperature > 0.00001)
        {
            for (int j = 0; j< 100; j++)
            {
                nextOrder = perturb_tour(currentOrder);
                delta = compute_tour(nextOrder) - tourLength;
                
                if (delta < 0 || Math.exp(-delta/temperature) > rand.nextDouble() )
                {
                    for (int i=0; i< currentOrder.size(); i++)
                        currentOrder.set(i, nextOrder.get(i));
                    
                    newPath.add(graphEdge(currentOrder));
                    tourLength = delta + tourLength;
                }
            }
            temperature *= coolRate;
            System.out.println(tourLength);
        }
        
        return newPath;
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
        String file = "C:\\Users\\olivia\\Documents\\weights.txt";
        simAnneal sa = new simAnneal(g,file);
        sa.sAnneal();
        
    }
}
