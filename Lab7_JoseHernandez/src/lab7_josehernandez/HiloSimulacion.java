/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_josehernandez;

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
        int destino;
        destino = (int) (parada2.getDistancia() / bus.getVelocidad());
        while (vive) {
            barra.setValue((int) (parada1.getDistancia() / bus.getVelocidad()));
            if (barra.getValue() == destino) {
                vive = false;
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
    }
    
}
