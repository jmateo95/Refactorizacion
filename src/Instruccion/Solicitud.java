package Instruccion;
import Archivo.ManejadorArchivo;
import java.io.*;
import java.util.*;

public class Solicitud extends Instruccion{
    private int numeroDeSolicitud;
    private String fecha;
    private int tipo;
    private String nombre;
    private int salario;
    private String direccion;
    
    public Solicitud(String linea){
        super(linea);
        
    }

    public Solicitud() {
        super(null);
    }
    
    @Override
    public void evaluarLinea() {
        llenarObject();
        String nombreDeLaNuevaSolicitud="Solicitud"+this.numeroDeSolicitud+".sol";
        ManejadorArchivo.getManejadorArchivo().escribirArchivo(nombreDeLaNuevaSolicitud,this);
    }
    
    public void llenarObject(){
        StringTokenizer token = new StringTokenizer(getLinea(),","); 
        String temp=token.nextToken().replace("(", "");
        this.numeroDeSolicitud=Integer.parseInt(temp.replaceAll("SOLICITUD", ""));
        temp=token.nextToken(); 
        this.fecha=temp.replaceAll("\"","");
        this.tipo=Integer.valueOf(token.nextToken().replace("\"", ""));
        this.nombre=String.valueOf(token.nextToken().replaceAll("\"", ""));
        this.salario=Integer.valueOf(token.nextToken());
        this.direccion=token.nextToken().replaceAll("\"", "").replace(")", "");
    }
    
    
    
    
    public int getNumeroDeSolicitud(){
        return this.numeroDeSolicitud;
    }

    public int getTipo() {
        return tipo;
    }
    public String getTipoStr(){
        switch (tipo) {
            case 1:
                return "Nacional";
            case 2:
                return "Regional";  
            default:
                return "Internacional";
        }
    }

    public int getSalario() {
        return salario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
    
    public int calcularLimite(){
        return (int)(salario*0.6);
    }
    
}
