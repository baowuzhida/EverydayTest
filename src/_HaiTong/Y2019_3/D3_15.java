package _HaiTong.Y2019_3;

public class D3_15 {

    public static void main(String[] args) {
        // 有80个小朋友手拉手围成一圈，由第一个小朋友开始从1开始数，数到3的小朋友退出，再从后面的小朋友从1数起，数到3的再退出，以此游戏下去，问最后剩下哪个小朋友？
        boolean[] kids = new boolean[80];
        int all = 80,count = 0,i = 0;
        for(int a=0;a<kids.length;a++) {
            kids[a] = true;
        }
        while(all>1){
            if(kids[i]){
                count ++;
                if(count==3){
                    count=0;
                    kids[i]=false;
                    all--;
                }
            }
            i++;
            if(i==80)
                i=0;
        }
        for(int j=0;j<80;j++)
            if(kids[j])
                System.out.println("最后剩下的第"+(j+1)+"个小朋友");
    }
}
