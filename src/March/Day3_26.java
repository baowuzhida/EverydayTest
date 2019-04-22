package March;

import java.util.HashMap;

public class Day3_26 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,7,9,11};
        int target = 9;
        int[] result = new int[2];
        HashMap<Integer,Integer> maps = new HashMap<Integer,Integer>();
        for(int i =0;i<nums.length;i++){
            if(maps.containsKey(target-nums[i])){
                result[0] = maps.get(target-nums[i]);
                result[1] = i;
                System.out.println(result[0]+" + "+result[1]);
                break;
            }
            maps.put(nums[i],i);
        }
    }
}

/*
* 1. 两数之和
题目描述提示帮助提交记录社区讨论阅读解答
给定一个整数数列，找出其中和为特定值的那两个数。

你可以假设每个输入都只会有一种答案，同样的元素不能被重用。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
* */
