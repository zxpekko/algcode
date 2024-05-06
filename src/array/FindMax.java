package array;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:04 2024/5/3
 */
public class FindMax {
    public static void main(String[] args) {
        FindMax findMax = new FindMax();
        System.out.println(findMax.getK(new int[]{1, 2, 4, 5}, new int[]{3, 7}, 3));
    }
    public int getK(int[] arr1,int[] arr2,int k){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int curk=0;
        int m=arr1.length,n=arr2.length;
        int index1=m-1,index2=n-1;
        while (index1>=0&&index2>=0){
            if(curk==k-1)
                return Math.max(arr1[index1],arr2[index2]);
            else {
                if(arr1[index1]>=arr2[index2])
                    index1--;
                else
                    index2--;
                curk++;
            }
        }
        return 0;
    }
}
