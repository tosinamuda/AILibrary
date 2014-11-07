
package Model.graphapi;


import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Tosin AMUDA
 */
public class Graph 
{

    private final int NoOfVertices;
    private int NoOfEdges;
    private final List<Edge>[] AdjacencyList; //Adjancy list is an array of list

    
    //Initialize this Graph Object
    public Graph(int v) 
    {
        if (v < 0) 
        {
            throw new IllegalArgumentException("Number of vertices must be nonnegative");
        }
        this.NoOfVertices = v;
        this.NoOfEdges = 0;
        this.AdjacencyList = (List<Edge>[]) new ArrayList[v];
        int size = this.AdjacencyList.length;
        for (int i = 0; i < size; i++) 
        {
            AdjacencyList[i] = new ArrayList<>();
        }

    }

	//INITIALIZE the graph with a file read with GraphReader class
    public Graph(GraphReader reader) 
    {
        this(reader.readInt()); //Calls constructor Graph(int v)
        int E = reader.readInt();
        
        if (E < 0)
        {
            throw new IllegalArgumentException("Number of edges must be nonnegative");
        }
        for (int i = 0; i < E; i++) 
        {
            int v1 = reader.readInt();
            int v2 = reader.readInt();
           
            Edge e = new Edge(v1, v2);
            AddEdge(e);
        }

    }

    public void AddEdge(Edge e)
    {

        int v1 = e.thisVertex();
        int v2 = e.otherVertex(v1);

        AdjacencyList[v1].add(e);
        AdjacencyList[v2].add(e);
        NoOfEdges++;

    }

    //Get Edges Incident to V
    public Iterable<Edge> getIncidentList(int v) 
    {
        return AdjacencyList[v];
    }

      //Get Adjacent Vertices to V
    public Iterable<Integer> getAdjacentVerticies(int v) {
       List<Integer> adjacentVertexList = new ArrayList<Integer>();
       
       for (Edge e : getIncidentList(v)) {
           adjacentVertexList.add(e.otherVertex(v));
           
       }
       
        return adjacentVertexList;
    }
     /* @return in-degree of a vertex in the edge-weighted graph .
     */
    public int getDegree(int v) 
    {
        return this.getInDegree(v)* 2;
    }
    
    /* @return in-degree of a vertex in the edge-weighted graph .
     */
    public int getInDegree(int v) 
    {
        return AdjacencyList[v].size();
    }

    public int getOutDegree(int v) 
    {
        return AdjacencyList[v].size();
    }
    
    /* @return all edges in the edge-weighted graph as an Iterable.
     */

    public Iterable<Edge> edges() 
    {
        List<Edge> list = new ArrayList<>();
        for (int v = 0; v < this.NoOfVertices; v++) 
        {
            int selfLoops = 0;
            for (Edge e : getIncidentList(v)) 
            {
                if (e.otherVertex(v) > v) 
                {
                    list.add(e);
                } // only add one copy of each self loop (self loops will be consecutive)
                else if (e.otherVertex(v) == v) 
                {
                    if (selfLoops % 2 == 0) 
                    {
                        list.add(e);
                    }
                    selfLoops++;
                }
            }
        }
        return list;
    }

    /**
     * Returns a string representation of the edge-weighted graph. This method
     * @return     
     */
    @Override
    public String toString() 
    {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder();
        s.append("G(V,E) = (").append(this.NoOfVertices).append(", ").append(this.NoOfEdges).append(")").append(NEWLINE);
        for (int v = 0; v < this.NoOfVertices; v++) 
        {
            s.append(v).append(": ");
            for (Edge e : getIncidentList(v)) 
            {
                s.append(e).append("  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public int getV() 
    {
        return this.NoOfVertices;
    }

    public int getE() 
    {
        return this.NoOfEdges;
    }

}
