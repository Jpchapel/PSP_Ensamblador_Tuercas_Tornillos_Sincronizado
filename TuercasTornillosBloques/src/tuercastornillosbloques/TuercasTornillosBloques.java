/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tuercastornillosbloques;

/**
 *
 * @author Joaquin Pereira Chapel
 */
public class TuercasTornillosBloques {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        
        Bloque bloque = new Bloque(almacen);
        Tuerca tuerca = new Tuerca(almacen);
        Tornillo tornillo = new Tornillo(almacen);
        Ensamblador ensamblador = new Ensamblador(almacen);
        
        bloque.start();
        tuerca.start();
        tornillo.start();
        ensamblador.start();
    }
    
}
