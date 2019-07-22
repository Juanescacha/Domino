/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Juan Esteban Camargo
 */
public class GUI extends JFrame implements ActionListener{
    
    //Creamos los Objetos
    
    JTextArea area;
    JPanel pAdversario, pMesa, pJugador, pArbitro;
    JButton boton1;
    JButton boton2;
    JButton boton3;
    
    
    public GUI(){
        
        // Inicializamos los Objetos
        super("Juego Domino");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        
        //Definimos el objeto de las constrains de GridBag
        GridBagConstraints gbc = new GridBagConstraints();
        
        area = new JTextArea("ESTO ES EL TEXT AREA");
        pAdversario = new JPanel();
        pMesa = new JPanel();
        pJugador = new JPanel();
        pArbitro = new JPanel();
        
        boton1 = new JButton("Cartas Enemigo");
        boton2 = new JButton("Texto Arbitro");
        boton3 = new JButton("Cartas Propias");
        
        //Definimos layouts
        pArbitro.setLayout( new GridLayout(5,1)) ;
        pMesa.setLayout(new BorderLayout() );
        pJugador.setLayout( new FlowLayout() );
        pAdversario.setLayout( new FlowLayout() );
        
        //Definimos Bordes
        pAdversario.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pMesa.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));
        pJugador.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pArbitro.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        //Agregamos a los Paneles
        
        pAdversario.add(boton1);
        pMesa.add(area , BorderLayout.CENTER);  
        pArbitro.add(boton2);
        pJugador.add(boton3);
        
        
        
        //valores para cada objeto antes de posicionar
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(pAdversario,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(pArbitro,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(pMesa,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(pJugador,gbc);
       
        
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == boton ){
//            area.append(texto.getText() + "\n");
//            texto.setText("");
//        }
    }
}
