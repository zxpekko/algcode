package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:49 2024/8/3
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Main.maxValueAfterOneSwap(new int[]{1, 2, 8, 10}));
    }
    public static int maxValueAfterOneSwap(int[] arr){
        int n=arr.length;
        if(n<2)
            return 0;
        int[] originalValues=new int[n-1];
        int originalMax=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            originalValues[i]=arr[i]*arr[i+1];
            if(originalValues[i]>originalMax){
                originalMax=originalValues[i];
            }
        }
        int maxValue=originalMax;
        for(int i=0;i<n-1;i++){
            swap(arr,i,i+1);
            int left=i>0?arr[i-1]*arr[i]:originalValues[i];
            int mid=arr[i]*arr[i+1];
            int right=i+2<n?arr[i+1]*arr[i+2]:originalValues[i];
            int newMaxValue=Math.max(left,Math.max(mid,right));
            if(newMaxValue>maxValue){
                maxValue=newMaxValue;
            }
            swap(arr,i,i+1);
        }

        return maxValue;
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
