package array;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:01 2024/5/17
 */
public class LRUCache {
//    int cap;
//    LinkedHashMap<Integer,Integer> cache=new LinkedHashMap<>();
//
//    public LRUCache(int capacity) {
//        this.cap=capacity;
//    }
//
//    public int get(int key) {
//        if(!cache.containsKey(key))
//            return -1;
//        makeRecently(key);
//        return cache.get(key);
//    }
//
//    public void put(int key, int value) {
//        if(cache.containsKey(key)){
//            cache.put(key,value);
//            makeRecently(key);
//            return;
//        }
//        if(cache.size()>=this.cap){
//            Integer oldestKey = cache.keySet().iterator().next();
//            cache.remove(oldestKey);
//        }
//        cache.put(key,value);
//    }
//    public void makeRecently(int key){
//        Integer val = cache.get(key);
//        cache.remove(key);
//        cache.put(key,val);
//    }
//    int cap;
//    LinkedHashMap<Integer,Integer> cache=new LinkedHashMap<>();
//    public LRUCache(int capacity){
//        this.cap=capacity;
//    }
//    public int get(int key){
//        if(!cache.containsKey(key))
//            return -1;
//        makeRecently(key);
//        return cache.get(key);
//    }
//    public void put(int key, int value){
//        if(cache.containsKey(key)){
//           makeRecently(key);
//           cache.put(key,value);
//           return;
//        }
//        if(cache.size()>=this.cap){
//            Integer  oldest= cache.keySet().iterator().next();
//            cache.remove(oldest);
//        }
//        cache.put(key,value);
//    }
//    public void makeRecently(int key){
//        Integer value = cache.get(key);
//        cache.remove(key);
//        cache.put(key,value);
//    }
//    int cap;
//    private LinkedHashMap<Integer,Integer> cache=new LinkedHashMap<>();
//    public LRUCache(int capacity){
//        this.cap=capacity;
//    }
//    public int get(int key){
//        if(!cache.containsKey(key))
//            return -1;
//        makeRecently(key);
//        return cache.get(key);
//    }
//    public void put(int key, int value){
//        if(cache.containsKey(key)){
//            makeRecently(key);
//            cache.put(key,value);
//            return;
//        }
//        if(cache.size()>=cap){
//            Integer oldest = cache.keySet().iterator().next();
//            cache.remove(oldest);
//        }
//        cache.put(key,value);
//    }
//    public void makeRecently(int key){
//        Integer value = cache.get(key);
//        cache.remove(key);
//        cache.put(key,value);
//    }
    int cap;
    LinkedHashMap<Integer,Integer> cache=new LinkedHashMap<>();
    public LRUCache(int capacity){
        this.cap=capacity;
    }
    public int get(int key){
        if(cache.containsKey(key)){
            makeRecently(key);
            return cache.get(key);
        }
        return -1;
    }
    public void put(int key, int value){
        if(cache.containsKey(key)){
            makeRecently(key);
            cache.put(key,value);
            return;
        }
        else if(cache.size()>=this.cap){
            Integer oldest = cache.keySet().iterator().next();
            cache.remove(oldest);
        }
        cache.put(key,value);
    }
    public void makeRecently(int key){
        int val=cache.get(key);
        cache.remove(key);
        cache.put(key,val);
    }

}
