package Instruccion;

import Reportes.*;

public class EstadoDeCuenta extends Instruccion{

    public EstadoDeCuenta(String linea) {
        super(linea);
    }

    @Override
    public void evaluarLinea() {
        System.err.println("No se implemento esto");
    }
}
