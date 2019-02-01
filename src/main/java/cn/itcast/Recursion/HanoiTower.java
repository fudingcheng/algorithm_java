package cn.itcast.Recursion;

import org.junit.Test;

/**
 * @author:fudingcheng
 * @date:2019-01-31
 * @description:
 */
public class HanoiTower {

    public void doTower(int topN, char from, char inter, char to) {
        if (topN == 1) {
            System.out.println("盘子1,从" + from + "塔座到" + to + "塔座");
        } else {
            //1.将topN-1的盘子从from移动到inter
            doTower(topN - 1, from, to, inter);
            //2.将topN的盘子从from移动到to
            System.out.println("盘子" + topN + ",从" + from + "塔座到" + to + "塔座");
            //3.将topN-1的盘子从inter移动到to
            doTower(topN - 1, inter, from, to);
        }
    }

    @Test
    public void test(){
        doTower(5,'A','B','C');
    }

}
