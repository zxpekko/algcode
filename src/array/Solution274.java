package array;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:03 2024/5/7
 */
public class Solution274 {
    public static void main(String[] args) {
        Solution274 solution274 = new Solution274();
        System.out.println(solution274.hIndex(new int[]{0,1}));
    }
    public int hIndex(int[] citations){
        int right=citations.length;
        int left=1;
        int result=Integer.MIN_VALUE;
        while (left<=right){
            int mid=(left+right)/2;
            int great = great(citations, mid);
            if(great>=mid){
                result=Math.max(result,mid);
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        return result==Integer.MIN_VALUE?0:result;
    }
    public int great(int[] citations,int h){
        int index=0;
        for(int i=0;i<citations.length;i++){
            if(citations[i]>=h)
                index++;
        }
        return index;
    }
}
