/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaGUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

/**
 *
 * @author taniv
 */
public class txtToArray {
    
    public String[][] array (String filename) throws IOException {
        List <String[]>Array = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line=reader.readLine())!=null){
                String [] data = line.split(",");
                Array.add(data);
                
            }
            
            
                
        } catch (FileNotFoundException ex) {
            Logger.getLogger(txtToArray.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(txtToArray.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String [][] dataArray  = Array.toArray(String[][]::new);
        return dataArray;
                
            
            
        }
    } 
    
    

