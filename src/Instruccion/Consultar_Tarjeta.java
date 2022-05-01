package Instruccion;

import Archivo.ManejadorArchivo;
import Instruccion.*;
import Tarjetas.TarjetaDeCredito;

public class Consultar_Tarjeta extends Instruccion{

    public Consultar_Tarjeta(String linea) {
        super(linea);
    }
    
    
    
    @Override
    public void evaluarLinea(){
        String numeroDeTarjeta;
        numeroDeTarjeta=getLinea().replaceAll("CONSULTAR_TARJETA","").replace("(","").replace(")","");
        TarjetaDeCredito tarjeta=ManejadorArchivo.getManejadorArchivo().leerTarjetaDeCredito("Tarjeta"+numeroDeTarjeta+".tacre");
        ManejadorArchivo.getManejadorArchivo().EditarReporteHTML(Reporte(tarjeta));
    }
    
    
    
    public String Reporte(TarjetaDeCredito tarjeta){
        return "<h3>Consulta de Tarjeta: " +tarjeta.getNumeroDeTarjeta() +"</h3>" +
            "	<table style=\"border-collapse: collapse;\">\n" +
            "	  <tr>\n" +
            "	    <th style=\"border: 1px solid #000000;\">NUMERO DE TARJETA</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">LIMITE</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">ESTADO TARJETA</th>\n" +
            "	  </tr>\n" +
            "	  <tr>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+tarjeta.getNumeroDeTarjeta()+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+tarjeta.getTipoStr()+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+tarjeta.getLimite()+".00"+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+tarjeta.getnombreDelCliente()+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+tarjeta.getDireccionDelCliente()+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+tarjeta.getEstaActivaStr()+"</td>\n" +
            "	  </tr>\n" +
            "	</table>";
    }
    
}
