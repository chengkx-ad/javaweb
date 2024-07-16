package tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class TankGame extends JFrame {

    public static void main(String[] args) {
        // 游戏启动
        new TankGame();

    }
    public TankGame(){

        // 初始化界面
        MyPanel panel = new MyPanel();
        this.add(panel);
        // 设置大小
        this.setSize(1000,750);
        this.addKeyListener(panel);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }
}
