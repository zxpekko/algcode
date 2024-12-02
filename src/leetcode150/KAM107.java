package leetcode150;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:23 2024/11/8
 */
public class KAM107 {
    public static void main(String[] args) {
        judgeSourceToDesc();
    }
    public static void judgeSourceToDesc(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m= scanner.nextInt();
        init(n);
        for(int i=0;i<m;i++){
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            union(s-1,t-1);
        }
//        System.out.println(Arrays.toString(fa));
        int source = scanner.nextInt();
        int desc = scanner.nextInt();
        if(find(source-1)==find(desc-1))
            System.out.println("1");
        else System.out.println("0");
    }
    static int[] fa;
    public static void init(int n){
        fa=new int[n];
        for(int i=0;i<n;i++){
            fa[i]=i;
        }
    }
    public static int find(int i){
        if(fa[i]==i)
            return i;
        else {
            fa[i]=find(fa[i]);
            return fa[i];
        }
    }
    public static void union(int u,int v){
        u=find(u);
        v=find(v);
        if(u==v)
            return;
        fa[u]=v;
    }
}