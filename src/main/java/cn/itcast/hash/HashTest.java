package cn.itcast.hash;

import cn.itcast.hash.openAddress.HashTable;
import org.junit.Test;

/**
 * @author:fudingcheng
 * @date:2019-02-06
 * @description:
 */
public class HashTest {

    @Test
    public void test() {
        //HashTable hashTable = new HashTable();
        cn.itcast.hash.linkedList.HashTable hashTable = new cn.itcast.hash.linkedList.HashTable();
        Info info1 = new Info("a", "zs");
        Info info2 = new Info("ct", "lisi");
        Info info3 = new Info("299", "ww");
        hashTable.insert(info1);
        hashTable.insert(info2);
        hashTable.insert(info3);

        System.out.println(hashTable.find(info1.getKey()).getName());
        System.out.println(hashTable.find(info2.getKey()).getName());
        System.out.println(hashTable.find(info3.getKey()).getName());

        //System.out.println(hashTable.delete(info3.getKey()));

        //System.out.println(hashTable.find(info3.getKey()).getName());
    }

}
