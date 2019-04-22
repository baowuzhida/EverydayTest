package April;

import java.util.Arrays;

public class Day4_22 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,3,5};
        if (nums.length == 0)
            System.out.println("0");
        //判断无输入
        int number = 0;//标记计数
        for (int i=0; i < nums.length ; i++) {
            if ( nums[i] != nums[number] ) {
                number++;
                nums[number] = nums[i];
            }
        }
        number+=1; //标记+1即为数字个数
        System.out.println(number);
    }
}
/*
* public static void main(String[] args) {
        Day4_22 lt = new Day4_22();
        int []num = {0,1,1,2,2,3,3,4};
        System.out.println(lt.removeDuplicates(num));
    }

    // 扔进去AC了他
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        //判断无输入
        int number = 0;//标记计数
        for (int i=0; i < nums.length ; i++) {
            if ( nums[i] != nums[number] ) {
                number++;
                nums[number] = nums[i];
            }
        }
        number+=1; //标记+1即为数字个数
        return number;
    }
* */
