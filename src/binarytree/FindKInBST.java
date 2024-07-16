package binarytree;

import java.util.List;
import java.util.Stack;

/**
 * @Author:zxp
 * @Description:
 * @Date:12:56 2024/7/15
 */
public class FindKInBST {
    public static void main(String[] args) {

    }
   public int findK(TreeNode root,int k){
       Stack<TreeNode> stack = new Stack<>();
       TreeNode cur=root;
       int index=0;
       while (!stack.isEmpty()||cur!=null){
           if(cur!=null){
               stack.push(cur);
               cur=cur.left;
           }
           else {
               TreeNode pop = stack.pop();
               index++;
               if(index==k)
                   return pop.val;
               cur=pop.right;
           }
       }
       return 0;
   }
   private int result=Integer.MIN_VALUE;
    private int count=0;

    public void findKByDigui(TreeNode root, int k){
        if(root==null)
            return;
        findKByDigui(root.left,k);
        count++;
        if(count==k){
            result=root.val;
            return;
        }
        findKByDigui(root.right,k);
    }
}
//class TreeNode{
//    TreeNode left;
//    TreeNode right;
//    int val;
//    public TreeNode(){
//
//    }
//    public TreeNode(int val){
//        this.val=val;
//    }
//}