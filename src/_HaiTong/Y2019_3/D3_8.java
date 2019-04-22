package _HaiTong.Y2019_3;

import java.util.ArrayList;

public class D3_8 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int a,b=0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(b<nums2.length){
            for(a=0;a<nums1.length;a++){
                if(nums1[a]==nums2[b]){
                    list.add(nums1[a]);
                    System.out.println(nums1[a]+"\t");
                    break;
                }
            }
            b++;
        }
        int[] nums3 = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums3[i] = list.get(i);
            System.out.println(nums3[i]);
        }
    }
}
