package cn.itcast.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author:fudingcheng
 * @date:2019-01-22
 * @description:
 */
public class SortArray {

    /**
     * 冒泡排序
     *
     * @param arr
     */
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


    /**
     * 选择排序
     *
     * @param arr
     */
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

    /**
     * 插入排序
     *
     * @param arr
     */
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

    /**
     * 希尔排序
     *
     * @param arr
     */
    public void shellSort(long[] arr) {
        //初始化一个间隔
        int h = 1;
        while (h < arr.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            long temp = 0;
            for (int i = h; i < arr.length; i++) {
                temp = arr[i];
                int j = i;
                while (j > h - 1 && arr[j - h] >= temp) {
                    arr[j] = arr[j - h];
                    j -= h;
                }
                arr[j] = temp;
            }
            h = (h - 1) / 3;
        }
    }

    /**
     * 划分数组
     */
    public int partition(long[] arr, int left, int right, long point) {
        int leftPtr = left - 1;
        int rightPtr = right;

        while (true) {
            while (leftPtr < rightPtr && arr[++leftPtr] < point) ;
            while (rightPtr > leftPtr && arr[--rightPtr] > point) ;

            if (leftPtr >= rightPtr) {
                break;
            } else {
                long temp = arr[leftPtr];
                arr[leftPtr] = arr[rightPtr];
                arr[rightPtr] = temp;
            }
        }
        long temp = arr[leftPtr];
        arr[leftPtr] = arr[right];
        arr[right] = temp;
        return leftPtr;
    }

    /**
     * 快速排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public void quickSort(long[] arr, int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            //设置比较关键字
            long point = arr[right];
            //获得切入点,同时对数组进行划分
            int partition = partition(arr, left, right, point);
            //对左边的子数组进行快速排序
            quickSort(arr, left, partition - 1);
            //对右边的子数组进行快速排序
            quickSort(arr, partition + 1, right);
        }
    }


    @Test
    public void testSolr() {
        long[] arr = new long[]{10, 23, 4, 1, 3, 6};
        System.out.println("排序前:" + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:" + Arrays.toString(arr));
    }

}
