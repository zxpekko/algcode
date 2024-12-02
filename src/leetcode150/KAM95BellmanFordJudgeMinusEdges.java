package leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:bellmanford算法，判断是否存在回路。建议遍历边，这样n次之后判断是否还有节点发生变化。
 * @Date:14:20 2024/11/30
 */
public class KAM95BellmanFordJudgeMinusEdges {
    static class Edge{
        public int from;
        public int to;
        public int val;
        public Edge(int from,int to,int val){
            this.from=from;
            this.to=to;
            this.val=val;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Edge> edgeList=new ArrayList<>();
        for(int i=0;i<m;i++){
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            int v = scanner.nextInt();
            edgeList.add(new Edge(s-1,t-1,v));
        }
        bellmanFordJudgeMinusEdges(edgeList,0,n);
    }
    public static void bellmanFordJudgeMinusEdges(List<Edge> edgeList,int source,int n){
        int[] shortest = new int[n];
        Arrays.fill(shortest,Integer.MAX_VALUE/2);
        shortest[source]=0;
        boolean isChanged=false;
        for(int i=0;i<n;i++){
            isChanged=false;
            for(int j=0;j<edgeList.size();j++){
                Edge edge = edgeList.get(j);
                int from = edge.from;
                int to = edge.to;
                int val = edge.val;
                if(shortest[from]!=Integer.MAX_VALUE/2&&shortest[from]+val<shortest[to]){
                    shortest[to]=shortest[from]+val;
                    isChanged=true;
                }
            }
        }
        if(isChanged)
            System.out.println("circle");
        else if(shortest[n-1]==Integer.MAX_VALUE/2)
            System.out.println("unconnected");
        else
            System.out.println(shortest[n-1]);
    }
}
