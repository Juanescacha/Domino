/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import java.util.ArrayList;

/**
 *
 * @author Juan Esteban Camargo
 */
public class Tablero {
    
    private ArrayList<Ficha> dominos;
    private int ladoS , ladoI;
    
    //Crea un tablero vacio, con una lista vacia para almacenar todos los dominos en el tablero
    public Tablero() {
        dominos = new ArrayList<Ficha>();
    }
    
    //Regresa una lista de todos los dominos en la mesa
    public ArrayList<Ficha> getDominos() {
        return dominos;
    }
    
    public int getLadoS() {
        if(!estaVacio()) return ladoS;
        else return -1;
    }
    
    public int getLadoI() {
        if(!estaVacio()) return ladoI;
        else return -1;
    }
    
    public boolean estaVacio() {
        return dominos.isEmpty();
    }
    
    //retorna el numero de dominos actuales en la mesa
    public int numDomMesa() {
        return dominos.size();
    }
    
    //Agregar una Ficha en la parte superior del tablero
    public void agregarDominoS(Ficha x , boolean lado1) {
        dominos.add(0, x);
        
        // si el lado1 es verdadero, significa que el lado1 es el que emparejo, entonces el lado2 se convierte en el lado disponible del tablero
        if(lado1) {
            ladoS = x.getLado2();
        }
        else{
            ladoS = x.getLado1();
        }
    }
    
    
    public void agregarDominoI(Ficha x , boolean lado1) {
        //lo agregamos al final de la lista
        dominos.add(x);
        
        // si el lado1 es verdadero, significa que el lado1 es el que emparejo, entonces el lado2 se convierte en el lado disponible del tablero
        if(lado1) {
            ladoI = x.getLado2();
        }
        else{
            ladoI = x.getLado1();
        }
    }
    
    //Determina si un domino especifico esta en la mesa
    public boolean dominoEnMesa(Ficha x) {
        return dominos.contains(x);
    }
    
    //Retorna el numero de dominos en la mesa que tienen unas caracteristicas especificas
    public int numDeTipo(int tipo) {
        //Contador para llevar seguimiento de cuantos concuerdan
        int numDeTipo = 0;
        
        for ( Ficha x : dominos){
            if( (x.getLado1() == tipo) || (x.getLado2() == tipo) ) {
                numDeTipo++;
            }
        }
        
        return numDeTipo;
    }
}
