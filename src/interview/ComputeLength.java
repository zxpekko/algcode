package interview;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:23:14 2024/5/1
 */
public class ComputeLength {
    public static void main(String[] args) {
        ComputeLength computeLength = new ComputeLength();
        System.out.println(computeLength.computeLength(new int[]{1, 9, 3, 4, 15, 2, 7, 6, 5, 8}));
    }
    public int computeLength(int[] arr){
        int max=-1;
        int curMax=1;
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=1;i<n;i++){
            if(arr[i]==arr[i-1]+1)
                curMax++;
            else {
                max= Math.max(max,curMax);
                curMax=1;
            }
        }
        return max;
    }
}
