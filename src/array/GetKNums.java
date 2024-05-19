package array;

import java.util.*;

/**
 * @Author:zxp
 * @Description:m*n的矩阵，行有序，列无序，找出前k大的值
 * @Date:10:49 2024/5/7
 */
public class GetKNums {
    public static void main(String[] args) {
        GetKNums getKNums = new GetKNums();
        System.out.println(getKNums.getKNums(new int[][]{{1, 2, 4}, {2, 3, 5}, {1, 3, 7}}, 4));
        System.out.println(getKNums.getKNumsByPri(new int[][]{{1, 2, 4}, {2, 3, 5}, {1, 3, 7}}, 4));
    }
    public List<Integer> getKNums(int[][] nums,int k){//时间复杂度为O(km)
        List<Integer> result=new ArrayList<>();
        int m=nums.length;
        int n=nums[0].length;
        int[] index = new int[m];
        Arrays.fill(index,n-1);
        for(int i=0;i<k;i++){
            int max=Integer.MIN_VALUE;
            int maxRow=Integer.MIN_VALUE;
            for(int j=0;j<m;j++){
                if(index[j]<0)
                    continue;
                if(nums[j][index[j]]>max){
                    max=nums[j][index[j]];
                    maxRow=j;
                }
            }
            result.add(max);
            index[maxRow]--;
        }
        return result;
    }
    public List<Integer> getKNumsByPri(int[][] nums,int k){//利用优先级队列维护大小为m的大根堆，
        // 每次都弹出堆顶的元素，执行k次，维护堆的时间复杂度为logm(堆的大小)
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2]-o1[2];
            }
        });
        int m=nums.length;
        int n=nums[0].length;
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<m;i++)
            priorityQueue.offer(new int[]{i,n-1,nums[i][n-1]});
        for(int i=0;i<k;i++){
            int[] poll = priorityQueue.poll();
            result.add(poll[2]);
            if(poll[1]>=1)
                priorityQueue.offer(new int[]{poll[0],poll[1]-1,nums[poll[0]][poll[1]-1]});
        }
        return result;
    }
}
