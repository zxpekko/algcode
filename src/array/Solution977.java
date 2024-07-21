package array;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;
import leetcode.binarysearch.FindNthDigit;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:53 2024/7/15
 */
public class Solution977 {
    public static void main(String[] args) {
        Solution977 solution977 = new Solution977();
        int[] ints = solution977.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(ints));
        Solution977Ⅰ solution977Ⅰ = new Solution977Ⅰ();
        int[] ints1 = solution977Ⅰ.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(ints1));
        Scanner scanner = new Scanner(System.in);
        int count= scanner.nextInt();
        int[] ints2 = new int[count];
        for(int i=0;i<count;i++){
            ints2[i]=scanner.nextInt();
        }
        scanner.close();
        int[] ints3 = solution977Ⅰ.sortedSquares(ints2);
        System.out.println(Arrays.toString(ints3));
    }
    public int[] sortedSquares(int[] nums){
        int n=nums.length;
        int[] result = new int[n];
        int i=0,j=n-1;
        int startIndex=n-1;
        while (i<=j){
            if(nums[i]*nums[i]>=nums[j]*nums[j]){
                result[startIndex--]=nums[i]*nums[i];
                i++;
            }
            else {
                result[startIndex--]=nums[j]*nums[j];
                j--;
            }
        }
        return result;
    }
}
class Solution977Ⅰ{
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] result = new int[n];
        int i=0,j=n-1;
        int startIndex=n-1;
        while (i<=j){
            if(nums[i]*nums[i]>=nums[j]*nums[j]){
                result[startIndex--]=nums[i]*nums[i];
                i++;
            }
            else {
                result[startIndex--]=nums[j]*nums[j];
                j--;
            }
        }
        return result;
    }
}