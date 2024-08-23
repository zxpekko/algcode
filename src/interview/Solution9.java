package interview;

import org.junit.Test;

import java.util.*;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:34 2024/8/22
 */
public class Solution9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
//        HashMap<int[], Integer> record = new HashMap<>();
        HashMap<Integer, Map<Integer,Integer>> record =new HashMap<>();
        for(int i=0;i<m;i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            record.computeIfAbsent(u-1,k->new HashMap<>()).put(v-1,w);
            record.computeIfAbsent(v-1,k->new HashMap<>()).put(u-1,w);
        }
        int[] shortest = dijHeap(record, 0,n);
        int res=0;
        for(int i=0;i<q;i++){
            int a = scanner.nextInt();
            res+=2*shortest[a-1];
        }
        System.out.println(res);
    }
    public static int[] dijk(HashMap<Integer,Map<Integer,Integer>> record,int n, int source){
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
                Map map = record.get(k);
                if(map.containsKey(m)){
                    int o = (int)map.get(m);
                    if(shortest[k]+o<shortest[m])
                        shortest[m]=shortest[k]+o;
                }
            }
        }
        return shortest;
    }
    public static int[] dijHeap(HashMap<Integer, Map<Integer,Integer>> adj,int source,int n){
        int[] shortest = new int[n];
        Arrays.fill(shortest,Integer.MAX_VALUE/2);
        boolean[] visited = new boolean[n];
        shortest[source]=0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        priorityQueue.offer(new int[]{source,0});
        while (!priorityQueue.isEmpty()){
            int[] poll = priorityQueue.poll();
            if(visited[poll[0]])
                continue;
            visited[poll[0]]=true;
            Map<Integer, Integer> integerIntegerMap = adj.get(poll[0]);
            for(Map.Entry<Integer,Integer> entry:integerIntegerMap.entrySet()){
                Integer node = entry.getKey();
                Integer value = entry.getValue();
                if(!visited[node]){
                    if(shortest[poll[0]]+value<shortest[node]){
                        shortest[node]=shortest[poll[0]]+value;
                        priorityQueue.offer(new int[]{node,shortest[node]});
                    }
                }
            }
        }
        return shortest;
    }
    @Test
    public void test(){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1000,1000);
        System.out.println(hashMap.containsKey(1000));
    }
}