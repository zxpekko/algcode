package chaintable;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:56 2024/5/20
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;
        while (cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                int x =cur.next.val;
                while (cur.next!=null&&cur.next.val==x)
                    cur.next=cur.next.next;
            }
            else
                cur.next=cur.next.next;
        }
        return dummy.next;
    }
}
class Solution82Ⅰ{
    public ListNode deleteDuplicates(ListNode head){
        if(head==null)
            return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;
        while (cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                int x=cur.next.val;
                while (cur.next!=null&&cur.next.val==x)
                    cur.next=cur.next.next;
            }
            else cur=cur.next;
        }
        return dummy.next;
    }
}
class Solution82Ⅱ{
    public ListNode deleteDuplicates(ListNode head){
        if(head==null)
            return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;
        while (cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                int x=cur.next.val;
                while (cur.next!=null&&cur.next.val==x)
                    cur.next=cur.next.next;
            }
            else
                cur=cur.next;
        }
        return dummy.next;
    }
}
class Solution82Ⅲ{
    public ListNode deleteDuplicates(ListNode head){
        if(head==null)
            return null;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=dummy;
        while (cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                int x=cur.next.val;
                while (cur.next!=null&&cur.next.val==x)
                    cur.next=cur.next.next;
            }
            else cur=cur.next;
        }
        return dummy.next;
    }
}