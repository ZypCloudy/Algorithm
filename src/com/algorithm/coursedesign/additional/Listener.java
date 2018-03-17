package com.algorithm.coursedesign.additional;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {
    private MapColor mc;
    private Polygon[] p;
    private JTextField text;
    private JCheckBox cbx;
    private int[][] metrix;

    public Listener(MapColor mc, Polygon[] p, JTextField text, JCheckBox cbx, int[][] metrix) {
        this.mc = mc;
        this.p = p;
        this.text = text;
        this.cbx = cbx;
        this.metrix = metrix;
    }

    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        JButton btn = (JButton) obj;
        if (btn.getText().equals("回溯")) {
            Recall de = new Recall(mc, cbx, metrix);
            long startTime = System.currentTimeMillis();   //获取开始时间
            de.backtrack();
            long endTime = System.currentTimeMillis(); //获取结束时间
            text.setText((endTime - startTime) + "ms");
        }else if(btn.getText().equals("优化")){
            Optimize de = new Optimize(mc,cbx,metrix);
            long startTime=System.currentTimeMillis();   //获取开始时间
            de.optimize();
            long endTime=System.currentTimeMillis(); //获取结束时间
            text.setText((endTime-startTime)+"ms");
        }else {
            Recall de = new Recall(mc, cbx, metrix);
            de.resetMap();
            text.setText(null);
            cbx.setSelected(false);
        }
    }
}