package Game;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class drawpanel extends JPanel {
    private int[] circlex = {200, 100, 300, 150, 250};//圆心的x坐标
    private int[] circley = {50, 150, 150, 250, 250};//圆心的y坐标
    private int[] linex1 = {105, 305, 155, 205, 255};//线段起点的x坐标
    private int[] liney1 = {155, 155, 255, 55, 255};//线段起点的y坐标
    private int[] linex2 = {305, 155, 205, 255, 105};//线段终点的x坐标
    private int[] liney2 = {155, 255, 55, 255, 155};//线段终点的y坐标
    private Set<Ellipse2D> circle = new HashSet<Ellipse2D>(); //放circle的哈希表
    private Set<Line2D> line = new HashSet<Line2D>();//放line的哈希表
    private Set<Line2D> visitedline = new HashSet<Line2D>();//放visitedline的哈希表
    private static double x1, y1, x2, y2 = 0;

    private Iterator<Ellipse2D> iterator = circle.iterator();
    private Iterator<Line2D> iterator1 = line.iterator();
    private Iterator<Line2D> iterator2 = visitedline.iterator();


    public drawpanel() {
        // TODO Auto-generated constructor stub
        super();
        final JLabel text = new JLabel("关卡一");
        JButton reset = new JButton("重新开始");
        this.add(text);
        this.add(reset);
        reset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                x1 = 0;
                y1 = 0;
                x2 = 0;
                y2 = 0;
                for (int i = 0; i < 5; i++) {
                    resetlinecolor(getGraphics(), linex1[i], liney1[i], linex2[i], liney2[i]);

                }
                for (int i = 0; i < 5; i++) {
                    resetcirclecolor((Graphics2D) getGraphics(), circlex[i], circley[i]);
                }


                visitedline.clear();
            }
        });

        this.addMouseListener(new MouseListener() {

            @SuppressWarnings("null")
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

                System.out.println("------------------------------------" + line.size());
                int x = e.getX();
                int y = e.getY();

                iterator = circle.iterator();

                while (iterator.hasNext())//判断点击的点是否在线段的顶点
                {
                    Ellipse2D e1 = iterator.next();

                    if (e1.contains(x, y)) {

                        double x2 = e1.getCenterX();
                        double y2 = e1.getCenterY();

                        System.out.println("x1=" + x1);
                        System.out.println("y1=" + y1);
                        System.out.println("x2=" + x2);
                        System.out.println("y2=" + y2);


                        System.out.println("inline " + judgeinline(x1, y1, x2, y2) + "judgerepeat" + judgerepeat(x1, y1, x2, y2));

                        if (judgeinline(x1, y1, x2, y2) && judgerepeat(x1, y1, x2, y2))//如果没有走重复的线段，且线段也存在

                        {
                            Line2D readyline = new Line2D.Double(x1, y1, x2, y2);
                            System.out.println("进入visited的线段");
                            changelinecolor(getGraphics(), readyline);//将线段改变为红色
                            visitedline.add(readyline);
                            x1 = x2;
                            y1 = y2;
                            iterator = circle.iterator();
                            while (iterator.hasNext()) {

                                Ellipse2D point = iterator.next();
                                if (point.getCenterX() == x1 && point.getCenterY() == y1) {
                                    changecirclecolor(getGraphics(), point);//将点改变为红色
                                }
                            }
                        }
                        if (x1 == 0 && y1 == 0)//考虑点击第一个点时的特殊情况
                        {
                            x1 = x2;
                            y1 = y2;
                            iterator = circle.iterator();
                            while (iterator.hasNext()) {

                                Ellipse2D point = iterator.next();
                                if (point.getCenterX() == x1 && point.getCenterY() == y1) {
                                    changecirclecolor(getGraphics(), point);

                                }
                            }
                        }
                        if (visitedline.size() == 5)//所有线段访问完毕
                        {
                            visitedline.clear();
                            x1 = 0;
                            y1 = 0;
                            x2 = 0;
                            y2 = 0;

                            int flag1 = JOptionPane.showConfirmDialog(null, "恭喜过关，是否进入下一关？", "过关", 1);
                            if (flag1 == 0)//点击“是“
                            {

                                JPanel panel = (JPanel) ((JPanel) text.getParent()).getParent();
                                Container container = panel.getParent();
                                CardLayout layout = (CardLayout) container.getLayout();
                                layout.show(container, "game2");

                                //以下代码为解锁第二关
                                JPanel jPanel = (JPanel) getParent();
                                JPanel jPanel2 = (JPanel) jPanel.getParent();

                                JPanel jPanel3 = (JPanel) jPanel2.getComponent(1);

                                JButton button = (JButton) jPanel3.getComponent(2);

                                button.setEnabled(true);

                            }
                        }
                    }
                }
            }
            @Override
            public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

        });

        this.setVisible(true);
    }

    public Ellipse2D drawcircle(Graphics2D g, int x, int y)//画点
    {
        Color c = g.getColor();
        g.setColor(Color.green);
        Ellipse2D a = new Ellipse2D.Double(x, y, 10, 10);
        g.fill(a);
        g.setColor(c);
        return a;
    }
    public Line2D drawline(Graphics g, int x1, int y1, int x2, int y2)//画初始线段
    {
        Color c = g.getColor();
        g.setColor(Color.blue);
        Line2D a = new Line2D.Double(x1, y1, x2, y2);
        ((Graphics2D) g).draw(a);
        g.setColor(c);
        return a;

    }
    public void changelinecolor(Graphics g, Line2D line)//改变线段颜色
    {
        Color c = g.getColor();
        g.setColor(Color.red);
        Graphics2D g1 = (Graphics2D) g;
        g1.draw(line);
        g.setColor(c);
    }

    public void resetlinecolor(Graphics g, int x1, int y1, int x2, int y2)//重置颜色
    {
        Color c = g.getColor();
        g.setColor(Color.blue);
        Line2D a = new Line2D.Double(x1, y1, x2, y2);
        ((Graphics2D) g).draw(a);
        g.setColor(c);
    }

    public void changecirclecolor(Graphics g, Ellipse2D circle)//改变点的颜色
    {
        Color c = g.getColor();
        g.setColor(Color.red);
        ((Graphics2D) g).fill(circle);
        g.setColor(c);


    }

    public void resetcirclecolor(Graphics2D g, int x, int y)//重置线段颜色为蓝色
    {

        Color c = g.getColor();
        g.setColor(Color.green);
        Ellipse2D a = new Ellipse2D.Double(x, y, 10, 10);
        g.fill(a);
        g.setColor(c);

    }

    public boolean judgeinline(double xa, double ya, double xb, double yb)//检测是否在line中
    {

        iterator1 = line.iterator();

        System.out.println("xa=" + xa);
        System.out.println("ya=" + ya);
        System.out.println("xb=" + xb);
        System.out.println("yb=" + yb);
        while (iterator1.hasNext()) {

            Line2D readyline = iterator1.next();//readyline是待进入的线段

            if (readyline.getX1() == xa && readyline.getY1() == ya && readyline.getX2() == xb && readyline.getY2() == yb || readyline.getX1() == xb && readyline.getY1() == yb && readyline.getX2() == xa && readyline.getY2() == ya)//如果带进入的线段在line中
            {

                return true;


            }
        }

        System.out.println("find!!!!!!!");
        return false;

    }

    public boolean judgerepeat(double xa, double ya, double xb, double yb)//判断有没有重复访问线段
    {
        iterator2 = visitedline.iterator();

        while (iterator2.hasNext() && visitedline.size() != 0) {

            System.out.println("visited的size为" + visitedline.size());
            Line2D visited = iterator2.next();
            if (visited.getX1() == xa && visited.getY1() == ya && visited.getX2() == xb && visited.getY2() == yb || visited.getX1() == xb && visited.getY1() == yb && visited.getX2() == xa && visited.getY2() == ya)//如果没有重复线段
            {

                return false;
            }
        }
        return true;

    }


    @Override
    protected void paintComponent(Graphics g)//画初始线段
    {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        circle.clear();
        for (int i = 0; i < 5; i++) {
            circle.add(drawcircle(g2, circlex[i], circley[i]));

        }


        line.clear();
        for (int i = 0; i < 5; i++) {
            line.add(drawline(g2, linex1[i], liney1[i], linex2[i], liney2[i]));
            System.out.println("------------------------------------" + line.size());
        }


    }


}
