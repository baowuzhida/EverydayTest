package _HaiTong.Y19_4_9.HW1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        String[] arrName = new String[]{"chenhao", "zhangsan", "zhangsan", "chenhao", "lisi", "wangwu", "zhaoliu", "xiaoqiang", "haha"};
        for (String n:arrName) {
            if(hashMap.containsKey(n))
                hashMap.put(n,(int)hashMap.get(n)+1);
            else
                hashMap.put(n,1);
        }
        Set<Map.Entry> ms =hashMap.entrySet();
        for (Map.Entry entry : ms) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }



    }

}
