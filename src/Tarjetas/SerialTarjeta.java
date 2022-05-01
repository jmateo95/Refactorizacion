/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarjetas;

import Archivo.ManejadorArchivo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author joubm
 */
public class SerialTarjeta {
    private static SerialTarjeta serialTarjeta; 
    private SerialTarjeta() {} 
    public static SerialTarjeta getSerialTarjeta() { 
            if (serialTarjeta == null) {
                serialTarjeta = new SerialTarjeta();
            }
            return serialTarjeta;
    }
    
    public String CrearNumeroDeTarjeta(int limiteDeCredito, int tipo) throws Exception{
        String valorActual="";
        String NUMERO="";
        String RUTA="";
        if(tipo==1 & limiteDeCredito>=2000){
            NUMERO="4256-3102-6585-";
            RUTA="numeroNacionalCorriente.txt";
        }
        if(tipo==2 & limiteDeCredito>=5000){
            NUMERO="4256-3102-6590-";
            RUTA="numeroRegionalCorriente.txt";
        }
        if(tipo==3 & limiteDeCredito>=12000){
            NUMERO="4256-3102-6595-";
            RUTA="numeroInternacionalCorriente.txt";
        }
        valorActual=leerYAsingarNumeroEnArchivo(NUMERO, RUTA);
        System.out.println("Solicitud del tipo "+tipo+" aprovada con exito");
        return valorActual;
    }
    
    
    public String leerYAsingarNumeroEnArchivo(String NUMERO, String  RUTA) throws Exception{
        int FINNUMERO=ManejadorArchivo.getManejadorArchivo().leerSerialTarjeta(RUTA);
        String noTarjeta=(asingarNumeroTarjeta(NUMERO,FINNUMERO));
        FINNUMERO=FINNUMERO+1;
        ManejadorArchivo.getManejadorArchivo().actualizarSerialTarjeta(FINNUMERO, RUTA);
        return noTarjeta; //este retorno me regresa un valor con el formato de un numero como xxxx-xxxx-xxxx-xxxx
    }
    
    
    
    private String asingarNumeroTarjeta(String base,int valor){
        String numeroDeTarjeta = null;
        if(valor>=1 & valor<10){
            numeroDeTarjeta=base+"000"+valor;
        }
        if(valor>=10& valor<100){
            numeroDeTarjeta=base+"00"+valor;
        }
        if(valor>=100&valor<10000){
            numeroDeTarjeta=base+"0"+valor;
        }
    return numeroDeTarjeta; //ESTE RETORNO ES DEL FORMATO XXXX-XXXX-XXXX-XXXX
    }
    
}
