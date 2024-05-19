package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:40 2024/5/15
 */
public class Solution56 {
    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
//        int[][] merge = solution56.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        int[][] merge = solution56.merge(new int[][]{{1, 4},{4,5}});
        for(int[] me:merge){
            System.out.println(Arrays.toString(me));
        }
    }
    public int[][] merge(int[][] intervals){
        if(intervals.length<=1)
            return intervals;
        int n=intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> result=new ArrayList<>();
        if(intervals[1][0]>=intervals[0][0]&&intervals[1][0]<=intervals[0][1]){
            int left=intervals[0][0];
            int right=Math.max(intervals[0][1],intervals[1][1]);
            result.add(new int[]{left,right});
        }
        else {
            result.add(intervals[0]);
            result.add(intervals[1]);
        }
        for(int i=2;i<n;i++){
            int[] subResult=result.get(result.size()-1);
            if(intervals[i][0]>=subResult[0]&&intervals[i][0]<=subResult[1]){
                int left=subResult[0];
                int right=Math.max(intervals[i][1],subResult[1]);
                result.remove(result.size()-1);
                result.add(new int[]{left,right});
            }
            else {
                result.add(intervals[i]);
            }
        }
        int size=result.size();
        int[][] last= new int[size][2];
        for(int i=0;i<size;i++){
            last[i][0]=result.get(i)[0];
            last[i][1]=result.get(i)[1];
        }
        return last;
    }
}
