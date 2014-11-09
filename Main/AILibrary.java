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
import UninformedSearch.*;
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
        {   Graph g = new Graph();
        g.AddNode("1"); g.AddNode("2"); g.AddNode("3"); g.AddNode("4");
        g.AddEdge(g.getNode("1"), g.getNode("2"));
        g.AddEdge(g.getNode("1"), g.getNode("3"));
        g.AddEdge(g.getNode("2"), g.getNode("4"));
        g.AddEdge(g.getNode("3"), g.getNode("4"));
        String graphString = g.toString();
        System.out.println(graphString);
        }
        catch(FileNotFoundException f)
        {
            System.out.println("I am not Working");
//            f.printStackTrace();
        }
        
        
    }
}
