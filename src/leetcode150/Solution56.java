package leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:03 2024/7/30
 */
public class Solution56 {
    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        int[][] merge = solution56.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for(int[] ints:merge){
            System.out.println(Arrays.toString(ints));
        }
        Solution56Ⅰ solution56Ⅰ = new Solution56Ⅰ();
        int[][] merge1 = solution56Ⅰ.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for(int[] arr:merge1){
            System.out.println(Arrays.toString(arr));
        }
    }
    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> result=new ArrayList<>();
        if(intervals.length==1){
            return intervals;
        }
        if(intervals[1][0]<=intervals[0][1]&&intervals[1][1]<=intervals[0][1]){
            result.add(intervals[0]);
        }
        else if(intervals[1][0]<=intervals[0][1]&&intervals[1][1]>intervals[0][1]){
            int[] ints = new int[2];
            ints[0]=intervals[0][0];
            ints[1]=intervals[1][1];
            result.add(ints);
        }
        else {
            result.add(intervals[0]);
            result.add(intervals[1]);
        }
        for(int i=2;i<intervals.length;i++){
            int[] ints = result.get(result.size() - 1);
            if(intervals[i][0]<=ints[1]&&intervals[i][1]<=ints[1]){
                continue;
            }
            else if(intervals[i][0]<=ints[1]&&intervals[i][1]>ints[1]){
                int[] ints1 = new int[2];
                ints1[0]=ints[0];
                ints1[1]=intervals[i][1];
                result.remove(result.size()-1);
                result.add(ints1);
            }
            else
                result.add(intervals[i]);
        }
        int[][] ints = new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            ints[i]=result.get(i);
        }
        return ints;
    }
}
class Solution56Ⅰ{
    public int[][] merge(int[][] intervals){
        if(intervals.length<=1)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> result=new ArrayList<>();
        result.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] ints = result.get(result.size() - 1);
            if(intervals[i][0]<=ints[1]&&intervals[i][1]<=ints[1])
                continue;
            if(intervals[i][0]<=ints[1]&&intervals[i][1]>ints[1]){
                int[] res = new int[2];
                res[0]=ints[0];
                res[1]=intervals[i][1];
                result.remove(result.size()-1);
                result.add(res);
            }
            else if(intervals[i][0]>ints[1])
                result.add(intervals[i]);
        }
        int[][] last = new int[result.size()][];
        for(int i=0;i< result.size();i++)
            last[i]=result.get(i);
        return last;
    }
}