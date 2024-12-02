package leetcode150;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:57 2024/11/28
 */
public class KAM94BellmanFord {
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
        int res = bellmanFord(edgeList, 0, n);
        if(res==-1)
            System.out.println("右负环");
        else if(res!=Integer.MAX_VALUE/2)
            System.out.println(res);
        else System.out.println("unconnected");
    }
    public static int bellmanFord(List<Edge> edgeList,int source,int n){
        int[] shortest = new int[n];
        boolean isChange=false;
        Arrays.fill(shortest,Integer.MAX_VALUE/2);
        shortest[source]=0;
        for(int i=0;i<n;i++){
            isChange=false;
            for(int j=0;j<edgeList.size();j++){
                Edge edge = edgeList.get(j);
                if((shortest[edge.from]!=Integer.MAX_VALUE/2)&&(shortest[edge.from]+ edge.val<shortest[edge.to])){
                    shortest[edge.to]=shortest[edge.from]+edge.val;
                    isChange=true;
                }
            }
        }
        if(isChange)
            return -1;
        return shortest[n-1];
    }
}