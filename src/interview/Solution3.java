package interview;

import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:30 2024/8/17
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-->0){
            int n = scanner.nextInt();
            for(int i=2;i<=n;i++){
                int gcd = getGCD(n, i);
                if(prime(gcd)){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
    public static int getGCD(int m,int n){
//        int up=Math.min(m,n);
//        for(int i=up;i>=1;i--){
//            if(m%i==0&&n%i==0)
//                return i;
//        }
        int a=Math.max(m,n);
        int b=Math.min(m,n);
        while (b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public static boolean prime(int m){
        if(m==1)
            return false;
        for(int i=2;i<=Math.sqrt(m);i++){
            if(m%i==0)
                return false;
        }
        return true;
    }
}
