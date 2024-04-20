package stacksandqueues;

import java.math.BigInteger;
import java.util.*;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:41 2024/4/17
 */
public class Solution347 {
    public static void main(String[] args) {
        Solution347 solution347 = new Solution347();
        int[] ints = solution347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(ints));
    }
    public int[] topKFrequent(int[] nums, int k){
        int[] result = new int[k];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                Integer integer = hashMap.get(nums[i]);
                hashMap.put(nums[i],integer+1);
            }
            else
                hashMap.put(nums[i],1);
        }
        hashMap.forEach((key,value)->{
            int[] map={key,value};
             if(priorityQueue.size()<k)
                priorityQueue.offer(map);
             else {
                 int[] peek = priorityQueue.peek();
                 if(peek[1]<value){
                     priorityQueue.poll();
                     priorityQueue.offer(map);
                 }
             }
        });
        int index=k-1;
        while (!priorityQueue.isEmpty()){
            int[] poll = priorityQueue.poll();
            result[index--]=poll[0];
        }
        return result;
    }
}
