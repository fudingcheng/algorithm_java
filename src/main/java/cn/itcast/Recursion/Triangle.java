package cn.itcast.Recursion;

import org.junit.Test;

/**
 * @author:fudingcheng
 * @date:2019-01-31
 * @description: 三角数列
 * eg: 1,3,6,10,15,21
 */
public class Triangle {

    public int getNumber(int n) {
        int total = 0;
        while (n > 0) {
            total = total + n;
            n--;
        }
        return total;
    }

    public int getNumberByRecursion(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + getNumberByRecursion(n - 1);
        }
    }


    @Test
    public void test() {
        long start = System.currentTimeMillis();
        System.out.println(getNumber(1000));
        //System.out.println(getNumberByRecursion(1000));
        long end = System.currentTimeMillis();
        System.out.println("运行时间:" + (end - start));
    }

}
