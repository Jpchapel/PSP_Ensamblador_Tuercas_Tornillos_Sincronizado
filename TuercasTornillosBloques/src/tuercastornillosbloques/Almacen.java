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
public class Almacen {

    private final int MAX_BLOQUES = 10;
    private final int MAX_TORNILLOS_TUERCAS = 10;

    private int bloque;
    private int tuerca;
    private int tornillo;

    public synchronized void almacenarBloque() throws InterruptedException {
        while (bloque == MAX_BLOQUES) {
            wait();
        }

        bloque++;
        notifyAll();
        imprimirEstado();
    }

    public synchronized void almacenarTuerca() throws InterruptedException {
        while(tuerca + tornillo >= MAX_TORNILLOS_TUERCAS ||
               (tuerca == MAX_TORNILLOS_TUERCAS - 1 && tornillo == 0)){
            wait();
        }
        
        tuerca++;
        notifyAll();
        imprimirEstado();
    }

    public synchronized void almacenarTornillo() throws InterruptedException {
        while(tuerca + tornillo == MAX_TORNILLOS_TUERCAS){
            wait();
        }
        
        tornillo++;
        notifyAll();
        imprimirEstado();
    }

    public synchronized void montarPieza() throws InterruptedException {
        while(tuerca == 0 || tornillo == 0 || bloque == 0){
            wait();
        }
        
        tuerca--;
        tornillo--;
        bloque--;
        
        notifyAll();
        
        System.out.println("Pieza ensamblada");
    }

    private void imprimirEstado() {
        System.out.println("Cubos: " + bloque + " - Tornillos: " + tornillo
          + " - Tuercas: " + tuerca);
    }

}
