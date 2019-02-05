package cn.itcast.hash;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @author:fudingcheng
 * @date:2019-02-03
 * @description:
 */
public class HashTable {

    private Info[] arr;

    public HashTable() {
        arr = new Info[100];
    }

    public HashTable(int maxSize) {
        arr = new Info[maxSize];
    }

    /**
     * 插入数据
     *
     * @param info
     */
    public void insert(Info info) {
        //获得关键字的Hash值
        int hashCode = hashCode(info.getKey());
        //如果当前的位置已经占用,并且值不为空
        while (arr[hashCode] != null && arr[hashCode].getName() != null) {
            //进行递加
            ++hashCode;
            //循环
            hashCode %= arr.length;
        }
        arr[hashCode] = info;
    }

    /**
     * 查找数据
     *
     * @param key
     * @return
     */
    public Info find(String key) {
        int hashCode = hashCode(key);
        while (arr[hashCode] != null) {
            if (arr[hashCode].getKey().equals(key)) {
                return arr[hashCode];
            }
            ++hashCode;
            hashCode %= arr.length;
        }
        return null;
    }

    public Info delete(String key) {
        int hashCode = hashCode(key);
        while (arr[hashCode] != null) {
            if (arr[hashCode].getKey().equals(key)) {
                Info info = arr[hashCode];
                info.setName(null);
                return info;
            }
        }
        return null;
    }

    @Test
    public void test() {
        HashTable hashTable = new HashTable();
        Info info1 = new Info("a", "zs");
        Info info2 = new Info("ct", "lisi");
        Info info3 = new Info("299", "ww");
        hashTable.insert(info1);
        hashTable.insert(info2);
        hashTable.insert(info3);

        System.out.println(hashTable.find(info1.getKey()).getName());
        System.out.println(hashTable.find(info2.getKey()).getName());
        System.out.println(hashTable.find(info3.getKey()).getName());

        System.out.println(hashTable.delete(info3.getKey()));

        System.out.println(hashTable.find(info3.getKey()).getName());
    }


    /**
     * 获得key的Hash值
     *
     * @param key
     * @return
     */
    public int hashCode(String key) {
        /**
         * 这种方式进行转换,如果key='abc' || 'acb' || 'cba'
         * 那么这三个不同的key会计算出相同的hashCode值,造成数据的被覆盖!
         */
//        int hashVal = 0;
//        for (int i = key.length() - 1; i >= 0; i--) {
//            int letter = key.charAt(i) - 96;
//            hashVal += letter;
//        }
//        return hashVal;

        BigInteger hashVal = new BigInteger("0");
        BigInteger pow27 = new BigInteger("1");
        for (int i = key.length() - 1; i >= 0; i--) {
            int letter = key.charAt(i) - 96;
            BigInteger letterB = new BigInteger(String.valueOf(letter));
            hashVal = hashVal.add(letterB.multiply(pow27));
            pow27 = pow27.multiply(new BigInteger(String.valueOf(27)));
        }
        return hashVal.mod(new BigInteger((String.valueOf(arr.length)))).intValue();
    }


}
