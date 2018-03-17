package com.algorithm.graph.game.unicursal;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class leveldialog extends JDialog {
    public leveldialog() {
        this.setAlwaysOnTop(isAlwaysOnTop());
        JButton nextlevel = new JButton("继续下一关");
        JButton back = new JButton("返回");
        JLabel text = new JLabel("恭喜过关");
        this.setLayout(new BorderLayout());
        this.add(text);
        this.add(nextlevel);
        this.add(back);
        this.setSize(500, 500);
        nextlevel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                JButton button = (JButton) e.getSource();
                JPanel panel = (JPanel) ((JPanel) button.getParent()).getParent();
                Container container = panel.getParent();
                CardLayout layout = (CardLayout) container.getLayout();
                layout.show(container, "game2");
            }
        });
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JButton button = (JButton) e.getSource();
                JPanel panel = (JPanel) ((JPanel) button.getParent()).getParent();
                Container container = panel.getParent();
                CardLayout layout = (CardLayout) container.getLayout();
                layout.show(container, "level");

            }
        });
    }
}
