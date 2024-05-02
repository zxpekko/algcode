package array;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:11 2024/5/1
 */
public class DeleteNums {
    public static void main(String[] args) {
        DeleteNums deleteNums = new DeleteNums();
        System.out.println(deleteNums.deleteNums(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
    public int deleteNums(int[] arr){
        int p=0,q=1;
        int n=arr.length;
        while (q<n){
            if(arr[p]!=arr[q]){
                arr[p+1]=arr[q];
                p++;
                q++;
            }
            else {
                q++;
            }
        }
//        System.out.println(Arrays.toString(arr));
        return p+1;
    }
}
