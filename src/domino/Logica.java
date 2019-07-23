/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Esteban Camargo
 */
public class Logica {
    
    private ArrayList<Jugador> listaJugadores;
    boolean turnoJugador1 = true;
    boolean gameOver = false;
    boolean paso1 = false;
    boolean paso2 = false;
    
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
        
        if(humano.manoJugador.get(0).mayor(humano2.manoJugador.get(0))){
            System.out.println("Inicia Jugador 1");
            turnoJugador1 = true;
        }
        else {
            System.out.println("inicia jugador2");
            turnoJugador1 = false;
        }
        
        //devolvemos las 2 fichas denuevo al maso
        nuevoMazo.agregarFicha(humano.removerFicha(0));
        nuevoMazo.agregarFicha(humano2.removerFicha(0));
        
        //repartimos las 7 fichas a cada jugador
        nuevoMazo.repartir(humano, 7); //reparte 7 dominos
        nuevoMazo.repartir(humano2, 7);
        
        //agrega la primera ficha para empezar el juego
        nuevoTablero.agregarPrimeraFicha(nuevoMazo.getFicha());
        System.out.println("Primera Ficha: " + nuevoTablero.getLadoI() + " | " + nuevoTablero.getLadoS());
             
        while (!gameOver) {            
            if(turnoJugador1) {
                paso1 = false;
                if(humano.tieneJuego(nuevoTablero.getLadoI()) || humano.tieneJuego(nuevoTablero.getLadoS())) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    
                    System.out.println("Turno Jugador 1 \n");
                    System.out.println("puedes jugar , elije una ficha, si te equivocas pierdes el turno ");
                    System.out.println("Extremo Izquierdo " + nuevoTablero.getLadoI() + " Extremo Derecho " + nuevoTablero.getLadoS() );
                    //mostramos cartas
                    humano.aString();
                    String x = JOptionPane.showInputDialog("elije la posicion de una Ficha");
                    //lado 1
                    if(humano.manoJugador.get(Integer.parseInt(x)).getLado1() == nuevoTablero.getLadoI()) {
                        nuevoTablero.agregarDominoI(humano.removerFicha(Integer.parseInt(x)), true);
                    }
                    //lado 2
                    else if(humano.manoJugador.get(Integer.parseInt(x)).getLado1() == nuevoTablero.getLadoS()) {
                        nuevoTablero.agregarDominoS(humano.removerFicha(Integer.parseInt(x)), true);
                    }
                    
                    else if(humano.manoJugador.get(Integer.parseInt(x)).getLado2() == nuevoTablero.getLadoI()) {
                        nuevoTablero.agregarDominoI(humano.removerFicha(Integer.parseInt(x)), false);
                    }
                    //lado 2
                    else if(humano.manoJugador.get(Integer.parseInt(x)).getLado2()== nuevoTablero.getLadoS()) {
                        nuevoTablero.agregarDominoS(humano.removerFicha(Integer.parseInt(x)), false);
                    }
                    if(humano.manoVacia()) {
                        System.out.println("gano Jugador 1");
                        gameOver = true;
                    }
                    
                }
                
                else {
                    System.out.println("No puedes hacer nada pasas");
                    paso1 = true;
                    if(paso2 == true) {
                        System.out.println("Empate");
                        gameOver = true;
                    }
                }
                //ahora el jugador elije una carta y la pone
                
                //fin turno1
                turnos();
            }
            else if(!turnoJugador1) {
                paso2 = false;
                if(humano2.tieneJuego(nuevoTablero.getLadoI()) || humano2.tieneJuego(nuevoTablero.getLadoS())) {
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    
                    System.out.println("Turno Jugador 2 \n");
                    System.out.println("puedes jugar , elije una ficha, si te equivocas pierdes el turno ");
                    System.out.println("Extremo Izquierdo " + nuevoTablero.getLadoI() + " Extremo Derecho " + nuevoTablero.getLadoS() );
                    //le mostramos las cartas
                    humano2.aString();
                    String x = JOptionPane.showInputDialog("elije la posicion de una Ficha");
                    //lado 1
                    if(humano2.manoJugador.get(Integer.parseInt(x)).getLado1() == nuevoTablero.getLadoI()) {
                        nuevoTablero.agregarDominoI(humano2.removerFicha(Integer.parseInt(x)), true);
                    }
                    //lado 2
                    else if(humano2.manoJugador.get(Integer.parseInt(x)).getLado1() == nuevoTablero.getLadoS()) {
                        nuevoTablero.agregarDominoS(humano2.removerFicha(Integer.parseInt(x)), true);
                    }
                    
                    else if(humano2.manoJugador.get(Integer.parseInt(x)).getLado2() == nuevoTablero.getLadoI()) {
                        nuevoTablero.agregarDominoI(humano2.removerFicha(Integer.parseInt(x)), false);
                    }
                    //lado 2
                    else if(humano2.manoJugador.get(Integer.parseInt(x)).getLado2()== nuevoTablero.getLadoS()) {
                        nuevoTablero.agregarDominoS(humano2.removerFicha(Integer.parseInt(x)), false);
                    }
                    if(humano2.manoVacia()) {
                        System.out.println("gano Jugador 2");
                        gameOver = true;
                    }
                    
                }
                
                else {
                    System.out.println("No puedes hacer nada, pasas!");
                    paso2 = true;
                    if(paso1 = true) {
                        System.out.println("Empate");
                        gameOver = true;
                    }
                }
                
                // fin turno2
                turnos();
            }
            
            if(humano.manoVacia()) {
                System.out.println("gano Jugador 1");
                gameOver = true;
            }
            if(humano2.manoVacia()) {
                System.out.println("gano Jugador 2");
                gameOver = true;
            }
        }
        
    }
    
    public void turnos() {
        turnoJugador1 = !turnoJugador1;
    }
}
