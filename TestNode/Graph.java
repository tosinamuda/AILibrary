/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestNode;

/**
 *
 * @author BaldEagle
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Graph 
{
    java.util.List<Edge> ListofEdges = new ArrayList<Edge>();
    private HashMap AdjacencyList = new HashMap();
    
    public Graph()
    {
        
    }
    
    public void AddNode(String Label)
    {
        Node n = new Node(Label);
        AdjacencyList.put(n, new ArrayList<Node>());        
    }
    
    public void AddEdge(String to, )
    
    
}
