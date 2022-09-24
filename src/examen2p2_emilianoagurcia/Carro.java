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
public class Carro implements Serializable{
    String Marca;
    String Modelo;
    int YearFabricado;
    String Estado;
    double Costo;

    public Carro() {
    }

    public Carro(String Marca, String Modelo, int YearFabricado, String Estado, double Costo) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.YearFabricado = YearFabricado;
        this.Estado = Estado;
        this.Costo = Costo;
    }

    public String getMarca() {
        return Marca;
    }
    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }
    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getYearFabricado() {
        return YearFabricado;
    }
    public void setYearFabricado(int YearFabricado) {
        this.YearFabricado = YearFabricado;
    }

    public String getEstado() {
        return Estado;
    }
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public double getCosto() {
        return Costo;
    }
    public void setCosto(double Costo) {
        this.Costo = Costo;
    }

    @Override
    public String toString() {
        return Marca+" "+Modelo+" "+YearFabricado;
    }
}
