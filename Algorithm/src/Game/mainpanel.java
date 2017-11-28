

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


public class mainpanel extends JPanel {

    /**
     *
     */

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public mainpanel() {
        super();


        JLabel gamename = new JLabel("一笔画游戏");
        JButton start = new JButton("开始游戏");
        JButton exit = new JButton("退出游戏");
        this.setVisible(true);
        this.add(gamename);
        this.add(start);

        this.add(exit);
        GridBagLayout gr = new GridBagLayout();
        this.setLayout(gr);
        GridBagConstraints gc = new GridBagConstraints();
        int[] gx = {1, 1, 1};
        int[] gy = {1, 10, 14};
        int[] gw = {2, 1, 1};
        int[] gh = {3, 1, 1};
        for (int i = 0; i < gx.length; i++) {
            gc.gridx = gx[i];
            gc.gridy = gy[i];
            gc.gridwidth = gw[i];
            gc.gridheight = gh[i];
            gc.fill = GridBagConstraints.BOTH;
            gr.setConstraints(this.getComponent(i), gc);

        }


        start.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {


                JButton button = (JButton) e.getSource();
                JPanel panel = (JPanel) button.getParent();
                Container container = panel.getParent();
                CardLayout layout = (CardLayout) container.getLayout();
                layout.show(container, "level");


            }
        });

        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub

                System.exit(0);
            }
        });


    }

}
