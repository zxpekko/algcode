package leetcode150;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:09 2024/8/4
 */
public class Solution86 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        listNode5.next=listNode6;
        Solution86 solution86 = new Solution86();
        ListNode partition = solution86.partition(listNode1, 3);
        while (partition!=null){
            System.out.println(partition.val);
            partition=partition.next;
        }
    }
    public ListNode partition(ListNode head, int x){
        if(head==null)
            return head;
        List<ListNode> small=new ArrayList<>();
        List<ListNode> big=new ArrayList<>();
        ListNode p=head;
        while (p!=null){
            if(p.val<x){
                small.add(p);
            }
            else {
                big.add(p);
            }
            p=p.next;
        }
        ListNode dummy=new ListNode(0);
        p=dummy;
        for(int i=0;i<small.size();i++){
            p.next=small.get(i);
            p=p.next;
        }
        for(int i=0;i<big.size();i++){
            p.next=big.get(i);
            p=p.next;
        }
        p.next=null;
        return dummy.next;
    }
}