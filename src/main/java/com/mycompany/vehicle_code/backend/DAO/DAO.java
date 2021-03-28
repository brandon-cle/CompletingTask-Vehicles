/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vehicle_code.backend.DAO;

import java.io.IOException;
import java.util.Collection;        
/**
 *
 * @author Usuario
 * @param <T>
 */
//DATA ACCES OBJECT = DAO
//SE CREA ESTO PARA PODER TENER UN ACCESO ESPECIAL A TRAVÉS DE UNA TABLA; EXISTIENDO LA POSIBILIDAD DE ELIMINAR Y AGREGAR 
//O ACTUALIZAR. LE PRESENTAMOS LA IDEA O "CONCEPTO" A LA PC SOBRE LO QUE QUEREMOS HACER PRINCIPALMENTE
public interface DAO<T> {
    void create(T t) throws IOException;
    int update(T t) throws IOException;
    boolean delete(T t) throws IOException;
    Collection<T> getAll() throws IOException;
}
