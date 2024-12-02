package unionfindsets;

import java.util.EventListener;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:;现在有若干家族图谱关系，给出了一些亲戚关系，如Mary和Tom是亲戚，Tom和Ben是亲戚等等。从这些信息中，你可以推
 * 导出Marry和Ben是亲戚。请写一个程序，对于我们的关于亲戚关系的提问，以最快速度给出答案。
 * 【输入格式】
 * 第一部分是以N,M开始。N为人数(1<=N<=20000),这些人的编号为1,2,3.N。下面有M行(1<=M<=1000000),每行有两个数a,b,表
 * 示a和b是亲戚。
 * 第二部分是以O开始。以下O行有O个询问(1<=0<=1000000),每行为c.d,表示询问c和d是否为亲戚
 * 【输出样例】
 * 【输入样例】
 * 10 7
 * YES
 * 对于询问c.d.输出一行:若c.d为亲戚，则输出"YES",否则输出"NO"
 * NO
 * 2 4
 * 5 7
 * YES
 * 13
 * 89
 * 12
 * 【输出格式】
 * 56
 * C
 * 2
 * m
 * 3 4
 * 7 10
 * 89
 * @Date:18:59 2024/11/7
 */
public class isRelatives {
    public static void main(String[] args) {
        judge();
    }
    static int[] fa;
    public static void judge(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        init(n);
        for(int i=0;i<m;i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            union(a-1,b-1);
        }
        int q = scanner.nextInt();
        for(int i=0;i<q;i++){
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            if(fa[c-1]==fa[d-1])
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
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
            fa[i]=find(fa[i]);//路径压缩
            return fa[i];
        }
    }
    public static void union(int i,int j){
        int u=find(i);
        int v=find(j);
        if(u==v)
            return;
        fa[u]=v;
    }
}
