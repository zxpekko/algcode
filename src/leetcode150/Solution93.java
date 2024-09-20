package leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:05 2024/9/20
 */
public class Solution93 {
    public static void main(String[] args) {
        Solution93 solution93 = new Solution93();
        System.out.println(solution93.restoreIpAddresses("101023"));
    }
    List<String> result=new ArrayList<>();
    public List<String> restoreIpAddresses(String s){
        dfs(s,0,0);
        return result;
    }
    public void dfs(String s,int start,int pointNum){
        if(pointNum==3){
            if(isValid(s.substring(start))){
                result.add(s);
            }
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isValid(s.substring(start,i+1))){
                s=s.substring(0,i+1)+"."+s.substring(i+1);
                pointNum++;
                dfs(s,i+2,pointNum);
                s=s.substring(0,i+1)+s.substring(i+2);
                pointNum--;
            }
        }
    }
    public boolean isValid(String s){
        if(s.length()>3||s.length()<1)
            return false;
        if(s.length()>1&&s.charAt(0)=='0')
            return false;
        if(Integer.parseInt(s)>255)
            return false;
        return true;
    }
}