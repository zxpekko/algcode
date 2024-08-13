package interview;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:01 2024/8/10
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T=scanner.nextInt();
//        int[] ints = new int[T];
//        int index=0;
        while (T-->0){
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            int x=scanner.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            int minCost=Math.min(n*x,k*find(arr));
            for(int i=0;i<=n;i++){
                int cost=i*x;
                boolean[] present=new boolean[n+1];
                for(int j=i;j<n;j++){
                    if(arr[j]<=n){
                        present[arr[j]]=true;
                    }
                }
                int mex=0;
                while (mex<=n&&present[mex]){
                    mex++;
                }
                cost+=k*mex;
                minCost=Math.min(minCost,cost);
            }
            System.out.println(minCost);
//            ints[index++]=minCost;
        }
//        for(int i=0;i<ints.length;i++)
//            System.out.println(ints[i]);
    }
    public static int find(int[] arr){
        int n=arr.length;
        boolean[] present=new boolean[n+1];
        for(int num:arr){
            if(num>=0&&num<=n){
                present[num]=true;
            }
        }
        for(int i=0;i<=n;i++){
            if(!present[i])
                return i;
        }
        return n+1;
    }
    @Test
    public void test(){
        System.out.println(find(new int[]{0,1,2,3}));
    }
}
