package leetcode150;

import java.util.*;

/**
 * @Author:zxp
 * @Description:拓扑排序模板
 * @Date:14:51 2024/11/17
 */
public class TopicSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<List<Integer>> eMap=new ArrayList<>();
        for(int i=0;i<n;i++)
            eMap.add(new ArrayList<>());
        int[] inDegrees = new int[n];
        for(int i=0;i<m;i++){
            int s = scanner.nextInt();
            int t = scanner.nextInt();
            inDegrees[t]++;
            eMap.get(s).add(t);
        }
        List<Integer> result=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<inDegrees.length;i++){
            if(inDegrees[i]==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            result.add(poll);
            List<Integer> inList = eMap.get(poll);
            for(int in:inList){
                inDegrees[in]--;
                if(inDegrees[in]==0)
                    queue.offer(in);
            }
        }
        if(result.size()==n){
            for(int i=0;i<result.size();i++){
                System.out.print(result.get(i));
                if(i<result.size()-1)
                    System.out.print(" ");
            }
        }
        else System.out.println(-1);
    }
}