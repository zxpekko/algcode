package array;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:21:02 2024/4/9
 */
public class Quick {
    public static void main(String[] args) {
        Quick quick = new Quick();
        int[] ints = quick.quickSort(new int[]{2, 3, 8, 1, 4, 9, 10, 7, 16, 14});
        System.out.println(Arrays.toString(ints));
        Quick1 quick1 = new Quick1();
        int[] ints1 = quick1.quickSort(new int[]{2, 3, 8, 1, 4, 9, 10, 7, 16, 14});
        System.out.println(Arrays.toString(ints1));
    }
    public int[] quickSort(int[] arr){
        quick(arr,0,arr.length-1);
        return arr;
    }
    public void quick(int[] arr,int left,int right){
        if(left>=right)
            return;
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
        quick(arr,left,r-1);
        quick(arr,r+1,right);
    }
}
class Quick1{
    public int[] quickSort(int[] arr){
        quick(arr,0,arr.length-1);
        return arr;
    }
    public void quick(int[] arr,int left,int right){
        if(left>=right)
            return;
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
        quick(arr,left,r-1);
        quick(arr,r+1,right);
    }
}
