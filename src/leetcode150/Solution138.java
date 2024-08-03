package leetcode150;

import java.util.HashMap;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:24 2024/8/1
 */
public class Solution138 {
    public Node copyRandomList(Node head){
        Node newHead = new Node(0);
        Node p=head;
        Node q=newHead;
        int count=0;
        while (p!=null){
            Node node = new Node(p.val);
            q.next=node;
            p=p.next;
            q=q.next;
            count++;
        }
        int[] randIndex = new int[count];
        p=head;
        int index=0;
        while (p!=null){
            Node random = p.random;
            count=0;
            if(random==null)
                randIndex[index++]=-1;
            else {
                Node cur=head;
                while (cur!=null){
                    if(cur==random){
                        randIndex[index++]=count;
                        break;
                    }
                    else {
                        cur=cur.next;
                        count++;
                    }
                }
            }
            p=p.next;
        }
        p=newHead.next;
        index=0;
        while (p!=null){
            int curRand = randIndex[index];
            if(curRand==-1)
                p.random=null;
            else {
                Node cur=newHead.next;
                int curCount=0;
                while (curCount<curRand){
                    cur=cur.next;
                    curCount++;
                }
                p.random=cur;
            }
            p=p.next;
        }
        //计算每个节点在原链表中的random索引，然后到新的里面这么操作。
        return newHead.next;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution138Ⅰ{
    HashMap<Node,Node> hashMap=new HashMap<>();
    public Node copyRandomList(Node head){
        if(head==null)
            return head;
        if(!hashMap.containsKey(head)){
            Node newHead=new Node(head.val);
            hashMap.put(head,newHead);
            newHead.next=copyRandomList(head.next);
            newHead.random=copyRandomList(head.random);
        }
        return hashMap.get(head);
    }
}
class Solution138Ⅱ{
    HashMap<Node,Node> hashMap=new HashMap<>();
    public Node copyRandomList(Node head){
        if(head==null)
            return head;
        if(!hashMap.containsKey(head)){
            Node newHead=new Node(head.val);
            hashMap.put(head,newHead);
            newHead.next=copyRandomList(head.next);
            newHead.random=copyRandomList(head.random);
        }
        return hashMap.get(head);
    }
}
