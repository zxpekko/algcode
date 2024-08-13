package interview;

import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:21 2024/8/10
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count=0;
        for(int i=1;i<=n;i++){
            if(getSum(i)==getBaseSum(i))
                count++;
        }
        System.out.println(count);
    }
    public static int getSum(int n){
        int cur=0;
        int count=0;
        while (n>0){
            cur=n%10;
            count+=cur;
            n/=10;
        }
        return count;
    }
    public static int getBaseSum(int n){
        int count=0;
        while (n>0){
            if(n%2==1)
                count++;
            n/=2;
        }
        return count;
    }
}
