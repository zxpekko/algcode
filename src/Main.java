import java.util.*;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:48 2024/7/6
 */
public class Main {
    public static void main(String[] args) {
        List<String> result=new ArrayList<>();
        Main.dfs("19216811",0,0,result);
//        String[] objects = (String[])result.toArray();
//        System.out.println(Arrays.toString(objects));
        String[] strings=new String[result.size()];
        for(int i=0;i< result.size();i++){
            strings[i]=result.get(i);
        }
        System.out.println(Arrays.toString(strings));
        System.out.print("[");
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
        System.out.print("]");
    }
    public static List<String> restoreIpAddresses(String s){
        List<String> result=new ArrayList<>();
        if(s.length()<4)
            return result;
        dfs(s,0,0,result);
        return result;
    }
    public static void dfs(String str,int start,int pointNum, List<String> result){
        if(pointNum==3){
            String substring = str.substring(start);
            if(judgeIsValid(substring))
                result.add(str);
        }
        for(int i=start;i<str.length();i++){
            String substring = str.substring(start,i+1);
            if(judgeIsValid(substring)){
                str=str.substring(0,i+1)+"."+str.substring(i+1);
                pointNum+=1;
                dfs(str,i+2,pointNum,result);
                pointNum-=1;
                str=str.substring(0,i+1)+str.substring(i+2);
            }
        }
    }
    public static boolean judgeIsValid(String s){
        if(s.length()>3||s.length()<1)
            return false;
        if(s.length()>1&&s.charAt(0)=='0')
            return false;
        if(Integer.parseInt(s)>255)
            return false;
        return true;
    }
}
