/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.UninformedSearch;

/**
 *
 * @author BaldEagle
 */
import TestNode.*;
import java.util.*;
public class IdsResult implements Cloneable
{
    public int value;
    public List<Node> nodeList = new ArrayList<Node>();
    
    public IdsResult( int value, List<Node> list)
    {
        this.value = value;        
        this.nodeList = list;
    }               
    
}

