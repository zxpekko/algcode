package leetcode150;

import java.util.*;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:02 2024/8/23
 */
public class DijkstraWithHeap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//节点个数
        int e=scanner.nextInt();//边个数
        for(int i=0;i<N;i++){
            graphAdj[i]=new ArrayList<>();
        }
        for(int i=0;i<e;i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            addEdge(u,v,w);
        }
        dijkstra(0);
        //shortest中0到n-1元素即为到源点0的最短距离。
    }
    static int N=100010;
    static List<Edge>[] graphAdj=new ArrayList[N];
    static int[] shortest=new int[N];
    static boolean[] visited=new boolean[N];
    static class Edge{
        int to;
        int weight;
        Edge(int to,int weight){
            this.to=to;
            this.weight=weight;
        }
    }
    public static void dijkstra(int source){
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        priorityQueue.offer(new int[]{source,0});
        Arrays.fill(shortest,Integer.MAX_VALUE);
        shortest[source]=0;
        while (!priorityQueue.isEmpty()){
            int[] poll = priorityQueue.poll();
            int node=poll[0];
            int distance=poll[1];
            if(visited[node])
                continue;
            visited[node]=true;
            for(Edge edge:graphAdj[node]){
                int to = edge.to;
                int weight = edge.weight;
                if(distance+weight<shortest[to]){
                    shortest[to]=distance+weight;
                    priorityQueue.offer(new int[]{to,shortest[to]});
                }
            }
        }
    }
    public static void addEdge(int u,int v,int w){
        graphAdj[u].add(new Edge(v,w));
        graphAdj[v].add(new Edge(u,w));
    }
}