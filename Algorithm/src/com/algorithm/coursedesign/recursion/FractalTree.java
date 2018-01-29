package com.algorithm.coursedesign.recursion;

import javax.swing.*;
import java.awt.*;

/**
 * 分形树
 */
public class FractalTree extends JFrame {
    public int x = 300;
    public int y = 480;
    public int max = 243;
    public int min = 5;

    public static void main(String[] args) {
        FractalTree frame = new FractalTree();
        frame.setSize(600, 600);
        frame.setTitle("分形树");
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public FractalTree() {
        setTitle("分形树");
        add(new FractalTree.TreePanel());

    }

    class TreePanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            getPoint(x, y, max, Math.PI / 2, g);
        }

        private void getPoint(int x, int y, int max1, double e, Graphics g) {
            if (max1 > min) {
                //划线
                //当线段的长度大于等于规定的最小值时
                int endX = (int) (x + max1 * Math.cos(e));
                int endY = (int) (y - max1 * Math.sin(e));
                //主线
                g.drawLine(x, y, endX, endY);

                //左线
                int left_startX = (int) (x + max1 * Math.cos(e) * 2.0 / 3);
                int left_startY = (int) (y - max1 * Math.sin(e) * 2.0 / 3);
                getPoint(left_startX, left_startY, (int) (max1 * 2.0 / 3), e + Math.PI / 6, g);

                //右线
                int right_startX = (int) (x + max1 * Math.cos(e) * 1.0 / 3);
                int right_startY = (int) (y - max1 * Math.sin(e) * 1.0 / 3);
                getPoint(right_startX, right_startY, (int) (max1 * 2.0 / 3), e - Math.PI / 6, g);
            } else {
                int endX = (int) (x + max1 * Math.cos(e));
                int endY = (int) (y - max1 * Math.sin(e));
                //主线
                g.drawLine(x, y, endX, endY);
                return;
            }
        }
    }
}
