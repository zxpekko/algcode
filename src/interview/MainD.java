package interview;

import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:30 2024/9/3
 */
public class MainD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i=0;i<T;i++){
            int n = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int[] ints = get(n, l, r);
            if(ints[0]==-1)
                System.out.println(-1);
            else {
                System.out.print(ints[0]+" ");
                System.out.println(ints[1]);
            }
        }
    }
    public static int[] get(int kuai,int left,int right){
        int[] result = new int[2];
        int cur=(left+kuai-1)/kuai;
        if(cur*kuai>right){
            result[0]=-1;
            result[1]=-1;
            return result;
        }
        result[0]=cur;
        int rightCur=right/kuai;
        result[1]=rightCur;
        return result;
    }
}
