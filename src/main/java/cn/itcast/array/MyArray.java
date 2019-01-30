package cn.itcast.array;

/**
 * @author:fudingcheng
 * @date:2019-01-21
 * @description:
 */
public class MyArray {

    private long[] arr;
    /**
     * 元素个数
     */
    private int elements;


    public MyArray() {
        arr = new long[50];
    }

    public MyArray(int len) {
        arr = new long[len];
    }

    /**
     * 增加元素
     *
     * @param value
     */
    public void insert(long value) {
        int i;
        for (i = 0; i < elements; i++) {
            if (arr[i] > value) {
                break;
            }
        }

        for (int j = elements; j>i ; j--) {
            arr[j]=arr[j-1];
        }
        arr[i]=value;
        elements++;
    }

    /**
     * 删除某个value
     *
     * @param value
     */
    public void deleteByValue(long value) {
        //获得value的索引
        int index = search(value);

        //删除index对应的值
        delelteByIndex(index);
    }

    /**
     * 删除某个index对应的value
     *
     * @param index
     */
    public void delelteByIndex(int index) {
        //判断index是否合法
        checkIndex(index);

        //从index开始遍历到最后一个数字
        for (int j = index; j < elements; j++) {
            //将index开始后的值往前移动
            arr[j] = arr[j + 1];
        }
        //arr的数据总数-1
        elements--;

    }


    /**
     * 修改index的值为value
     *
     * @param index
     * @param value
     */
    public void update(int index, long value) {
        checkIndex(index);
        arr[index] = value;
    }

    /**
     * 查找某个索引对应的value
     *
     * @param index
     * @return
     */
    public long get(int index) {
        checkIndex(index);
        return arr[index];
    }

    /**
     * 查找某个值的索引
     *
     * @param value
     * @return
     */
    public int search(long value) {
        //查找value的对应的索引
        int index = -1;
        for (int i = 0; i < elements; i++) {
            if (arr[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * 二分查找
     *
     * @param value
     * @return
     */
    public int binarySearch(long value) {
        //中间位置
        int middle = 0;
        //查找结束位置
        int begin = 0;
        //查找结束
        int last = elements;
        //目标元素索引
        int index = -1;

        while (true) {
            //计算中间值索引
            middle = (begin + last) / 2;
            //如果中间值刚好等于value,则返回middle
            if (arr[middle] == value) {
                index = middle;
                return index;
            } else if (begin > last) {  //退出条件
                break;
            } else {
                //如果中间值大于value,重新查找前半段
                if (arr[middle] > value) {
                    last = middle - 1;
                } else {  //如果中间值小于value,重新查找前半段
                    begin = middle + 1;
                }
            }
        }
        return index;
    }


    /**
     * 遍历
     */
    public void display() {
        System.out.print("[ ");
        for (int i = 0; i < elements; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
    }

    /**
     * 检查index是否合法
     * @param index
     */
    private void checkIndex(int index) {
        if (index < 0 || index > elements - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

}
