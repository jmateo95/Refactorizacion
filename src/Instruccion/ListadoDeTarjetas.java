package Instruccion;

import Archivo.ManejadorArchivo;
import Reportes.*;
import Tarjetas.TarjetaDeCredito;
import java.io.File;

public class ListadoDeTarjetas extends Instruccion{

    public ListadoDeTarjetas(String linea) {
        super(linea);
    }

    @Override
    public void evaluarLinea() {  
        File carpeta = new File(new File (".").getAbsolutePath ());
        File[] files = carpeta.listFiles((dir1, name) ->
        name.endsWith(".tacre"));
        ManejadorArchivo.getManejadorArchivo().EditarReporteHTML(encabezado());
        for(File i: files){
            TarjetaDeCredito tarjeta=ManejadorArchivo.getManejadorArchivo().leerTarjetaDeCredito(i.getPath());
            ManejadorArchivo.getManejadorArchivo().EditarReporteHTML(item(tarjeta));
        }
        ManejadorArchivo.getManejadorArchivo().EditarReporteHTML("</table>");
    }
    
    
    
    private String encabezado(){
        return 
                "<table style=\"border-collapse: collapse;\">\n"
                + "<h3>Listado de Tarjetas<h3>" +
                "	    <th style=\"border: 1px solid #000000;\">NUMERO DE TARJETA</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">LIMITE</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
                "           <th style=\"border: 1px solid #000000;\">FECHA</th>\n" +               
                "	    <th style=\"border: 1px solid #000000;\">ESTADO TARJETA</th>\n" +
                "	  </tr>";      
    }
    
    
    private String item( TarjetaDeCredito tarjeta){
        return 
                "         <tr>\n" +
                "	    <td style=\"border: 1px solid #000000;\">"+tarjeta.getNumeroDeTarjeta()+"</th>\n" +
                "	    <td style=\"border: 1px solid #000000;\">"+tarjeta.getTipoStr()+"</th>\n" +
                "	    <td style=\"border: 1px solid #000000;\">"+tarjeta.getLimite()+"</th>\n" +
                "	    <td style=\"border: 1px solid #000000;\">"+tarjeta.getnombreDelCliente()+"</th>\n" +
                "	    <td style=\"border: 1px solid #000000;\">"+tarjeta.getDireccionDelCliente()+"</th>\n" +
                "           <td style=\"border: 1px solid #000000;\">"+""+"</th>\n" +               
                "	    <td style=\"border: 1px solid #000000;\">"+tarjeta.getEstaActivaStr()+"</th>\n" +
                "	  </tr>";
    }
    
    
}
