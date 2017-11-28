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
    private int[] circlex = {200, 100, 300, 150, 250};//Բ�ĵ�x����
    private int[] circley = {50, 150, 150, 250, 250};//Բ�ĵ�y����
    private int[] linex1 = {105, 305, 155, 205, 255};//�߶�����x����
    private int[] liney1 = {155, 155, 255, 55, 255};//�߶�����y����
    private int[] linex2 = {305, 155, 205, 255, 105};//�߶��յ��x����
    private int[] liney2 = {155, 255, 55, 255, 155};//�߶��յ��y����
    private Set<Ellipse2D> circle = new HashSet<Ellipse2D>(); //��circle�Ĺ�ϣ��
    private Set<Line2D> line = new HashSet<Line2D>();//��line�Ĺ�ϣ��
    private Set<Line2D> visitedline = new HashSet<Line2D>();//��visitedline�Ĺ�ϣ��
    private static double x1, y1, x2, y2 = 0;

    private Iterator<Ellipse2D> iterator = circle.iterator();
    private Iterator<Line2D> iterator1 = line.iterator();
    private Iterator<Line2D> iterator2 = visitedline.iterator();


    public drawpanel() {
        // TODO Auto-generated constructor stub
        super();
        final JLabel text = new JLabel("�ؿ�һ");
        JButton reset = new JButton("���¿�ʼ");
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

                while (iterator.hasNext())//�жϵ���ĵ��Ƿ����߶εĶ���
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

                        if (judgeinline(x1, y1, x2, y2) && judgerepeat(x1, y1, x2, y2))//���û�����ظ����߶Σ����߶�Ҳ����

                        {
                            Line2D readyline = new Line2D.Double(x1, y1, x2, y2);
                            System.out.println("����visited���߶�");
                            changelinecolor(getGraphics(), readyline);//���߶θı�Ϊ��ɫ
                            visitedline.add(readyline);
                            x1 = x2;
                            y1 = y2;
                            iterator = circle.iterator();
                            while (iterator.hasNext()) {

                                Ellipse2D point = iterator.next();
                                if (point.getCenterX() == x1 && point.getCenterY() == y1) {
                                    changecirclecolor(getGraphics(), point);//����ı�Ϊ��ɫ
                                }
                            }
                        }
                        if (x1 == 0 && y1 == 0)//���ǵ����һ����ʱ���������
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
                        if (visitedline.size() == 5)//�����߶η������
                        {
                            visitedline.clear();
                            x1 = 0;
                            y1 = 0;
                            x2 = 0;
                            y2 = 0;

                            int flag1 = JOptionPane.showConfirmDialog(null, "��ϲ���أ��Ƿ������һ�أ�", "����", 1);
                            if (flag1 == 0)//������ǡ�
                            {

                                JPanel panel = (JPanel) ((JPanel) text.getParent()).getParent();
                                Container container = panel.getParent();
                                CardLayout layout = (CardLayout) container.getLayout();
                                layout.show(container, "game2");

                                //���´���Ϊ�����ڶ���
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

    public Ellipse2D drawcircle(Graphics2D g, int x, int y)//����
    {
        Color c = g.getColor();
        g.setColor(Color.green);
        Ellipse2D a = new Ellipse2D.Double(x, y, 10, 10);
        g.fill(a);
        g.setColor(c);
        return a;
    }
    public Line2D drawline(Graphics g, int x1, int y1, int x2, int y2)//����ʼ�߶�
    {
        Color c = g.getColor();
        g.setColor(Color.blue);
        Line2D a = new Line2D.Double(x1, y1, x2, y2);
        ((Graphics2D) g).draw(a);
        g.setColor(c);
        return a;

    }
    public void changelinecolor(Graphics g, Line2D line)//�ı��߶���ɫ
    {
        Color c = g.getColor();
        g.setColor(Color.red);
        Graphics2D g1 = (Graphics2D) g;
        g1.draw(line);
        g.setColor(c);
    }

    public void resetlinecolor(Graphics g, int x1, int y1, int x2, int y2)//������ɫ
    {
        Color c = g.getColor();
        g.setColor(Color.blue);
        Line2D a = new Line2D.Double(x1, y1, x2, y2);
        ((Graphics2D) g).draw(a);
        g.setColor(c);
    }

    public void changecirclecolor(Graphics g, Ellipse2D circle)//�ı�����ɫ
    {
        Color c = g.getColor();
        g.setColor(Color.red);
        ((Graphics2D) g).fill(circle);
        g.setColor(c);


    }

    public void resetcirclecolor(Graphics2D g, int x, int y)//�����߶���ɫΪ��ɫ
    {

        Color c = g.getColor();
        g.setColor(Color.green);
        Ellipse2D a = new Ellipse2D.Double(x, y, 10, 10);
        g.fill(a);
        g.setColor(c);

    }

    public boolean judgeinline(double xa, double ya, double xb, double yb)//����Ƿ���line��
    {

        iterator1 = line.iterator();

        System.out.println("xa=" + xa);
        System.out.println("ya=" + ya);
        System.out.println("xb=" + xb);
        System.out.println("yb=" + yb);
        while (iterator1.hasNext()) {

            Line2D readyline = iterator1.next();//readyline�Ǵ�������߶�

            if (readyline.getX1() == xa && readyline.getY1() == ya && readyline.getX2() == xb && readyline.getY2() == yb || readyline.getX1() == xb && readyline.getY1() == yb && readyline.getX2() == xa && readyline.getY2() == ya)//�����������߶���line��
            {

                return true;


            }
        }

        System.out.println("find!!!!!!!");
        return false;

    }

    public boolean judgerepeat(double xa, double ya, double xb, double yb)//�ж���û���ظ������߶�
    {
        iterator2 = visitedline.iterator();

        while (iterator2.hasNext() && visitedline.size() != 0) {

            System.out.println("visited��sizeΪ" + visitedline.size());
            Line2D visited = iterator2.next();
            if (visited.getX1() == xa && visited.getY1() == ya && visited.getX2() == xb && visited.getY2() == yb || visited.getX1() == xb && visited.getY1() == yb && visited.getX2() == xa && visited.getY2() == ya)//���û���ظ��߶�
            {

                return false;
            }
        }
        return true;

    }


    @Override
    protected void paintComponent(Graphics g)//����ʼ�߶�
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
