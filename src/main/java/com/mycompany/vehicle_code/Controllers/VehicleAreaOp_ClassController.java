/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vehicle_code.Controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.mycompany.vehicle_code.JPanels.Pnl_VehicleAreaOp;
import com.mycompany.vehicle_code.backend.DAO_implements.Json_DAO_ImplementsOn_Vehicle;
import com.mycompany.vehicle_code.backend.pojo.MainObj_Vehicle;
import com.mycompany.vehicle_code.backend.pojo.subObject.SubObjModel_Vehicle;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class VehicleAreaOp_ClassController {
    //
    //[SE RECALCA]Necesitamos una clase en donde vaya pueda crear un objeto vehículo.//
    //Primeramente, declaro la variable principal; con la que es el papel de todo esto:
    private Pnl_VehicleAreaOp pnl_VehicleAreaOp;
    //--------------------------------------------------------------------------------
    //
    //Los pinceles de los combo box, ya están siendo creados:
    private DefaultComboBoxModel cmbModel_Year;
    private DefaultComboBoxModel cmbModel_Make;
    private DefaultComboBoxModel cmbModel_Model;
    private DefaultComboBoxModel cmbModel_EColor;
    private DefaultComboBoxModel cmbModel_IColor;
    private DefaultComboBoxModel cmbModel_Status;
    //
    private Json_DAO_ImplementsOn_Vehicle Jdaov;
    private Gson gson;
    
    //
    private ArrayList<SubObjModel_Vehicle> SubObjModel_Vehicle;
    //
    private JFileChooser fileChooser;
    
    public VehicleAreaOp_ClassController(Pnl_VehicleAreaOp pnl_VehicleAreaOp) throws FileNotFoundException
    {
       this.pnl_VehicleAreaOp = pnl_VehicleAreaOp;
       initComponent();
    }
    
    public void initComponent() throws FileNotFoundException{
        gson = new Gson();
        Jdaov = new Json_DAO_ImplementsOn_Vehicle();
        
        JsonReader jreader = new JsonReader(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/jsons/vehicleData"))));
        
        java.lang.reflect.Type listType = new TypeToken<ArrayList<SubObjModel_Vehicle>>(){}.getType();
        SubObjModel_Vehicle = gson.fromJson(jreader, listType);
        ArrayList<String> makes = (ArrayList<String>) SubObjModel_Vehicle.stream()
                .map(v -> v.getMake()).collect(Collectors.toList());
        ArrayList<String> models = (ArrayList<String>) SubObjModel_Vehicle.stream()
                .map(v -> v.getModel()).collect(Collectors.toList());
        ArrayList<String> years = (ArrayList<String>) SubObjModel_Vehicle.stream()
                .map(v -> v.getYear()).collect(Collectors.toList());
        ArrayList<String> colors = (ArrayList<String>) SubObjModel_Vehicle.stream()
                .map(v -> v.getColor()).collect(Collectors.toList());
        
        cmbModel_Make = new DefaultComboBoxModel(makes.toArray());
        cmbModel_Model = new DefaultComboBoxModel(models.toArray());
        cmbModel_Year = new DefaultComboBoxModel(years.toArray());
        cmbModel_EColor = new DefaultComboBoxModel(colors.toArray());
        cmbModel_IColor = new DefaultComboBoxModel(colors.toArray());
        cmbModel_Status = new DefaultComboBoxModel(colors.toArray());
        
        pnl_VehicleAreaOp.getTxt_Stock().requestFocus();
        
        pnl_VehicleAreaOp.getBtn_Browse().addActionListener((e) ->{
            btn_BrowseActionListener(e);
        });
        
        pnl_VehicleAreaOp.getBtn_Save().addActionListener((e) -> {
            btn_SaveActionListener(e);
        });
    }
    
    private void btn_SaveActionListener(ActionEvent e)
    {
        int stock, year;
        String make, model, style, vin, eColor, iColor, miles, engine, image, status;
        float price;
        MainObj_Vehicle.Transmission transmission = MainObj_Vehicle.Transmission.AUTOMATIC;
        
        if(pnl_VehicleAreaOp.getTxt_Stock().getText().isEmpty())
        {
            return;
        }
        
        stock = Integer.parseInt(pnl_VehicleAreaOp.getTxt_Stock().getText());
        year = Integer.parseInt(pnl_VehicleAreaOp.getCmb_Year().getSelectedItem().toString());
        make = pnl_VehicleAreaOp.getCmb_Make().getSelectedItem().toString();
        model = pnl_VehicleAreaOp.getCmb_Model().getSelectedItem().toString();
        style = pnl_VehicleAreaOp.getTxt_Style().getText();
        vin = pnl_VehicleAreaOp.getFrmt_VIN().getText();
        eColor = pnl_VehicleAreaOp.getCmb_EColor().getSelectedItem().toString();
        iColor = pnl_VehicleAreaOp.getCmb_IColor().getSelectedItem().toString();
        miles = pnl_VehicleAreaOp.getSpn_Miles().getModel().getValue().toString();
        price = Float.parseFloat(pnl_VehicleAreaOp.getSpn_Price().getModel().getValue().toString());
        engine = pnl_VehicleAreaOp.getTxt_Engine().getText();
        image = pnl_VehicleAreaOp.getTxt_Image().getText();
        status = pnl_VehicleAreaOp.getCmb_Status().getSelectedItem().toString();
        transmission = pnl_VehicleAreaOp.getRbtn_Auto().isSelected() ?
                transmission : MainObj_Vehicle.Transmission.MANUAL;
        MainObj_Vehicle v = new MainObj_Vehicle(stock, year, make, model, style, vin, eColor, iColor, miles, price,
                engine, image, status);
        
        try {
            Jdaov.create(v);
            JOptionPane.showMessageDialog(null, "Vehicle saved successfully.", 
                    "Information message", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), 
                    "Error message", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Pnl_VehicleAreaOp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btn_BrowseActionListener(ActionEvent e)
    {
        fileChooser = new JFileChooser();
        
        int option = fileChooser.showOpenDialog(null);
        if(option == JFileChooser.CANCEL_OPTION){
            return;
        }
        
        File file = fileChooser.getSelectedFile();
        if(!file.exists()){
            JOptionPane.showMessageDialog(null, "Image does not exists", 
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        pnl_VehicleAreaOp.getTxt_Image().setText(file.getPath());        
    }
    
}
