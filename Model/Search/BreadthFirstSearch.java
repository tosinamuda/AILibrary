/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Search;

import TestNode.Graph;
import TestNode.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author tosinamuda
 */
public class BreadthFirstSearch  extends UninformedSearch{

    public BreadthFirstSearch(Graph g)
    {
        super(g);
      
        
    }
    @Override
    public List<Node> Search() {
        return null;
        
    }
    
    @Override
    public List<Node> Search( Node start, Node goal)
    {
        Node currentNode = start;
        Queue<Node> searchQueue = new LinkedList<Node>();
        List<Node> VisitedNodeList = new ArrayList<Node>();
        
        searchQueue.add(start);
        while(!searchQueue.isEmpty())
        {
            currentNode = searchQueue.remove();
            currentNode.setVisited(true);
            
            VisitedNodeList.add(currentNode);            
            if(currentNode == goal)
            {
                break;
            }
            for(Node e : this.g.AdjacencyList2.get(currentNode))
            {
                if(!(VisitedNodeList.contains(e) && !(searchQueue.contains(e))))
                {
                    searchQueue.add(e);                    
                }                
            }                                 
        }
        for(Node e: VisitedNodeList)
        {
            System.out.println(e.Label()+"\t");
        }  
        return VisitedNodeList;
    }

    @Override
    public List<Node> Search(Node start) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
