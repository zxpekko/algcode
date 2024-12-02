package leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description: prim算法模板题
 * @Date:16:04 2024/11/8
 */
public class KAM53 {
    public static void main(String[] args) {
        System.out.println(primSearch());
    }
    static class Node{
        public int index;
        public List<Node> neighbors=new ArrayList<>();
        public List<Integer> neiVal=new ArrayList<>();
    }
    public static int primSearch(){
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int e = scanner.nextInt();
        Node[] nodes=new Node[v];
        for(int i=0;i<v;i++){
            Node node = new Node();
            node.index=i;
            nodes[i]=node;
        }
        for(int i=0;i<e;i++){
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int val = scanner.nextInt();
            Node nodev1 = nodes[v1 - 1];
            Node nodev2 = nodes[v2 - 1];
            nodev1.neighbors.add(nodev2);
            nodev1.neiVal.add(val);
            nodev2.neighbors.add(nodev1);
            nodev2.neiVal.add(val);
        }
        //prim核心算法
        int[] minDist = new int[v];
        Arrays.fill(minDist,Integer.MAX_VALUE/2);
        minDist[0]=0;
        boolean[] visited=new boolean[v];
        visited[0]=true;
        int lastAdd=0;
        for(int i=0;i<v-1;i++){
            for(int j=0;j<v;j++){
                if(!visited[j]){
                    Node lastNode = nodes[lastAdd];
                    Node nodej = nodes[j];
                    if(lastNode.neighbors.contains(nodej)){
                        int index = lastNode.neighbors.indexOf(nodej);
                        Integer val = lastNode.neiVal.get(index);
                        if(val<minDist[j]){
                            minDist[j]=val;
                        }
                    }
                }
            }
            int curMin=Integer.MAX_VALUE;
            int curNode=-1;
            for(int k=0;k<v;k++){
                if(!visited[k]&&minDist[k]<curMin){
                    curMin=minDist[k];
                    curNode=k;
                }
            }
            visited[curNode]=true;
            lastAdd=curNode;
        }
        int result=0;
        for(int i=0;i<v;i++)
            result+=minDist[i];
//        System.out.println(Arrays.toString(minDist));
        return result;
    }
}