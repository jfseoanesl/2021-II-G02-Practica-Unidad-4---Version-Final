/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author jairo
 */
public abstract class Vehiculo {
    private String placa;
    
    public abstract double getImporteRenta();
    public abstract String getDatosTipoVehiculo();
    
    public String getDatosVehiculos(){
        
        return "Placa: " + this.getPlaca()+ "\n" + this.getDatosTipoVehiculo();
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    public Vehiculo(String placa) {
        
        if(placa==null || placa.length()==0 || placa.equals(""))
            throw new IllegalArgumentException("La placa requiere un valor adecuado");
       
        this.placa = placa;
    }

    public Vehiculo() {
    }
    

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
}
