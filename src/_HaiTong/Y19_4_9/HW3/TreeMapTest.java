package _HaiTong.Y19_4_9.HW3;

import java.util.Comparator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int a = random.nextInt(6) + 30;
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else
                map.put(a, 1);
        }
        int max=0;
        int maxkey=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()>max) {
                max = entry.getValue();
                maxkey = entry.getKey();
            }
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        System.out.println("Max is "+maxkey+" MaxValue is "+max);
    }
}
