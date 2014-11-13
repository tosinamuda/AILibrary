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
import Model.GeneticAlgorithms.IFunction;
public class AssignmentFunctions implements IFunction
{

    @Override
    public double ObjFunction(int[] x)
    {
        double eqn = 0;
        for(int i = 0; i < x.length; i++)
        {
            eqn +=  15 * x[i] -  Math.pow(x[i],2) ;
        }
        return eqn;
    }

    @Override
    public double getFuncMin()
    {
        return 0;
    }

    @Override
    public String getName()
    {
        return "Assignmnet Fuction";
    }
    
}
