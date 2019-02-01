package cn.itcast.Recursion;

import org.junit.Test;

/**
 * @author:fudingcheng
 * @date:2019-01-31
 * @description:
 */
public class Fibonacci {

    public int getNumber(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return getNumber(n - 1) + getNumber(n - 2);
        }
    }

    @Test
    public void test(){
        System.out.println(getNumber(5));
    }

}
