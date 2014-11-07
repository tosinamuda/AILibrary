/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.graphapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Moji
 */
public class GraphReader 
{
    private final InputStream in;
    private final InputStreamReader inputStreamReader;
    private final BufferedReader br;
    private final Scanner s;
    private final File file;
    private final String fileName;    

    public GraphReader(String fileName) throws FileNotFoundException 
    {
        this.fileName = fileName;
        this.file = new File(this.fileName);
        this.in = new FileInputStream(file);
        this.inputStreamReader = new InputStreamReader(in);
        this.br = new BufferedReader(inputStreamReader);
        this.s = new Scanner(br);
    }

    public int readInt() 
    {
        return s.nextInt();
    }

    public double readDouble() 
    {
        return s.nextDouble();
    }
	
	//TO-DO implement other methods for reading other data types
}
