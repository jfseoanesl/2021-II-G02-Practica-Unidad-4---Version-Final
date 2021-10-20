/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import entidades.*;
import excepciones.*;
import logica.*;

/**
 *
 * @author jairo
 */
public class VistaConsola {
    
    private String menuOpciones[] = {"1. Rentar Vehiculo", "2. Devolver Vehiculo", "3. Salir"};
    private int opcionSeleccionada;
    private AgenciaRenta agencia;

    public VistaConsola() {
        this.agencia = new AgenciaRenta();
    }

    /**
     * @return the menuOpciones
     */
    public String[] getMenuOpciones() {
        return menuOpciones;
    }

    /**
     * @param menuOpciones the menuOpciones to set
     */
    public void setMenuOpciones(String[] menuOpciones) {
        this.menuOpciones = menuOpciones;
    }

    /**
     * @return the opcionSeleccionada
     */
    public int getOpcionSeleccionada() {
        return opcionSeleccionada;
    }

    /**
     * @param opcionSeleccionada the opcionSeleccionada to set
     */
    public void setOpcionSeleccionada(int opcionSeleccionada) {
        this.opcionSeleccionada = opcionSeleccionada;
    }

    /**
     * @return the agencia
     */
    public AgenciaRenta getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(AgenciaRenta agencia) {
        this.agencia = agencia;
    }
    
    public void runMenu(){
        do{
            this.menuOpciones();
            this.evaluarOpcion();
            
        }while(this.opcionSeleccionada!=3);
    }
    
    public void menuOpciones(){
            System.out.println("**** MENU OPCIONES - AGENCIA DE RENTA DE VEHICULOS ****");
            for(String item: this.menuOpciones){
                System.out.println(item);
            }
            System.out.println("");
            this.opcionSeleccionada = Lector.leerEntero("Selecciones una opcion: ");
            
    }
    
    public void evaluarOpcion(){
        switch(this.opcionSeleccionada){
            case 1: this.rentarVehiculo();break;
            case 2: this.devolverVehiculo();break;
            case 3: System.out.println("A Terminado la ejecucion de la aplicacion");break;
            default: System.out.println("La opcion seleccionada no esta disponible, intente nuevamente");
        }
    }
    
    public void rentarVehiculo(){
        System.out.println("*** 1. RENTA DE VEHICULO ****  ");
        try{
            
            Vehiculo v = this.leerVehiculo();
            this.agencia.agregarVehiculoRenta(v);
            System.out.println("Vehiculo Agregado a la lista de Rentados");
            
        }catch(EntidadException ee){
            System.out.println(ee.getMessage());
        } 
        catch(ExcepcionAccesoDatos ead){
            System.out.println(ead.getMessage());
        }
    }
    
    public void devolverVehiculo(){
         System.out.println("*** 2.DEVOLUCION DE VEHICULO ****  ");
         String placa = Lector.leerString("Placa del vehiculo: ");
         Vehiculo v = new Autobus();
         v.setPlaca(placa);
         try{
            
             Vehiculo devuelto = this.agencia.eliminarVehiculoDevolucion(v);
             System.out.println(devuelto.getDatosVehiculos());
            
         }catch(ExcepcionAccesoDatos ead){
             System.out.println(ead.getMessage());
         }   
    }
    
    public Vehiculo leerVehiculo() throws EntidadException{
        System.out.println("Datos del vehiculo: ");
        String placa = Lector.leerString("Placa: ");
        int tipo = Lector.leerEntero("Tipo Vehiculo [1->Autobus][*->Tractor]: ");
        Vehiculo v = null;
        switch(tipo){
            case 1:  int kmInicio = Lector.leerEntero("Km inicio: ");
                     int kmDevolucion = Lector.leerEntero("Km devolucion: ");
                     int precioKm = Lector.leerEntero("Precio x Km: ");
                     v = FabricaVehiculo.getVehiculo("Autobus", placa, kmInicio, kmDevolucion, precioKm, 0, 0);
                     break;
            default: int nDiasRenta = Lector.leerEntero("No dias renta: ");
                     int precioDia = Lector.leerEntero("Precio x dia: ");
                     v = FabricaVehiculo.getVehiculo("Tractor", placa, 0, 0, 0, nDiasRenta, precioDia);
                     
        }
        return v;
        
    }
    
}
