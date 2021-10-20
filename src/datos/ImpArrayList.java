/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.Vehiculo;
import excepciones.ExcepcionAccesoDatos;
import java.util.*;

/**
 *
 * @author jairo
 */
public class ImpArrayList implements IAlquilable {
    
    private List lista;

    public ImpArrayList() {
        this.lista = new ArrayList();
    }

    
    @Override
    public boolean agregarVehiculoRenta(Vehiculo v) throws ExcepcionAccesoDatos {
        return this.lista.add(v);
        
    }

    @Override
    public Vehiculo eliminarVehiculoDevuelto(Vehiculo v) throws ExcepcionAccesoDatos {
        
        Vehiculo eliminado = null;
        Iterator<Vehiculo> i = this.lista.iterator();
        while(i.hasNext()){
            Vehiculo proximo = i.next();
            if(proximo.getPlaca().equals(v.getPlaca())){
                eliminado = proximo;
                i.remove();
                return eliminado;
            }
        }
        throw new ExcepcionAccesoDatos("El Vehiculo de placa " + v.getPlaca() + "No se encuentra en la lista de rentados" );
    }

    @Override
    public int getTotalvehiculosAlquilados() throws ExcepcionAccesoDatos {
        return this.lista.size();
    }
    
}
