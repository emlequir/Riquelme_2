
package Interaccion;

import Objeto.Polera;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Erick
 */
public class Controlador {
    private ArrayList<Polera> poleras;
    private String[] texto;
    private String[] datos;
    
    /*
    Cpmstructor que ejecuta los metodos
    @Param ruta del archivo
    /*
    
    */
    public Controlador(String ruta){
        copiarTexto(ruta);
        agregarPoleras();
        mostrarPoleras();
        agregarObjeto(ruta);
        leerArchivo(ruta);
    }
    
    /*
    Separa las lineas del texto
    @Param ruta del archivo
    */
    
    public  void copiarTexto(String ruta) {
        try{          
            texto = new String[5];
            File file = new File (ruta);
            if (file.exists()){
                FileReader fl = new FileReader(ruta);
                BufferedReader br = new BufferedReader(fl);  
                while(br.readLine() != null){
                    for(int i = 0; i < 5; i++){
                        texto[i] = br.readLine();
                    }
                }
                
            }else{
                crearArchivo(ruta);
                copiarTexto(ruta);
            }
        }catch(IOException e){
            
        }
    }
    
    /*
    Agrega los objetos al array de polera
    */
    
    public void agregarPoleras(){
        poleras = new ArrayList();
        boolean estampado;
        for(int i=0;i<this.texto.length;i++){
            datos=texto[i].split(",");
            if(datos[2].equals("false")){
                estampado=false;
            }else{
                estampado=true;
            }
            this.poleras.add(new Polera(datos[1],datos[0],estampado));
        }
         
    }
    
    /*
    Muestra lo contenido en el array de poleras
    */
    
    public  void mostrarPoleras(){
        for(int i=0;i<this.poleras.size();i++){
            
            System.out.println("Polera:");
            System.out.println("Material: "+this.poleras.get(i).getMaterial());
            System.out.println("Talla: "+this.poleras.get(i).getTalla());
            this.poleras.get(i).printEstampado();
            System.out.println("");
            System.out.println("-----------------------------\n");
        }
    }
    
    /*
    Ingresa el objeto al archivo csv
    @Param Ruta del archivo
    */
    
    public static void agregarObjeto(String ruta){
    try {
            File file = new File(ruta);   
            if(file.exists()){
                FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
                BufferedWriter bw = new BufferedWriter(fw);                                        
                bw.newLine(); 
                bw.write("algodon,XL,false");  
                bw.close();
            }else{
                crearArchivo(ruta);
                agregarObjeto(ruta);
            }
        }catch (IOException e) {
        }
    }
    
    /*
    Lee el archivo especificado
    @Param Ruta del archivo
    @return En caso de que encuentre el archivo retorna el contenido del archivo y si no retorna "El archivo no ue encontrado"
    */
    
    public static String leerArchivo(String ruta){
        Path archivo = Paths.get(ruta);
            String texto = "";
            try {
                texto = new String(Files.readAllBytes(archivo));
                System.out.println(texto);
                return texto;
            } catch (IOException e) {
                texto="El archivo no fue encontrado";
                System.out.println(texto);
                return texto;
            }
    }
    
    /*
    Crea el archivo en caso de no estar
    @Param Ruta del archivo
    */
    
    public static void crearArchivo(String ruta ){
        File file = new File(ruta);
        try{
            file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);    
            String texto="material,talla,estampado\n"
                    +"polyester,S,false\n"
                    +"algodon,M,true\n"
                    +"spandex,XL,true\n"
                    +"algodon,L,false\n"
                    +"polyester,M,true";
            bw.write(texto);  
            bw.close();
        }catch(IOException e){
        }
        
    }

    
    
}
