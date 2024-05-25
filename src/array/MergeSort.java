package array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:41 2024/4/22
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {14, 12, 15, 13, 11, 16};
        int[] arr1 = {14, 12, 15, 13, 11, 16};
        int[] arr2 = {14, 12, 15, 13, 11, 16};
        int[] arr3 = {14, 12, 15, 13, 11, 16};
        int[] arr4 = {14, 12, 15, 13, 11, 16};
        int[] arr5 = {14, 12, 15, 13, 11, 16};
        mergeSort.mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        MergeSort1 mergeSort1 = new MergeSort1();
        int[] ints = mergeSort1.mergeSort(arr1, 0, arr1.length-1);
        System.out.println(Arrays.toString(ints));
        MergeSort2 mergeSort2 = new MergeSort2();
        mergeSort2.MergeSort(arr2,0,arr2.length-1);
        System.out.println(Arrays.toString(arr2));
        MergeSort4 mergeSort4 = new MergeSort4();
        int[] ints1 = mergeSort4.mergeSort(arr3, 0, arr3.length - 1);
        System.out.println(Arrays.toString(ints1));
        MergeSort5 mergeSort5 = new MergeSort5();
        int[] ints2 = mergeSort5.mergeSort(arr4, 0, arr4.length - 1);
        System.out.println(Arrays.toString(ints2));
        PrioritySort prioritySort = new PrioritySort();
        System.out.println(prioritySort.getK(arr5, 3));
    }
    public void mergeSort(int[] arr,int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,high,mid);
        }
    }
    public void merge(int[] arr,int left,int right,int mid){
        if(left>=right)
            return;
        int[] copy = new int[arr.length];
        for(int i=0;i<arr.length;i++)
            copy[i]=arr[i];
        int l=left,r=mid+1;
        int index=left;
        while (l<=mid&&r<arr.length){
            if(copy[l]<=copy[r])
                arr[index++]=copy[l++];
            else
                arr[index++]=copy[r++];
        }
        while (l<=mid)
            arr[index++]=copy[l++];
        while (r<arr.length)
            arr[index++]=copy[r++];
    }
}
class MergeSort1{
    public int[] mergeSort(int[] arr,int left,int rigt){
        if(left<rigt){
            int mid=(left+rigt)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,rigt);
            merge(arr,left,rigt,mid);
        }
        return arr;
    }
    public void merge(int[] arr,int left,int right,int mid){
        int n= arr.length;
        int[] copy = new int[n];
        for(int i=0;i<n;i++){
            copy[i]=arr[i];
        }
        int index1=left,index2=mid+1;
        int index=left;
        while (index1<=mid&&index2<=right){
            if(copy[index1]<copy[index2])
                arr[index++]=copy[index1++];
            else
                arr[index++]=copy[index2++];
        }
        while (index1<=mid)
            arr[index++]=copy[index1++];
        while (index2<=mid)
            arr[index++]=copy[index2++];
    }
}
class MergeSort2{
    public void MergeSort(int[] arr,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            MergeSort(arr,left,mid);
            MergeSort(arr,mid+1,right);
            Merge(arr,left,right,mid);
        }
    }
    public void Merge(int[] arr,int left,int right,int mid){
        int n=arr.length;
        int[] copy = new int[n];
        for(int i=0;i< arr.length;i++)
            copy[i]=arr[i];
        int l=left,r=mid+1;
        int index=left;
        while (l<=mid&&r<=right){
            if(copy[l]<=copy[r])
                arr[index++]=copy[l++];
            else
                arr[index++]=copy[r++];
        }
        while (l<=mid)
            arr[index++]=copy[l++];
        while (r<=right)
            arr[index++]=copy[r++];
    }
}
class MergeSort3{
    public int[] mergeSort(int[] arr,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,right,mid);
        }
        return arr;
    }
    public void merge(int[] arr,int left,int right,int mid){
        int n=arr.length;
        int[] copy = new int[n];
        for(int i=0;i<n;i++)
            copy[i]=arr[i];
        int l=left,r=mid+1;
        int index=left;
        while (l<=mid&&r<=right){
            if(copy[l]<=copy[r])
                arr[index++]=copy[l++];
            else
                arr[index++]=copy[r++];
        }
        while (l<=mid)
            arr[index++]=copy[l++];
        while (r<=right)
            arr[index++]=copy[r++];
    }
}
class MergeSort4{
    public int[] mergeSort(int[] arr,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,right,mid);
        }
        return arr;
    }
    public void merge(int[] arr,int left,int right,int mid){
        int n=arr.length;
        int[] copy = new int[n];
        for(int i=0;i<n;i++)
            copy[i]=arr[i];
        int l=left,r=mid+1;
        int index=left;
        while (l<=mid&&r<=right){
            if(copy[l]<=copy[r]){
                arr[index++]=copy[l++];
            }
            else
                arr[index++]=copy[r++];
        }
        while (l<=mid)
            arr[index++]=copy[l++];
        while (r<=right)
            arr[index++]=copy[r++];
    }
}
class MergeSort5{
    public int[] mergeSort(int[] arr,int left,int right){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            merge(arr,left,right,mid);
        }
        return arr;
    }
    public void merge(int[] arr,int left,int right,int mid){
        int n=arr.length;
        int[] copy = new int[n];
        int l=left,r=mid+1;
        int index=left;
        for(int i=0;i<n;i++)
            copy[i]=arr[i];
        while (l<=mid&&r<=right){
            if(copy[l]<=copy[r])
                arr[index++]=copy[l++];
            else
                arr[index++]=copy[r++];
        }
        while (l<=mid)
            arr[index++]=copy[l++];
        while (r<=right)
            arr[index++]=copy[r++];
    }
}
class PrioritySort{
    public int getK(int[] arr,int k){
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                return o1-o2;
            }
        });
        for(int i=0;i<arr.length;i++){
            if(queue.size()<k)
                queue.offer(arr[i]);
            else if(arr[i]>queue.peek()){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        return queue.peek();
    }

}
