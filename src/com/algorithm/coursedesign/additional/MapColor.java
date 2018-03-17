package com.algorithm.coursedesign.additional;

import java.awt.*;

public class MapColor extends Canvas {
    private Color[] c = {Color.yellow, Color.blue, Color.green, Color.red, Color.white};
    private Polygon[] p;

    public MapColor(Polygon[] p) {
        this.p = p;
    }
    //画多边形
    public void paint(Graphics g) {
        g.setColor(Color.black);
        for (int i = 0; i < 34; i++)
            g.drawPolygon(p[i]);
    }
    //填充颜色
    public void fillColor(Graphics g, int i, int j) {
        g.setColor(c[j]);
        g.fillPolygon(p[i]);
    }
}
