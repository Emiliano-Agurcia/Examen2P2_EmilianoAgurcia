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
public class Empleado implements Serializable{
    String Nombre;
    int Edad;
    String ID;
    int CarrosReparados;

    public Empleado() {
    }

    public Empleado(String Nombre, int Edad, String ID, int CarrosReparados) {
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.ID = ID;
        this.CarrosReparados = CarrosReparados;
    }

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getEdad() {
        return Edad;
    }
    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public int getCarrosReparados() {
        return CarrosReparados;
    }
    public void setCarrosReparados(int CarrosReparados) {
        this.CarrosReparados = CarrosReparados;
    }

    @Override
    public String toString() {
        return "ID: "+ID+" Nombre: "+Nombre;
    }
}
