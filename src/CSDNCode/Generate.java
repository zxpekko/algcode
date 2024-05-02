package CSDNCode;

import array.Heap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:41 2024/4/29
 */
public class Generate {
    public static void main(String[] args) {
        HashSet<Integer> hashSet=new HashSet<>();
        for(int i=1;i<=100;i++)
            hashSet.add(i);
        List<Integer> result=new ArrayList<>();
        result.addAll(hashSet);
        hashSet.forEach(v->{
            result.add(v);
        });
        System.out.println(result);
    }
}
