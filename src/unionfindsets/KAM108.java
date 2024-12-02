package unionfindsets;

import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:冗余连接
 * @Date:14:44 2024/11/14
 */
public class KAM108 {
    public static void main(String[] args) {
        deleteAddEdge();
    }
    public static void deleteAddEdge(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        init(n);
        for(int i=0;i<n;i++){
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            if(isSame(s,t)){
                System.out.println(s+" "+t);
                break;
            }
            union(s,t);
        }
    }
    static int[] fa;
    public static void init(int n){
        fa=new int[n+1];
        for(int i=0;i<n;i++)
            fa[i]=i;
    }
    public static boolean isSame(int u,int v){
        return find(u)==find(v);
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