/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_josehernandez;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author jrdjh
 */
public class adminBuses {

    private ArrayList<Autobus> listaAutobuses = new ArrayList();
    private File archivo = null;

    public adminBuses(String path) {
        archivo = new File(path);
    }

    public ArrayList<Autobus> getListaAutobuses() {
        return listaAutobuses;
    }

    public void setListaAutobuses(ArrayList<Autobus> listaAutobuses) {
        this.listaAutobuses = listaAutobuses;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "adminBuses{" + "listaAutobuses=" + listaAutobuses + ", archivo=" + archivo + '}';
    }

    public void SetAutobus(Autobus a) {
        this.listaAutobuses.add(a);
    }

    public void cargarArchivo() {
        try {
            listaAutobuses = new ArrayList();
            Autobus temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Autobus) objeto.readObject()) != null) {
                        listaAutobuses.add(temp);
                    }
                } catch (EOFException e) {
                }
                objeto.close();
                entrada.close();
            }
        } catch (Exception e) {
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Autobus t : listaAutobuses) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception e) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception e) {
            }
        }
    }

}
