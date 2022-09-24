/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2p2_emilianoagurcia;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emili
 */
public class adminHilo extends Thread{
    Random rnd = new Random();
    JTable TB_Reaparaciones;
    ArrayList <Reparacion> ListaReparaciones = new ArrayList();
    boolean Exito;
    boolean Completado;

    public adminHilo(JTable TB_Reaparaciones, Empleado Empleado, Carro Carro, JProgressBar PB, ArrayList <Reparacion> ListaReparaciones) {
        this.TB_Reaparaciones = TB_Reaparaciones;
        this.Empleado = Empleado;
        this.Carro = Carro;
        this.PB = PB;
        this.ListaReparaciones = ListaReparaciones;
        
        this.Completado = false;
        this.PB.setMaximum((int)Carro.getCosto());
    }

    //Lo que controla
    Empleado Empleado;
    Carro Carro;
    JProgressBar PB;

    @Override
    public void run() {
        try {
            while (Completado == false) {
                PB.setValue(PB.getValue() + 1000);
                PB.setString("Reparando, espere un momento...");
                
                if (PB.getValue() >= PB.getMaximum()) {
                    int Chance = 0;
                    
                    //Chance de reparación
                    if (Empleado.getCarrosReparados() >= 1 && Empleado.getCarrosReparados() <= 5) {
                        Chance = 1 + rnd.nextInt(30);
                    } else if (Empleado.getCarrosReparados() >= 6 && Empleado.getCarrosReparados() <= 15) {
                        Chance = 1 + rnd.nextInt(22);
                    } else if (Empleado.getCarrosReparados() >= 16 && Empleado.getCarrosReparados() <= 30) {
                        Chance = 1 + rnd.nextInt(13);
                    } else if (Empleado.getCarrosReparados() > 30) {
                        Chance = 1 + rnd.nextInt(7);
                    }

                    //Si el chance esta entre 1 y 6, la reparación es exitosa
                    if (Chance >= 1 && Chance <= 6) {
                        Exito = true;
                    } else {
                        Exito = false;
                    }
                    PB.setString("¡Reparado!");

                    //Archivo de Texto
                    adminArchivos AD = new adminArchivos("./Reparaciones.emi");
                    AD.DownloadReparaciones();
                    ListaReparaciones.add(new Reparacion(Empleado, Carro, Exito));
                    AD.setListaReparaciones(ListaReparaciones);
                    AD.UploadReparaciones();
                    
                    //Tabla  
                    DefaultTableModel mTB = (DefaultTableModel) TB_Reaparaciones.getModel();
                    Object[] newRow = {
                        Empleado,
                        Carro,
                        Exito
                    };
                    mTB.addRow(newRow);
                    TB_Reaparaciones.setModel(mTB);
                    
                    
                    
                    Thread.sleep(2000);

                    PB.setString("Elija un reparador y un carro a reparar");
                    PB.setValue(0);
                    Completado = true;
                }
                
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
