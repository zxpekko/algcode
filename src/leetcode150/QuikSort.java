package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:快排，先按照第一个元素排，第一个元素相等再按照第二个元素排。
 * 堆排序，冒泡排序
 * @Date:16:31 2024/8/19
 */
public class QuikSort {
    public static void main(String[] args) {
        QuikSort quikSort = new QuikSort();
        int[][] ints = new int[][]{{4,1},{4,0},{3,1},{2,1}};
        int[][] quick = quikSort.quick(ints);
//        System.out.println(Arrays.toString(quick));
        for(int[] arr:quick){
            System.out.println(Arrays.toString(arr));
        }
    }
    public int[][] quick(int[][] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    public void quickSort(int[][] arr,int left,int right){
        if(left>=right)
            return;
        int l=left,r=right;
        int pivot=arr[left][0];
        int pivot1=arr[left][1];
        while (l<r){
            while (l<r&&arr[r][0]>=pivot){
                if(arr[r][0]==pivot&&arr[r][1]<pivot1)
                    break;
                r--;
            }
            if(l<r){
                arr[l][0]=arr[r][0];
                arr[l][1]=arr[r][1];
            }
            while (l<r&&arr[l][0]<=pivot){
                if(arr[l][0]==pivot&&arr[l][1]>pivot1)
                    break;
                l++;
            }
            if(l<r){
                arr[r][0]=arr[l][0];
                arr[r][1]=arr[l][1];
            }

            if(l==r){
                arr[r][0]=pivot;
                arr[r][1]=pivot1;
            }
        }
        quickSort(arr,left,r-1);
        quickSort(arr,r+1,right);
    }
}