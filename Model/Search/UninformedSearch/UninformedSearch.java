/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Search.UninformedSearch;

import Model.Graph.Graph;
import Model.Graph.Node;
import Model.Search.Search;
import java.util.List;

/**
 *
 * @author tosinamuda
 */
public abstract class UninformedSearch implements Search{
 public Graph g;
 
 public UninformedSearch(Graph g)
 {
     this.g = g;
 }
}
