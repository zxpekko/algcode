package array;

import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:01 2024/7/12
 */
public class Solution206 {
//    public ListNode reverseList(ListNode head){
//        ListNode dummy=null,pre=head;
//        ListNode next=head.next;
//        while (pre!=null){
//            pre.next=dummy;
//            dummy=pre;
//            pre=next;
//            if(pre!=null)
//                next=pre.next;
//        }
//        return dummy;
//    }
    public ListNode reverseList(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

}
class Solution206Ⅰ{
    public ListNode reverseList(ListNode head){
        return reverse(null,head);
    }
    public ListNode reverse(ListNode pre,ListNode cur){
        if(cur==null)
            return pre;
        ListNode next=cur.next;
        cur.next=pre;
        return reverse(cur,next);
    }
}
class ListNode{
    ListNode next;
    int val;
    public ListNode(){

    }
    public ListNode(int val){
        this.val=val;
    }
}
class Solution206Ⅱ{
    public ListNode reverseList(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
class Solution206Ⅲ{
    public ListNode reverseList(ListNode head){
        return reverse(null,head);
    }
    public ListNode reverse(ListNode pre,ListNode cur){
        if(cur==null)
            return pre;
        ListNode next=cur.next;
        cur.next=pre;
        return reverse(cur,next);
    }
}