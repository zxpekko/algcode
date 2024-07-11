package array;

import java.util.LinkedHashMap;

/**
 * @Author:zxp
 * @Description:
 * @Date:20:20 2024/5/7
 */
//public class LRU {
//    int cap;
//    LinkedHashMap<Integer,Integer> record=new LinkedHashMap<>();
//    public LRU(int capacity){
//        this.cap=capacity;
//    }
//    public int get(int key){
//        if(!record.containsKey(key))
//            return -1;
//        makeRecently(key);
//        return record.get(key);
//    }
//    public void put(int key,int value){
//        if(record.containsKey(key)){
//            makeRecently(key);
//            record.put(key,value);
//            return;
//        }
//        if(record.size()>=cap){
//            Integer oldest = record.keySet().iterator().next();
//            record.remove(oldest);
//        }
//        record.put(key,value);
//    }
//    public void makeRecently(int key){
//        Integer value = record.get(key);
//        record.remove(key);
//        record.put(key,value);
//    }
//}
//public class LRU {
//    int cap;
//    LinkedHashMap<Integer,Integer> record=new LinkedHashMap<>();
//    public LRU(int capacity){
//        this.cap=capacity;
//    }
//    public int get(int key){
//        if(record.containsKey(key)){
//            makeRecently(key);
//            return record.get(key);
//        }
//        return -1;
//    }
//    public void put(int key,int val){
//        if(record.containsKey(key)){
//            makeRecently(key);
//            record.put(key,val);
//            return;
//        }
//        if(record.size()>=cap){
//            Integer oldest = record.keySet().iterator().next();
//            record.remove(oldest);
//        }
//        record.put(key,val);
//    }
//    public void makeRecently(int key){
//        Integer val = record.get(key);
//        record.remove(key);
//        record.put(key,val);
//    }
//}
public class LRU {
    int cap;
    LinkedHashMap<Integer,Integer> cache=new LinkedHashMap<>();
    public LRU(int capacity){
        this.cap=capacity;
    }
    public int get(int key){
        if(cache.containsKey(key)){
            makeRecently(key);
            return cache.get(key);
        }
        else
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
        Integer value = cache.get(key);
        cache.remove(key);
        cache.put(key,value);
    }
}
