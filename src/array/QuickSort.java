package array;

import leetcode.PathSum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author:zxp
 * @Description:快速排序的手动实现
 * @Date:20:42 2024/1/17
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] quick = quickSort.quick(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        QuickSortⅡ quickSortⅡ = new QuickSortⅡ();
        int[] quick1 = quickSortⅡ.quick(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        QuickSortⅢ quickSortⅢ = new QuickSortⅢ();
        int[] quick2 = quickSortⅢ.quick(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        QuickSortⅣ quickSortⅣ = new QuickSortⅣ();
        int[] quick3 = quickSortⅣ.quick(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        System.out.println(Arrays.toString(quick3));
        System.out.println(Arrays.toString(quick2));
        System.out.println(Arrays.toString(quick1));
        System.out.println(Arrays.toString(quick));
        QuickSortⅤ quickSortⅤ = new QuickSortⅤ();
        int[] ints = quickSortⅤ.quickSort(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        System.out.println(Arrays.toString(ints));
        QuickSortⅥ quickSortⅥ = new QuickSortⅥ();
        int[] quick4 = quickSortⅥ.quick(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        System.out.println(Arrays.toString(quick4));
        QuickSortⅦ quickSortⅦ = new QuickSortⅦ();
        int[] ints1 = quickSortⅦ.quickSort(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        System.out.println(Arrays.toString(ints1));
        QuickSortⅧ quickSortⅧ = new QuickSortⅧ();
        int[] ints2 = {3, 5, 1, 3, 9, 7, 5, 6, -1};
        quickSortⅧ.quickSort(ints2);
        System.out.println(Arrays.toString(ints2));
        QuickSortⅨ quickSortⅨ = new QuickSortⅨ();
        int[] quick5 = quickSortⅨ.quick(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        System.out.println(Arrays.toString(quick5));
        QuickSortⅩ quickSortⅩ = new QuickSortⅩ();
        int[] ints3 = quickSortⅩ.quickSort(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        System.out.println(Arrays.toString(ints3));
        System.out.println(quickSortⅩ.twoSum(new int[]{3, 2, 4}, 6));
        int[] ints4 = quickSortⅩ.twoSum(new int[]{3, 2, 4},6);
        System.out.println(Arrays.toString(ints4));
        QuickSort1 quickSort1 = new QuickSort1();
        int[] ints5 = quickSort1.quickSort(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1});
        System.out.println(Arrays.toString(ints5));
        QuickSort2 quickSort2 = new QuickSort2();
        System.out.println(quickSort2.quick(new int[]{3, 5, 1, 3, 9, 7, 5, 6, -1}, 3));
    }
    public int[] quick(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    public void quickSort(int[] arr,int L,int R){
        if(L>=R)
            return;
        int left=L,right=R;
        int pivot=arr[left];
        while (left<right){
            while (left<right&&arr[right]>=pivot){
                right--;
            }
            if(left<right){
                arr[left]=arr[right];
            }
            while (left<right&&arr[left]<=pivot){
                left++;
            }
            if(left<right){
                arr[right]=arr[left];
            }
            if(left>=right)
                arr[right]=pivot;
        }
        quickSort(arr,L,right-1);
        quickSort(arr,right+1,R);
    }
}
class QuickSortⅡ{
    public int[] quick(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    public void quickSort(int[] arr,int L,int R){
        if(L>=R)
            return;//递归出口要注意，因为不写的话，后续的逻辑无法结束递归，会一直入栈，直到栈满报错退出。L>=R说明当前要处理的子数组只有一个元素，因此可以退出。
        int left=L,right=R;
        int pivot=arr[left];
        while (left<right){
            while (left<right&&arr[right]>=pivot)
                right--;
            if(left<right)
                arr[left]=arr[right];
            while (left<right&&arr[left]<=pivot)
                left++;
            if(left<right)
                arr[right]=arr[left];
            if(left>=right)
                arr[right]=pivot;
        }
        quickSort(arr,L,right-1);
        quickSort(arr,right+1,R);
    }
}
class QuickSortⅢ{
    public void quickSort(int[] arr,int L,int R){
        if (L>=R)
            return;
        int left=L,right=R;
        int pivot=arr[left];
        while(left<right){
            while (left<right&&arr[right]>=pivot)
                right--;
            if(left<right)
                arr[left]=arr[right];
            while (left<right&&arr[left]<=pivot)
                left++;
            if(left<right)
                arr[right]=arr[left];
            if(left>=right)
                arr[right]=pivot;
        }
        quickSort(arr,L,right-1);
        quickSort(arr,right+1,R);
    }
    public int[] quick(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }
}
class QuickSortⅣ{
    public int[] quick(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    public void quickSort(int[] arr,int L,int R){
        if(L>=R)
            return;
        int left=L,right=R;
        int pivot=arr[left];
        while (left<right){
            while (left<right&&arr[right]>=pivot)
                right--;
            if(left<right)
                arr[left]=arr[right];
            while (left<right&&arr[left]<=pivot)
                left++;
            if(left<right)
                arr[right]=arr[left];
            if(left==right)
                arr[right]=pivot;
        }
        quickSort(arr,L,right-1);
        quickSort(arr,right+1,R);
    }
}
class QuickSortⅤ{
    public int[] quickSort(int[] arr){
        quick(arr,0,arr.length-1);
        return arr;
    }
    public void quick(int[] arr,int L,int R){
        if(L>=R)
            return;
        int left=L;
        int right=R;
        int pivot=arr[left];
        while (left<right){
            while (left<right&&arr[right]>=pivot)
                right--;
            if(left<right)
                arr[left]=arr[right];
            while (left<right&&arr[left]<=pivot)
                left++;
            if(left<right)
                arr[right]=arr[left];
            if(left==right)
                arr[right]=pivot;
        }
        quick(arr,L,right-1);
        quick(arr,right+1,R);
    }
}
class QuickSortⅥ{
    public int[] quick(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }
    public void quickSort(int[] arr,int L,int R){
        if(L>=R)
            return;
        int left=L;
        int right=R;
        int pivot=arr[left];
        while (left<right){
            while (left<right&&arr[right]>=pivot)
                right--;
            if(left<right)
                arr[left]=arr[right];
            while (left<right&&arr[left]<=pivot)
                left++;
            if(left<right)
                arr[right]=arr[left];
            if(left==right)
                arr[right]=pivot;
        }
        quickSort(arr,L,right-1);
        quickSort(arr,right+1,R);
    }
}
class QuickSortⅦ{
    public int[] quickSort(int[] arr){
        quick(arr,0,arr.length-1);
        return arr;
    }
    public void quick(int[] arr,int left,int right){
        int l=left,r=right;
        if(left>=right)
            return;
        int pivot=arr[l];
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
class QuickSortⅧ{
    public void quickSort(int[] arr){
        quick(arr,0, arr.length-1);
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
class QuickSortⅨ{
    public int[] quick(int[] arr){
        quickSort(arr,0, arr.length-1);
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
class QuickSortⅩ{
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
                arr[l]=pivot;
        }
        quick(arr,left,r-1);
        quick(arr,r+1,right);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        hashMap.containsKey(1)
    }
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        HashMap<Integer,Integer> record=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(!record.containsKey(target-numbers[i])){
                record.put(numbers[i],i);
            }
            else{
                int[] result=new int[2];
                result[0]=i;
                result[1]=record.get(target-numbers[i]);

                return result;
            }
        }
        return null;
    }
}
class QuickSort1{
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
class QuickSort2{
    public int quick(int[] arr,int minK){
        quickSort(arr,0, arr.length-1,minK );
        return arr[minK-1];
    }
    public void quickSort(int[] arr,int left,int right,int minK){
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
        if(r>minK-1){
            quickSort(arr,left,r-1,minK);
        }
        else if(r<minK-1){
            quickSort(arr,r+1,right,minK);
        }
        else
            return;
    }
}