/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.UninformedSearch;

/**
 *
 * @author Tosin Amuda
 */
import Model.graphapi.*;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BreadthFirstSearch {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    private int[] distTo;      // distTo[v] = number of edges shortest source-v path

    /**
     * Computes the shortest path between the source vertex <tt>source</tt>
     * and every other vertex in the graph <tt>G</tt>.
     * @param G the graph
     * @param source the source vertex
     */
    public BreadthFirstSearch(Graph G, int source) {
        marked = new boolean[G.getV()];
        distTo = new int[G.getV()];
        edgeTo = new int[G.getV()];
        bfs(G, source);

        assert check(G, source);
    }

    /**
     * Computes the shortest path between any one of the source vertices in <tt>sources</tt>
     * and every other vertex in graph <tt>G</tt>.
     * @param G the graph
     * @param sources the source vertices
     */
    public BreadthFirstSearch(Graph G, Iterable<Integer> sources) {
        marked = new boolean[G.getV()];
        distTo = new int[G.getV()];
        edgeTo = new int[G.getV()];
        for (int v = 0; v < G.getV(); v++) distTo[v] = INFINITY;
        bfs(G, sources);
    }


    // breadth-first search from a single source
    private void bfs(Graph G, int s) {
        Queue<Integer> q = new LinkedList<Integer>();
        for (int v = 0; v < G.getV(); v++) distTo[v] = INFINITY;
        distTo[s] = 0;
        marked[s] = true;
        q.add(s);
        

        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w : G.getAdjacentVerticies(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.add(w);
                }
            }
        }
    }

    // breadth-first search from multiple sources
    private void bfs(Graph G, Iterable<Integer> sources) {
        Queue<Integer> q = new LinkedList<Integer>();
        for (int s : sources) {
            marked[s] = true;
            distTo[s] = 0;
            q.add(s);
        }
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w : G.getAdjacentVerticies(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.add(w);
                }
            }
        }
    }

    /**
     * Is there a path between the source vertex <tt>s</tt> (or sources) and vertex <tt>v</tt>?
     * @param v the vertex
     * @return <tt>true</tt> if there is a path, and <tt>false</tt> otherwise
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * Returns the number of edges in a shortest path between the source vertex <tt>s</tt>
     * (or sources) and vertex <tt>v</tt>?
     * @param v the vertex
     * @return the number of edges in a shortest path
     */
    public int distTo(int v) {
        return distTo[v];
    }

    /**
     * Returns a shortest path between the source vertex <tt>s</tt> (or sources)
     * and <tt>v</tt>, or <tt>null</tt> if no such path.
     * @param v the vertex
     * @return the sequence of vertices on a shortest path, as an Iterable
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }


    // check optimality conditions for single source
    private boolean check(Graph G, int s) {

        // check that the distance of s = 0
        if (distTo[s] != 0) {
            System.out.println("distance of source " + s + " to itself = " + distTo[s]);
            return false;
        }

        // check that for each edge v-w dist[w] <= dist[v] + 1
        // provided v is reachable from s
        for (int v = 0; v < G.getV(); v++) {
            for (int w : G.getAdjacentVerticies(v)) {
                if (hasPathTo(v) != hasPathTo(w)) {
                    System.out.println("edge " + v + "-" + w);
                    System.out.println("hasPathTo(" + v + ") = " + hasPathTo(v));
                    System.out.println("hasPathTo(" + w + ") = " + hasPathTo(w));
                    return false;
                }
                if (hasPathTo(v) && (distTo[w] > distTo[v] + 1)) {
                    System.out.println("edge " + v + "-" + w);
                    System.out.println("distTo[" + v + "] = " + distTo[v]);
                    System.out.println("distTo[" + w + "] = " + distTo[w]);
                    return false;
                }
            }
        }

        // check that v = edgeTo[w] satisfies distTo[w] + distTo[v] + 1
        // provided v is reachable from s
        for (int w = 0; w < G.getV(); w++) {
            if (!hasPathTo(w) || w == s) continue;
            int v = edgeTo[w];
            if (distTo[w] != distTo[v] + 1) {
                System.out.println("shortest path edge " + v + "-" + w);
                System.out.println("distTo[" + v + "] = " + distTo[v]);
                System.out.println("distTo[" + w + "] = " + distTo[w]);
                return false;
            }
        }

        return true;
    }

    /**
     * Unit tests the <tt>BreadthFirstSearch</tt> data type.
     */
    public static void main(String[] args) {
        //In in = new In(args[0]);
        System.out.println("Error");
        GraphReader in = null;
        try {
            
          
            in = new GraphReader("C:\\Users\\Tosin Amuda\\Documents\\AILibrary\\src\\Model\\graphapi\\Graph.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BreadthFirstSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
        Graph G = new Graph(in);
        System.out.println(G);

        int s = 0; //Integer.parseInt(args[1]);
        int v = 4; // Integer.parseInt(args[2]);
        
        BreadthFirstSearch bfs = new BreadthFirstSearch(G, s);
        
         if (bfs.hasPathTo(v)) {
                System.out.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
                
                for (int x : bfs.pathTo(v)) {
                    if (x == s)
                    { 
                        System.out.print(x);
                    }
                    else      
                    {
                        System.out.print("-" + x);
                    }
                }
                System.out.println();
            }

            else {
                System.out.printf("%d to %d (-):  not connected\n", s, v);
            }

      
    }


}
