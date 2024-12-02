package leetcode150;

import java.util.*;

/**
 * @Author:zxp
 * @Description: kruskal模板题
 * @Date:12:57 2024/11/14
 */
public class KAM53Kruskal {
    public static void main(String[] args) {
        int res = minDistByKruskal();
        System.out.println(res);
    }
    static class Edge{
        int val;
        int node1;
        int node2;
        public Edge(int val,int node1,int node2){
            this.val=val;
            this.node1=node1;
            this.node2=node2;
        }
    }
    public static int minDistByKruskal(){
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int e = scanner.nextInt();
        Edge[] edges = new Edge[e];
        for(int i=0;i<e;i++){
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            int val = scanner.nextInt();
            Edge edge = new Edge(val, node1, node2);
            edges[i]=edge;
        }
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.val-o2.val;
            }
        });
        List<Edge> pickEdges=new ArrayList<>();
        HashSet<Integer> hashSet=new HashSet<>();
        int index=0;
        while (pickEdges.size()<v-1){
            Edge edge = edges[index];
            int node1 = edge.node1;
            int node2 = edge.node2;
            if(hashSet.contains(node1)&&hashSet.contains(node2)){
                index++;
                continue;
            }
            hashSet.add(node1);
            hashSet.add(node2);
            pickEdges.add(edge);
            index++;
        }
        int result=0;
        for(Edge edge:pickEdges){
            result+=edge.val;
        }
        return result;
    }
}