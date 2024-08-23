package interview;

import com.sun.org.apache.bcel.internal.generic.DADD;
import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:23 2024/8/22
 */
public class Solution10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0;i<t;i++){
            String xiadan = scanner.next();
            String yuji = scanner.next();
            String shiji = scanner.next();
            int yujihuafei = judge(xiadan, yuji);
            int shijihuafei=judge(xiadan,shiji);
            if(shijihuafei<=yujihuafei)
                System.out.println("No");
            else
                System.out.println("Yes");
        }
    }
    public static int judge(String s1,String s2){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime parse1 = LocalTime.parse(s1);
        LocalTime parse2 = LocalTime.parse(s2);
        int m1=parse1.getHour()*60+parse1.getMinute();
        int m2=parse2.getHour()*60+parse2.getMinute();
        int diff=m2-m1;
        if(diff<0)
            diff+=1440;
        return diff;
    }

}
