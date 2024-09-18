package interview;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:45 2024/9/3
 */
public class MainD1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String str=scanner.next();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        Character cur=str.charAt(0);
        int count=1;
        for(int i=1;i<str.length();i++){
            if(cur==str.charAt(i)){
                if(count<k)
                    count++;
                if(count==k){
                    count=0;
                    hashMap.put(str.charAt(i),hashMap.getOrDefault(str.charAt(i),0)+1);
                }
            }
            else {
                cur=str.charAt(i);
                count=1;
            }
        }
        if(hashMap.isEmpty())
            System.out.println(0);
        else {
            int max=0;
            for(Map.Entry<Character,Integer> entry:hashMap.entrySet()){
                int value =entry.getValue();
                if(value>max)
                    max=value;
            }
            System.out.println(max);
        }

    }
}
