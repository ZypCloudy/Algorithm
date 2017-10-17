package Code;

public class Solution {
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
        if(str.charAt(j) == '+')
        {
            sign = 1;
            j++;
        }else if(str.charAt(j) == '-')
        {
            sign = -1;
            j++;
        }
        for(int i=j;i<nlen;i++)
        {
            char current = str.charAt(i);
            if(current >= '0' && current <= '9')
            {
                sum = sum*10 + (int)(current - '0');
            }
            else
            {
                break;//碰到非数字，退出转换
            }
        }
        sum = sum*sign;
//这里要小心，需要判断范围
        if (sum > Integer.MAX_VALUE) {
            sum = Integer.MAX_VALUE;
        } else if (sum < Integer.MIN_VALUE) {
            sum = Integer.MIN_VALUE;
        }
        return (int)sum;
    }
}