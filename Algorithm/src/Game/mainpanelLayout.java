package Game;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;

public class mainpanelLayout extends CardLayout implements LayoutManager2 {


    /**
     *
     */
    private static final long serialVersionUID = 1L;


    public float getLayoutAlignmentY(Container target) {
        int n = target.getComponentCount();
        for (int i = 0; i < n; i++) {
            target.getComponent(n);
        }
        return (float) 0.5;
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
        // TODO Auto-generated method stub


    }

    @Override
    public void layoutContainer(Container parent) {
        // TODO Auto-generated method stub

    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        // TODO Auto-generated method stub


    }

    @Override
    public float getLayoutAlignmentX(Container target) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void invalidateLayout(Container target) {
        // TODO Auto-generated method stub

    }

    @Override
    public Dimension maximumLayoutSize(Container target) {
        // TODO Auto-generated method stub
        return null;
    }


}

	

