/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_josehernandez;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JProgressBar;
import javax.swing.JTable;

/**
 *
 * @author jrdjh
 */
public class HiloSimulacion extends Thread {

    private JProgressBar barra;
    private boolean vive;
    private boolean avanzar;
    private JTable tabla;
    private Autobus bus;
    private Parada parada1;
    private Parada parada2;

    public HiloSimulacion() {
    }

    public HiloSimulacion(JProgressBar barra, JTable tabla, Autobus b, Parada p1, Parada p2) {
        this.barra = barra;
        this.tabla = tabla;
        this.bus = b;
        this.parada1 = p1;
        this.parada2 = p2;
        vive = true;
        avanzar = true;
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }

    public boolean isAvanzar() {
        return avanzar;
    }

    public void setAvanzar(boolean avanzar) {
        this.avanzar = avanzar;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public Autobus getBus() {
        return bus;
    }

    public void setBus(Autobus bus) {
        this.bus = bus;
    }

    public Parada getParada1() {
        return parada1;
    }

    public void setParada1(Parada parada1) {
        this.parada1 = parada1;
    }

    public Parada getParada2() {
        return parada2;
    }

    public void setParada2(Parada parada2) {
        this.parada2 = parada2;
    }

    @Override
    public void run() {
        double distancia = dist(parada1.getCoordenadaX(), parada2.getCoordenadaX(), parada1.getCoordenadaY(), parada2.getCoordenadaY());
        while (vive) {
            barra.setValue(barra.getValue() + 1);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public double sacarMenor(ArrayList<Double> dist) {

        double distMenor = 0;
        Collections.sort(dist);
        distMenor = dist.get(0);
        return distMenor;
    }

    public double dist(double x1, double x2, double y1, double y2) {
        double dist = 0;
        double valorX;
        double valorY;
        valorX = Math.pow(x2 - x1, 2);
        valorY = Math.pow(y2 - y1, 2);
        dist = Math.sqrt(valorX + valorY);
        return dist;
    }

}
