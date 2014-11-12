/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestNode;

/**
 *
 * @author olivia
 */
import java.util.*;
//import Model.graphapi.Node;

public class TowersOH
{
    Stack[] towers;
    
     public class Step
    {
        int from, to;
        
        public Step(int from, int to)
        {
            this.from = from +1;
            this.to = to +1;
        }
        @Override 
        public String toString()
        {
            return "Move from tower " + from + " to tower "+ to;
        }
     }
     
    private static class Node implements Cloneable
    {
        public Stack[] v;
        public Node parent;
        public Step st;
        
        public Node(Stack[] tow)
        {
            this.v = tow;
            parent = null;
        }
        
        public Node(){}
         
         @Override
        public Node clone() throws CloneNotSupportedException
        {
            Stack[] cloned = new Stack[v.length];
            for (int i=0; i< v.length; i++)
                cloned[i] = (Stack) v[i].clone();

            Node n = new Node(cloned);
            return n;
        }
        
        @Override
        public boolean equals(Object o)
        {
            if(o == null)
                return false;
            if(getClass() != o.getClass())
                return false;
            Node second = (Node) o;
            if(!Arrays.deepEquals(this.v, second.v))
                return false;
            return true;
        }
        
         public Node towerConfig (int nTowers, int nDisc, boolean goal)
         {
             Stack[] config = new Stack[nTowers];
             for (int i=0; i<nTowers; i++)
                 config[i] = new Stack<>();
             if (!goal)
             {
                 TreeMap<Integer, Integer> order = new TreeMap<Integer, Integer>(Collections.reverseOrder());
                 for (int i=0; i < nDisc; i++)
                     order.put(i,1);
                 for (Map.Entry<Integer, Integer> en: order.entrySet())
                 {
                     config[en.getValue()-1].push(en.getKey());
                 }
             }
             else
             {
                 TreeMap<Integer, Integer> order = new TreeMap<Integer, Integer>(Collections.reverseOrder());
                 for (int i=0; i < nDisc; i++)
                     order.put(i,nTowers);
                 for (Map.Entry<Integer, Integer> en: order.entrySet())
                 {
                     config[en.getValue()-1].push(en.getKey());   
                 }
             }
             
             return new Node(config);
         }
    
    }
    
    public TowersOH()
    {
    }
    
    public void usingBFS(Node start, Node goal, List visit)
    {
        Queue queue = new LinkedList();
        Node now = start;
        queue.add(now);
        visit.add(now);
        while (!queue.isEmpty())
        {
            now = (Node) queue.poll();
            if (now.equals(goal))
                break;
            List<Node> children = children(now);
            if (children.size() >0)
            {
                for (Node no: children)
                {
                    if (!contain(visit, no) && !queue.contains(no))
                    {
                        queue.offer(no);
                        visit.add(no);
                    }
                }
            }
        }
        if (now.equals(goal))
        {
            printResult(now);
            printResult(visit);
        }
    }
    
    public boolean contain(List m, Node n)
    {
        for (Object o : m)
        {
            if(n.equals(o))
                return true;
        }
        return false;
    }
    
    public void usingDFS(Node start, Node goal, List visit)
    {
        Stack stack = new Stack<>();
        Node now = start;
        stack.push(now);
        visit.add(now);
        while (!stack.isEmpty())
        {
            now = (Node)stack.pop();
            if(now.equals(goal))
                break;
            List<Node> children = children(now);
            if (children.size()>0)
            {
                for (Node no: children)
                {
                    if (!contain(visit, no))
                    {
                        stack.push(no);
                        visit.add(no);
                    }
                }
            }
        }
        if (now.equals(goal))
        {
            printResult(now);
            printResult(visit);
        }
    }
    
    public void printResult(Node goal)
    {
        Stack st = new Stack<>();
        while (goal.parent != null) 
        {
            st.add(goal.st);
            goal = goal.parent;
        }
        //System.out.println(st.size());
        
        while (!st.isEmpty())
          System.out.println(st.pop());
    }
    
    public void printResult(List visited)
    {
        for (Object o : visited) 
        {
            Node n = (Node) o;
            for (Stack s : n.v)
            {
                System.out.print(s.size() + "\t");
            }
            System.out.println();
        }
    }
    
    private boolean legal(Stack tower1, Stack tower2)
    {
        boolean allow = false;
        if (tower2.isEmpty())
            return true;
        int tower1Disc = (int)tower1.peek();
        int tower2Disc = (int)tower2.peek();

        if (tower1Disc < tower2Disc)
            allow = true;

        return allow;
    }
    
    private List<Node> children(Node n)
    {
        List children = new ArrayList();
        for (int i=0; i< n.v.length; i++)
        {
            for (int j=0; j < n.v.length; j++)
            {
                if ( i!= j && !n.v[i].isEmpty())
                {
                    try
                    {
                        Node child = n.clone();
                        if(legal(child.v[i], child.v[j]))
                    {
                        child.v[j].push(child.v[i].pop());
                        child.parent = n;
                        child.st = new Step(i,j);
                        children.add(child);
                    }
                    }
                    catch(CloneNotSupportedException c){c.printStackTrace();}
                }
            }
        }
        return children;
    }
    
       
    public static void main(String args[])
    {
        //Set visited = new HashSet();
        List visited = new ArrayList();
        Node n = new Node();
        Node initial = n.towerConfig(3, 3, false);
        Node goal = n.towerConfig(3, 3, true);
        TowersOH t = new TowersOH();
        t.usingBFS(initial, goal, visited);
        System.out.println();
        visited.clear();
        t.usingDFS(initial, goal, visited);
        System.out.println();

    }
    
}
