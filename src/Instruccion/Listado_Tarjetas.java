package Instruccion;

import Archivo.ManejadorArchivo;
import Instruccion.*;
import java.io.File;
import Tarjetas.TarjetaDeCredito;

public class Listado_Tarjetas  {
    
    String reporteHTML;
    public void evaluarLinea(String line){
        String numeroDeTarjeta;
        int tipoDeTarjeta;
        String tipo = null;
        int limite = 0;
        String nombre;
        String direccion;
        String fecha;
        boolean estado;
        String condicion;
        
        TarjetaDeCredito tarjeta = new TarjetaDeCredito();
        File carpeta = new File(new File (".").getAbsolutePath ());
        File[] files = carpeta.listFiles((dir1, name) ->
        name.endsWith(".tacre"));
        
        reporteHTML="<table style=\"border-collapse: collapse;\">\n"
                + "<h3>Listado de Tarjetas<h3>" +
"	    <th style=\"border: 1px solid #000000;\">NUMERO DE TARJETA</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">LIMITE</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
"	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
"           <th style=\"border: 1px solid #000000;\">FECHA</th>\n" +               
"	    <th style=\"border: 1px solid #000000;\">ESTADO TARJETA</th>\n" +
"	  </tr>";
        ManejadorArchivo.getManejadorArchivo().EditarReporteHTML(reporteHTML);
        for(File i: files){
        tarjeta=ManejadorArchivo.getManejadorArchivo().leerTarjetaDeCredito(i.getPath());
        numeroDeTarjeta=tarjeta.getNumeroDeTarjeta();
        tipoDeTarjeta=tarjeta.getTipo();
        if(tipoDeTarjeta==1){tipo="Nacional";limite=2000;}
        if(tipoDeTarjeta==2){tipo="Regional";limite=5000;}
        if(tipoDeTarjeta==3){tipo="Internacional";limite=12000;}
        nombre=tarjeta.getnombreDelCliente();
        direccion=tarjeta.getDireccionDelCliente();
        estado=tarjeta.getEstaActiva();
        if(estado){
            condicion="ACTIVA";
        }else{condicion="CANCELADA";}
        
        
        reporteHTML=
"         <tr>\n" +
"	    <td style=\"border: 1px solid #000000;\">"+numeroDeTarjeta+"</th>\n" +
"	    <td style=\"border: 1px solid #000000;\">"+tipo+"</th>\n" +
"	    <td style=\"border: 1px solid #000000;\">"+limite+"</th>\n" +
"	    <td style=\"border: 1px solid #000000;\">"+nombre+"</th>\n" +
"	    <td style=\"border: 1px solid #000000;\">"+direccion+"</th>\n" +
"           <td style=\"border: 1px solid #000000;\">"+""+"</th>\n" +               
"	    <td style=\"border: 1px solid #000000;\">"+condicion+"</th>\n" +
"	  </tr>";

        ManejadorArchivo.getManejadorArchivo().EditarReporteHTML(reporteHTML);
        }
        reporteHTML="</table>";
        ManejadorArchivo.getManejadorArchivo().EditarReporteHTML(reporteHTML);
        
    }
}
