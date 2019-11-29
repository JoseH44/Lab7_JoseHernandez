/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_josehernandez;

import java.io.Serializable;

/**
 *
 * @author jrdjh
 */
public class Estudiante implements Serializable {

    private String nombre;
    private int edad;
    private int numCuenta;
    private Parada parada;
    private static final long SerialVersionUID = 333L;

    public Estudiante() {
    }

    public Estudiante(String nombre, int edad, int numCuenta) {
        this.nombre = nombre;
        this.edad = edad;
        this.numCuenta = numCuenta;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Parada getParada() {
        return parada;
    }

    public void setParada(Parada parada) {
        this.parada = parada;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
