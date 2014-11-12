/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.GeneticAlgorithm;

/**
 *
 * @author olivia
 */

import java.util.List;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Random;

public class Population 
{
    int xsomeLength;
    int populationSize;
    double crossProbability;
    double mutationProbability;
    List<BitSet> population;
    
    public Population(int length, int size, double cross_prob, double mut_prob)
    {
        this.xsomeLength = length;
        this.populationSize = size;
        this.crossProbability = cross_prob;
        this.mutationProbability = mut_prob;
        population = new ArrayList<>();
    }
    
    public void initialPopulation()
    {
        Random rand = new Random();
        for (int j=0; j < populationSize; j++)
        {
            BitSet b = new BitSet(xsomeLength);
            for (int i=0; i< xsomeLength; i++)
            {
                int x = rand.nextInt((xsomeLength-1 - 0) + 1) + 0;
                b.set(x);
            }
            population.add(b);
            System.out.println(b.toString());
        }
        
    }
    
    public 
    
    public static void main(String[] args)
    {
        Population p = new Population (4,6,0.7,0.001);
        p.initialPopulation();
    }
    
}
