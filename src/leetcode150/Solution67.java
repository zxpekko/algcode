package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:17 2024/8/21
 */
public class Solution67 {
    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
        System.out.println(solution67.addBinary("1010", "1011"));
        System.out.println(solution67.addBinary1("1010", "1011"));
    }
    public String addBinary(String a, String b){
        int m=a.length(),n=b.length();
        StringBuilder longest,shortest;
        if(m>n){
            longest=new StringBuilder(a);
            int zeros=m-n;
            shortest=new StringBuilder();
            for(int i=0;i<zeros;i++)
                shortest.append("0");
            shortest.append(b);
        }
        else {
            longest=new StringBuilder(b);
            int zeros=n-m;
            shortest=new StringBuilder();
            for(int i=0;i<zeros;i++)
                shortest.append("0");
            shortest.append(a);
        }
        int jinwei=0,index=longest.length()-1;
        StringBuilder res=new StringBuilder();
        while (index>=0){
            int long1=longest.charAt(index)-'0';
            int short1=shortest.charAt(index)-'0';
            int cur=long1+short1+jinwei;
            if(cur==0){
                res.append("0");
                jinwei=0;
            }
            else if(cur==1){
                res.append("1");
                jinwei=0;
            }
            else if(cur==2){
                res.append("0");
                jinwei=1;
            }
            else if(cur==3){
                res.append("1");
                jinwei=1;
            }
            index--;
        }
        if(jinwei>0)
            res.append("1");

        return res.reverse().toString();
    }
    public String addBinary1(String a, String b){
        int aValue=0,bValue=0;
        int index=0;
        for(int i=a.length()-1;i>=0;i--){
            int jinzhi=a.charAt(i)-'0';
            aValue+=(jinzhi*Math.pow(2,index++));
        }
        index=0;
        for(int i=b.length()-1;i>=0;i--){
            int jinzhi=b.charAt(i)-'0';
            bValue+=(jinzhi*Math.pow(2,index++));
        }
        int res=aValue+bValue;
        StringBuilder stringBuilder=new StringBuilder();
        while (res>0){
            stringBuilder.append(res%2+"");
            res/=2;
        }
        return stringBuilder.reverse().toString();
    }
}