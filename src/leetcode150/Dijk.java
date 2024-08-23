package leetcode150;

import java.util.*;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:05 2024/8/21
 */
public class Dijk {
    public static void main(String[] args) {

    }

    public int[] dij(int[][] adj, int source) {
        int[] shortest = new int[adj.length];
        Arrays.fill(shortest, Integer.MAX_VALUE / 2);
        shortest[source] = 0;
        boolean[] visited = new boolean[adj.length];
        for (int i = 0; i < adj.length; i++) {
            int k = -1;
            for (int j = 0; j < adj.length; j++) {
                if (!visited[j] && (k == -1 || shortest[j] < shortest[k]))
                    k = j;
            }
            visited[k] = true;
            for (int m = 0; m < adj.length; m++) {
                if (shortest[k] + adj[k][m] < shortest[m])
                    shortest[m] = shortest[k] + adj[k][m];
            }
        }
        return shortest;
    }

    public int[] dijHeap(HashMap<Integer, Map<Integer, Integer>> adj, int source, int n) {
        int[] shortest = new int[n];
        Arrays.fill(shortest, Integer.MAX_VALUE / 2);
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        priorityQueue.offer(new int[]{0, 0});
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            shortest[poll[0]] = poll[1];
            if(visited[poll[0]])
                continue;
            visited[poll[0]]=true;
            Map<Integer, Integer> integerIntegerMap = adj.get(poll[0]);
            for (Map.Entry<Integer, Integer> entry : integerIntegerMap.entrySet()) {
                Integer node = entry.getKey();
                Integer value = entry.getValue();
                if (!visited[node]) {
                    if (shortest[poll[0]] + value < shortest[node]) {
                        shortest[node] = shortest[poll[0]] + value;
                        priorityQueue.offer(new int[]{node, shortest[node]});
                    }
                }
            }
        }
        return shortest;
    }
}
