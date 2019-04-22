package July;

public class Day7_12 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int[] nnums = new int[nums.length];
        for (int i = 0; i < nums.length - k; i++) {
            nnums[i + k] = nums[i];
        }
        for (int j = 0; j < k; j++) {
            nnums[j] = nums[nums.length - k + j];
        }

        for (int i = 0; i < nnums.length; i++) {//循环数组
            System.out.println(nnums[i]);//输出数组元素。
        }
    }
}
