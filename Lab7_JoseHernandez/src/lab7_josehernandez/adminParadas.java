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
public class adminParadas {

    private ArrayList<Parada> lista_paradas = new ArrayList();
    private File archivo = null;

    public adminParadas(String path) {
        archivo = new File(path);

    }

    public ArrayList<Parada> getLista_paradas() {
        return lista_paradas;
    }

    public void setLista_paradas(ArrayList<Parada> lista_paradas) {
        this.lista_paradas = lista_paradas;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setParada(Parada p) {
        this.lista_paradas.add(p);
    }

    @Override
    public String toString() {
        return "adminParadas{" + "lista_paradas=" + lista_paradas + ", archivo=" + archivo + '}';
    }

    public void cargarArchivo() {
        try {
            lista_paradas = new ArrayList();
            Parada temp;
            lista_paradas.add(new Parada("Unitec", 0, 0));
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Parada) objeto.readObject()) != null) {
                        lista_paradas.add(temp);
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
            for (Parada t : lista_paradas) {
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
