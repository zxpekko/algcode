package leetcode150;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:06 2024/7/31
 */
public class Solution452 {
    public static void main(String[] args) {
        Solution452 solution452 = new Solution452();
        System.out.println(solution452.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }
    public int findMinArrowShots(int[][] points){
        if(points.length==1)
            return 1;
        if(points.length==2&&points[0][1]<0&&points[1][0]>0){
            return 2;
        }
        Arrays.sort(points,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[1]-o2[1];
            }
        });
        int result=1;
        int right=points[0][1];
        for(int i=0;i<points.length;i++){
            if(points[i][0]>right){
                right=points[i][1];
                result++;
            }
        }
        return result;
    }
}