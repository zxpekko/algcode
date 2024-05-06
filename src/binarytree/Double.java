package binarytree;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:zxp
 * @Description:二叉搜索树转成双向有序链表
 * @Date:15:32 2024/5/5
 */
public class Double {
    public DLinkedNode change(TreeNode root){
        List<Integer> inorderList=new ArrayList<>();
        inorder(root,inorderList);
        DLinkedNode head = new DLinkedNode();
        DLinkedNode pre = new DLinkedNode();
        for(int i=0;i<inorderList.size();i++){
            if(i==0){
                head.val=inorderList.get(i);
                head.pre=null;
                pre=head;
            }
            else {
                DLinkedNode dLinkedNode = new DLinkedNode(inorderList.get(i));
                dLinkedNode.pre=pre;
                pre.next=dLinkedNode;
                pre=dLinkedNode;
                if(i==inorderList.size()-1)
                    dLinkedNode.next=null;
            }
        }
        return head;
    }
    public void inorder(TreeNode root, List<Integer> inorderList){
        if(root==null)
            return;
        inorder(root.left,inorderList);
        inorderList.add(root.val);
        inorder(root.right,inorderList);
    }
}
class DLinkedNode{
    public DLinkedNode pre;
    public DLinkedNode next;
    public int val;
    public DLinkedNode(int val){
        this.val=val;
    }
    public DLinkedNode(){}
}