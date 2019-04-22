package July;

import java.util.ArrayList;
import java.util.List;

public class Day7_11 {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int money = 0;
        int i = 0;
        while( i< prices.length-1){
            int diff = prices[i+1] - prices[i];
            if(diff>0){
                money+=diff;
            }
            ++i;
        }
        System.out.println(prices.length);
        System.out.println(money);

        }
}
