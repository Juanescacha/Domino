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
        //Retorna true si el jugador 1 inicia , false si inicia el 2
        String ficha1 = Integer.toString( humano.manoJugador.get(0).getLado1()) + " - " + Integer.toString( humano.manoJugador.get(0).getLado2());
        String ficha2 = Integer.toString( humano2.manoJugador.get(0).getLado1()) + " - " + Integer.toString( humano2.manoJugador.get(0).getLado2());
        
        //imprimimos bonito que ficha saca jugador y cual empieza, esto pasarlo a la gui
        
        System.out.println("jugador1: " + ficha1);
        System.out.println("jugador2: " + ficha2);
        boolean inicia1;
        if(humano.manoJugador.get(0).mayor(humano2.manoJugador.get(0))){
            System.out.println("Inicia Jugador 1");
            inicia1 = true;
        }
        else {
            System.out.println("inicia jugador2");
            inicia1 = false;
        }
        
        //devolvemos las 2 fichas denuevo al maso
        nuevoMazo.agregarFicha(humano.removerFicha(0));
        nuevoMazo.agregarFicha(humano2.removerFicha(0));
        
        //repartimos las 7 fichas a cada jugador
        nuevoMazo.repartir(humano, 7); //reparte 7 dominos
        nuevoMazo.repartir(humano2, 7);
        
        
        
        
    }
}
