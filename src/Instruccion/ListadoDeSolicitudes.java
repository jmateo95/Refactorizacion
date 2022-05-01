package Instruccion;

import Archivo.ManejadorArchivo;
import Reportes.*;
import java.io.File;

public class ListadoDeSolicitudes extends Instruccion{

    public ListadoDeSolicitudes(String linea) {
        super(linea);
    }

    @Override
    public void evaluarLinea(){
        File carpeta = new File(new File (".").getAbsolutePath ());
        File[] files = carpeta.listFiles((dir1, name) ->
        name.endsWith(".sol"));
        ManejadorArchivo.getManejadorArchivo().EditarReporteHTML(encabezado());
        for(File i: files){
            Solicitud solicitud=ManejadorArchivo.getManejadorArchivo().leerSolicitud(i.getPath());
            ManejadorArchivo.getManejadorArchivo().EditarReporteHTML(item(solicitud));
        }
        
        ManejadorArchivo.getManejadorArchivo().EditarReporteHTML("</table>"); 
    }
    
    private String encabezado(){
        return 
                "<table style=\"border-collapse: collapse;\">\n"
                + "<h3>Listado de Tarjetas<h3>" +
                "	  <tr>\n" +
                "	    <th style=\"border: 1px solid #000000;\">NUMERO DE SOLICITUD</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">FECHA DE SOLICITUD</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">SALARIO</th>\n" +
                "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
                "           <th style=\"border: 1px solid #000000;\">FECHA APROV/RECH</th>\n" +               
                "	    <th style=\"border: 1px solid #000000;\">ESTADO SOLICITUD</th>\n" +
                "	  </tr>";        
    }
    
    
    private String item( Solicitud solicitud){
        return 
                "         <tr>\n" +
                "	    <td style=\"border: 1px solid #000000;\">"+solicitud.getNumeroDeSolicitud()+"</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">"+null+"</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">"+solicitud.getTipoStr()+"</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">"+solicitud.getTipoStr()+"</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">"+0+"</td>\n" +
                "	    <td style=\"border: 1px solid #000000;\">"+solicitud.getDireccion()+"</td>\n" +
                "           <td style=\"border: 1px solid #000000;\">"+""+"</td>\n" +               
                "	    <td style=\"border: 1px solid #000000;\">"+""+"</td>\n" +
                "	  </tr>";
    }
    
    
    
}
