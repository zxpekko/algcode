package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:19:31 2024/8/6
 */
public class Solution129 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        Solution129 solution129 = new Solution129();
        System.out.println(solution129.sumNumbers(treeNode1));
    }
    int result=0;
    public int sumNumbers(TreeNode root){
        getSum(root,0);
        return result;
    }
    public void getSum(TreeNode root,int cur){
        if(root==null)
            return;
        cur=cur*10+root.val;
        if(root.left==null&&root.right==null){
            result+=cur;
            return;
        }
        if(root.left!=null)
            getSum(root.left,cur);
        if(root.right!=null)
            getSum(root.right,cur);
    }
}