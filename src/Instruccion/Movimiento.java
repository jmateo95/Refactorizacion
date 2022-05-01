package Instruccion;

import Instruccion.*;
import Archivo.ManejadorArchivo;
import java.io.Serializable;
import java.util.Calendar;
import java.util.StringTokenizer;
import Tarjetas.TarjetaDeCredito;

public class Movimiento  extends Instruccion{
    String numeroDeTarjeta;
    String fecha;
    String tipoDeMovimiento;
    String descripcion;
    String establecimiento;
    double monto;

    
    public Movimiento(String linea){ 
        super(linea);
    }
    
    @Override
    public void evaluarLinea(){
        System.out.println("Aqui");
        llenarObject();
        TarjetaDeCredito tarjeta=ManejadorArchivo.getManejadorArchivo().leerTarjetaDeCredito("Tarjeta"+this.numeroDeTarjeta+".tacre");
        tarjeta.setCredito(tarjeta.getCreditoDeTarjeta()+this.monto);
        ManejadorArchivo.getManejadorArchivo().escribirArchivo("Tarjeta"+this.numeroDeTarjeta+".tacre", tarjeta);     //Actualizacion del objeto en el archivo
        Calendar tiempo=Calendar.getInstance();
        String nombreDelNuevoMovimiento="Movimiento"+String.valueOf(tiempo.getTimeInMillis())+".mvito";
        ManejadorArchivo.getManejadorArchivo().escribirArchivo(nombreDelNuevoMovimiento,this);
    }
    
    public void llenarObject(){
        StringTokenizer token = new StringTokenizer(getLinea(),",");
        String temp=token.nextToken().replace("(", ""); 
        this.numeroDeTarjeta=temp.replaceAll("MOVIMIENTO", "");
        this.fecha=token.nextToken().replaceAll("\"",""); 
        this.tipoDeMovimiento=(token.nextToken().replace("\"", ""));
        this.descripcion=(token.nextToken().replace("\"", ""));
        this.establecimiento=(token.nextToken().replace("\"", ""));
        this.monto=Double.parseDouble(token.nextToken().replaceAll("\"", "").replace(")", ""));
        
    }
}
