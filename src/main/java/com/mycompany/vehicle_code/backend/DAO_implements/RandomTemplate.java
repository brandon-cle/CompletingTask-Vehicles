/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vehicle_code.backend.DAO_implements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Usuario
 */
/*
¨TEMPLATE:  is a file that serves as a starting point for a new document

When you open a template, it is pre-formatted in some way. 
For example, you might use template in Microsoft Word that is formatted as a business letter.
*/

//PRESENTAR UN CONCEPTO
//AQUÍ SE HABLA SOBRE QUE NECERSITAMOS PARA NUESTRO CAJÓN DE INFORMACIÓN PARA CADA VEHÍCULO UNA
//CABECERA Y SU SECCIÓN DE INFORMACIÓN; ASÍ SE HABRÁ EN QUÉ "GABETA" ESTÁ.
abstract class RandomTemplate {
    private File file_Head; //CABEZERA
    private File file_Data; //INFORMACIÓN
    private CustomRandom customRandom;

    //CREANDO SU CONSTRUCTOR DE INFORMACIÓN:
    public RandomTemplate(File file_Head, File file_Data) {
        this.file_Head = file_Head;
        this.file_Data = file_Data;
    }
    
    //NECESITAMOS POR PARTE DE CUSTOM_RANDOM PARA DESIGNAR UN LUGAR DE ESTO
    //...
    
    protected CustomRandom getCustomRandom() throws FileNotFoundException, IOException{
        if (customRandom == null){
            customRandom = new CustomRandom(file_Head, file_Data);
            return customRandom;
        }
        
        return customRandom;
    }
    
    protected void close() throws IOException
    {
        customRandom.close();
        customRandom = null;
    }
}
