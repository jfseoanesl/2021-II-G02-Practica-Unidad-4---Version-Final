/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.*;
import excepciones.EntidadException;

/**
 *
 * @author jairo
 */
public class FabricaVehiculo {
    
    public static Vehiculo getVehiculo(String tipo, String placa, int kmInicioRenta, int kmDevolucion, double precioPorKm, int nDiasRenta, double precioPorDia) 
            throws EntidadException{
        Vehiculo v = null;
        try{
            switch(tipo){
                case "Autobus": v = new Autobus(placa, kmInicioRenta, kmDevolucion, precioPorKm);
                                break;
                case "Tractor": v = new Tractor(placa, nDiasRenta,precioPorDia);
            }
            return v;
        }catch(IllegalArgumentException ie){
            throw new EntidadException(ie.getMessage());
        }    
    }
}
