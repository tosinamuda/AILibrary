/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Search;

import TestNode.Graph;
import TestNode.Node;
import java.util.List;

/**
 *
 * @author tosinamuda
 */
public interface Search {
    
    
    public List<Node>Search();
    
    public List<Node> Search(Node start);
    
    public List<Node> Search( Node start, Node goal);
    
    
}
