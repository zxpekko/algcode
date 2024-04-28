package array;

import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:58 2024/4/28
 */
public class MergeK {
    public static void main(String[] args) {
        MergeK mergeK = new MergeK();
        System.out.println(mergeK.getKth(new int[]{1, 3, 5, 8, 11, 13, 15, 17, 19, 21}, new int[]{2, 4, 7, 10}, 4));
    }
    public int getKth(int[] nums1,int[] nums2,int k){
        int curK=0;
        int index1=0,index2=0;
        while (index1<nums1.length&&index2< nums2.length){
            if(curK==k-1){
                if(nums1[index1]<nums2[index2])
                    return nums1[index1];
                else
                    return nums2[index2];
            }
            if(nums1[index1]<nums2[index2]){
                index1++;
                curK++;
            }
            else {
                index2++;
                curK++;
            }
        }
        return 0;
    }
}
