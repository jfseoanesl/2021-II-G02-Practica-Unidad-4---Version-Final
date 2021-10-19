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
public class Tractor extends Vehiculo {
    private int nDiasRenta;
    private double precioPorDia;

    public Tractor() {
    }

    public Tractor(String placa, int nDiasRenta, double precioPorDia) {
        super(placa);
        if(nDiasRenta<0 || precioPorDia<0)
            throw new IllegalArgumentException("Los dias de renta, y el precio por dia no pueden ser negativos");
        
        this.nDiasRenta = nDiasRenta;
        this.precioPorDia = precioPorDia;
    }

    /**
     * @return the nDiasRenta
     */
    public int getnDiasRenta() {
        return nDiasRenta;
    }

    /**
     * @param nDiasRenta the nDiasRenta to set
     */
    public void setnDiasRenta(int nDiasRenta) {
        this.nDiasRenta = nDiasRenta;
    }

    /**
     * @return the precioPorDia
     */
    public double getPrecioPorDia() {
        return precioPorDia;
    }

    /**
     * @param precioPorDia the precioPorDia to set
     */
    public void setPrecioPorDia(double precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    
    @Override
    public double getImporteRenta() {
        return this.nDiasRenta * this.precioPorDia;
    }

    @Override
    public String getDatosTipoVehiculo() {
        return "No dias rentados: " + this.nDiasRenta + "\n" + 
               "Precio x dia: " + this.precioPorDia + "\n"  +
               "Importe de renta: " + this.getImporteRenta()+"\n";
    }
    
    
    
    
    
}
