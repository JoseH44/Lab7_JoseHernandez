/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_josehernandez;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author jrdjh
 */
public class Autobus {

    private int numID;
    private String placa;
    private Color color;
    private double velocidad;
    private ArrayList<Estudiante> estudiantes = new ArrayList();

    public Autobus() {
    }

    public Autobus(int numID, String placa, Color color, double velocidad) {
        this.numID = numID;
        this.placa = placa;
        this.color = color;
        this.velocidad = velocidad;
    }

    public int getNumID() {
        return numID;
    }

    public void setNumID(int numID) {
        this.numID = numID;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Autobus{" + "numID=" + numID + ", placa=" + placa + ", color=" + color + ", velocidad=" + velocidad + ", estudiantes=" + estudiantes + '}';
    }

}
