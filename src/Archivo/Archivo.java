package Archivo;
import Archivo.ManejadorArchivo;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import Instruccion.*;

public class Archivo implements Serializable{
    private String path;
    private  ArrayList<Instruccion> instrucciones = new ArrayList<Instruccion>();


    public Archivo(String path){
        this.path=path;
        llenarArray();
    }
    
    //Crear nuestro Objeto con su lista  de instrucciones
    private void llenarArray(){
        //Leemos  el archivo 
        try (Scanner archivoDeEntrada = new Scanner(new FileReader(path))) {
            while (archivoDeEntrada.hasNextLine()){
                //Leemos la linea y la añadimos a la instruccion
                instrucciones.add(ManejadorInstruccion.getManejadorArchivo().getInstruccion(archivoDeEntrada.nextLine()));
            }
        }
        //De lo contrario mostramos un error
        catch (FileNotFoundException e){ 
            System.out.println("Error: " + e.getMessage());
        }
    }

    
public void Ejecutar_archivo(){
    //Leemos instruccion por  instruccion
    for (Instruccion instruccion : instrucciones){
        System.out.println(instruccion.getLinea());
        instruccion.evaluarLinea();
    }
}
}
