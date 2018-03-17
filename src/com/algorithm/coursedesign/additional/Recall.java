package com.algorithm.coursedesign.additional;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Robot;

/**
 * 回溯法
 */
public class Recall {
    private MapColor mc;
    private JCheckBox cbx;
    private int current = 0;
    private int[][] metrix;

    public Recall(MapColor mc, JCheckBox cbx, int[][] metrix) {
        this.mc = mc;
        this.cbx = cbx;
        this.metrix = metrix;
    }

    private boolean isOK(int province[]) {
        for (int j = 0; j < current; j++)
            if (metrix[current][j] == 1 && province[j] == province[current])
                return false;
        return true;
    }

    private int color(int province[]) {
        int i = 0;
        if (current <= 33)
            for (i = 0; i < 4; i++) {
                province[current] = i;
                Graphics g = mc.getGraphics();
                mc.fillColor(g, current, i);
                if (cbx.isSelected())
                    try {
                        //设置延迟50ms
                        Robot r = new Robot();
                        r.delay(50);
                    } catch (Exception e) {
                    }
                if (isOK(province)) {
                    current++;
                    int j = color(province);
                    if (j == -1) {
                        current--;
                        province[current] = -1;
                    }
                    if (current > 33) return 1;
                }
            }
        if (i >= 4)
            return -1;
        return 1;
    }

    public void backtrack() {
        int province[] = new int[34];
        color(province);
    }

    public void resetMap() {
        Graphics g = mc.getGraphics();
        for (int k = 0; k < 34; k++) {
            mc.fillColor(g, k, 4);
        }
        mc.paint(g);
    }
}
