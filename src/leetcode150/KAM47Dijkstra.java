package leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:32 2024/11/19
 */
public class KAM47Dijkstra {
    static class Node{
        public int node;
        public List<Integer> tos;
        public List<Integer> vals;
        public Node(int node){
            this.node=node;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Node> nodes=new ArrayList<>();
        for(int i=0;i<n;i++){
            Node node = new Node(i);
            node.tos=new ArrayList<>();
            node.vals=new ArrayList<>();
            nodes.add(node);
        }
        for(int i=0;i<m;i++){
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            int v = scanner.nextInt();
            nodes.get(s-1).tos.add(e-1);
            nodes.get(s-1).vals.add(v);
        }
        System.out.println(minDistance(nodes, 0));
    }
    public static int minDistance(List<Node> nodes,int source){
        int n=nodes.size();
        int[] shortest = new int[n];
        boolean[] visit = new boolean[n];
        Arrays.fill(shortest,Integer.MAX_VALUE/2);
        shortest[source]=0;
        for(int i=0;i<n;i++){
            int k=-1;
            for(int j=0;j<n;j++){
                if(!visit[j]&&(k==-1||shortest[j]<shortest[k]))
                    k=j;
            }
            visit[k]=true;
            Node knode = nodes.get(k);
            for(int m=0;m<knode.tos.size();m++){
                int to = knode.tos.get(m);
                int val = knode.vals.get(m);
                if(shortest[k]+val<shortest[to])
                    shortest[to]=shortest[k]+val;
            }
        }
        return shortest[n-1]==Integer.MAX_VALUE/2?-1:shortest[n-1];
    }
}