package tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {
    // 定义tank
    MyTank tank1 = null;
    Vector<EnemyTank> vector = new Vector<>();
    int vectorSize = 3;
    // 初始化tank
    public MyPanel(){
        tank1 = new MyTank(100,100);
        tank1.setSpeed(10);
        for (int i = 0; i < vectorSize; i++) {
            EnemyTank enemyTank = new EnemyTank(100*(i+1),0);
            enemyTank.setSpeed(10);
            vector.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0,1000,750);
        // 我的tank
        draw(tank1.getX(),tank1.getY(),g, tank1.getDirect(),0);
        // 敌人的tank
        for (int i = 0; i < vectorSize; i++) {
            EnemyTank tank = vector.get(i);
            draw(tank.getX(),tank.getY(),g, tank.getDirect(), 1);
        }


    }
    // tank设计
    /**
     *
     * @param x : tank 横坐标
     * @param y ：tank 纵坐标
     * @param g ：绘制tank
     * @param direct : 方向
     * @param type ：tank类型
     */
    public void draw(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0: // 己方tank
                g.setColor(Color.CYAN);
                break;
            case 1: // 敌方tank
                g.setColor(Color.green);
                break;
        }
        switch (direct) {
            case 0: // 向上
                g.fill3DRect(x, y, 10, 60, true);
                g.fill3DRect(x + 30, y, 10, 60, true);
                g.fill3DRect(x + 10, y + 10, 20, 40, true);
                g.fill3DRect(x + 10, y + 20, 20, 20, true);
                g.drawLine(x + 20, y, x + 20, y + 30);
                break;
            case 1: // 向右
                g.fill3DRect(x, y, 60, 10, true);
                g.fill3DRect(x, y + 30, 60, 10, true);
                g.fill3DRect(x + 10, y + 10, 40, 20, true);
                g.fill3DRect(x + 20, y + 10, 20, 20, true);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2: // 向下
                g.fill3DRect(x, y, 10, 60, true);
                g.fill3DRect(x + 30, y, 10, 60, true);
                g.fill3DRect(x + 10, y + 10, 20, 40, true);
                g.fill3DRect(x + 10, y + 20, 20, 20, true);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3: // 向左
                g.fill3DRect(x, y, 60, 10, true);
                g.fill3DRect(x, y + 30, 60, 10, true);
                g.fill3DRect(x + 10, y + 10, 40, 20, true);
                g.fill3DRect(x + 20, y + 10, 20, 20, true);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("00");
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W){
            tank1.setDirect(0);
            tank1.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            tank1.setDirect(1);
            tank1.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            tank1.setDirect(2);
            tank1.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            tank1.setDirect(3);
            tank1.moveLeft();
        }
        this.repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
