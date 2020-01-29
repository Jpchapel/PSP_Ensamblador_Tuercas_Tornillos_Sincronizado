/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuercastornillosbloques;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joaquin Pereira Chapel
 */
public class Ensamblador extends Thread {

    private Almacen almacen;

    public Ensamblador(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (Math.random() * 50));

                almacen.montarPieza();
            } catch (InterruptedException ex) {
                Logger.getLogger(Tuerca.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
