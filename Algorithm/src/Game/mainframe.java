package Game;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;


public class mainframe extends JFrame {
    public mainframe() {
        super("一笔画游戏");
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
        co.setLayout(card);//定义布局模式为卡片布局
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
        co.add("main", mainpa);//将模板mainpa放入mainframe的card中
        co.add("level", levelpa);//将模板levelpanel放入mainframe的card中
        co.add("game", gamepa);//将模板gamepa放入mainframe的card中
        co.add("game2", gamepa2);
        co.add("game3", gamepa3);
        card.show(co, "main");//打开mainframe首先显示的是mainpa
        mainmenu.setVisible(true);
    }
}
