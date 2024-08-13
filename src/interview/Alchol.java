package interview;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:32 2024/8/10
 */
public class Alchol {
    static int[] directions=new int[]{0,1,2,3};//上下左右
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index=0;
        String s=scanner.nextLine();
        int curX=0,curY=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='S')
                continue;
            else if(s.charAt(i)=='W'){
                int curDir=directions[index];
                if(curDir==0)
                    curY++;
                else if(curDir==1)
                    curY--;
                else if(curDir==2)
                    curX--;
                else curX++;
            }
            else if(s.charAt(i)=='A'){
                if(index==0)
                    index=2;
                else if(index==1)
                    index=3;
                else if(index==2)
                    index=1;
                else
                    index=0;
            }
            else {
                if(index==0)
                    index=3;
                else if(index==1)
                    index=2;
                else if(index==2)
                    index=0;
                else index=1;
            }
        }
        System.out.print(curX);
        System.out.print(" ");
        System.out.print(curY);
    }

}
