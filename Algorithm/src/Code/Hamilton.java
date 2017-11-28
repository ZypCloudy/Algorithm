/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Hamilton {
    static int[][] citys = null;

    /*public static int gettheFirst(int distance[])
        {
        int minNum = distance[1];
        int theDingDian = 1;
        for(int i = 1;i<distance.length;i++){
            if(distance[i] < minNum)
            {
                minNum = distance[i];
                theDingDian = i;
            }
        }
        return theDingDian;//返回输入数所在阶乘数的最小整数

    }*/
    public static void main(String[] args) {

        int n = 5;

        int[] initDistance = new int[n];
        citys = new int[n][n];

        citys[0][0] = 0;
        citys[0][1] = 2;
        citys[0][2] = 12;
        citys[0][3] = 9;
        citys[0][4] = 3;
        citys[1][0] = 2;
        citys[1][1] = 0;
        citys[1][2] = 7;
        citys[1][3] = 1;
        citys[1][4] = 4;
        citys[2][0] = 12;
        citys[2][1] = 7;
        citys[2][2] = 0;
        citys[2][3] = 8;
        citys[2][4] = 2;
        citys[3][0] = 9;
        citys[3][1] = 1;
        citys[3][2] = 8;
        citys[3][3] = 0;
        citys[3][4] = 5;
        citys[4][0] = 3;
        citys[4][1] = 4;
        citys[4][2] = 2;
        citys[4][3] = 5;
        citys[4][4] = 0;


        int[] part = new int[3];
        part[0] = 1;
        part[1] = 2;
        part[2] = 2;
        int result[] = part;
        int flag = 2;
        while (flag < n) {
            result = getResult(result, n);
            flag++;
        }

        System.out.print("哈密尔顿回路");
        for (int i = 0; i < result.length - 1; i++) {
            System.out.print(result[i] + ",");
        }

    }

    private static int[] getResult(int[] result, int n) {
        // TODO Auto-generated method stub
        int length = result.length;//要插入的数据
        int[] partresult = new int[length + 1];
        partresult = gettheBestArray(result, length);
        return partresult;
    }

    private static int[] gettheBestArray(int[] part, int length) {
        // TODO Auto-generated method stub
        int[] bestresult = new int[length];
        List midList = new ArrayList();
        for (int i = 1; i < length; i++) {
            int[] partresult = new int[length + 1];
            for (int j = 0; j < part.length; j++) {
                partresult[j] = part[j];
            }

            for (int j = length; j > i; j--) {
                partresult[j] = partresult[j - 1];
            }
            partresult[i] = length;
            midList.add(partresult);
        }
        bestresult = gettheMidArray(midList);
        return bestresult;
    }

    private static int[] gettheMidArray(List midList) {
        // TODO Auto-generated method stub
        int[] bestresult = (int[]) midList.get(0);
        int totaldistance = getthedistance(bestresult);
        for (int i = 1; i < midList.size(); i++) {
            int[] temp = (int[]) midList.get(i);
            int tempdis = getthedistance(temp);
            if (tempdis < totaldistance) {
                totaldistance = tempdis;
                bestresult = temp;
            }
        }
        return bestresult;
    }

    private static int getthedistance(int[] temp) {
        // TODO Auto-generated method stub
        int distance = 0;
        for (int i = 0; i < temp.length - 1; i++) {
            distance = distance + citys[temp[i] - 1][temp[i + 1] - 1];
        }
        return distance;
    }
}
