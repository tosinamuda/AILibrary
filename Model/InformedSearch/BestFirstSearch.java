/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Model.InformedSearch;

/**
 *
 * @author BaldEagle
 */
import TestNode.*;
import java.util.AbstractQueue;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
public class BestFirstSearch
{
    Graph _g;
    
    public BestFirstSearch(Graph g)
    {
        this._g = g;
    }
    
    public List<Node> BestFS(Node start, Node Goal)
    {
        Node currentNode = start;
        PriorityQueue<Node> open = new PriorityQueue<>();
        PriorityQueue<Node> closed = new PriorityQueue<>();
        
        
        
    }
    
}
