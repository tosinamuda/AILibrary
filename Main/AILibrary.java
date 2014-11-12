
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Tosin Amuda
 */
//import Model.graphapi.*;
import TestNode.*;
import Model.UninformedSearch.*;
import java.io.*;
public class AILibrary 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {     
        Graph g = new Graph();
        g.AddNode("1"); g.AddNode("2"); g.AddNode("3"); g.AddNode("4");
        g.AddEdge(g.getNode("1"), g.getNode("2"));
        g.AddEdge(g.getNode("1"), g.getNode("3"));
        g.AddEdge(g.getNode("2"), g.getNode("4"));
        g.AddEdge(g.getNode("3"), g.getNode("4"));   
        
      //  DepthFirstSearch dfs = new DepthFirstSearch();        
                
        // TODO code application logic here
        //Testing GraphAPI
//        try
//        {            
//            GraphReader Gr = new GraphReader("graph2.txt");
//            Graph g = new Graph(Gr);
//            System.out.println(g.toString());
////            DepthFirstSearch dfs = new DepthFirstSearch();
//////            dfs.DFS(g, 3);  
//////            dfs.DFS(g, 3, 8);
////            DepthLimitedSearch dls = new DepthLimitedSearch();
////            dls.DLS(g, 0, 8, 2);
////            
//            IterativeDeepeningSearch ids = new IterativeDeepeningSearch();
//            ids.IDS(g, 0, 8);
//        }
//        catch(FileNotFoundException f)
//        {
//            System.out.println("I am not Working");
////            f.printStackTrace();
//        }
//        
        
    }
}
