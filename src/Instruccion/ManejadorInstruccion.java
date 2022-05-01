/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instruccion;

import Archivo.ManejadorArchivo;



/**
 *
 * @author joubm
 */
public class ManejadorInstruccion {
    private static ManejadorInstruccion manejadorInstruccion; 
    private ManejadorInstruccion() {} 
    public static ManejadorInstruccion getManejadorArchivo() { 
            if (manejadorInstruccion == null) {
                    manejadorInstruccion = new ManejadorInstruccion();
                    ManejadorArchivo.getManejadorArchivo().crearArchivo("numeroNacionalCorriente.txt");
                    ManejadorArchivo.getManejadorArchivo().crearArchivo("numeroRegionalCorriente.txt");
                    ManejadorArchivo.getManejadorArchivo().crearArchivo("numeroInternacionalCorriente.txt");
            }
            return manejadorInstruccion;
    }
    
   
       
    public Instruccion getInstruccion(String linea){
        if(linea.startsWith("SOLICITUD"))                   return new Solicitud(linea);
        else if(linea.startsWith("MOVIMIENTO"))             return new Movimiento(linea);
        else if(linea.startsWith("AUTORIZACION_TARJETA"))   return new Autorizacion_Tarjeta(linea);
        else if(linea.startsWith("CANCELACION_TARJETA"))    return new Cancelacion_Tarjeta(linea);
        else if(linea.startsWith("CONSULTAR_TARJETA"))      return new Consultar_Tarjeta(linea);
        else if(linea.startsWith("ESTADO_CUENTA"))          return new EstadoDeCuenta(linea);
        else if(linea.startsWith("LISTADO_TARJETAS"))       return new ListadoDeTarjetas(linea);
        else if (linea.startsWith("LISTADO_SOLICITUDES"))   return new ListadoDeSolicitudes(linea);
        else return null;
    }
    
}
