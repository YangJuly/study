package com.yangzanjie.graph;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;


/**
 *
 * 程序入口
 *
 */
public class TestDrawLine {
    public static void main(String[] args) {
        DrawSee drawSee = new DrawSee();
        AStart aStart = new AStart(49,  drawSee);
        aStart.run(new Point(0,0), new Point(49,49));
    }
}

class DrawSee extends JFrame {

    private static final int sx = 50;//小方格宽度
    private static final int sy = 50;//小方格高度
    private static final int w = 10;
    private static final int rw = 500;


    private Graphics jg;



    private Color rectColor = new Color(0xf5f5f5);

    /**
     * DrawSee构造方法
     */
    public DrawSee() {
        Container p = getContentPane();
        setBounds(100, 100, 800, 800);
        setVisible(true);
        p.setBackground(rectColor);
        setLayout(null);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 获取专门用于在窗口界面上绘图的对象
        jg =  this.getGraphics();

        // 绘制游戏区域
        paintComponents(jg);


    }



    public void paintComponents(Graphics g) {
        try {

            // 设置线条颜色为红色
            g.setColor(Color.RED);

            // 绘制外层矩形框
            g.drawRect(sx, sy, rw, rw);

            /* 绘制水平50个，垂直50个方格。
             * 即水平方向49条线，垂直方向49条线，
             * 外围四周4条线已经画过了，不需要再画。
             */
            for(int i = 1; i < 50; i ++) {
                // 绘制第i条竖直线
                g.drawLine(sx + (i * w), sy, sx + (i * w), sy + rw);

                // 绘制第i条水平线
                g.drawLine(sx, sy + (i * w), sx + rw, sy + (i * w));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paintPoint(Point point, Color color) {
        try {
            // 设置线条颜色
            jg.setColor(color);
            jg.fillRect(sx + point.x * w, sy + point.y * w, 9,9);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}