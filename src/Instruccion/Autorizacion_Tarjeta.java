package Instruccion;

import Instruccion.*;
import Archivo.ManejadorArchivo;
import Tarjetas.SerialTarjeta;
import Tarjetas.TarjetaDeCredito;


public class Autorizacion_Tarjeta extends Instruccion {
    public Autorizacion_Tarjeta() {
        super(null);
    }
    
    public Autorizacion_Tarjeta(String linea) {
        super(linea);
    }
        
        
    @Override
    public void evaluarLinea() {
        try{
            int numeroDeSolicitud=Integer.valueOf(getLinea().replaceAll("AUTORIZACION_TARJETA", "").replace("(", "").replace(")", ""));
            String nombreDelArchivo="Solicitud"+numeroDeSolicitud+".sol";
            Solicitud solicitudActual=ManejadorArchivo.getManejadorArchivo().leerSolicitud(nombreDelArchivo);
            CreateObject(solicitudActual);
        }
        catch(Exception e){
            System.out.println(e.getMessage()+"No puede autorizar una solicitud que no exista");
        }
    }
    
    
    private void CreateObject(Solicitud solicitud) throws Exception{
        String numeroDeSiguienteTarjeta=SerialTarjeta.getSerialTarjeta().CrearNumeroDeTarjeta(solicitud.calcularLimite(),solicitud.getTipo());

        if(numeroDeSiguienteTarjeta==null){
                System.out.println("No se pudo autorizar su tarjeta, porque no cumple con los requisitos.");
        }else{
            TarjetaDeCredito tarjeta = new TarjetaDeCredito(numeroDeSiguienteTarjeta,solicitud.getTipo(), solicitud.calcularLimite(),
                                                            solicitud.getNombre(), solicitud.getDireccion(), 0, true);
            String nombreDelArchivoTarjeta="Tarjeta"+numeroDeSiguienteTarjeta+".tacre";
            ManejadorArchivo.getManejadorArchivo().escribirArchivo(nombreDelArchivoTarjeta, tarjeta);
        }      
        
    }

}
