package leetcode150;

import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators;

import java.util.*;

/**
 * @Author:zxp
 * @Description:bellman-ford算法的队列优化版本.
 * 简称SPFA。个人理解这块和dijkstra的堆优化版本是不
 * 同的，那边是可以根据小根堆的优先级队列快速得到距离
 * 源点最小的点，这边主要是记录上一次遍历过程中真正发
 * 生距离源点变更的点，这样不需要反复遍历所有的边。
 * @Date:16:10 2024/11/29
 */
public class KAM94BellmanFordWithHeap {
    static class Node{
        public int nodeIndex;
        public List<Integer> toList=new ArrayList<>();
        public List<Integer> vals=new ArrayList<>();
        public Node(int nodeIndex){
            this.nodeIndex=nodeIndex;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Node> nodeList=new ArrayList<>();
        for(int i=0;i<n;i++){
            nodeList.add(new Node(i));
        }
        for(int i=0;i<m;i++){
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            int v = scanner.nextInt();
            Node node = nodeList.get(s - 1);
            node.toList.add(t-1);
            node.vals.add(v);
        }
        int res = bellmanFordWithQueue(nodeList, 0, n);
        if(res==Integer.MAX_VALUE/2)
            System.out.println("unconnected");
        else System.out.println(res);
    }
    public static int bellmanFordWithQueue(List<Node> nodeList,int source,int n){
        int[] shortest = new int[n];
        Arrays.fill(shortest,Integer.MAX_VALUE/2);
        shortest[source]=0;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(nodeList.get(source));
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            List<Integer> toList = poll.toList;
            List<Integer> vals = poll.vals;
            for(int i=0;i<toList.size();i++){
                if(shortest[poll.nodeIndex]+vals.get(i)<shortest[toList.get(i)]){
                    shortest[toList.get(i)]=shortest[poll.nodeIndex]+vals.get(i);
                    queue.offer(nodeList.get(toList.get(i)));
                }
            }
        }
        return shortest[n-1];
    }
}