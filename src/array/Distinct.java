package array;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:58 2024/7/12
 */
public class Distinct {
    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 3, 4, 4};
        Distinct distinct = new Distinct();
        System.out.println(distinct.distinct(ints));
        int[] ints1 = {1, 1, 1, 2, 2, 3, 4, 4, 4};
        System.out.println(distinct.distinct2(ints1));
    }
    public int distinct(int[] arr){
        int n=arr.length;
        int p=0,q=1;
        while (q<n){
            if(arr[p]==arr[q]){
                q++;
            }
            else {
                arr[p+1]=arr[q];
                p++;
                q++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return p+1;
    }
    public int distinct2(int[] arr){
        int p=0,q=1,n=arr.length;
        int count=1;
        while (q<n){
            if(arr[p]==arr[q]){
                if(count<2){
                    arr[p+1]=arr[q];
                    p++;
                    q++;
                    count++;
                }
                else q++;
            }
            else{
                count=1;
                arr[p+1]=arr[q];
                p++;
                q++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return p+1;
    }
}