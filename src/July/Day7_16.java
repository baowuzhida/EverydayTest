package July;

public class Day7_16 {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 8, 3, 5, 3, 7};
        int flag = 0;
        for(int i = 0 ;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    flag = 1;
                    break;
                }
            }
        }
        if(flag==1){
            System.out.println("Have");
        }else
            System.out.println("no");

    }
}
