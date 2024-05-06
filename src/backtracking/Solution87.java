package backtracking;

import org.junit.experimental.theories.internal.SpecificDataPointsSupplier;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:16:33 2024/5/5
 */
public class Solution87 {
    public static void main(String[] args) {
        Solution87 solution87 = new Solution87();
//        System.out.println(solution87.restoreIpAddresses("25525511135"));
        System.out.println(solution87.restoreIpAddresses("0000"));
    }
    List<String> result=new ArrayList<>();
    public List<String> restoreIpAddresses(String s){
        dfs(s,0,0);
        return result;
    }
    public void dfs(String s,int startIndex,int pointNum){
        if(pointNum==3){
            if(isValid(s.substring(startIndex,s.length()))){
                result.add(new String(s));
            }
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            if(isValid(s.substring(startIndex,i+1))){
                s=s.substring(0,i+1)+"."+s.substring(i+1,s.length());
                pointNum++;
                dfs(s,i+2, pointNum);
                pointNum--;
                s=s.substring(0,i+1)+s.substring(i+2,s.length());
            }
            else break;
        }
    }
    public boolean isValid(String s){
        if(s.length()>1&&s.charAt(0)=='0')
            return false;
        else if(s.length()>3)
            return false;
        else if(Integer.parseInt(s)>255)
            return false;
        return true;
    }
}
