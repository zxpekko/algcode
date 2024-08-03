package leetcode150;

import graphtheory.LargestIsland;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:34 2024/7/30
 */
public class Solution57 {
    public static void main(String[] args) {
        Solution57 solution57 = new Solution57();
        int[][] insert = solution57.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        for(int[] ints:insert){
            System.out.println(Arrays.toString(ints));
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval){
        int n=intervals.length;
        int[][] lastIntervals = new int[intervals.length + 1][2];
        int i=0,index=0;
        while (i<n){
            if(intervals[i][0]<=newInterval[0]){
                lastIntervals[index++]=intervals[i++];
            }
            else {
                lastIntervals[index++]=newInterval;
                break;
            }
        }
        if(i<n){
            while (i<n)
                lastIntervals[index++]=intervals[i++];
        }
        else lastIntervals[index++]=newInterval;
        List<int[]> result=new ArrayList<>();
        if(lastIntervals.length==1)
            return lastIntervals;
        result.add(lastIntervals[0]);
        for(int j=1;j<lastIntervals.length;j++){
            int[] ints = result.get(result.size()-1);
            if(lastIntervals[j][1]<=ints[1])
                continue;
            else if(lastIntervals[j][0]<=ints[1]&&lastIntervals[j][1]>ints[1]){
                int[] ints1 = new int[2];
                ints1[0]=ints[0];
                ints1[1]=lastIntervals[j][1];
                result.remove(result.size()-1);
                result.add(ints1);
            }
            else
                result.add(lastIntervals[j]);
        }
        int[][] ints = new int[result.size()][2];
        for(int m=0;m<result.size();m++){
            ints[m]=result.get(m);
        }
        return ints;
    }
}