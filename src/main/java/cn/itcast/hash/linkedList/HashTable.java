package cn.itcast.hash.linkedList;

import cn.itcast.hash.Info;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @author:fudingcheng
 * @date:2019-02-06
 * @description: 链表法实现HashTable
 */
public class HashTable {

    public LinkList[] arr;

    public HashTable() {
        arr = new LinkList[100];
    }

    public HashTable(int maxSize) {
        arr = new LinkList[maxSize];
    }


    /**
     * 插入数据
     *
     * @param info
     */
    public void insert(Info info) {
        String key = info.getKey();
        int hashCode = hashCode(key);
        if (arr[hashCode] == null) {
            arr[hashCode] = new LinkList();
        }
        arr[hashCode].insertFirst(info);
    }

    /**
     * 查找数据
     *
     * @param key
     * @return
     */
    public Info find(String key) {
        int hashCode = hashCode(key);
        return arr[hashCode].find(key).info;
    }

    /**
     * 删除数据
     *
     * @param key
     * @return
     */
    public Info delete(String key) {
        int hashCode = hashCode(key);
        return arr[hashCode].delete(key).info;
    }

    /**
     * 获得key的Hash值
     *
     * @param key
     * @return
     */
    public int hashCode(String key) {

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
