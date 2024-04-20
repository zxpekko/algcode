package dynamicprogramming;

import sun.security.jca.GetInstance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:55 2024/3/25
 */
public class ClimbPlus {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n=0,m=0;
//        while (scanner.hasNext()){
//            n=scanner.nextInt();
//            m=scanner.nextInt();
//            break;
//        }
//        int[] dp = new int[n + 1];
//        dp[0]=1;
//        for(int i=0;i<=n;i++){
//            for(int j=1;j<=m;j++){
//                if(j<=i)
//                    dp[i]+=dp[i-j];
//            }
//        }
//        System.out.println(dp[n]);
        String str="1,2,3,4";
        String[] split = str.split(",");
        System.out.println(Arrays.toString(split));
        int[] ints = new int[split.length];
        int index=0;
        for(String str1:split){
            ints[index++]=Integer.parseInt(str1);
        }
        System.out.println(Arrays.toString(ints));

    }
}
