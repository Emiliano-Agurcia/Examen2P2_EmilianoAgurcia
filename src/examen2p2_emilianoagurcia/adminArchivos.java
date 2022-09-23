/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2p2_emilianoagurcia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
}
