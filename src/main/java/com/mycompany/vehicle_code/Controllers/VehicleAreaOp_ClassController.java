/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vehicle_code.Controllers;

import com.mycompany.vehicle_code.JPanels.Pnl_VehicleAreaOp;
import javax.swing.DefaultComboBoxModel;

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
}
