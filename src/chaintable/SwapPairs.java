package chaintable;

/**
 * @Author:zxp
 * @Description:给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * @Date:10:21 2024/1/17
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode pre=head;
        ListNode cur=head.next;
        ListNode resultNode=head.next;
        while (cur!=null){
            ListNode temp=cur.next;
            if(temp!=null&&temp.next!=null)
                pre.next=temp.next;
            else pre.next=cur.next;
            cur.next=pre;
            if(temp==null)
                return resultNode;
            pre=temp;
            cur=temp.next;
        }
        return resultNode;
    }
}
class SwapPairsⅡ{
    public ListNode swapPairs(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode next=head.next;
        ListNode newNode=swapPairs(next.next);
        next.next=head;
        head.next=newNode;
        return next;
    }
}
class SwapPairs1{
    public ListNode swapPairs(ListNode head){
        if(head==null&&head.next==null)
            return head;
        ListNode next=head.next;
        ListNode newNode=swapPairs(next.next);
        head.next=newNode;
        next.next=head;
        return next;
    }
}
class SwapPairs2{
    public ListNode swapPairs(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode next=head.next;
        ListNode newNode=swapPairs(next.next);
        head.next=newNode;
        next.next=head;
        return next;
    }
}
class SwapPairs3{
    public ListNode swapPairs(ListNode head){
        if(head==null&&head.next==null)
            return head;
        ListNode next=head.next;
        ListNode newNode=swapPairs(next.next);
        next.next=head;
        head.next=newNode;
        return next;
    }
}
