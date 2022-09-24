/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2p2_emilianoagurcia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author emili
 */
public class adminArchivos {
    ArrayList <Empleado> ListaEmpleados = new ArrayList();
    ArrayList <Carro> ListaCarros = new ArrayList();
    ArrayList <Reparacion> ListaReparaciones = new ArrayList();                 //Bitácora
    File Archivo = null;

    public adminArchivos(String Path) {
        this.Archivo = new File(Path);
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return ListaEmpleados;
    }
    public void setListaEmpleados(ArrayList<Empleado> ListaEmpleados) {
        this.ListaEmpleados = ListaEmpleados;
    }

    public ArrayList<Carro> getListaCarros() {
        return ListaCarros;
    }
    public void setListaCarros(ArrayList<Carro> ListaCarros) {
        this.ListaCarros = ListaCarros;
    }

    public ArrayList<Reparacion> getListaReparaciones() {
        return ListaReparaciones;
    }
    public void setListaReparaciones(ArrayList<Reparacion> ListaReparaciones) {
        this.ListaReparaciones = ListaReparaciones;
    }
    
    public File getArchivo() {
        return Archivo;
    }
    public void setArchivo(File Archivo) {
        this.Archivo = Archivo;
    }
    
    public void DownloadEmpleados() throws FileNotFoundException, IOException{
        ListaEmpleados = new ArrayList();
        Empleado temporal;
        FileInputStream FR = null;
        ObjectInputStream BR = null;
        
        if(Archivo.exists()){
            FR = new FileInputStream(Archivo);
            BR = new ObjectInputStream(FR);
            
            try {
                while( ( temporal = (Empleado) BR.readObject() ) != null ){      //readObject
                    ListaEmpleados.add(temporal);
                }
            } catch (Exception e) {
            }
            
            FR.close();
            BR.close();
        }
    }
    public void UploadEmpleados(){
        FileOutputStream FW = null;
        ObjectOutputStream BW = null;
        
        try {
            FW = new FileOutputStream(Archivo);
            BW = new ObjectOutputStream(FW);
            
            for (Empleado t : ListaEmpleados) {
                BW.writeObject(t);                                              //writeObject
            }
            BW.flush();
            
        } catch (Exception e) {
        }
        
        try {
            FW.close();
            BW.close();
        } catch (Exception e) {
        }
    }
    
    public void DownloadCarros() throws FileNotFoundException, IOException{
        ListaCarros = new ArrayList();
        Carro temporal;
        FileInputStream FR = null;
        ObjectInputStream BR = null;
        
        if(Archivo.exists()){
            FR = new FileInputStream(Archivo);
            BR = new ObjectInputStream(FR);
            
            try {
                while( ( temporal = (Carro) BR.readObject() ) != null ){      //readObject
                    ListaCarros.add(temporal);
                }
            } catch (Exception e) {
            }
            
            FR.close();
            BR.close();
        }
    }
    public void UploadCarros(){
        FileOutputStream FW = null;
        ObjectOutputStream BW = null;
        
        try {
            FW = new FileOutputStream(Archivo);
            BW = new ObjectOutputStream(FW);
            
            for (Carro t : ListaCarros) {
                BW.writeObject(t);                                              //writeObject
            }
            BW.flush();
            
        } catch (Exception e) {
        }
        
        try {
            FW.close();
            BW.close();
        } catch (Exception e) {
        }
    }
    
    public void UploadReparaciones(){
        FileWriter FW = null;
        BufferedWriter BW = null;
        
        try {
            FW = new FileWriter(Archivo);
            BW = new BufferedWriter(FW);
            
            BW.write("|");
            if(!ListaReparaciones.isEmpty()){
                for (Reparacion temp : ListaReparaciones) {
                    //Empleado
                    BW.write(temp.getEmpleado().getNombre()+";");
                    BW.write(temp.getEmpleado().getEdad()+";");
                    BW.write(temp.getEmpleado().getID()+";");
                    BW.write(temp.getEmpleado().getCarrosReparados()+";");

                    //Carro
                    BW.write(temp.getCarro().getMarca()+";");
                    BW.write(temp.getCarro().getModelo()+";");
                    BW.write(temp.getCarro().getYearFabricado()+";");
                    BW.write(temp.getCarro().getEstado()+";");
                    BW.write(temp.getCarro().getCosto()+";");

                    //Exito
                    BW.write( String.valueOf(temp.isExito()) );

                    BW.write("|");
                }
            }else{
                BW.write("|");
            }
            BW.flush();
            
            FW.close();
            BW.close(); 
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
    }
    public void DownloadReparaciones(){
        FileReader FR = null;
        BufferedReader BR = null;
        ListaReparaciones = new ArrayList();
        String Linea = "";
        
        if(Archivo.exists()){
            try {
                FR = new FileReader(Archivo);
                BR = new BufferedReader(FR);    
                
                if( (Linea = BR.readLine()) != null){
                    String[] Reparaciones = Linea.split("|");  
                                                                                System.out.println(Linea);
                    
                    for (int i = 0; i < Reparaciones.length; i++) {
                        String[] Atributos = Reparaciones[i].split(";");

                        if(Atributos.length > 1){
                            Carro carro = new Carro();
                            Empleado empleado = new Empleado();
                            boolean exitoso = false;

                            //Empleado
                            empleado.setNombre                          (Atributos[0]);
                            empleado.setEdad           (Integer.parseInt(Atributos[1]));
                            empleado.setID                              (Atributos[2]);
                            empleado.setCarrosReparados(Integer.parseInt(Atributos[3]));

                            //Carro
                            carro.setMarca                              (Atributos[4]);
                            carro.setModelo                             (Atributos[5]);
                            carro.setYearFabricado     (Integer.parseInt(Atributos[6]));
                            carro.setEstado                             (Atributos[7]);
                            carro.setCosto             (Integer.parseInt(Atributos[8]));

                            //Exito
                            if(Atributos[9].contains("true")){
                                exitoso = true;
                            }

                            //Lista
                            Reparacion reparacion = new Reparacion(empleado, carro, exitoso);
                            ListaReparaciones.add(reparacion);    
                        }
                    }
                }
                FR.close();
                BR.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
