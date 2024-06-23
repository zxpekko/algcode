package binarytree;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:43 2024/6/17
 */
public class Solution129 {
    public int sumNumbers(TreeNode root){

        return dfs(root,0);
    }
    public int dfs(TreeNode root,int prevSum){
        if(root==null)
            return 0;
        int sum=prevSum*10+root.val;
        if(root.left==null&&root.right==null)
            return sum;
        return dfs(root.left,sum)+dfs(root.right,sum);
    }
}
class Solution129Ⅰ{
    public int sumNumbers(TreeNode root){
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int prevSum){
        if(root==null)
            return 0;
        int sum=prevSum*10+root.val;
        if(root.left==null&&root.right==null)
            return sum;
        return dfs(root.left,sum)+dfs(root.right,sum);
    }
}