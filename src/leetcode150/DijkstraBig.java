package leetcode150;

/**
 * @Author:zxp
 * @Description:处理大规模的单源最短路径问题，堆优化的迪杰斯特拉算法
 * @Date:17:16 2024/8/22
 */
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

public class DijkstraBig {

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static final int N = 200010;
    static int n; // 点的数量
    static List<Edge>[] graph = new ArrayList[N]; // 图的邻接表表示
    static int[] dist = new int[N]; // 存储所有点到1号点的距离
    static boolean[] st = new boolean[N]; // 存储每个点的最短距离是否已确定

    // 求1号点到n号点的最短距离，如果不存在，则返回-1
    public static int dijkstra() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        heap.offer(new int[]{0, 1}); // {距离, 节点编号}

        while (!heap.isEmpty()) {
            int[] t = heap.poll();
            int ver = t[1], distance = t[0];

            if (st[ver]) continue;
            st[ver] = true;

            for (Edge edge : graph[ver]) {
                int j = edge.to, w = edge.weight;
                if (dist[j] > distance + w) {
                    dist[j] = distance + w;
                    heap.offer(new int[]{dist[j], j});
                }
            }
        }

        return dist[n] == Integer.MAX_VALUE ? -1 : dist[n];
    }

    // 添加边到图的邻接表
    public static void addEdge(int a, int b, int c) {
        graph[a].add(new Edge(b, c));
        graph[b].add(new Edge(a, c)); // 无向图，添加反向边
    }

    public static void main(String[] args) {
//        List<Edge>[] arrayLists = new ArrayList[200010];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            addEdge(a, b, c);
        }

        dijkstra();

        long sum = 0;
        while (q-- > 0) {
            int idx = scanner.nextInt();
            sum += dist[idx];
        }

        System.out.println(sum * 2);

        scanner.close();
    }
}
