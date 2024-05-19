package array;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:01 2024/5/17
 */
public class LRUCache {
    int cap;
    LinkedHashMap<Integer,Integer> cache=new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap=capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key,value);
            makeRecently(key);
            return;
        }
        if(cache.size()>=this.cap){
            Integer oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key,value);
    }
    public void makeRecently(int key){
        Integer val = cache.get(key);
        cache.remove(key);
        cache.put(key,val);
    }
}
