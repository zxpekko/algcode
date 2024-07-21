package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:06 2024/7/19
 */
public class Solution274 {
    public static void main(String[] args) {
        Solution274 solution274 = new Solution274();
        System.out.println(solution274.hIndex(new int[]{1,3,1}));
    }
    public int hIndex(int[] citations){
        int n=citations.length;
        int left=0,right=n,h=0;
        while (left<=right){
            int mid=(left+right)/2;
            int count = computeHIndex(citations, mid);
            if(count>=mid){
                h=Math.max(h,mid);
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        return h;
    }
    public int computeHIndex(int[] citations,int wait){
        int count=0;
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=wait)
                count++;
        }
        return count;
    }
}
