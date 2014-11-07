/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author Tosin Amuda
 */
import Model.graphapi.*;
import Model.UninformedSearch.*;
import java.io.*;
public class AILibrary 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {                
        // TODO code application logic here
        //Testing GraphAPI
        try
        {            
            GraphReader Gr = new GraphReader("graph2.txt");
            Graph g = new Graph(Gr);
            System.out.println(g.toString());
//            DepthFirstSearch dfs = new DepthFirstSearch();
////            dfs.DFS(g, 3);  
////            dfs.DFS(g, 3, 8);
//            DepthLimitedSearch dls = new DepthLimitedSearch();
//            dls.DLS(g, 0, 8, 2);
//            
            IterativeDeepeningSearch ids = new IterativeDeepeningSearch();
            ids.IDS(g, 0, 8);
        }
        catch(FileNotFoundException f)
        {
            System.out.println("I am not Working");
//            f.printStackTrace();
        }
        
        
    }
}
