/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.graphapi;

/**
 *
 * @author tosinamuda
 */
public class Vertex {
    
    private int data;
    private float pointX;
    private float pointY;
    
    
    public int getData(){return this.data;}
    
    public float getPointX(){return this.pointX;}
    
    public float getPointY(){return this.pointY;}
    
    public void setData(int data){this.data = data;}
    
    public void setPointX(float pointX) {this.pointX = pointX;}
    
    public void setPointY(float pointY) {this.pointY = pointY;}
}
