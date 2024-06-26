package graphtheory;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:实现Dijkstra算法
 * @Date:21:18 2024/1/30
 */
public class Dijkstra {
    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
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
        int[] dijkstra1 = dijkstra.dijkstra(adj, 0);

        System.out.println(Arrays.toString(dijkstra1));
        DijkstraⅡ dijkstraⅡ = new DijkstraⅡ();
        int[] dijkstra2 = dijkstraⅡ.dijkstra(adj, 0);
        System.out.println(Arrays.toString(dijkstra2));
        DijkstraⅢ dijkstraⅢ = new DijkstraⅢ();
        int[] dijkstra3 = dijkstraⅢ.dijkstra(adj, 0);
        System.out.println(Arrays.toString(dijkstra3));
        DijkstraⅣ dijkstraⅣ = new DijkstraⅣ();
        int[] dijkstra4 = dijkstraⅣ.dijkstra(adj, 0);
        System.out.println(Arrays.toString(dijkstra4));
        DijkstraⅤ dijkstraⅤ = new DijkstraⅤ();
        int[] dijkstra5 = dijkstraⅤ.dijkstra(adj, 0);
        System.out.println(Arrays.toString(dijkstra5));
        DijkstraⅥ dijkstraⅥ = new DijkstraⅥ();
        int[] dijkstra6 = dijkstraⅥ.dijkstra(adj, 0);
        System.out.println(Arrays.toString(dijkstra6));
        DijkstraⅦ dijkstraⅦ = new DijkstraⅦ();
        int[] dijkstra7 = dijkstraⅦ.dijkstra(adj, 0);
        System.out.println(Arrays.toString(dijkstra7));
    }
    public int[] dijkstra(int[][] adj,int source){
        int n= adj.length;
        boolean[] visited = new boolean[n];
        int[] shortest = new int[n];
        Arrays.fill(shortest,Integer.MAX_VALUE/2);
        shortest[source]=0;
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
class DijkstraⅡ{
    public int[] dijkstra(int[][] adj,int source){
        int n=adj.length;
        int[] shortest = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(shortest,Integer.MAX_VALUE/2);
        shortest[source]=0;
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
class DijkstraⅢ{
    public int[] dijkstra(int[][] adj,int source){
        int n=adj.length;
        int[] shortest = new int[n];
        Arrays.fill(shortest, Integer.MAX_VALUE/2);
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
class DijkstraⅣ{
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
class DijkstraⅤ{
    public int[] dijkstra(int[][] adj,int source){
        int n=adj.length;
        int[] shortest = new int[n];
        Arrays.fill(shortest,Integer.MAX_VALUE/2);
        shortest[source]=0;//距离源点的距离，首先最近的一定是它自己
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            int k=-1;//记录的是距离源点最近的节点
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
class DijkstraⅥ{
    public int[] dijkstra(int[][] adj,int source){
        int n=adj.length;
        int[] shortest = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(shortest,Integer.MAX_VALUE/2);
        shortest[source]=0;
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
class DijkstraⅦ{
    public int[] dijkstra(int[][] adj,int source){
        int[] shortest = new int[adj.length];
        boolean[] visited = new boolean[adj.length];
        Arrays.fill(shortest,Integer.MAX_VALUE/2);
        shortest[source]=0;
        for(int i=0;i<adj.length;i++){
            int k=-1;
            for(int j=0;j< adj.length;j++){
                if(!visited[j]&&(k==-1||shortest[j]<shortest[k]))
                    k=j;
            }
            visited[k]=true;
            for(int m=0;m<adj.length;m++){
                if(shortest[k]+adj[k][m]<shortest[m])
                    shortest[m]=shortest[k]+adj[k][m];
            }
        }
        return shortest;
    }
}

