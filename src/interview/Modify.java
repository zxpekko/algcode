package interview;

import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:43 2024/8/10
 */
public class Modify {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int n=scanner.nextInt();
            int[] b = new int[n];
            for(int i=0;i<n;i++){
                b[i]=scanner.nextInt();
            }
            System.out.println(minOperations(b,n));
        }
    }
    public static int minOperations(int[] b,int n){
        int cur=0;
        int oprations=0;
        while (true){
            int maxValue=0;
            for(int i=0;i<n;i++){
                maxValue=Math.max(maxValue,b[i]);
            }
            if(maxValue==0){
                break;
            }
            boolean hasOdd=false;
            for(int i=0;i<n;i++){
                if(b[i]%2!=0){
                    hasOdd=true;
                    break;
                }
            }
            if(hasOdd){
                for(int i=0;i<n;i++){
                    if(b[i]%2!=0){
                        b[i]-=1;
                    }
                }
                oprations++;
                cur++;
            }
            else {
                for(int i=0;i<n;i++){
                    b[i]/=2;
                }
                oprations++;
            }
        }
        return oprations-cur;
    }
}
