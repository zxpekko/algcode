package leetcode150;
import java.util.*;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:39 2024/11/6
 */
public class KAM105 {
    static class Node{
        int val;
        List<Node> toneighbors;
        public Node(int val,List<Node> toneighbors){
            this.val=val;
            this.toneighbors=toneighbors;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Node> nodeList=new ArrayList<>();
        for(int i=0;i<n;i++){
            nodeList.add(new Node(i,new ArrayList<>()));
        }
        for(int i=0;i<k;i++){
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            Node fromNode = nodeList.get(from - 1);
            Node toNode=nodeList.get(to-1);
            fromNode.toneighbors.add(toNode);
        }
        int res = judgeDirect(nodeList.get(0), n);
        System.out.println(res);
    }
    public static int judgeDirect(Node cur,int n){
        boolean[] visited = new boolean[n];
        bfs(cur,visited);
        for(int i=0;i<visited.length;i++){
            if(!visited[i])
                return -1;
        }
        return 1;
    }
    public static void dfs(Node cur,boolean[] visited) {//深度优先遍历
        Stack<Node> stack=new Stack<>();
        stack.push(cur);
        visited[cur.val]=true;
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            for(Node toneighbor:pop.toneighbors){
                if(!visited[toneighbor.val]){
                    visited[toneighbor.val]=true;
                    stack.push(toneighbor);
                }
            }
        }
    }
    public static void bfs(Node cur,boolean[] visited){//广度优先遍历
        Queue<Node> queue=new LinkedList<>();
        queue.offer(cur);
        visited[cur.val]=true;
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            for(Node toneighbor:poll.toneighbors){
                if(!visited[toneighbor.val]){
                    visited[toneighbor.val]=true;
                    queue.offer(toneighbor);
                }
            }
        }
    }
}