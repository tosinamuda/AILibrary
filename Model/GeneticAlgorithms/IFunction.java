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
public interface IFunction
{    
    double ObjFunction(int[] x);
    double getFuncMin();
    String getName();
    
}
