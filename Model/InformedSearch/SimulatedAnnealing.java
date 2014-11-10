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
public class SimulatedAnnealing 
{
    private Node[] cities;
    private double tour_length;
    private Graph g;
    
    public SimulatedAnnealing(int n, Graph g)
    {
        this.cities = new Node[n];
        this.tour_length = 0;
        this.g = g;
    }
    
    public double eucDist(Node node1, Node node2)
    {
        double x = node2.Center().x - node1.Center().x;
        double y = node2.Center().y - node1.Center().y;
        double eucDist = Math.sqrt(Math.pow(x, 2.0)+ Math.pow(y, 2.0));
        
        return eucDist;
    }
    
    public void compute_tour(SimulatedAnnealing sa)
    {
        double tourlength = 0;
        for (int i=0; i< cities.length -1; i++)
            tourlength += eucDist(cities[i], cities[i+1]);
        tourlength += eucDist(cities[cities.length-1], cities[0]);
        sa.tour_length = tourlength;
    }
    
}
