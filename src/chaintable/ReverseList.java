package chaintable;

import com.sun.org.apache.bcel.internal.generic.LUSHR;

/**
 * @Author:zxp
 * @Description:给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * @Date:9:59 2024/1/17
 */
public class ReverseList {
    public ListNode reverseList(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}
class ReverseListⅡ{
    public ListNode reverseList(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode pre=head;
        ListNode p=pre.next;
        ListNode r=p.next;
        pre.next=null;
        p.next=pre;
        pre=p;
        p=r;
        if(r!=null)
            r=r.next;
        else
            return pre;
        while (p!=null){
            p.next=pre;
            pre=p;
            p=r;
            if(r!=null)
                r=r.next;
            else
                break;
        }
        return pre;
    }
    public ListNode reverseListⅡ(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}
class ReverseList1{
    public ListNode reverseList(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}
class ReverseList2{
    public ListNode reverseList(ListNode head){
        ListNode cur=head,pre=null;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }
}
class ReverseList3{
    public ListNode reverseList(ListNode head){
        ListNode pre=null,cur=head;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}