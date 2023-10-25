package meuJogomodelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Fase extends JPanel implements ActionListener {
    
    private Image fundo;
    private Player player;
    private Timer timer;
    private List<Enemy1> enemy1;

    public Fase(){
        setFocusable(true);
        setDoubleBuffered(true);

        ImageIcon referencia = new ImageIcon("res\\fundo2.jpg");
        fundo = referencia.getImage();

        player = new Player();
        player.load();

        addKeyListener(new TecladoAdapter());

        timer = new Timer(5, this);
        timer.start();

        inicializaInimigos();
        
    }

    public void inicializaInimigos() {
        int coordenadas [ ] = new int [40];
        enemy1 = new ArrayList<Enemy1>();

        for (int i = 0; i < coordenadas.length; i++) {
            int x = (int)(Math.random() * 8000+1024);
            int y = (int)(Math.random() * 550 + 10); //650 + 30 quando for 728
            enemy1.add(new Enemy1(x, y));
        }
    }

    
    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        graficos.drawImage(player.getImagem(),player.getX(), player.getY(), this);

         List<Tiro> tiros = player.getTiros();
        for(int i = 0; i < tiros.size(); i++) {
            Tiro m = tiros.get(i);
            m.load();
            graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
        }

        for (int i = 0; i < enemy1.size(); i++){
            Enemy1 in = enemy1.get(i);
            in.load();
            graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        
        List<Tiro> tiros = player.getTiros();
        for(int i = 0; i < tiros.size(); i++) {
            Tiro m = tiros.get(i);
            if(m.isVisivel()) {
                m.update();
            } else {
                tiros.remove(i);
            }
        }

        for (int i = 0; i < enemy1.size(); i++) {
            Enemy1 in = enemy1.get(i);
            if(in.isVisivel()) {
                in.update();
            } else {
                enemy1.remove(i);
            }
        }
        
        repaint();

    }

    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyRelease(e);
        }
    }

}
