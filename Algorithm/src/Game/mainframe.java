package Game;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;


public class mainframe extends JFrame {
    public mainframe() {
        super("һ�ʻ���Ϸ");
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        mainframe mainmenu = new mainframe();
        mainmenu.setLocation(400, 100);
        mainmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainmenu.setSize(500, 500);
        Container co = mainmenu.getContentPane();
        CardLayout card = new CardLayout();
        co.setLayout(card);//���岼��ģʽΪ��Ƭ����
        co.setLayout(card);
        drawpanel draw = new drawpanel();
        levelpanel levelpa = new levelpanel();
        mainpanel mainpa = new mainpanel();
        gamepanel gamepa = new gamepanel();
        drawpanel drawpa = new drawpanel();
        gamepanel2 gamepa2 = new gamepanel2();
        gamepanel3 gamepa3 = new gamepanel3();
        mainmenu.add(mainpa);
        mainmenu.add(levelpa);
        mainmenu.add(gamepa);
        mainmenu.add(gamepa2);
        mainmenu.add(gamepa3);
        co.add("main", mainpa);//��ģ��mainpa����mainframe��card��
        co.add("level", levelpa);//��ģ��levelpanel����mainframe��card��
        co.add("game", gamepa);//��ģ��gamepa����mainframe��card��
        co.add("game2", gamepa2);
        co.add("game3", gamepa3);
        card.show(co, "main");//��mainframe������ʾ����mainpa
        mainmenu.setVisible(true);
    }
}
