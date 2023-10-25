package meuJogo;
import javax.swing.*;

import meuJogomodelo.Fase;

public class Container extends JFrame {
    public Container(){
        add(new Fase());
        setTitle("Jogo");
        setSize(1024, 577);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);
        setVisible(true);
    }

    public static void main (String args[]){
        new Container();
    }
}