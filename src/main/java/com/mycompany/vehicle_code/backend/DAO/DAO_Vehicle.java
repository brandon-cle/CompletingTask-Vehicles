/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vehicle_code.backend.DAO;

import com.mycompany.vehicle_code.backend.pojo.MainObj_Vehicle;
import java.io.IOException;
import java.util.Collection;

/**
 *
 * @author Usuario
 */
//DE ESTA MANERA SE TENDRÁ (ESO PLANTÉA LA INTERFAZ) EL ACCESO A ESTE, POR ID O POR ESTADO.
public interface DAO_Vehicle extends DAO<MainObj_Vehicle>{
    
    MainObj_Vehicle fundById(int id) throws IOException;
    Collection<MainObj_Vehicle> findByStatus(String status) throws IOException;
}
