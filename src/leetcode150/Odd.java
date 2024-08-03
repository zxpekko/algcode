package leetcode150;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:数组A，有2*n个元素，n个奇数，n个偶数，设计一个算法，使得数组奇数下标位置都是奇数，偶数下标位置都是偶数
 * @Date:21:01 2024/8/2
 */
public class Odd {
    public static void main(String[] args) {
        Odd odd = new Odd();
        int[] modify = odd.modify(new int[]{1, 2, 6, 4, 5, 3});
        System.out.println(Arrays.toString(modify));

    }
    public int[] modify(int[] arr){
        int even=0,odd=1;
        while (even<arr.length&&odd<arr.length){
            if(arr[even]%2==0&&arr[odd]%2!=0){
                odd+=2;
                even+=2;
            }
            else if(arr[even]%2!=0&&arr[odd]%2==0){
                //交换
                int temp=arr[even];
                arr[even]=arr[odd];
                arr[odd]=temp;
                even+=2;
                odd+=2;
            }
            else if(arr[even]%2==0)
                even+=2;
            else if(arr[odd]%2!=0)
                odd+=2;
        }
        return arr;
    }
}