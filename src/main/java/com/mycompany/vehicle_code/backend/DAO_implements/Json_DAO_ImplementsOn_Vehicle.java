package com.mycompany.vehicle_code.backend.DAO_implements;

import com.google.gson.Gson;
import com.mycompany.vehicle_code.backend.DAO.DAO_Vehicle;
import com.mycompany.vehicle_code.backend.pojo.MainObj_Vehicle;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Json_DAO_ImplementsOn_Vehicle extends RandomTemplate implements DAO_Vehicle {
    private final int SIZE = 800;
    private Gson gson;
    public Json_DAO_ImplementsOn_Vehicle() throws FileNotFoundException{
        super(new File("vehicleJson.head"), new File("vehicleJson.dat"));
        gson = new Gson();
    }
    //SE IMPLEMENTA TODOS LOS CONCEPTOS ABSTRACTOS QUE PROVIENEN DEL RANDOMTEMPLATE Y DAO VEHICLE
    @Override
    public MainObj_Vehicle fundById(int id) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<MainObj_Vehicle> findByStatus(String status) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(MainObj_Vehicle t) throws IOException {
      
        getCustomRandom().getRafH().seek(0);
        int n = getCustomRandom().getRafH().readInt();
        int k = getCustomRandom().getRafH().readInt();
        
        long Pos_D = k * SIZE;
        getCustomRandom().getRafD().seek(Pos_D);
        
        getCustomRandom().getRafD().writeInt(++k); //ID
        getCustomRandom().getRafD().writeUTF(gson.toJson(t));//VEHICLE JSON
        
        long Pos_H = 8 + (n * 8);
        getCustomRandom().getRafH().seek(Pos_H);
        getCustomRandom().getRafH().writeInt(++n);
        getCustomRandom().getRafH().writeInt(k);
        
        close();
    }

    @Override
    public int update(MainObj_Vehicle t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(MainObj_Vehicle t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<MainObj_Vehicle> getAll() throws IOException {
        ArrayList<MainObj_Vehicle> Vehicles = new ArrayList<>();
        MainObj_Vehicle Vehicle = null;
        getCustomRandom().getRafH().seek(0);
        int n = getCustomRandom().getRafH().readInt();
        
        for(int i = 0; i< n; i++)
        {
            long Pos_H = (i * 8);
            getCustomRandom().getRafH().readInt();
            int id = getCustomRandom().getRafH().readInt();
            
            if(id <= 0)
            {
                continue;
            }
            
            long Pos_D = (id - 1) * SIZE;
            getCustomRandom().getRafD().seek(Pos_D);
            getCustomRandom().getRafD().readInt();
            Vehicle = gson.fromJson(getCustomRandom().getRafD().readUTF(), MainObj_Vehicle.class);
            
            Vehicles.add(Vehicle);
        }
        
        return Vehicles;
        
        
     
    }
    //------------------------------------------------------------------------------------
    
    
    
}
