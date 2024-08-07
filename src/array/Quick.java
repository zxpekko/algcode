package array;

import org.junit.Test;

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
        Quick2 quick2 = new Quick2();
        int[] quick3 = quick2.quick(new int[]{2, 3, 8, 1, 4, 9, 10, 7, 16, 14});
        System.out.println(Arrays.toString(quick3));
        Quick3 quick31 = new Quick3();
        int[] ints2 = quick31.quickSort(new int[]{2, 3, 8, 1, 4, 9, 10, 7, 16, 14});
        System.out.println(Arrays.toString(ints2));
        Quick4 quick4 = new Quick4();
        int[] ints3 = quick4.quickSort(new int[]{2, 3, 8, 1, 4, 9, 10, 7, 16, 14});
        System.out.println(Arrays.toString(ints3));
        Quick5 quick5 = new Quick5();
        int[] ints4 = quick5.quickSort(new int[]{2, 3, 8, 1, 4, 9, 10, 7, 16, 14});
        System.out.println(Arrays.toString(ints4));
        Quick6 quick6 = new Quick6();
        int[] ints5 = quick6.quickSort(new int[]{2, 3, 8, 1, 4, 9, 10, 7, 16, 14});
        System.out.println(Arrays.toString(ints5));
        Quick7 quick7 = new Quick7();
        int[] quick8 = quick7.quick(new int[]{2, 3, 8, 1, 4, 9, 10, 7, 16, 14});
        System.out.println(Arrays.toString(quick8));

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
    @Test
    public void test(){
        String a="123";
        StringBuilder stringBuilder=new StringBuilder();

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
class Quick2{
    public int[] quick(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    public void quickSort(int[] arr,int left,int right){
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
        quickSort(arr,left,r-1);
        quickSort(arr,r+1,right);
    }
}
class Quick3{
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
class Quick4{
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
class Quick5{
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
class Quick6{
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
class Quick7{
    public int[] quick(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    public void quickSort(int[] arr,int left,int right){
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
        quickSort(arr,left,r-1);
        quickSort(arr,r+1,right);
    }
}