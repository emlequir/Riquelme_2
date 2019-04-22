/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Interaccion.Controlador;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author licho
 */
public class ControladorTest {
    
   
     
    @Test
    public  void leerArchivoTest(){
        String esperado="material,talla,estampado\n"
                    +"polyester,S,false\n"
                    +"algodon,M,true\n"
                    +"spandex,XL,true\n"
                    +"algodon,L,false\n"
                    +"polyester,M,true";
        assertEquals(Controlador.leerArchivo("nose.csv"),"El archivo no fue encontrado");       
        assertEquals(Controlador.leerArchivo("listado.csv"),esperado);
    }
}
