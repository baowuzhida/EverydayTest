package March;

public class Day3_27 {
   /* public static void main(String[] args) {
        long x = -1534236469;
        long newx=0;
        if(x > Math.pow(2,31) || x < -Math.pow(2,31)){
            newx = 0;
        }
        else {
            while(x!=0){
                newx = newx * 10 + x % 10;
                x =x / 10;

            }
            if(newx > Math.pow(2,31) || newx < -Math.pow(2,31)){
                newx = 0;
            }
        }
        System.out.println(newx);
    }方法1*/

    public static void main(String[] args) {
        int x = -1534236469;
        String str = String.valueOf(x);
//        int[] nums;
//        if(x>0){
//            nums = new int[str.length()];
//        }else {
//            nums = new int[str.length()-1];
//        }
        int[] nums = new int[10];

        long newx = 0;
        if(x > Math.pow(2,31) || x < -Math.pow(2,31)){
            newx = 0;
        }
        else {
            int i =0;
            while(x!=0){
                nums[i] = x % 10;
                x =x / 10;
                i++;
            }
            for (i = 0;i<nums.length;i++) {
                newx = newx*10 + nums[i];
            }
            System.out.println(newx);
            if(newx > Math.pow(2,31) || newx < -Math.pow(2,31)){
                newx = 0;
            }
        }
        System.out.println((int)newx);
    }
}

/*
* 7. 颠倒整数
题目描述提示帮助提交记录社区讨论阅读解答
给定一个范围为 32 位 int 的整数，将其颠倒。

例 1:
输入: 123
输出:  321


例 2:
输入: -123
输出: -321


例 3:
输入: 120
输出: 21

注意:

假设我们的环境只能处理 32 位 int 范围内的整数。根据这个假设，如果颠倒后的结果超过这个范围，则返回 0。
* */
