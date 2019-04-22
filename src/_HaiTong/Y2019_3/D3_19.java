package _HaiTong.Y2019_3;

import java.util.*;

public class D3_19{

    private static int[] array = {1,3,10,23,25,33,41};

    public static void main(String[] args) {
        /*有一个已经排好序的数组{1,3,10,23,25,33,41}。现输入一个数，要求按原来的规律将它插入数组中。
        要求：插入数组要用方法完成。当插入的元素大于最大的数则不插入。例如 插入8 输出数组顺序为：1,3,8,10,23,25,33,41*/
        Scanner input = new Scanner(System.in);
        System.out.println("Before array:");
        for (int a:array ) {
            System.out.print(a+" ");
        }
        System.out.println("\n Input a number plug into array :");
        int x = input.nextInt();

        int[] NewArray  = AddArray(array,x);

        System.out.println("After array:");
        for (int a:NewArray ) {
            System.out.print(a+" ");
        }
    }

    public static int[] AddArray(int[] array,int x){
        int i,j,l=array.length;
        if(x > array[l-1]){
            System.out.println("Too Big!");
            return null;
        }else{
            array = Arrays.copyOf(array,l+1);
            for(i = 0;i<l;i++){
                if(x<=array[i]){
                    for(j=l;j>i;j--)
                        array[j] = array[j-1];
                    array[i] = x;
                    return array;
                }
            }
        }
        return null;
    }
}
