/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.ANN;

import java.util.Random;

/**
 *
 * @author tosinamuda
 */
public class SingleLayerPerceptron {

    public final static int NUM_INPUTS = 3;
    public final static int NUM_WEIGHTS = 3;
    public final static int MAX_TESTS = 4;
    private  double ALPHA;  //alpha is the learning rate, where 0 < alpha <= 1
    /* Note: +1 here to account for the bias input */
    double weights[] = new double[NUM_INPUTS + 1];
    double inputs[] = new double[NUM_INPUTS + 1];
    
    private TrainingData training_set[];

  

    public SingleLayerPerceptron() {
       this(0.1);
       
    }

    public SingleLayerPerceptron(double alpha) {
        this.ALPHA = alpha;
        initWeight();
        training_set = TrainingData.createORDataSet();
                        
    }
    
 public SingleLayerPerceptron(double alpha, double weights[], TrainingData trainingSet[]) {
        this.ALPHA = alpha;
        this.weights = weights;
        this.training_set = trainingSet;   
 }
 
 public SingleLayerPerceptron(double alpha,  TrainingData trainingSet[]) {
        this.ALPHA = alpha;
        initWeight();
        this.training_set = trainingSet;   
 }

  


    public double getALPHA() {
        return ALPHA;
    }

    public void setALPHA(double ALPHA) {
        this.ALPHA = ALPHA;
    }



    

    int step_function(double input) {
        if (input > 0.0) {
            return 1;
        } else {
            return -1;
        }
    }

    int calc_output() {

        double sum = 0.0;
        /* Set the bias (could be done once at init)*/
        inputs[NUM_INPUTS] = 1.0;
        /* Compute the output (Equation 8.1) */
        for (int i = 0; i < inputs.length && i < weights.length; i++) {
            sum += (weights[i] * inputs[i]);
        }
        /* Pass the output through the step (activation) function */
        return step_function(sum);
    }

    private void initWeight() {
        /* Initialize the weights for the perceptron */
        this.weights = new double[NUM_WEIGHTS];
        for (int i = 0; i < NUM_WEIGHTS; i++) {
            this.weights[i] = 0.0;
        }
    }

    double compute(int test) {
        double result;
        /* Equation 8.2 */
        result = ((this.training_set[test].a * weights[0]) + (this.training_set[test].b * weights[1]) + (1.0 * weights[2]));
        /* Clip the result */
      
        return step_function(result);
    }
    
    public void Train()
    {
            boolean change = true;
            while (change) {
            change = false;
            for (int test = 0; test < MAX_TESTS; test++) {
                /* Test on the perceptron */
                double output = this.compute(test);
                /* Perceptron Supervised Learning Algorithm */
                if ((int) this.training_set[test].expected != (int) output) {
                    /* Use Equation 8.3 */
                   this.weights[0] += this.ALPHA * this.training_set[test].expected * this.training_set[test].a;
                    this.weights[1] += this.ALPHA * this.training_set[test].expected * this.training_set[test].b;
                    this.weights[2] += this.ALPHA * this.training_set[test].expected;
                    change = true;
                }
            }
        }
    }
    
    public String ToString()
    {
        String SLPString = "";
        
        /* Check the status of the Perceptron */
        for (int i = 0; i < MAX_TESTS; i++) {
            SLPString += String.format(" %d\t  %d\t  %d\n", (int)this.training_set[i].a, (int)this.training_set[i].b, (int)this.compute(i));
        }
        
        return SLPString;
    }
    
      public TrainingData[] getTraining_set() {
        return training_set;
    }

    public void setTraining_set(TrainingData[] training_set) {
        this.training_set = training_set;
    }

    public static void main(String[] args) {

        SingleLayerPerceptron SLP = new SingleLayerPerceptron();
        /* Train the perceptron with the training set */
        SLP.Train();
        System.out.println(SLP.ToString());                      

     
    }
}
