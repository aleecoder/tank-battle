package com.aleecoder;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 坦克类
 * @author HuanyuLee
 * @date 2022/7/25
 */
public class Tank {
    private int x, y;
    private static final int SPEED = 5;
    private Direction dir;
    /** 坦克方向的标识 */
    private boolean bL, bR, bU, bD;

    public Tank(int x, int y, Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                bL = true;
                break;
            case KeyEvent.VK_RIGHT:
                bR = true;
                break;
            case KeyEvent.VK_UP:
                bU = true;
                break;
            case KeyEvent.VK_DOWN:
                bD = true;
                break;
            default:
        }
        setMainTankDir();
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                bL = false;
                break;
            case KeyEvent.VK_RIGHT:
                bR = false;
                break;
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
            default:
        }
        setMainTankDir();
    }

    private void setMainTankDir() {
        if (!bL && !bR && !bU && !bD) {
            dir = Direction.STOP;
        }
        if (bL && !bR && !bU && !bD) {
            dir = Direction.LEFT;
        }
        if (!bL && bR && !bU && !bD) {
            dir = Direction.RIGHT;
        }
        if (!bL && !bR && bU && !bD) {
            dir = Direction.UP;
        }
        if (!bL && !bR && !bU && bD) {
            dir = Direction.DOWN;
        }
        // 斜着走 类似
    }
}
