/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestNode;

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
    BestFirstNode2 root;
    //End of Okoro's
    public final java.util.List<BestFirstEdge> ListofEdges = new ArrayList<BestFirstEdge>();
    public final java.util.List<BestFirstNode2> ListofNodes = new ArrayList<BestFirstNode2>();
    public static int countNode = 1;
    
    
    public final HashMap<BestFirstNode2,java.util.List<BestFirstNode2>> AdjacencyList2 = new HashMap<BestFirstNode2,java.util.List<BestFirstNode2>>();
      
      //Okoro's
    
//    public void setDepthOfNodes()
//    {
//        for(BestFirstNode2 node : ListofNodes)
//        {
//            if(!node.children.isEmpty())
//            {
//                for(BestFirstNode2 childNode: node.children)
//                {
//                   childNode.depth = node.depth +1; 
//                }
//            }
//        }
//    }
    public boolean EdgeExistsWith(BestFirstNode2 theNode , BestFirstNode2 otherNode)
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
        BestFirstNode2 n = new BestFirstNode2(Label,heuristic);
        if (ListofNodes.isEmpty())
        {
            this.root = n;
            ListofNodes.add(n);
            AdjacencyList2.put(n, new ArrayList<BestFirstNode2>());   
            countNode++;      
            //this.root.depth = 0;
        }
        else
        {
            ListofNodes.add(n);
            AdjacencyList2.put(n, new ArrayList<BestFirstNode2>());   
            countNode++;            
        }        
    }
    
    public void AddNode(BestFirstNode2 newNode)
    {
        //Okoro's
        if (ListofNodes.isEmpty())
        {
            this.root = newNode;
            ListofNodes.add(newNode);
            AdjacencyList2.put(newNode, new ArrayList<BestFirstNode2>());   
            countNode++;      
            //this.root.depth = 0;
        }        
        //End of Okoro's
        else
        {
            ListofNodes.add(newNode);
            AdjacencyList2.put(newNode,  new ArrayList<BestFirstNode2>());
            countNode++;
        }
        
    }
    
    
    private boolean check(BestFirstNode2 a, HashMap v)
    {
        Iterator it = v.keySet().iterator();
        while (it.hasNext())
        {
            BestFirstNode2 b = (BestFirstNode2) it.next();
            if (a == b)
            {
                return true;
            }
        }
        return false;
    }
    
    public void AddEdge(BestFirstNode2 from, BestFirstNode2 to)
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
    
       
    public void AddEdge(BestFirstNode2 from, BestFirstNode2 to, double weight)
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
    
    public BestFirstNode2 getNode(String value)
    {
     Set keys = AdjacencyList2.keySet();
     Iterator iterator = keys.iterator();
     BestFirstNode2 n = null;
     while(iterator.hasNext())
     {
        BestFirstNode2  foundNode = (BestFirstNode2)iterator.next();
         if (foundNode.Label().equals(value) )
         {
             n = foundNode;
             break;
         }
         
     }
     
     return n;
    }
    
    public BestFirstEdge getEdge(BestFirstNode2 v1, BestFirstNode2 v2)
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
            BestFirstNode2 n = (BestFirstNode2)it.next();
            graph += "BestFirstNode2 " + n.Label() + ": ";
            java.util.List <BestFirstNode2> adjacentNode = (java.util.List<BestFirstNode2>)AdjacencyList2.get(this.getNode(n.Label()));
            for (BestFirstNode2 others : adjacentNode)
            {
                BestFirstNode2 otherNode = getNode(others.Label());
                graph += otherNode.Label() + " ";
            }
            graph += "\n";
        }
        return graph;
    }
    
}
