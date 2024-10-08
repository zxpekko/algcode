package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:49 2024/7/27
 */
public class Dijkstra {
    public int[] dijkstra(int[][] adj,int source){
        int n=adj.length;
        int[] shortest = new int[n];
        Arrays.fill(shortest,Integer.MAX_VALUE/2);
        shortest[source]=0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            int k=-1;
            for(int j=0;j<n;j++){
                if(!visited[j]&&(k==-1||shortest[j]<shortest[k]))
                    k=j;
            }
            visited[k]=true;
            for(int m=0;m<n;m++){
                if(adj[k][m]!=Integer.MAX_VALUE&&shortest[k]+adj[k][m]<shortest[m])
                    shortest[m]=shortest[k]+adj[k][m];
            }
        }
        return shortest;
    }
}
class DijkstraⅠ{
    public int[] dijkstra(int[][] adj,int source){
        int[] shortest = new int[adj.length];
        Arrays.fill(shortest,Integer.MAX_VALUE);
        shortest[source]=0;
        boolean[] visited = new boolean[adj.length];
        for(int i=0;i<adj.length;i++){
            int k=-1;
            for(int j=0;j<adj.length;j++){
                if(!visited[j]&&(k==-1||shortest[j]<shortest[k]))
                    k=j;
            }
            visited[k]=true;
            for(int m=0;m<adj.length;m++){
                if(adj[k][m]!=Integer.MAX_VALUE&&shortest[k]+adj[k][m]<shortest[m])
                    shortest[m]=shortest[k]+adj[k][m];
            }
        }
        return shortest;
    }
}