/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vehicle_code.backend.DAO_implements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Usuario
 */
public class CustomRandom {
    private RandomAccessFile rafH;//HEAD
    private RandomAccessFile rafD;//DATA
    
    public CustomRandom(File file_Head, File file_Data) throws FileNotFoundException, IOException{
        rafH = new RandomAccessFile(file_Head, "rw"); // Read/Written to = "rw"; (YOU CAN READ IT AND MODIFY)
        // operating systems also allow you to protect objects with a read-only attribute 
        //that prevents other users from modifying the object
        rafD = new RandomAccessFile(file_Data, "rw");
        
        
        /*
        
        */
        if(file_Head.length() == 0){
            rafH.writeInt(0);
            rafH.writeInt(0);
        }
    }
    
    //Cortar los flujos por cualquier imprevisto.
     public void close() throws IOException{
            if(rafH != null){
                rafH.close();
            }
            
            if(rafD != null){
                rafD.close();
            }
     }        
     
     
    public RandomAccessFile getRafH()
    {
        return rafH;
    }
    
    public RandomAccessFile getRafD()
    {
        return rafD;
    }
}
