package leetcode150;

/**
 * @Author:zxp
 * @Description:
 * @Date:14:09 2024/9/23
 */
public class Solution337 {
    public static void main(String[] args) {
        Solution337 solution337 = new Solution337();
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(1);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.right=treeNode4;
        System.out.println(solution337.rob(treeNode));
    }
    public int rob(TreeNode root){
        int[] result=maxGain(root);
        return Math.max(result[0],result[1]);
    }
    public int[] maxGain(TreeNode root){//返回一个长度为2的数组，0位置代表不偷当前节点的最大值，1代表偷当前节点的最大值。
        int[] result = new int[2];
        if(root==null)
            return new int[]{0,0};
        //后续遍历
        int[] left=maxGain(root.left);
        int[] right=maxGain(root.right);
        //不偷当前节点
        result[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        //偷当前节点
        result[1]=root.val+left[0]+right[0];
        return result;
    }
}
