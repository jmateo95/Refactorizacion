/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instruccion;

import java.io.Serializable;

/**
 *
 * @author joubm
 */
public abstract class Instruccion implements Serializable{
    private String linea;

    public Instruccion(String linea) {
        this.linea=linea;
    }
        
    public abstract void evaluarLinea();
    
    public String getLinea(){
        return linea;
    }
    
    
    
}
