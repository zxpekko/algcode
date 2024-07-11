package array;



//import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:17:45 2024/7/7
 */
public class Solution49 {
    public static void main(String[] args) {

    }
    public List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, List<String>> hashmap = new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            List<String> orDefault = hashmap.getOrDefault(key, new ArrayList<String>());
            orDefault.add(str);
            hashmap.put(key,orDefault);
        }
        return new ArrayList<>(hashmap.values());
    }
}
class Solution49Ⅰ{
    public List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, List<String>> hashmap = new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            List<String> orDefault = hashmap.getOrDefault(key, new ArrayList<>());
            orDefault.add(str);
            hashmap.put(key,orDefault);
        }
        return new ArrayList<>(hashmap.values());
    }
}