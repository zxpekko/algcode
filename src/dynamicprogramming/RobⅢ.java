package dynamicprogramming;

//import javax.swing.tree.TreeNode;



/**
 * @Author:zxp
 * @Description:小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 *
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 *
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * @Date:13:48 2023/12/7
 */
public class RobⅢ {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        TreeNode treeNode1 = new TreeNode();
        TreeNode treeNode2 = new TreeNode();
        TreeNode treeNode3 = new TreeNode();
        TreeNode treeNode4 = new TreeNode();
        treeNode.val=3;
        treeNode.left=treeNode1;
        treeNode1.val=2;
        treeNode.right=treeNode2;
        treeNode2.val=3;
        treeNode1.right=treeNode3;
        treeNode3.val=3;
        treeNode2.right=treeNode4;
        treeNode4.val=1;
        RobⅢ robⅢ = new RobⅢ();
        System.out.println(robⅢ.rob(treeNode));
    }
    public int rob(TreeNode root){
        int[] result= robTree(root);
        return Math.max(result[0], result[1]);
    }
    public int[] robTree(TreeNode root){
        int[] result = new int[2];
        if(root==null)
            return new int[]{0,0};
        int[] left = robTree(root.left);//后续遍历，左右根
        int[] right = robTree(root.right);
        //不偷当前节点
        int val0=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        //偷当前节点
        int val1=root.val+left[0]+right[0];
        result[0]=val0;
        result[1]=val1;
        return result;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }
}