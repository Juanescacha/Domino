/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Juan Esteban Camargo
 */
public class Mazo {
    
    // Creamos el arreglo dinamico donde estara toda la baraja
    private ArrayList<Ficha> mazo = new ArrayList<Ficha>();
    private int tamanoO; //tamano del mazo inicial
    
    public Mazo() {
        // Ciclo para crear los 28 dominos
        for (int i = 0; i <= 10; i++) {
            for (int j = i; j <= 6; j++) {
                mazo.add(new Ficha(i, j));
            }
        }
        tamanoO = mazo.size();
    }
    
    public void agregarFicha(Ficha x) {
        mazo.add(x);
    }
    
    // Retorna la lista de todos los dominos actuales en el mazo
    public ArrayList<Ficha> getFichas() {
        return mazo;
    }
    
    public void revolver() {
        Collections.shuffle(mazo);
    }
    
    public int mazoTamano() {
        return mazo.size();
    }
    
    public int mazoTamanoO() {
        return tamanoO;
    }
    
    public void repartir(Jugador jugador , int numRepartir) {
        for (int i = 0; i < numRepartir; i++) {
            // Toma el primer Domino del paquete y lo pone en la mano del jugador
            jugador.agregarFicha(mazo.remove(0));
        }
    }
    
    public void repartirFicha(Jugador jugador) {
        this.revolver();
        jugador.agregarFicha(mazo.remove(0));
    }
    
   
}
