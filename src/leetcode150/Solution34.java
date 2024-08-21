package leetcode150;

import javax.xml.bind.annotation.XmlMimeType;
import java.util.Arrays;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:55 2024/8/21
 */
public class Solution34 {
    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] ints = solution34.searchRange(new int[]{5, 7, 7, 8, 8, 10},6);
        System.out.println(Arrays.toString(ints));
    }
    int left=-1;
    int right=-1;
    public int[] searchRange(int[] nums, int target){
        search(nums,target,0,nums.length-1);
        return new int[]{left,right};
    }
    public void search(int[] nums,int target,int left,int right){
        if(left>right)
            return;
        int l=left,r=right;
        while (l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                int curLeft=this.left;
                int curRight=this.right;
                if(this.left==-1)
                    this.left=mid;
                else this.left=Math.min(this.left,mid);
                if(this.right==-1)
                    this.right=mid;
                else this.right=Math.max(this.right, mid);
                if(curLeft==this.left&&curRight==this.right)
                    return;
                search(nums,target,left,mid-1);
                search(nums,target,mid+1,right);
            }
            else if(nums[mid]>target)
                r=mid-1;
            else l=mid+1;
        }
    }
}
