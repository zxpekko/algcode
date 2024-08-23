package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:38 2024/7/26
 */
public class HeapSort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] ints = heapSort.heapSort(new int[]{7, 4, 2, 1, 4, 3, 1, 4});
        System.out.println(Arrays.toString(ints));
        HeapSortⅠ heapSortⅠ = new HeapSortⅠ();
        int[] ints1 = heapSortⅠ.heapSort(new int[]{7, 4, 2, 1, 4, 3, 1, 4});
        System.out.println(Arrays.toString(ints1));
    }
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
class HeapSortⅠ{
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
        for(int i=n/2-1;i>=0;i--){
            heapfy(arr,n,i);
        }
        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapfy(arr,i,0);
        }
        return arr;
    }
}