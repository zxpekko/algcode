package CSDNCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author:zxp
 * @Description:优先级队列求第k大的数
 * @Date:20:24 2024/4/29
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        int[] arr = {2, 3, 8, 1, 4, 9, 10, 7, 16, 14};
        System.out.println(getKth(arr, 5));
    }
    public static int getKth(int[] arr,int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(priorityQueue.size()<k)
                priorityQueue.offer(arr[i]);
            else {
                if(arr[i]>priorityQueue.peek()){
                    priorityQueue.poll();
                    priorityQueue.offer(arr[i]);
                }
            }
        }
        return priorityQueue.poll();
    }
}
