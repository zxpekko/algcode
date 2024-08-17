package interview;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:07 2024/8/17
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int index=0;
        while (n-->0){
            arr[index++]=scanner.nextInt();
        }
        Arrays.sort(arr);
        if(arr.length%2!=0){
            int mid=arr[arr.length/2];
            int gap=0;
            for(int i=0;i<arr.length;i++){
                gap+=(Math.abs(arr[i]-mid));
            }
            System.out.println(gap/2);
        }
        else {
            int mid1=arr.length/2;
            int mid2=arr.length/2-1;
            int gap1=getGap(arr,mid1);
            int gap2=getGap(arr,mid2);
            int trueGap=Math.min(gap1,gap2);
            System.out.println(trueGap/2);
        }

    }
    public static int getGap(int[] arr,int mid){
        int gap=0;
        for(int i=0;i<arr.length;i++){
            gap+=(Math.abs(arr[i]-arr[mid]));
        }
        return gap;
    }
}