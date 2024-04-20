package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:02 2024/4/9
 */
public class Heap {
    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] ints = heap.heapSort(new int[]{2, 3, 8, 1, 4, 9, 10, 7, 16, 14},3);
        System.out.println(Arrays.toString(ints));
        Priority priority = new Priority();
        int[] ints1 = priority.priorityNums(new int[]{2, 3, 8, 1, 4, 9, 10, 7, 16, 14}, 3);
        System.out.println(Arrays.toString(ints1));
    }

    public void heapfy(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapfy(arr, n, largest);
        }
    }

    public int[] heapSort(int[] arr,int k) {//时间复杂度是O(klogn)
        int n = arr.length;
        int[] result = new int[k];
        int index=0;
        //建堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapfy(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            result[index++]=temp;
            if(index>=k)
                break;
            heapfy(arr, i, 0);
        }
        return result;
    }
}
class Priority{
    public int[] priorityNums(int[] arr,int k){//前k大的元素,优先级队列，时间复杂度为O(nlogk)
        int n=arr.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
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
        int[] result = new int[k];
        int index=k-1;
        while (!priorityQueue.isEmpty()){
            result[index--]=priorityQueue.poll();
        }
        return result;
    }

}