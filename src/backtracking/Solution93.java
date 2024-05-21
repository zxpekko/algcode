package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:50 2024/5/20
 */
public class Solution93 {
    public static void main(String[] args) {
        Solution93 solution93 = new Solution93();
        System.out.println(solution93.restoreIpAddresses("101023"));
    }
    List<String> result=new ArrayList<>();
    public List<String> restoreIpAddresses(String s){
        if(s.length()<4)
            return result;
        dfs(s,0,0);
        return result;
    }
    public void dfs(String s,int pointNum,int start){
        if(pointNum==3&&judgeIsValid(s.substring(start))){
            result.add(s);
            return;
        }
        for(int i=start;i<s.length();i++){
            if(judgeIsValid(s.substring(start,i+1))){
                s=s.substring(0,i+1)+"."+s.substring(i+1);
                pointNum++;
                dfs(s,pointNum,i+2);
                s=s.substring(0,i+1)+s.substring(i+2);
                pointNum--;
            }
        }
    }
    public boolean judgeIsValid(String s){
        if(s.length()>3||s.length()<1)
            return false;
        if(s.length()>1&&s.charAt(0)=='0')
            return false;
        if(Integer.parseInt(s)>255)
            return false;
        return true;
    }
}
