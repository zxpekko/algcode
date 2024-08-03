package leetcode150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:23 2024/8/3
 */
public class Get {
    List<Object> result=new ArrayList<>();

    public static void main(String[] args) {
        Get get = new Get();
        List<Object> arr=new ArrayList<>();
        arr.add(1);
        arr.add(2);
        List<Object> num=new ArrayList<>();
        num.add(3);
        arr.add(num);
        get.get(arr);
        System.out.println(get.result);
    }
    public void get(List<Object> arr){
        if(arr.size()==0)
            return;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i) instanceof Integer)
                result.add(arr.get(i));
            else
                get((List<Object>) arr.get(i));
        }
    }
}
