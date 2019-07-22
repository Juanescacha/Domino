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
public class Logica {
    
    private ArrayList<Jugador> listaJugadores;
    
    public Logica() {
        listaJugadores = new ArrayList<Jugador>();
    }
    
    public void jugar() {
        Tablero nuevoTablero = new Tablero();
        Mazo nuevoMazo = new Mazo();
        nuevoMazo.revolver();
        Jugador humano = new Jugador("Humano");
        Jugador humano2 = new Jugador("Humano2");
        listaJugadores.add(humano);
        listaJugadores.add(humano2);
        
        //Decidir quien inicia
        nuevoMazo.repartirFicha(humano);
        nuevoMazo.repartirFicha(humano2);
        humano.manoJugador.size();
        humano2.manoJugador.size();
        
        
        //nuevoMazo.repartir(humano, 7); //reparte 7 dominos
        //nuevoMazo.repartir(humano2, 7);
        
    }
}
