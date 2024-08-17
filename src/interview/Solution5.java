package interview;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:23 2024/8/17
 */
public class Solution5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        int index=0;
        while (n-->0){
            arr[index++]=scanner.nextInt();
        }
        int[] max = getMax(arr, arr.length);
        int maxl=max[0];
        int maxr=max[1];
        for(int i=maxl;i<=maxr;i++){
            arr[i]*=k;
        }
        int[] min = getMin(arr, arr.length);
        int minl=min[0];
        int minr=min[1];
        for(int i=minl;i<=minr;i++)
            arr[i]*=k;
        int sum=0;
        for(int i=0;i<arr.length;i++)
            sum+=arr[i];
        System.out.println(sum);
    }
    public static int[] getMax(int[] arr,int n){
        int maxSoFar=arr[0];
        int maxEndingHere=arr[0];
        int start=0;
        int s=0;
        int end=0;
        for(int i=1;i<n;i++){
            if(arr[i]>maxEndingHere+arr[i]){
                maxEndingHere=arr[i];
                s=i;
            }
            else {
                maxEndingHere+=arr[i];
            }
            if(maxEndingHere>maxSoFar){
                maxSoFar=maxEndingHere;
                start=s;
                end=i;
            }
        }
        return new int[]{start,end};
    }
    public static int[] getMin(int[] arr,int n){
        int maxSoFar=arr[0];
        int maxEndingHere=arr[0];
        int start=0;
        int s=0;
        int end=0;
        for(int i=1;i<n;i++){
            if(arr[i]<maxEndingHere+arr[i]){
                maxEndingHere=arr[i];
                s=i;
            }
            else {
                maxEndingHere+=arr[i];
            }
            if(maxEndingHere<maxSoFar){
                maxSoFar=maxEndingHere;
                start=s;
                end=i;
            }
        }
        return new int[]{start,end};
    }
    @Test
    public void test(){
        int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] max = getMax(ints, ints.length);
        System.out.println(Arrays.toString(max));
    }
}
