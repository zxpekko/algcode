import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:11 2024/7/6
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        if(n<=0){
            System.out.println(0);
            return;
        }
        else if(n==1){
            System.out.println(1);
            return;
        }
        else if(n==2){
            System.out.println(2);
            return;
        }
        else if(n==3){
            System.out.println(4);
            return;
        }
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        System.out.println(dp[n]);
    }
}
