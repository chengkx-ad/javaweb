package event;

/*
* 事件绑定
* */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame {

    public static void main(String[] args) {

        new BallMove();

    }

    public BallMove(){

        MyPanel mp = new MyPanel();
        this.add(mp);
        this.setSize(300,400);
        this.setDefaultCloseOperation(3);
        this.addKeyListener(mp);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener {

    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

