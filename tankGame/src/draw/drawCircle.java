package draw;

import javax.swing.*;
import java.awt.*;

public class drawCircle extends JFrame{

    public static void main(String[] args) {
        new drawCircle();
        System.out.println("程序结束~~");

    }

    public drawCircle() {
        // 初始化界面
        // 定义一个面板
        MyPanel mp = new MyPanel();
        // 将面板放入界面
        this.add(mp);
        // 设置窗口大小
        this.setSize(400,300);
        //
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel{

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 画⚪
        g.drawOval(10,10,100,100);
        // 设置颜色
        g.setColor(Color.blue);
    }
}
