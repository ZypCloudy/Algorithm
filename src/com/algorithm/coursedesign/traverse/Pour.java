package com.algorithm.coursedesign.traverse;

import java.util.ArrayList;
import java.util.List;

/**
 * 倒水问题
 */
public class Pour {
    private int Pot1 = 8; //壶一容量
    private int Pot2 = 5; //壶二容量
    private int Pot3 = 3; //壶三容量
    private int target = 4;//目标壶容量
    /**
     * b1,b2,b3初始时，壶中水的状态
     * @param b1
     * @param b2
     * @param b3
     */
    private void backPot(int b1, int b2, int b3) {
        System.out.println("壶一水：" + b1 + ", 壶二水：" + b2 + ", 壶三水：" + b3);
        if (b2 == target) {
            System.out.println();
            System.out.println("倒出"+b1 + b2 + b3);
            return;
        }
        if (b2 != 0 && b3 != Pot3) {
            //壶2往壶3倒
            if (b2 + b3 < Pot3) {
                //到不满
                backPot(b1, 0, b2 + b3);

            } else {
                backPot(b1, b2 + b3 - Pot3, Pot3);
            }
        } else if (b3 == Pot3) {
            //壶3满往壶1倒
            if (b3 + b1 < Pot1) {
                //说明倒不满
                backPot(b1 + b3, b2, 0);
            } else {
                backPot(Pot1, b2, b3 + b1 - Pot1);
            }
        } else if (b2 == 0) {
            //从壶1往壶2倒酒
            if (b1 >= Pot2) {
                backPot(b1 - Pot2, Pot2, b3);
            } else {
                backPot(0, b1, b3);
            }
        }
    }

    public static void main(String[] args) {
        Pour shareWine = new Pour();
        shareWine.backPot(8, 0, 0);
    }
}
