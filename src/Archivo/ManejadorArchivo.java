/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivo;

import Instruccion.Solicitud;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Tarjetas.TarjetaDeCredito;
import java.io.DataInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author joubm
 */

//Clase para el manejo de Archivos Binarios
public class ManejadorArchivo {
   private static ManejadorArchivo manejadorArchivo; 
    private ManejadorArchivo() {} 
    public static ManejadorArchivo getManejadorArchivo() { 
            if (manejadorArchivo == null) {
                manejadorArchivo = new ManejadorArchivo();
            }
            return manejadorArchivo;
    }

    //Aqui puedo editar un archivo binario
    public void escribirArchivo(String nombreArchivo,Object cuerpoArchivo){
        try{
        ObjectOutputStream fileOut = new ObjectOutputStream(                                   
            new FileOutputStream(nombreArchivo));                            
            fileOut.writeObject(cuerpoArchivo);                               
            fileOut.close();                                                    
        } 
        catch (IOException e){                                              
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    //Aqui puedo crear un nuevo archivo binario
    public void crearArchivo(String nombre){
        try{
            DataOutputStream fileOut = new DataOutputStream(                                   
            new FileOutputStream(nombre));                                      
            fileOut.writeInt(1);
            fileOut.close();                                                    
        } 
        catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    //Aqui puedo leer un archivo de tarjetas
    public TarjetaDeCredito leerTarjetaDeCredito(String archivoEntrante){
        ObjectInputStream fileIn;
        TarjetaDeCredito tarjeta=null;
        try{
            fileIn = new ObjectInputStream(
            new FileInputStream(archivoEntrante));
            tarjeta = (TarjetaDeCredito) fileIn.readObject();                        
            fileIn.close();
        }
        catch (Exception e){
            System.err.println("No se encontro el archivo");
        }        
        return tarjeta;
    }

    
    //Aqui puedo leer un archivo de solicitud
    public Solicitud leerSolicitud(String archivoEntrante){
        ObjectInputStream fileIn;
        Solicitud solicitud=null;
        try{
            fileIn = new ObjectInputStream(
            new FileInputStream(archivoEntrante));
            solicitud = (Solicitud) fileIn.readObject();                       
            fileIn.close();
        }
        catch (Exception e){
            System.err.println("No se encontro el archivo");
        }
        
        return solicitud;
    }
    
    //Aqui puedo crear o editar un archivo HTML
    public void EditarReporteHTML(String textoEntrante){
        File archivo = new File("Reportes.html");
        try {
                FileOutputStream salida = new FileOutputStream(archivo,true);
                salida.write(textoEntrante.getBytes());
                salida.close();
        } catch (IOException ex) {
                System.out.println(ex.getMessage()+" no se pudo gravar el texto");
        }
    } 
    
    //Aqui Busco un numero de tarjeta
    public int leerSerialTarjeta(String RUTA) throws Exception{
        DataInputStream fileIn =new DataInputStream(new FileInputStream(RUTA));
        return (Integer) fileIn.readInt();
    }
    
    //Aqui lo actualizo
    public void actualizarSerialTarjeta(int numero, String RUTA) throws Exception{
        DataOutputStream fileOut;
        fileOut =new DataOutputStream(new FileOutputStream(RUTA, false));
        fileOut.writeInt(numero);
        
    }
            
    
}