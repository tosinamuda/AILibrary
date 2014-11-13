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
    int fitnessSum;
    double crossProbability;
    double mutationProbability;
    List<Chromosome> population;
    Random rand = new Random();
    
    public Population(int length ,int size, double cross_prob, double mut_prob)
    {
        this.xsomeLength = length;
        this.populationSize = size;
        this.crossProbability = cross_prob;
        this.mutationProbability = mut_prob;
        this.fitnessSum =0;
        population = new ArrayList<>();
    }
    
    public void initialPopulation()
    {
        for (int j=0; j < populationSize; j++)
        {
            Chromosome chrome = new Chromosome(xsomeLength);
            for (int i=0; i< xsomeLength; i++)
            {
                int x = rand.nextInt((xsomeLength-1 - 0) + 1);
                chrome.genes.set(x);
            }
            population.add(chrome);
            //System.out.println(chrome.genes.toString());
        }
        
    }
    
    private int decimal(Chromosome x)
    {
            int decimal = 0;
            for (int i=0; i< x.length; i++)
            {
                if (x.genes.get(i))
                    decimal += Math.pow(2.0, i);
            }
//            System.out.println(x.fitness);
            return decimal;
    }
    
    private double function(double x)
    {
        return ((15 * x) - (x * x));
    }
    
    public void fitness()
    {
        fitnessSum =0;
        for (Chromosome x: population)
        {
            x.fitness = function(decimal(x));
            fitnessSum += x.fitness;
//            System.out.println(x.fitness);
        }
//         System.out.println(fitnessSum);
        for (Chromosome x: population)
        {
            x.fitnessRatio = (x.fitness/fitnessSum) * 100;
             //System.out.println(x.fitnessRatio);
        }
    }
    
    public int getParent()
    {
        for (Chromosome x: population)
        {
            if ((Math.random() * fitnessSum) < x.fitnessRatio)
                return population.indexOf(x);
        }
        return rand.nextInt((population.size()-1 -0)+1) +0;
    }
    
    public Chromosome[] crossOver(Chromosome father, Chromosome mother)
    {
        Chromosome[] children = new Chromosome[2];
        int crossingPoint = rand.nextInt((father.length-1 -0) + 1) + 0;
//        System.out.println(crossingPoint);
        Chromosome child1 = new Chromosome(father.length);
        Chromosome child2 = new Chromosome(father.length);
        
        if(Math.random() < crossProbability)
        {
            for (int i =0; i< crossingPoint; i++)
                child1.genes.set(i, father.genes.get(i));
            for (int i = crossingPoint; i< mother.length; i++)
                child1.genes.set(i, mother.genes.get(i));
            for (int i =0; i< crossingPoint; i++)
                child2.genes.set(i, mother.genes.get(i));
            for (int i = crossingPoint; i< father.length; i++)
                child1.genes.set(i, father.genes.get(i));
        }
        else
        {
            for (int i =0; i< father.length; i++)
                child1.genes.set(i, father.genes.get(i));
             for (int i = 0; i< mother.length; i++)
                child1.genes.set(i, mother.genes.get(i));
        }
//            System.out.println(child1.genes.toString());
//            System.out.println(child2.genes.toString());
        children[0] = mutate(child1);
        children[1] = mutate(child2);
        
        return children;
    }
    
    public Chromosome mutate(Chromosome chrome)
    {
        for (int i=0; i< chrome.length; i++)
        {
            if (Math.random() <= mutationProbability)
            {
                if (chrome.genes.get(i) == false)
                    chrome.genes.set(i, true);
                else
                    chrome.genes.set(i, false);
            }
        }
//       System.out.println(chrome.genes.toString());
        return chrome;
    }
    
    public double geneticAlgorithm()
    {
        initialPopulation();
        List<Chromosome> newPopulation = new ArrayList<>();
        for (int j = 0; j < 1000; j++)
        {
            fitness();
//            List<Chromosome> newPopulation = new ArrayList<>();

            while (newPopulation.size() < population.size())
            {
                Chromosome father = population.get(getParent());
                Chromosome mother = population.get(getParent());
                Chromosome[] children = crossOver(father, mother);
                newPopulation.add(children[0]);
                newPopulation.add(children[1]);
            }

            for (int i=0; i< population.size(); i++)
            {
                population.set(i, newPopulation.get(i));
            }
            newPopulation.clear();
        }
        
        double max = 0;
        fitness();
        for (Chromosome x: population)
        {
            if (x.fitness > max)
                max = decimal(x);
        }
        return max;
    }
    
    
    public static void main(String[] args)
    {
        Population p = new Population (4, 10, 0.7, 0.005);
        System.out.println(p.geneticAlgorithm());
    }
    
}
