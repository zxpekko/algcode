package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:16 2024/5/29
 */
public class Solution373 {
    public static void main(String[] args) {
        Solution373 solution373 = new Solution373();
        System.out.println(solution373.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println(solution373.kSmallestPairsⅡ(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k){
        int m=nums1.length,n=nums2.length;
        PriorityQueue<int[]> priorityQueue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]+o2[1]-o1[0]-o1[1];
            }
        });
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(priorityQueue.size()<k)
                    priorityQueue.offer(new int[]{nums1[i],nums2[j]});
                else if(nums1[i]+nums2[j]<priorityQueue.peek()[0]+priorityQueue.peek()[1]){
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{nums1[i],nums2[j]});
                }
            }
        }
        List<List<Integer>> midResult=new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            List<Integer> subReuslt=new ArrayList<>();
            int[] poll = priorityQueue.poll();
            subReuslt.add(poll[0]);
            subReuslt.add(poll[1]);
            midResult.add(subReuslt);
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int i=midResult.size()-1;i>=0;i--)
            result.add(midResult.get(i));
        return result;
    }
    public List<List<Integer>> kSmallestPairsⅡ(int[] nums1, int[] nums2, int k){
        int m=nums1.length;
        int n=nums2.length;
        int[][] nums = new int[m * n][2];
        int index=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                nums[index++]=new int[]{nums1[i],nums2[j]};
            }
        }
        for(int i=m*n/2-1;i>=0;i--)
            heapfy(nums,m*n,i);
        List<List<Integer>> result=new ArrayList<>();
        int curK=0;
        for(int i=m*n-1;i>=0;i--){
            int[] temp=nums[0];
            nums[0]=nums[i];
            nums[i]=temp;
            heapfy(nums,i,0);
            List<Integer> subResult=new ArrayList<>();
            subResult.add(temp[0]);
            subResult.add(temp[1]);
            result.add(subResult);
            curK++;
            if(curK==k)
                return result;
        }
        return null;
    }
    public void heapfy(int[][] nums,int n,int i){
        int left=2*i+1;
        int right=2*i+2;
        int smallest=i;
        if(left<n&&nums[left][0]+nums[left][1]<nums[smallest][0]+nums[smallest][1])
            smallest=left;
        if(right<n&&nums[right][0]+nums[right][1]<nums[smallest][0]+nums[smallest][1])
            smallest=right;
        if(smallest!=i){
            int[] temp=nums[smallest];
            nums[smallest]=nums[i];
            nums[i]=temp;
            heapfy(nums,n,smallest);
        }
    }
}
