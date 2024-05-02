package interview;

//import javax.swing.tree.TreeNode;
import jdk.nashorn.internal.ir.Terminal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:zxp
 * @Description:
 * @Date:22:58 2024/5/1
 */
public class RightSideView {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.right=treeNode5;
        treeNode3.right=treeNode4;
        RightSideView rightSideView = new RightSideView();
        System.out.println(rightSideView.rightSideView(null));
    }
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null)
            return result;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                if(poll.left!=null)
                    queue.offer(poll.left);
                if(poll.right!=null)
                    queue.offer(poll.right);
                if(i==size-1)
                    result.add(poll.val);
            }
        }
        return result;
    }
}
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(TreeNode left,TreeNode right,int val){
        this.val=val;
        this.left=left;
        this.right=right;
    }
    public TreeNode(){

    }
    public TreeNode(int val){
        this.val=val;
    }
}
