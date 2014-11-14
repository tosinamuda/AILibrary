/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


/**
 *
 * @author BaldEagle
 */
public class BestFirstGraph 
{        
    public BestFirstGraph()
    {
    }
    
    
   
//Okoro's
    BestFirstNode root;
    //End of Okoro's
    public final java.util.List<BestFirstEdge> ListofEdges = new ArrayList<BestFirstEdge>();
    public final java.util.List<BestFirstNode> ListofNodes = new ArrayList<BestFirstNode>();
    public static int countNode = 1;
    
    
    public final HashMap<BestFirstNode,java.util.List<BestFirstNode>> AdjacencyList2 = new HashMap<BestFirstNode,java.util.List<BestFirstNode>>();
      
      //Okoro's
    
//    public void setDepthOfNodes()
//    {
//        for(BestFirstNode node : ListofNodes)
//        {
//            if(!node.children.isEmpty())
//            {
//                for(BestFirstNode childNode: node.children)
//                {
//                   childNode.depth = node.depth +1; 
//                }
//            }
//        }
//    }
    public boolean EdgeExistsWith(BestFirstNode theNode , BestFirstNode otherNode)
    {        
        if(getEdge(this.root,otherNode) != null)        
        {
            return true;
        }
        return false;
    }    
    //End of Okoro's
    public void AddNode(String Label, double heuristic)
    {       
        BestFirstNode n = new BestFirstNode(Label,heuristic);
        if (ListofNodes.isEmpty())
        {
            this.root = n;
            ListofNodes.add(n);
            AdjacencyList2.put(n, new ArrayList<BestFirstNode>());   
            countNode++;      
            //this.root.depth = 0;
        }
        else
        {
            ListofNodes.add(n);
            AdjacencyList2.put(n, new ArrayList<BestFirstNode>());   
            countNode++;            
        }        
    }
    
    public void AddNode(BestFirstNode newNode)
    {
        //Okoro's
        if (ListofNodes.isEmpty())
        {
            this.root = newNode;
            ListofNodes.add(newNode);
            AdjacencyList2.put(newNode, new ArrayList<BestFirstNode>());   
            countNode++;      
            //this.root.depth = 0;
        }        
        //End of Okoro's
        else
        {
            ListofNodes.add(newNode);
            AdjacencyList2.put(newNode,  new ArrayList<BestFirstNode>());
            countNode++;
        }
        
    }
    
    
    private boolean check(BestFirstNode a, HashMap v)
    {
        Iterator it = v.keySet().iterator();
        while (it.hasNext())
        {
            BestFirstNode b = (BestFirstNode) it.next();
            if (a == b)
            {
                return true;
            }
        }
        return false;
    }
    
    public void AddEdge(BestFirstNode from, BestFirstNode to)
    {
        from = getNode(from.Label());
        to = getNode(to.Label());
        BestFirstEdge e = new BestFirstEdge(from, to);
        if(check(from, AdjacencyList2) && check(to, AdjacencyList2))
        {  
            AdjacencyList2.get(from).add(to);
            AdjacencyList2.get(to).add(from);
            ListofEdges.add(e);  
           // from.children.add(to);
        }
        else
        {
            System.out.println("You cannot add an edge between nodes that are not in the graph");
        }
    }
    
       
    public void AddEdge(BestFirstNode from, BestFirstNode to, double weight)
    {
        from = getNode(from.Label());
        to = getNode(to.Label());
        BestFirstEdge e = new BestFirstEdge(from, to,weight);
        if(check(from, AdjacencyList2) && check(to, AdjacencyList2))
        {  
            AdjacencyList2.get(from).add(to);
            AdjacencyList2.get(to).add(from);
            ListofEdges.add(e);
            //from.children.add(to);
        }
        else
        {
            System.out.println("You cannot add an edge between nodes that are not in the graph");
        }
        
    }
    
    public BestFirstNode getNode(String value)
    {
     Set keys = AdjacencyList2.keySet();
     Iterator iterator = keys.iterator();
     BestFirstNode n = null;
     while(iterator.hasNext())
     {
        BestFirstNode  foundNode = (BestFirstNode)iterator.next();
         if (foundNode.Label().equals(value) )
         {
             n = foundNode;
             break;
         }
         
     }
     
     return n;
    }
    
    public BestFirstEdge getEdge(BestFirstNode v1, BestFirstNode v2)
    {
        for(BestFirstEdge e: ListofEdges)
        {
            if (e.thisNode().equals(v1) && e.otherNode(v1).equals(v2))
                return e;
        }
        return null;
    }    
    @Override
    public String toString()
    {
        String graph = "";
        Iterator it = this.AdjacencyList2.keySet().iterator();
        while(it.hasNext())
        {
            BestFirstNode n = (BestFirstNode)it.next();
            graph += "BestFirstNode2 " + n.Label() + ": ";
            java.util.List <BestFirstNode> adjacentNode = (java.util.List<BestFirstNode>)AdjacencyList2.get(this.getNode(n.Label()));
            for (BestFirstNode others : adjacentNode)
            {
                BestFirstNode otherNode = getNode(others.Label());
                graph += otherNode.Label() + " ";
            }
            graph += "\n";
        }
        return graph;
    }
    
}
