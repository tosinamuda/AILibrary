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
import Model.GeneticAlgorithms.GAFunctions.*;
import Model.GeneticAlgorithms.*;

public class IndividualEnvironment
{    
    private List<Individual> population;
    private List<Individual> matingList;
    private Individual fitIndividual;
    public String  results;
    private static Random random = new Random();
    private int numberOfExperiments;
    private int numberOfIndividuals;
    private int xDimension;
    private int geneNumber;
    private int max;
    private int min;
    private double mutationProbability;
    private int Generation;
    private int maxGeneration;
    
    private IFunction GAfunction;
    
    double averageFuncError = 0;
    double averageFuncErrorExp = 0;
    double standardDeviation = 0;
    double standardDeviationAveExp = 0;
    double bestMeanFuncEval = 0;
    double worseMeanFuncEval = 0;
    double successfulMeanFuncEval = 0;
    int successfulFuncEvals = 0;
    
    public IndividualEnvironment(int noExp, int maxGen, int noInd, int xdimen, int max, int min, double mutPr, IFunction func)
    {
        this.numberOfExperiments = noExp;
        this.numberOfIndividuals = noInd;
        this.xDimension = xdimen;
        this.mutationProbability = mutPr;
        this.max = max;
        this.min = min;
        this.maxGeneration = maxGen;
        this.GAfunction = func;
        
        geneNumber = getGeneNumber(Math.max((Math.abs(max)),(Math.abs(min))), xdimen);
        
    }
    
    
    public void Initialize()
    {
        population = new ArrayList<>(numberOfIndividuals);
        fitIndividual = null;
        
        for (int i = 0; i < numberOfIndividuals; i++)
        {
            int[] randomGene = new int[geneNumber];
            for (int j = 0; j < randomGene.length; ++j)
            {
                double num = random.nextDouble();
                if (num < 0.5)
                    randomGene[j] = 0;
                else
                    randomGene[j] = 1;
            }
            
            double randomFitness = GAfunction.ObjFunction(Decode(randomGene));

            bestMeanFuncEval += randomFitness;

            Individual newIndividual = new Individual(randomGene, randomFitness);
            population.add(newIndividual);
        }
        bestMeanFuncEval = bestMeanFuncEval / population.size();
        worseMeanFuncEval = bestMeanFuncEval;
    }
    
    public int getGeneNumber(int value, int dim) 
    {
        int i = 0;

        while (Math.pow(2, i) <= value) 
        {
            ++i;
        }

        return i * dim;
    }
    
    public int[] Decode(int[] x)
    {
        int[] y = new int[xDimension];
        int count = 0;
        for (int i = 0; i < y.length; i++)
        {
            count = (i+1) * (geneNumber / xDimension);
            double z = 0;
            for (int j = (geneNumber / xDimension) - 1; j >= 0; j--)
            {
                count--;
                z += Math.pow(2,j) * x[count];
            }
            y[i] = (int)z;
        }
        return y;
    }
    
    
    public Individual[] CrossOver()
    {
        Individual Father = matingList.get((int)(random.nextDouble() * matingList.size()));
        Individual Mother = matingList.get((int)(random.nextDouble() * matingList.size()));
        
        int crossingPoint = (int)(Father.getGene().length * random.nextDouble());
        int[] childGene1 = new int[geneNumber];
        int[] childGene2 = new int[geneNumber];
        for (int i = 0; i < crossingPoint; i++)
                childGene1[i] = Father.getGene()[i];
            for (int i = crossingPoint; i < Mother.getGene().length; i++)
                childGene1[i] = Mother.getGene()[i];

            for (int i = 0; i < crossingPoint; i++)
                childGene2[i] = Mother.getGene()[i];
            for (int i = crossingPoint; i < Father.getGene().length; i++)
                childGene2[i] = Father.getGene()[i];

            childGene1 = Mutate(childGene1);
            childGene2 = Mutate(childGene2);

            double childFitness1 = GAfunction.ObjFunction(Decode(childGene2));
            double childFitness2 = GAfunction.ObjFunction(Decode(childGene2));

            Individual child1 = new Individual(childGene1, childFitness1);
            Individual child2 = new Individual(childGene2, childFitness2);

            Individual[] ret = { child1, child2 };
            return ret;
        
        
    }
    
    public int[] Mutate(int[] individual) 
    {
        for (int i = 0; i < individual.length; i++)
        {
            double prob = random.nextDouble();
            if (prob < mutationProbability) 
            {
                if (individual[i] == 0)
                    individual[i] = 1;
                else
                    individual[i] = 0;
            }
        }

        return individual;
    }
    
    public void Run() 
    {
        results += GAfunction.getName();
        for (int e = 0; e < numberOfExperiments; e++)
            {
                //results += "\nGeneration : " + (currentGeneration + 1) + "\n";

                //Re-initialize for next experiment
                Initialize();

                for (Generation = 0; Generation < maxGeneration; Generation++)
                {
                    //Get Average GAfunction error
                    averageFuncError = 0;
                    for (int i = 0; i < population.size(); i++)
                        averageFuncError += (population.get(i).getFitnessValue() - GAfunction.getFuncMin());
                    averageFuncError = averageFuncError / population.size();

                    double minimum = Double.MAX_VALUE;
                    int minPos = 0;
                    double maximum = 0;
                    int maxPos = 0;

                    //Get standard deviation
                    standardDeviation = 0;
                    for (int i = 0; i < population.size(); i++)
                        standardDeviation += Math.pow((averageFuncError - (population.get(i).getFitnessValue() - GAfunction.getFuncMin())), 2);
                    standardDeviation = Math.sqrt(standardDeviation/population.size());

                    //Check for best & worst mean GAfunction evaluation
                    double aveFuncEval = 0;
                    for (int i = 0; i < population.size(); i++)
                        aveFuncEval += population.get(i).getFitnessValue();
                    aveFuncEval = aveFuncEval / population.size();

                    if (aveFuncEval < bestMeanFuncEval)
                        bestMeanFuncEval = aveFuncEval;
                    if (aveFuncEval > worseMeanFuncEval)
                        worseMeanFuncEval = aveFuncEval;

                    //Check for best solution
                    for (int i = 0; i < population.size(); i++)
                    {
                        if (population.get(i).getFitnessValue() < minimum)
                        {
                            minimum = population.get(i).getFitnessValue();
                            minPos = i;
                        }
                    }
                    //Check for worst solution
                    for (int i = 0; i < population.size(); i++)
                    {
                        if (population.get(i).getFitnessValue() > maximum)
                        {
                            maximum = population.get(i).getFitnessValue();
                            maxPos = i;
                        }
                    }

                    //Set best solution for iteration
                     fitIndividual = population.get(minPos);
                    //results += bestSolution.ToString();

                    //Stop loop if acceptable solution has been found
                    if (fitIndividual.getFitnessValue() <= 0.0001)
                    {
                        successfulFuncEvals++;
                        successfulMeanFuncEval += fitIndividual.getFitnessValue();
                        break;
                    }
                    
                    /*Generate Selection probablility*/

                    //Mating pool
                    matingList = new ArrayList<Individual>(population.size());

                    //Get total fitness
                    double totalFitness = 0;
                    for (int i = 0; i < population.size(); i++)
                        totalFitness += population.get(i).getFitnessValue();

                    //Get total probs
                    double totalProbs = 0;
                    for (int i = 0; i < population.size(); i++)
                    {
                        totalProbs += totalFitness / population.get(i).getFitnessValue();
                    }

                    //Get expected count & add to mating pool
                    for (int i = 0; i < population.size(); i++)
                    {
                        double prob = (totalFitness / population.get(i).getFitnessValue()) / totalProbs;
                        prob *= population.size();
                        int actualCount = (int)Math.round(prob);
                        for (int j = 0; j < actualCount; j++)
                            matingList.add(population.get(i));
                    }


                    //Create offspring - Crossover
                    population.clear();
                    for (int i = 0; i < numberOfIndividuals / 2; i++) 
                    {
                        Individual[] cs = CrossOver();
                        population.add(cs[0]);
                        population.add(cs[1]);
                    }
                    
                    
                }   // end generation loop

                results += "Best Solution in Experiment " + (e+1) + ": \n" ;
                results += fitIndividual.ToString();

                averageFuncErrorExp += averageFuncError;
                standardDeviationAveExp += standardDeviation;

            }   // end experiment loop

            averageFuncErrorExp = averageFuncErrorExp / numberOfExperiments;
            successfulMeanFuncEval = successfulMeanFuncEval / successfulFuncEvals;

            
            results += "\nAverage Function Error: " + averageFuncError;
            results += "\nStandard Deviation (Ave.): " + standardDeviationAveExp;
            results += "\nNo. of Successful Runs: " + successfulFuncEvals;
            results += "\nMean Function Evaluation of Succssful Runs: " + successfulMeanFuncEval;
            results += "\nBest Mean Function Evalution: " + bestMeanFuncEval;
            results += "\nWorst Mean Function Evaluation: " + worseMeanFuncEval;
        }
    
    
    public static void main(String[] args) 
    {
        int expCount = 10 ;
        int genCount = 10;
        int popCount = 20;
        int dim = 5;
        double mutProb = 0.05;
        int minx = 0;
        int maxx = 15;
        IFunction func = new AssignmentFunctions() ;
        
        IndividualEnvironment gaEnvironment = new IndividualEnvironment(expCount, genCount, popCount, dim, maxx, minx, mutProb, func);
        System.out.println("\"Simple Genetic Algorithm Initialized.\\n\\n\"");
        
        gaEnvironment.Run();
        System.out.print(gaEnvironment.results);
        
    }
}
