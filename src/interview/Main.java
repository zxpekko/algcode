package interview;

import java.util.*;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:21 2024/8/10
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        String correct=scanner.next();
        Set<String> passwordSet=new HashSet<>();
        List<String> passwords=new ArrayList<>();
        for(int i=0;i<n;i++){
            String pass=scanner.next();
            if(!passwordSet.contains(pass)){
                passwords.add(pass);
                passwordSet.add(pass);
            }
        }
        passwords.sort(Comparator.comparingInt(String::length));
        int correctLength=correct.length();
        int minCorrectNums=0;
        int minAndEqualLength=0;
        for(int i=0;i<passwords.size();i++){
            if(passwords.get(i).length()<correctLength){
                minCorrectNums++;
            }
            if(passwords.get(i).length()<=correctLength)
                minAndEqualLength++;
        }
        System.out.print(minCorrectNums+1);
        System.out.print(" ");
        System.out.print(minAndEqualLength);
    }

}
