package meuJogomodelo;

import java.awt.*;
import javax.swing.*;

public class Enemy1 {
    private Image imagem;
    private int x, y;
    private int largura, altura;
    private boolean isVisivel;

   // private static final int LARGURA = 938;
    private static int VELOCIDADE = 2;


    public Enemy1(int x, int y) {
        this.x = x;
        this.y = y;
        isVisivel = true;
    }

    public void load() {
        ImageIcon referencia = new ImageIcon("res\\bolso.png");
        imagem = referencia.getImage();

        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
    }

    public void update() {
        this.x -= VELOCIDADE;
           // if(this.x > LARGURA){
             //   isVisivel = false;
            //}
    }

    
    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisible(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    public static int getVELOCIDADE(){
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int vELOCIDADE) {
        VELOCIDADE = vELOCIDADE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }


}
