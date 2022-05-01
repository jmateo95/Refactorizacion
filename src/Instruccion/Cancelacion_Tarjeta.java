package Instruccion;

import Archivo.ManejadorArchivo;
import Tarjetas.TarjetaDeCredito;

public class Cancelacion_Tarjeta  extends Instruccion{

    public Cancelacion_Tarjeta(String linea) {
        super(linea);
    }
   
    @Override
    public void evaluarLinea(){
        try{
            String numeroDeTarjeta=getLinea().replaceAll("CANCELACION_TARJETA","").replace("(", "").replace(")", "");
            String nombreDelArchivo="Tarjeta"+numeroDeTarjeta+".tacre";
            TarjetaDeCredito tarjeta = ManejadorArchivo.getManejadorArchivo().leerTarjetaDeCredito(nombreDelArchivo);
            tarjeta.Desactivar();
        }
        catch(NullPointerException e){
            System.out.println("No puede autorizar solicitudes que no existan ");
        }
    }
    
}
