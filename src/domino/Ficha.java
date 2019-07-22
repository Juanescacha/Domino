/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

/**
 *
 * @author Juan Esteban Camargo
 */
public class Ficha {
    
    private int lado1;
    private int lado2;
    
    public Ficha() {
        lado1 = 0;
        lado2 = 0;
    }
    
    public Ficha(int a, int b) {
        lado1 = a;
        lado2 = b;
    }
    
    public int getLado1() {
        return lado1;
    }
    
    public int getLado2() {
        return lado2;
    }
    
    public int getTotal() {
        return lado1 + lado2;
    }
    
    public boolean esPar() {
        return lado1 == lado2;
    }
    
    public boolean mismoValor(Ficha x) {
        return this.getTotal() == x.getTotal();
    }
    
    public boolean mayor(Ficha x) {
        if(this.getTotal() > x.getTotal()) return true;
        else return false;
    }
    
    public boolean esIgual(Ficha x) {
        if(this.getLado1() == x.getLado1()) {
            if(this.getLado2() == x.getLado2()) {
                return true;
            }
        }
        
        if(this.getLado1() == x.getLado2()) {
            if(this.getLado2() == x.getLado1()) {
                return true;
            }
        }
        
        return false;  
    }
    
    
}
