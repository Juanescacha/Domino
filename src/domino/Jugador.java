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
public class Jugador {
    
    private String nombre;
    private int id;
    ArrayList<Ficha> manoJugador;
    private static int numDeJugadores;
    
    public Jugador(String x) {
        numDeJugadores++;
        
        nombre = x;
        id = numDeJugadores;
        
        //Empieza con mano vacia
        manoJugador = new ArrayList<Ficha>();
    }
    
    public static int getNumJugadores() {
        return numDeJugadores;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public int getId() {
        return id;
    }
    
    public ArrayList<Ficha> getMano() {
        return manoJugador;
    }
    
    public int numDeFichasEnMano() {
        return manoJugador.size();
    }
    
    public boolean manoVacia() {
        return manoJugador.isEmpty();
    }
    
    public void agregarFicha(Ficha x) {
        manoJugador.add(x);
    }
    
    public Ficha removerFicha(int i){
        // obtiene el domino a remover
        Ficha domino = manoJugador.get(i);
        
        // remueve el domino de la mano
        manoJugador.remove(i);
        
        //regresa ese domino
        return domino;
    }
    
    //determina si el jugador tiene un domino especifico en su mano
    // true si el jugador tiene el domino
    public boolean tieneFichaEnMano(Ficha x) {
        return manoJugador.contains(x);
    }
    
    //Retorna si el jugador tiene un domino en su mano que puede ser jugado en la mesa
    public boolean tieneJuego(int lado) {
        
        for(Ficha x : manoJugador) {
            //el lado del domino entero es igual con el lado 1 o 2 del domino en la mano
            if( (lado == x.getLado1()) || (lado == x.getLado2()) ) {
                return true;
            }
        }
        //Reviso la mano completa y no hay coincidencias
        return false;
    }
    
    //retorna el valor total de todos los dominos en la mano del jugador
    public int valorDeMano() {
        int total = 0;
        
        for(Ficha x : manoJugador) {
            total = total + x.getTotal();
        }
        
        return total;
    }   
    
}
