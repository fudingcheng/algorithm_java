package cn.itcast.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:fudingcheng
 * @date:2019-01-22
 * @description:
 */
public class SortArray {
    public void bubbleSort(long[] arr) {
        //控制比较次数
        for (int i = 0; i < arr.length - 1; i++) {
            //比较值大小
            for (int j = arr.length - 1; j > i; j--) {
                //如果j小于j-1,向前冒泡
                if (arr[j] < arr[j - 1]) {
                    long temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }


    public void selectionSort(long[] arr) {
        //k永远指向最小数
        int k = 0;
        //用户交换的变量
        long temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            //从第一位开始比较
            k = i;
            for (int j = i + 1; j < arr.length; j++) {
                //如果k位置的值大于j的值,k指向j
                if (arr[j] < arr[k]) {
                    k = j;
                }
                //经过循环k永远指向最小值
            }
            //交换k和i的值
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }

    public void insertSort(long[] arr) {

        for (int i = 1; i < arr.length; i++) {
            long temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    @Test
    public void testSolr() {
        long[] arr = new long[]{10, 23, 4, 1, 3, 6};
        System.out.println("排序前:" + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后:" + Arrays.toString(arr));
    }

}
