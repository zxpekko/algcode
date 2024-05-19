package chaintable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:31 2024/5/14
 */
public class Solution143 {
    //    public void reorderList(ListNode head){
//        ListNode left=head,right=head;
//        int nums=0;
//        while (right.next!=null){
//            right=right.next;
//            nums++;
//        }
//        nums++;
//        ListNode pre=new ListNode(0);
//        ListNode oldRight=null;
//        while (left!=right){
//            ListNode nextLeft=left.next;
//            left.next=right;
//            pre.next=left;
//            left=nextLeft;
//            pre=right;
//            oldRight=right;
//            ListNode nextRight=nextLeft;
//            while (nextRight.next!=right)
//                nextRight=nextRight.next;
//            right=nextRight;
//        }
//        oldRight.next=right;
//        right.next=null;
//        ListNode cur=head;
//        int index=1;
//        while (index<nums){
//            cur=cur.next;
//            index++;
//        }
//        cur.next=null;
//    }
//    public void reorderList(ListNode head){
//        List<ListNode> listNodes=new ArrayList<>();
//        ListNode cur=head;
//        while (cur!=null){
//            listNodes.add(cur);
//            cur=cur.next;
//        }
//        cur=head;
//        int i=0,j=0;
//        ListNode pre=new ListNode(0);
//        ListNode left=null;
//        ListNode right=null;
//        for(i=0,j= listNodes.size()-1;i<j;i++,j--){
//            left=listNodes.get(i);
//            right=listNodes.get(j);
//            head=left;
//            head.next=right;
//            pre.next=head;
//            pre=right;
//        }
//        if(i==j)
//            pre.next=listNodes.get(i);
//        head=cur;
//    }
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        List<ListNode> listNodes=new ArrayList<>();
        ListNode cur=head;
        while (cur!=null){
            listNodes.add(cur);
            cur=cur.next;
        }
        int i=0,j=listNodes.size()-1;
        while (i<j){
            listNodes.get(i).next=listNodes.get(j);
            i++;
            if(i==j)
                break;
            listNodes.get(j).next=listNodes.get(i);
            j--;
        }
        listNodes.get(i).next=null;
    }
}
