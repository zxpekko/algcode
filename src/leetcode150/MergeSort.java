package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:33 2024/7/27
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] ints = {7, 4, 2, 1, 4, 3, 1, 4};

        int[] ints1 = mergeSort.mergeSort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints1));
    }
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
        int[] copies = new int[n];
        for(int i=0;i<n;i++)
            copies[i]=arr[i];
        int l=left,r=mid+1;
        int index=left;
        while (l<=mid&&r<=right){
            if(copies[l]<=copies[r]){
                arr[index++]=copies[l++];
            }
            else
                arr[index++]=copies[r++];
        }
        while (l<=mid)
            arr[index++]=copies[l++];
        while (r<=right)
            arr[index++]=copies[r++];
    }
}