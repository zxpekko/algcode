package unionfindsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @Author:zxp
 * @Description:有向图的冗余连接，去除冗余连接的边，如果有多条，删除最后出现的那条。
 * @Date:12:05 2024/11/15
 */
public class KAM109 {
    public static void main(String[] args) {
        List<int[]> edges=new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inDegrees = new int[n + 1];
        for(int i=0;i<n;i++){
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            inDegrees[t]++;
            edges.add(new int[]{s,t});
        }
        List<Integer> removeEdges=new ArrayList<>();//入度为2的即将删除的可能的两条边
        for(int i=n-1;i>=0;i--){
            if(inDegrees[edges.get(i)[1]]==2)
                removeEdges.add(i);
        }
        if(removeEdges.size()>0){
            if(isTreeAfterRemove(edges,removeEdges.get(0))){
                System.out.println(edges.get(removeEdges.get(0))[0]+" "+edges.get(removeEdges.get(0))[1]);
            }
            else
                System.out.println(edges.get(removeEdges.get(1))[0]+" "+edges.get(removeEdges.get(1))[1]);
            return;
        }
        removeCircle(edges);
    }
    static int[] fa;
    public static void removeCircle(List<int[]> edges){
        init(edges.size());
        for(int i=0;i<edges.size();i++){
            if(same(edges.get(i)[0],edges.get(i)[1])){
                System.out.println(edges.get(i)[0]+" "+edges.get(i)[1]);
                break;
            }
            union(edges.get(i)[0],edges.get(i)[1]);
        }
    }
    public static boolean same(int u,int v){
        return find(u)==find(v);
    }
    public static boolean isTreeAfterRemove(List<int[]> edges,int deleteEdge){
        init(edges.size());
        for(int i=0;i<edges.size();i++){
            if(i==deleteEdge)
                continue;
            if(same(edges.get(i)[0],edges.get(i)[1]))
                return false;
            union(edges.get(i)[0],edges.get(i)[1]);
        }
        return true;
    }
    public static void init(int n){
        fa=new int[n+1];
        for(int i=0;i<=n;i++)
            fa[i]=i;
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