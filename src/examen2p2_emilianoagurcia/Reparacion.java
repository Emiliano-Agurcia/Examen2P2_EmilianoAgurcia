/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2p2_emilianoagurcia;

import java.io.Serializable;

/**
 *
 * @author emili
 */
public class Reparacion implements Serializable{
    Empleado Empleado;
    Carro Carro;
    boolean Exito;

    public Reparacion(Empleado Empleado, Carro Carro, boolean Exito) {
        this.Empleado = Empleado;
        this.Carro = Carro;
        this.Exito = Exito;
    }

    public Empleado getEmpleado() {
        return Empleado;
    }
    public void setEmpleado(Empleado Empleado) {
        this.Empleado = Empleado;
    }

    public Carro getCarro() {
        return Carro;
    }
    public void setCarro(Carro Carro) {
        this.Carro = Carro;
    }

    public boolean isExito() {
        return Exito;
    }
    public void setExito(boolean Exito) {
        this.Exito = Exito;
    }
    
}
