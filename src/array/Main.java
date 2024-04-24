package array;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:15 2024/4/24
 */
public class Main {
    public static void main(String[] args) {
        int[] x = {0, 6, 43, 39, 189};
        int[] y = {2,67,71,107,140};
        double result = getResult(x, y);
        System.out.println(result);
    }
//    public static int longest(String text1,String text2){
//        int m=text1.length();
//        int n=text2.length();
//        int[][] dp=new int[m+1][n+1];
//        for(int i=1;i<=m;i++){
//            for(int j=1;j<=n;j++){
//                if(text1.charAt(i-1)==text2.charAt(j-1)){
//                    dp[i][j]=dp[i-1][j-1]+1;
//                }
//                else {
//                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1]);
//                }
//            }
//        }
//        return dp[m][n];
//    }
//    static final int N=20000;
//    static long[] length=new long[N];
//    static long n,k;
//    static long l=0;
//    public static boolean check(long x){
//        long ans=0;
//        for(int i=0;i<n;i++){
//            ans+=length[i]/x;
//        }
//        return ans>=k;
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        n=in.nextInt();
//        k=in.nextInt();
//        for(int i=0;i<n;i++){
//            double x=in.nextDouble();
//            length[i]=(long)(x*100);
//            l+=(length[i]);
//        }
//        long s=0,e=l;
//        while (s<e){
//            long mid=(1+s+e)/2;
//            if(mid==0)
//                break;
//            if(check(mid))
//                s=mid;
//            else
//                e=mid-1;
//        }
//        System.out.printf("%.2f",s*1.00/100);
//    }
    public static double getResult(int[] xArray,int[] yArray){
        double min=Double.MAX_VALUE;
        for(int i=0;i<xArray.length;i++){
            for(int j=i+1;j<xArray.length;j++){
                int sum=(xArray[i]-xArray[j])*(xArray[i]-xArray[j])+(yArray[i]-yArray[j])*(yArray[i]-yArray[j]);
                double sqrt = Math.sqrt(sum);
                if(sqrt<min)
                    min=sqrt;
            }
        }
        return min;
    }
}
