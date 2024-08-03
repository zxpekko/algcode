package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:50 2024/7/21
 */
public class Solution6 {
    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        System.out.println(solution6.convert("PAYPALISHIRING", 3));
        Solution6Ⅰ solution6Ⅰ = new Solution6Ⅰ();
        System.out.println(solution6Ⅰ.convert("PAYPALISHIRING", 3));
    }
    public String convert(String s, int numRows){
        int n=s.length();
        if(numRows==1||numRows>=n)
            return s;
        int t=numRows*2-2;
        int col=(n+t-1)/t*(numRows-1);
        char[][] mat = new char[numRows][col];
        for(int i=0,x=0,y=0;i<n;i++){
            mat[x][y]=s.charAt(i);
            if(i%t<numRows-1)
                x++;
            else {
                x--;
                y++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]!=0)
                    stringBuilder.append(mat[i][j]);
            }
        }
        return stringBuilder.toString();
    }
}
class Solution6Ⅰ{
    public String convert(String s, int numRows){
        int n=s.length();
        int t=2*numRows-2;
        int tNums=(n+t-1)/t;
        int col=tNums*(numRows-1);
        char[][] mat = new char[numRows][col];
        for(int i=0,x=0,y=0;i<n;i++){
            mat[x][y]=s.charAt(i);
            if(i%t<numRows-1)
                x++;
            else {
                x--;
                y++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]!=0)
                    stringBuilder.append(mat[i][j]);
            }
        }
        return stringBuilder.toString();
    }
}
