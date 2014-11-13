/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.GeneticAlgorithms;

/**
 *
 * @author BaldEagle
 */
import java.util.*;

public class Individual
{
    private int [] gene;
    private double fitnessValue;
    
    public Individual(int [] gene, double fitnessValue)
    {
        this.fitnessValue = fitnessValue;
        this.gene = gene.clone();        
    }

    /**
     * @return the gene
     */
    public int[] getGene()
    {
        return gene;
    }

    /**
     * @return the fitnessValue
     */
    public double getFitnessValue()
    {
        return fitnessValue;
    }
    
    public String ToString()
    {
        String s = "";
        s += "********************************* \n";
        s += "Genes: ";
        for(int i =0; i< this.gene.length; ++i)        
            s += this.gene[i] + " ";
        s += "\n";
        s += "Fitness = " + this.fitnessValue + "\n";
        s += "***************************************\n";
        return s;
    }
    
    
    
}
