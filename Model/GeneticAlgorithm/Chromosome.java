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

import java.util.BitSet;

public class Chromosome 
{
    double fitness;
    double fitnessRatio;
    BitSet genes;
    int length;
    
    public Chromosome(int length)
    {
        this.length = length;
        this.fitness =0;
        this.fitnessRatio =0;
        genes = new BitSet(length);
    }
    
}
