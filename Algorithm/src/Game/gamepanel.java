package Game;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class gamepanel extends JPanel {
    /**
     *
     */


    public gamepanel() {
        super();
        JButton back = new JButton("����");
        JButton backmain = new JButton("�������˵�");
        JButton reset = new JButton("���¿�ʼ");
        drawpanel draw = new drawpanel();
        this.setLayout(new BorderLayout());//���ò��ַ�ʽΪBorderLayout
        this.add(draw, BorderLayout.CENTER);
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
