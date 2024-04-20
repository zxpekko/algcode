package array;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:36 2024/4/18
 */
public class Dijkstra {
    public static void main(String[] args) {
        int[][] adj = new int[4][4];
        for(int i=0;i<adj.length;i++){
            Arrays.fill(adj[i],Integer.MAX_VALUE/2);
        }
        adj[0][1] = 2;
        adj[1][0]=2;
        adj[0][2] = 1;
        adj[2][0]=1;
        adj[1][2] = 5;
        adj[2][1]=5;
        adj[1][3] = 2;
        adj[3][1]=2;
        Dijkstra dijkstra = new Dijkstra();
        int[] dijkstra1 = dijkstra.dijkstra(adj, 0);
        System.out.println(Arrays.toString(dijkstra1));
    }
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
                if(shortest[k]+adj[k][m]<shortest[m])
                    shortest[m]=shortest[k]+adj[k][m];
            }
        }
        return shortest;
    }
}
