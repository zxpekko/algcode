package unionfindsets;

import com.sun.org.apache.bcel.internal.generic.FSUB;

import java.util.HashSet;

/**
 * @Author:zxp
 * @Description:有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 示例 2：
 *
 *
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 * @Date:14:01 2024/2/15
 */
public class FindCircleNum {
    public static void main(String[] args) {
        FindCircleNum findCircleNum = new FindCircleNum();
        System.out.println(findCircleNum.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        FindCircleNumⅡ findCircleNumⅡ = new FindCircleNumⅡ();
        System.out.println(findCircleNumⅡ.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }
    int[] fa;
    public int findCircleNum(int[][] isConnected){
        int n=isConnected.length;
        fa=new int[n];
        init();
        for(int i=0;i<isConnected.length;i++)
            unionSet(isConnected[i]);
        HashSet<Integer> hashSet=new HashSet<>();
        for(int i=0;i< fa.length;i++){
            if(!hashSet.contains(find(i)))
                hashSet.add(find(i));
        }
        return hashSet.size();
    }
    public void init(){
        for(int i=0;i<fa.length;i++)
            fa[i]=i;
    }
    public int find(int i){
        if(fa[i]==i)
            return i;
        else {
            fa[i]=find(fa[i]);
            return fa[i];
        }
    }
    public void union(int u,int v){
        u=find(u);
        v=find(v);
        if(u==v)
            return;
        fa[u]=v;
    }
    public void unionSet(int[] subConnected){
        int startIndex=0;
        for(startIndex=0;startIndex< subConnected.length;startIndex++){
            if(subConnected[startIndex]==1)
                break;
        }
        for(int i=startIndex+1;i< subConnected.length;i++){
            if(subConnected[i]==1)
                union(startIndex,i);
        }
    }
}
class FindCircleNumⅡ{
    int[] fa;
    public int findCircleNum(int[][] isConnected){
        int n=isConnected.length;
        fa=new int[n];
        init();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j&&isConnected[i][j]==1){
                    union(i,j);
                }
            }
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0;i<n;i++){
            if(!hashSet.contains(find(i)))
                hashSet.add(find(i));
        }
        return hashSet.size();
    }
    public void init(){
        for(int i=0;i<fa.length;i++)
            fa[i]=i;
    }
    public int find(int i){
        if(fa[i]==i)
            return i;
        else {
            fa[i]=find(fa[i]);
            return fa[i];
        }
    }
    public void union(int u,int v){
        u=find(u);
        v=find(v);
        if(u==v)
            return;
        fa[v]=u;
    }
}
