package Code;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //8. String to Integer (atoi)
    public int myAtoi(String str) {
        //这里要小心，需要判断有效性
        if(str==null || str.length() == 0) {
            return 0;
        }
        int nlen = str.length();
        double sum = 0;
        int sign = 1;
        int j = 0;
        //剔除空格
        while(str.charAt(j) == ' ')
            j++;
        //判断正数和负数
        if(str.charAt(j) == '+') {
            sign = 1;
            j++;
        }else if(str.charAt(j) == '-') {
            sign = -1;
            j++;
        }
        for(int i=j;i<nlen;i++) {
            char current = str.charAt(i);
            if(current >= '0' && current <= '9') {
                sum = sum*10 + (int)(current - '0');
            }
            else {
                break;//碰到非数字，退出转换
            }
        }
        sum = sum * sign;
        //这里要小心，需要判断范围
        if (sum > Integer.MAX_VALUE) {
            sum = Integer.MAX_VALUE;
        } else if (sum < Integer.MIN_VALUE) {
            sum = Integer.MIN_VALUE;
        }
        return (int)sum;
    }
//        Map map = new HashMap(){{
//            put('I',1);
//            put('V',5);
//            put('X',10);
//            put('L',50);
//            put('C',100);
//            put('D',500);
//            put('M',1000);
//        }};

    //13. Roman to Integer
    public int romanToInt(String s) {
        int res = 0;
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'I':
                    if(s.charAt(i+1) == 'V')
                        res--;
                    else
                        res++;
                    break;
                case 'V': res += 5;break;
                case 'X':
                    if(s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')
                        res -= 10;
                    else
                        res += 10;
                    break;
                case 'L': res += 50;break;
                case 'C':
                    if(s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')
                        res -= 100;
                    else
                        res += 100;
                    break;
                case 'D': res += 500;break;
                case 'M': res += 1000;break;
            };
        }
        return res;
    }
}