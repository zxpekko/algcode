package leetcode150;

import java.util.*;

/**
 * @Author:zxp
 * @Description:
 * @Date:23:46 2024/8/8
 */
public class Solution133 {
    public Node2 cloneGraph(Node2 node){
        if(node==null)
            return null;
        if(node.neighbors.size()==0)
            return new Node2(node.val);
        Queue<Node2> queue=new LinkedList<>();
        HashMap<Node2,Node2> visited=new HashMap<>();
        visited.put(node,new Node2(node.val,new ArrayList<>()));
        queue.offer(node);
        while (!queue.isEmpty()){
            Node2 poll = queue.poll();
            for(Node2 neighbor: poll.neighbors){
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor,new Node2(neighbor.val,new ArrayList<>()));
                    queue.offer(neighbor);
                }
                visited.get(poll).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}
class Solution133Ⅰ{
    public Node2 cloneGraph(Node2 node){
        if(node==null)
            return node;
        Queue<Node2> queue=new LinkedList<>();
        queue.offer(node);
        HashMap<Node2,Node2> visited=new HashMap<>();
        visited.put(node,new Node2(node.val,new ArrayList<>()));
        while (!queue.isEmpty()){
            Node2 poll = queue.poll();
            for(Node2 neighbor:poll.neighbors){
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor,new Node2(neighbor.val,new ArrayList<>()));
                    queue.offer(neighbor);
                }
                visited.get(poll).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}
class Node2 {
    public int val;
    public List<Node2> neighbors;
    public Node2() {
        val = 0;
        neighbors = new ArrayList<Node2>();
    }
    public Node2(int _val) {
        val = _val;
        neighbors = new ArrayList<Node2>();
    }
    public Node2(int _val, ArrayList<Node2> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
