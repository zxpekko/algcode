package interview;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:00 2024/8/10
 */
public class TwoSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x=scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int num:arr){
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }
        int count=0;
        System.out.println(hashMap.size());
        for(int num:arr){
            if(hashMap.containsKey(x-num)){
                count+=hashMap.get(x-num);
            }
        }
        System.out.println(count);
    }
}
