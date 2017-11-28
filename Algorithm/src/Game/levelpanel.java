package Game;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class levelpanel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public levelpanel() {
        super();

        JLabel gamesearch = new JLabel("�ؿ�ѡ��");
        JButton back = new JButton("����");
        JButton level1 = new JButton("�ؿ�һ");
        final JButton level2 = new JButton("�ؿ���");
        final JButton level3 = new JButton("�ؿ���");
        JButton unlock = new JButton("�������йؿ�");
        level2.setEnabled(false);
        level3.setEnabled(false);
        this.add(gamesearch);
        this.add(level1);
        this.add(level2);
        this.add(level3);
        this.add(back);
        this.add(unlock);
        GridBagLayout gr = new GridBagLayout();
        this.setLayout(gr);//����levelpanel���ַ�ʽΪ���񲼾�
        GridBagConstraints gc = new GridBagConstraints();
        int[] gx = {1, 1, 1, 1, 1, 1};
        int[] gy = {1, 2, 3, 4, 5, 6};
        int[] gw = {1, 1, 1, 1, 1, 1};
        int[] gh = {1, 1, 1, 1, 1, 1};
        for (int i = 0; i < gx.length; i++) {
            gc.gridx = gx[i];
            gc.gridy = gy[i];
            gc.gridwidth = gw[i];
            gc.gridheight = gh[i];
            gc.fill = GridBagConstraints.BOTH;
            gr.setConstraints(this.getComponent(i), gc);

        }
        this.setVisible(true);

        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {


                JButton button = (JButton) e.getSource();
                JPanel panel = (JPanel) button.getParent();
                Container container = panel.getParent();
                CardLayout layout = (CardLayout) container.getLayout();
                layout.show(container, "main");


            }
        });
        level1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                JButton button = (JButton) e.getSource();
                JPanel panel = (JPanel) button.getParent();
                Container container = panel.getParent();
                CardLayout layout = (CardLayout) container.getLayout();
                layout.show(container, "game");


            }
        });
        level2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JButton button = (JButton) e.getSource();
                JPanel panel = (JPanel) button.getParent();
                Container container = panel.getParent();
                CardLayout layout = (CardLayout) container.getLayout();
                layout.show(container, "game2");


            }
        });
        level3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JButton button = (JButton) e.getSource();
                JPanel panel = (JPanel) button.getParent();
                Container container = panel.getParent();
                CardLayout layout = (CardLayout) container.getLayout();
                layout.show(container, "game3");

            }
        });
        unlock.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                level2.setEnabled(true);
                level3.setEnabled(true);


            }
        });
    }


}
