package CSDNCode;

/**
 * @Author:zxp
 * @Description:快排加二分求第k大的数
 * @Date:20:23 2024/4/29
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 8, 1, 4, 9, 10, 7, 16, 14};
        System.out.println(getKth(arr, 5));
    }
    public static int getKth(int[] arr,int k){
        int n=arr.length;
        quick(arr,0,arr.length-1,k);
        return arr[n-k];
    }
    public static void quick(int[] arr,int left,int right,int k){
        if(left>=right)
            return;
        int l=left,r=right;
        int pivot=arr[left];
        int n=arr.length;
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
        if(r==n-k)
            return;
        else if(r>n-k)
            quick(arr,left,r-1,k);
        else
            quick(arr,r+1,right,k);
    }
}
