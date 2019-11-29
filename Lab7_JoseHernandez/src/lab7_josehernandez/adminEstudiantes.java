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
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author jrdjh
 */
public class adminEstudiantes {

    private ArrayList<Estudiante> lista_estudiantes = new ArrayList();
    private File archivo = null;

    public adminEstudiantes(String path) {
        this.archivo = new File(path);
    }

    public ArrayList<Estudiante> getLista_estudiantes() {
        return lista_estudiantes;
    }

    public void setLista_estudiantes(ArrayList<Estudiante> lista_estudiantes) {
        this.lista_estudiantes = lista_estudiantes;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "adminEstudiantes{" + "lista_estudiantes=" + lista_estudiantes + ", archivo=" + archivo + '}';
    }

    public void setEstudiante(Estudiante e) {
        this.lista_estudiantes.add(e);
    }

    public void cargarArchivo() {
        try {
            lista_estudiantes = new ArrayList();
            Estudiante temp;
            if (archivo.exists()) {
                FileInputStream entrada = new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Estudiante) objeto.readObject()) != null) {
                        lista_estudiantes.add(temp);
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
            for (Estudiante t : lista_estudiantes) {
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
