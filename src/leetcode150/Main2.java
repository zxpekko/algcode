package leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:34 2024/8/3
 */
public class Main2 {
    static class Item{
        int volume;
        int value;
        Item(int volume,int value){
            this.volume=volume;
            this.value=value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] volumes=new int[n];
        int[] values=new int[n];
        for(int i=0;i<n;i++){
            volumes[i]=scanner.nextInt();
            values[i]=scanner.nextInt();
        }

        boolean[][] incompatible = new boolean[n][n];
        for(int i=0;i<k;i++){
            int a=scanner.nextInt()-1;
            int b=scanner.nextInt()-1;
            incompatible[a][b]=true;
            incompatible[b][a]=true;
        }
        int maxValue=knapsack(n,m,volumes,values,incompatible);
        System.out.println(maxValue);
    }
    private static int knapsack(int n, int m, int[] volumes,int[] values, boolean[][] incompatible){
        int[] dp = new int[m + 1];
        Arrays.fill(dp,0);
        for(int mask=0;mask<(1<<n);mask++){
            int totalVolume=0;
            int totalValue=0;
            boolean valid=true;
            for(int i=0;i<n;i++){
                if((mask&(1<<i))!=0){
                    totalVolume+=volumes[i];
                    totalValue+=values[i];
                    for(int j=i+1;j<n;j++){
                        if((mask&(1<<j))!=0&&incompatible[i][j]){
                            valid=false;
                            break;
                        }
                    }
                    if(!valid)
                        break;
                }
            }
            if(valid&&totalVolume<=m){
                dp[totalVolume]=Math.max(dp[totalVolume],totalValue);
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }
}
//G:\anypackages\java8\bin\java.exe "-javaagent:G:\IntelliJ IDEA 2022.3.1\lib\idea_rt.jar=51067:G:\IntelliJ IDEA 2022.3.1\bin" -Dfile.encoding=UTF-8 -classpath G:\anypackages\java8\jre\lib\charsets.jar;G:\anypackages\java8\jre\lib\deploy.jar;G:\anypackages\java8\jre\lib\ext\access-bridge-64.jar;G:\anypackages\java8\jre\lib\ext\cldrdata.jar;G:\anypackages\java8\jre\lib\ext\dnsns.jar;G:\anypackages\java8\jre\lib\ext\jaccess.jar;G:\anypackages\java8\jre\lib\ext\jfxrt.jar;G:\anypackages\java8\jre\lib\ext\localedata.jar;G:\anypackages\java8\jre\lib\ext\nashorn.jar;G:\anypackages\java8\jre\lib\ext\sunec.jar;G:\anypackages\java8\jre\lib\ext\sunjce_provider.jar;G:\anypackages\java8\jre\lib\ext\sunmscapi.jar;G:\anypackages\java8\jre\lib\ext\sunpkcs11.jar;G:\anypackages\java8\jre\lib\ext\zipfs.jar;G:\anypackages\java8\jre\lib\javaws.jar;G:\anypackages\java8\jre\lib\jce.jar;G:\anypackages\java8\jre\lib\jfr.jar;G:\anypackages\java8\jre\lib\jfxswt.jar;G:\anypackages\java8\jre\lib\jsse.jar;G:\anypackages\java8\jre\lib\management-agent.jar;G:\anypackages\java8\jre\lib\plugin.jar;G:\anypackages\java8\jre\lib\resources.jar;G:\anypackages\java8\jre\lib\rt.jar;G:\IDEAnew\algcode\out\production\leetcode;C:\Users\Lenovo1\.m2\repository\junit\junit\4.13.1\junit-4.13.1.jar;C:\Users\Lenovo1\.m2\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar leetcode150.Main2
//        3
//        100
//        2
//        15
//        19
//        20
//        30
//        15
//        19
//        1
//        2
//        2
//        3
//        38
//
//        Process finished with exit code 0
