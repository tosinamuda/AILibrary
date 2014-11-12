/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.GeneticAlgorithms.GAFunctions;

/**
 *
 * @author BaldEagle
 */
import java.util.*;
import Model.GeneticAlgorithms.IFunction;
public class Ackley implements IFunction
{

    @Override
    public double ObjFunction(int[] x)
    {
        double sum1 = 0.0;
        double sum2 = 0.0;
        for(int i = 0; i < x.length; i++)
        {
            sum1 += Math.pow(x[i], 2);
            sum2 += Math.cos(2.0 * Math.PI * x[i]);                        
        }
        
        sum1 = -20.0 * Math.exp(-0.2 * Math.sqrt(sum1 / x.length)) - Math.exp(sum2/x.length) + 20.0 + Math.E;
     return sum1;
    }

    @Override
    public double getFuncMin()
    {
        return 0;
    }

    @Override
    public String getName()
    {
        return "Ackley Function Problem\n";
    }
    
    
}
