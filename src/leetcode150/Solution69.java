package leetcode150;

import javax.xml.bind.annotation.XmlMimeType;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:09 2024/8/21
 */
public class Solution69 {
    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        System.out.println(solution69.mySqrt(10));
    }
    double pow=0.0000000001;
    public double mySqrt(int x){
        double left=0,right=x;
        while (left<right){
            double mid=(left+right)/2;
            if(mid* mid==x)
              return mid;
            else if(mid*mid>x)
                right=mid;
            else left=mid;
            if(Math.abs(mid*mid-x)<pow)
                return mid;
        }
        return 0;
    }
}
