/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.ANN;

/**
 *
 * @author tosinamuda
 */
public class TrainingData {
    
    double a;
    double b;  
    double expected;
    
    public TrainingData(double a, double b, double expected)
    {
        this.a = a;
        this.b = b;
        this.expected  = expected;
    }
    
    public static TrainingData[] createORDataSet()
    {
        TrainingData ORDataSet[] =  {new TrainingData(-1.0, -1.0, -1.0),
                                    new TrainingData(-1.0, 1.0, 1.0), 
                                    new TrainingData(1.0, -1.0, 1.0), 
                                    new TrainingData(1.0, 1.0, 1.0) };
        return ORDataSet;
    }
    
        public static TrainingData[] createANDDataSet()
    {
        TrainingData ANDDataSet[] =  {new TrainingData(-1.0, -1.0, -1.0),
                                    new TrainingData(-1.0, 1.0, -1.0), 
                                    new TrainingData(1.0, -1.0, -1.0), 
                                    new TrainingData(1.0, 1.0, 1.0) };
        return ANDDataSet;
    }
    
        
     public static TrainingData[] createXORDataSet()
    {
        TrainingData XORDataSet[] =  {new TrainingData(-1.0, -1.0, -1.0),
                                    new TrainingData(-1.0, 1.0, 1.0), 
                                    new TrainingData(1.0, -1.0, 1.0), 
                                    new TrainingData(1.0, 1.0, -1.0) };
        return XORDataSet;
    }
    
    
}
