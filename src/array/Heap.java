package array;

import java.util.*;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:02 2024/4/9
 */
public class Heap {
    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] ints = heap.heapSort(new int[]{2, 3, 8, 1, 4, 9, 10, 7, 16, 14}, 3);
        System.out.println(Arrays.toString(ints));
        Priority priority = new Priority();
        int[] ints1 = priority.priorityNums(new int[]{2, 3, 8, 1, 4, 9, 10, 7, 16, 14}, 3);
        System.out.println(Arrays.toString(ints1));
        Heap1 heap1 = new Heap1();
        int[] ints2 = heap1.heapSort(new int[]{2, 3, 8, 1, 4, 9, 10, 7, 16, 14}, 3);
        System.out.println(Arrays.toString(ints2));
        Prioriuty1 prioriuty1 = new Prioriuty1();
        int[] k = prioriuty1.getK(new int[]{2, 3, 8, 1, 4, 9, 10, 7, 16, 14}, 3);
        System.out.println(Arrays.toString(k));
        Heap3 heap3 = new Heap3();
        int[] ints3 = heap3.heapSort(new int[]{2, 3, 8, 1, 4, 9, 10, 7, 16, 14});
        System.out.println(Arrays.toString(ints3));
        Priority1 priority1 = new Priority1();
        System.out.println(priority1.prioritySort(new int[]{2, 3, 8, 1, 4, 9, 10, 7, 16, 14}, 3));
        Heap4 heap4 = new Heap4();
        int[] ints4 = heap4.heapSort(new int[]{2, 3, 8, 1, 4, 9, 10, 7, 16, 14});
        System.out.println(Arrays.toString(ints4));
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

    public int[] heapSort(int[] arr, int k) {//时间复杂度是O(klogn)
        int n = arr.length;
        int[] result = new int[k];
        int index = 0;
        //建堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapfy(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            result[index++] = temp;
            if (index >= k)
                break;
            heapfy(arr, i, 0);
        }
        return result;
    }
}

class Priority {
    public int[] priorityNums(int[] arr, int k) {//前k大的元素,优先级队列，时间复杂度为O(nlogk)
        int n = arr.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < n; i++) {
            if (priorityQueue.size() < k)
                priorityQueue.offer(arr[i]);
            else {
                if (arr[i] > priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.offer(arr[i]);
                }
            }
        }
        int[] result = new int[k];
        int index = k - 1;
        while (!priorityQueue.isEmpty()) {
            result[index--] = priorityQueue.poll();
        }
        return result;
    }

}

class Heap1 {
    public void heapfy(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapfy(arr, n, largest);
        }
    }

    public int[] heapSort(int[] arr, int k) {
        int n = arr.length;
        //建堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapfy(arr, n, i);
        }
        int curK = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (curK == k) {
                System.out.println(result);
                break;
            }
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapfy(arr, i, 0);
            result.add(temp);
            curK++;
            if (curK == k)
                System.out.println(temp);
        }
        return arr;
    }
}

class Prioriuty1 {
    public int[] getK(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (priorityQueue.size() < k)
                priorityQueue.offer(arr[i]);
            else {
                if (arr[i] > priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.offer(arr[i]);
                }
            }
        }
        int[] result = new int[k];
//        for(int i=k-1;i>=0;i--)
//            result[i]=priorityQueue.poll();
        int index=k-1;
        while (!priorityQueue.isEmpty()){
            result[index--]=priorityQueue.poll();
        }
        return result;
    }
}
class Heap2{
    public void heapfy(int[] arr,int n,int i){
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<n&&arr[left]>arr[largest])
            largest=left;
        if(right<n&&arr[right]>arr[largest])
            largest=right;
        if(largest!=i){
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            heapfy(arr,n,largest);
        }
    }
    public int[] heapSort(int[] arr){
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--)
            heapfy(arr,n,i);
        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapfy(arr,i,0);
        }
        return arr;
    }
}
class Heap3{
    public void heapfy(int[] arr,int n,int i){
        int left=2*i+1;
        int right=2*i+2;
        int largest=i;
        if(left<n&&arr[largest]<arr[left])
            largest=left;
        if(right<n&&arr[largest]<arr[right])
            largest=right;
        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            heapfy(arr,n,largest);
        }
    }
    public int[] heapSort(int[] arr){
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--)
            heapfy(arr,n,i);
        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapfy(arr,i,0);
        }
        return arr;
    }
}
class Priority1{
    public int prioritySort(int[] arr,int k){
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                return o1-o2;
            }
        });
        PriorityQueue<Integer> q=new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                return o1-o2;
            }
        });
        for(int i=0;i<arr.length;i++){
            if(priorityQueue.size()<k)
                priorityQueue.offer(arr[i]);
            else {
                if(arr[i]>priorityQueue.peek()){
                    priorityQueue.poll();
                    priorityQueue.offer(arr[i]);
                }
            }
        }
        return priorityQueue.peek();
    }
}
class Heap4{
    public void heapfy(int[] arr,int n,int i){
        int left=2*i+1;
        int right=2*i+2;
        int largest=i;
        if(left<n&&arr[largest]<arr[left])
            largest=left;
        if(right<n&&arr[largest]<arr[right])
            largest=right;
        if(largest!=i){
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            heapfy(arr,n,largest);
        }
    }
    public int[] heapSort(int[] arr){
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--){
            heapfy(arr,n,i);
        }
        for(int i=n-1;i>=0;i--){//交换并维护
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapfy(arr,i,0);
        }
        return arr;
    }
}