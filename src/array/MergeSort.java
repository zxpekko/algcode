package array;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:41 2024/4/22
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {14, 12, 15, 13, 11, 16};
        mergeSort.mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
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
