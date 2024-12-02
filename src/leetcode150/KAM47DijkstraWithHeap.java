package leetcode150;

import java.util.*;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:59 2024/11/20
 */
public class KAM47DijkstraWithHeap {
    static class Node{
        int node;
        List<Integer> tos=new ArrayList<>();
        List<Integer> val=new ArrayList<>();
        public Node(int node){
            this.node=node;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Node> nodeList=new ArrayList<>();
        for(int i=0;i<n;i++)
            nodeList.add(new Node(i));
        for(int i=0;i<m;i++){
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            int v = scanner.nextInt();
            Node node = nodeList.get(s - 1);
            node.tos.add(e-1);
            node.val.add(v);
        }
        System.out.println(dijkstraWithHeap(nodeList, 0));
    }
    public static int dijkstraWithHeap(List<Node> nodeList,int source){
        int n=nodeList.size();
        int[] shortest = new int[n];
        PriorityQueue<Node> nodeQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return shortest[o1.node]-shortest[o2.node];
            }
        });
        Arrays.fill(shortest,Integer.MAX_VALUE/2);
        shortest[source]=0;
        nodeQueue.offer(nodeList.get(source));
        while (!nodeQueue.isEmpty()){
            Node poll = nodeQueue.poll();
            for(int j=0;j<poll.tos.size();j++){
                int to = poll.tos.get(j);
                int val = poll.val.get(j);
                if(shortest[poll.node]+val<shortest[to]){
                    shortest[to]=shortest[poll.node]+val;
                    nodeQueue.offer(nodeList.get(to));
                }
            }
        }
        return shortest[n-1]==Integer.MAX_VALUE/2?-1:shortest[n-1];
    }
}