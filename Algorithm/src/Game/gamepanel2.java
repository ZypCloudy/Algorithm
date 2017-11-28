package Game;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class gamepanel2 extends JPanel {
    public gamepanel2() {
        super();
        JButton back = new JButton("返回");
        JButton backmain = new JButton("返回主菜单");
        drawpanel2 draw2 = new drawpanel2();
        this.setLayout(new BorderLayout());//设置布局方式为BorderLayout
        this.add(draw2, BorderLayout.CENTER);
        this.add(back, BorderLayout.NORTH);
        this.add(backmain, BorderLayout.SOUTH);
        this.setVisible(true);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                JButton button = (JButton) e.getSource();
                JPanel panel = (JPanel) button.getParent();
                Container container = panel.getParent();
                CardLayout layout = (CardLayout) container.getLayout();
                layout.show(container, "level");
            }
        });
        backmain.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JButton button = (JButton) e.getSource();
                JPanel panel = (JPanel) button.getParent();
                Container container = panel.getParent();
                CardLayout layout = (CardLayout) container.getLayout();
                layout.show(container, "main");

            }
        });
    }
}


