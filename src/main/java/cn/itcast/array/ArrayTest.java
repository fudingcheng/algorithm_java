package cn.itcast.array;

import org.junit.Before;
import org.junit.Test;

/**
 * @author:fudingcheng
 * @date:2019-01-21
 * @description:
 */
public class ArrayTest {

    int[] arr;
    /**
     * 初始化数组
     */
    @Before
    public void init(){
        //arr = new int[10];
        arr = new int[]{1,2,4,3,4,5};
    }


    public int get(int i){
        return arr[i];
    }

    @Test
    public void testGet(){
        System.out.println(get(1));
    }



}
