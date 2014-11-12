/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.InformedSearch;

/**
 *
 * @author tosinamuda
 */

public class HillClimbing 
{
    private double startNode;
    private double stepSize;

    public double getStepSize() {
        return stepSize;
    }

    public void setStepSize(double stepSize) {
        this.stepSize = stepSize;
    }

    public HillClimbing(double startNode, double stepSize) {
        this.startNode = startNode;
        this.stepSize = stepSize;
    }

    public double getStartNode() {
        return startNode;
    }

    public void setStartNode(double startNode) {
        this.startNode = startNode;
    }
    
    public double[] neighbours(double currentNode)
    {
       double step = this.stepSize;
        double[] val = new double[10];
        for (int i=0; i< val.length; i++){
            val[i] = currentNode + step;
            step  = val[i] + step;
        }
        return val;
    }
    
    public double Search()
    {
        double currentNode = this.startNode;
        double[] neighbours;
        do
        {
            neighbours = neighbours(currentNode);
            double nextEval = Double.NEGATIVE_INFINITY;
            double nextNode = 0;
            for (double x: neighbours)
            {
                if (eval(x)>nextEval)
                {
                    nextNode = x;
                    nextEval = eval(x);
                }
            }
            if (nextEval > eval(currentNode))
                currentNode = nextNode;
            else 
                break;
        }while(true);
        return currentNode;
    }
    
    private double eval(double x)
    {
        return (15 * x)-(x*x);
    }

    public static void main(String[] args)
    {
        HillClimbing hc = new HillClimbing(0, 0.005);
        System.out.println(hc.Search());
//        double[] neigh = hc.neighbours();
//        for(double i: neigh)
//            System.out.println(i);
    }
}
