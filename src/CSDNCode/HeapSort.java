package CSDNCode;

/**
 * @Author:zxp
 * @Description:堆排序求第k大的数
 * @Date:20:23 2024/4/29
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 8, 1, 4, 9, 10, 7, 16, 14};
        System.out.println(getKth(arr, 5));
    }
    public static void heapfy(int[] arr,int n,int i){
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
    public static int getKth(int[] arr,int k){
        int n=arr.length;
        for(int i=n/2-1;i>=0;i--){
            heapfy(arr,n,i);
        }
        int curK=0;
        for(int i=n-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            curK++;
            if(curK==k)
                return temp;
            heapfy(arr,i,0);
        }
        return 0;
    }
}
