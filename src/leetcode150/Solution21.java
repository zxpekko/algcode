package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:18 2024/8/1
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode head=new ListNode(0);
        ListNode p=head;
        while (list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                p.next=list1;
                list1=list1.next;
                p=p.next;
            }
            else {
                p.next=list2;
                list2=list2.next;
                p=p.next;
            }
        }
        while (list1!=null){
            p.next=list1;
            list1=list1.next;
            p=p.next;
        }
        while (list2!=null){
            p.next=list2;
            list2=list2.next;
            p=p.next;
        }
        return head.next;
    }
}
