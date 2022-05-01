package Tarjetas;

import java.io.Serializable;

public class TarjetaDeCredito implements Serializable{
    
    private String NumeroDeTarjeta;
    private int tipo;
    private int limite;
    private String nombreDelCliente;
    private String direccionDelCliente;
    private double credito;
    private boolean estaActiva;
    
    public TarjetaDeCredito( String NumeroDeTarjeta,int tipo,int limite,String nombreDelCliente,String direccionDelCliente,double credito,boolean estaActiva){
        this.NumeroDeTarjeta=NumeroDeTarjeta;
        this.tipo=tipo;
        this.limite=limite;
        this.nombreDelCliente=nombreDelCliente;
        this.direccionDelCliente=direccionDelCliente;
        this.credito=credito;
        this.estaActiva=estaActiva;
    }
    
    public TarjetaDeCredito()
    {}
    
    public void Desactivar(){
        estaActiva=(credito>0);
        if(estaActiva){
            System.out.println("No se puede cancelar la tarjeta ya que tiene credito pendiente. ");
        }else{
            System.out.println("La tarjeta fue cancelada. ");
        }
    }
    
    
    public String getNumeroDeTarjeta(){
        return this.NumeroDeTarjeta;
    }
    public int getTipo(){
        return this.tipo;
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
    
    public String getEstaActivaStr(){
        String Estado="No Activa";
        if(estaActiva){
            Estado="Activa";
        }
        return Estado;
    }
    
    
    public int getLimite(){
        return this.limite;
    }
    public String getnombreDelCliente(){
        return this.nombreDelCliente;
    }
    public String getDireccionDelCliente(){
        return this.direccionDelCliente;
    }
    public double getCreditoDeTarjeta(){
        return this.credito;
    }
    public boolean getEstaActiva(){
        return this.estaActiva;
    }
    public void setEstaActiva(boolean valor)
    {
        this.estaActiva = valor;
    }
    public void setCredito(double valor)
    {
        this.credito = valor;
    }
}
