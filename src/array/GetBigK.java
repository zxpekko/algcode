package array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:12 2024/7/15
 */
public class GetBigK {
    public static void main(String[] args) {
        GetBigK getBigK = new GetBigK();
        int[] ints = {4, 5, 1, 2, 6, 3, 9, 7};
        int[] ints1 = {4, 5, 1, 2, 6, 3, 9, 7};
        int[] ints2 = {4, 5, 1, 2, 6, 3, 9, 7};
        int[] ints3 = {4, 5, 1, 2, 6, 3, 9, 7};
        System.out.println(getBigK.getBigKByQuick(ints, 0, ints.length - 1, 3));
        System.out.println(getBigK.getKNumsByHeapSort(ints1, 3));
        System.out.println(getBigK.getKNumsByPri(ints2, 3));
        System.out.println(getBigK.getByQuick(ints3, 3));
    }
    public int getByQuick(int[] arr,int k){
        return getBigKByQuick(arr, 0, arr.length - 1, k);
    }

    public int getBigKByQuick(int[] arr,int left,int right, int k){
        int l=left,r=right;
        int pivot=arr[left];
        while (l<r){
            while (l<r&&arr[r]>=pivot)
                r--;
            if(l<r)
                arr[l]=arr[r];
            while (l<r&&arr[l]<=pivot)
                l++;
            if(l<r)
                arr[r]=arr[l];
            if(l==r)
                arr[r]=pivot;
        }
        if(r==arr.length-k)
            return pivot;
        else if(r>arr.length-k)
            return getBigKByQuick(arr,left,r-1,k);
        else
            return getBigKByQuick(arr,r+1,right,k);
    }
    public void heapfy(int[] arr,int n,int i){
        int left=2*i+1;
        int right=2*i+2;
        int largest=i;
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
    public int getKNumsByHeapSort(int[] arr,int k){
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--)
            heapfy(arr,n,i);
        int index=0;
        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            index++;
            if(index==k)
                return temp;
            heapfy(arr,i,0);
        }
        return 0;
    }
    public int getKNumsByPri(int[] arr,int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(priorityQueue.size()<k)
                priorityQueue.offer(arr[i]);
            else if(arr[i]>priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        return priorityQueue.peek();
    }
}
