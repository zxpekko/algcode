package binarytree;

import com.sun.org.apache.bcel.internal.generic.FSUB;
import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author:zxp
 * @Description:给你一个 二叉搜索树 的根节点 root ，和一个由正整数组成、长度为 n 的数组 queries 。
 *
 * 请你找出一个长度为 n 的 二维 答案数组 answer ，其中 answer[i] = [mini, maxi] ：
 *
 * mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。
 * maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。
 * 返回数组 answer 。
 *
 *
 *
 * 示例 1 ：
 *
 *
 *
 * 输入：root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2,5,16]
 * 输出：[[2,2],[4,6],[15,-1]]
 * 解释：按下面的描述找出并返回查询的答案：
 * - 树中小于等于 2 的最大值是 2 ，且大于等于 2 的最小值也是 2 。所以第一个查询的答案是 [2,2] 。
 * - 树中小于等于 5 的最大值是 4 ，且大于等于 5 的最小值是 6 。所以第二个查询的答案是 [4,6] 。
 * - 树中小于等于 16 的最大值是 15 ，且大于等于 16 的最小值不存在。所以第三个查询的答案是 [15,-1] 。
 * 示例 2 ：
 *
 *
 *
 * 输入：root = [4,null,9], queries = [3]
 * 输出：[[-1,4]]
 * 解释：树中不存在小于等于 3 的最大值，且大于等于 3 的最小值是 4 。所以查询的答案是 [-1,4] 。
 *
 *
 * 提示：
 *
 * 树中节点的数目在范围 [2, 105] 内
 * 1 <= Node.val <= 106
 * n == queries.length
 * 1 <= n <= 105
 * 1 <= queries[i] <= 106
 * @Date:13:21 2024/2/24
 */
public class ClosestNodes {
    public static void main(String[] args) {
        ClosestNodes closestNodes = new ClosestNodes();
        TreeNode treeNode=new TreeNode();
        TreeNode treeNode1=new TreeNode();
        TreeNode treeNode2=new TreeNode();
        treeNode.val=4;
        treeNode1.val=9;
        treeNode.right=treeNode1;
        List<Integer> queries=new ArrayList<>();
        queries.add(3);
        List<List<Integer>> list = closestNodes.closestNodes(treeNode, queries);
        System.out.println(list);
//        ClosestNodesⅡ closestNodesⅡ = new ClosestNodesⅡ();
//        System.out.println(closestNodesⅡ.closestNodes(treeNode, queries));
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> record=new ArrayList<>();
        inorder(root,record);
        for(int i=0;i<queries.size();i++){
            int left=-1;
            int great=-1;
            int index = binarySearchGetGreatMin(record, queries.get(i));
            if(index<record.size()){
                great=record.get(index);
                if(Objects.equals(record.get(index), queries.get(i))){
                    left=record.get(index);
                    List<Integer> subResult=new ArrayList<>();
                    subResult.add(left);
                    subResult.add(great);
                    result.add(subResult);
                    continue;
                }
            }
            if(index>0) {
                left = record.get(index - 1);
            }
            List<Integer> subResult=new ArrayList<>();
            subResult.add(left);
            subResult.add(great);
            result.add(subResult);

        }
        return result;
    }
    public void inorder(TreeNode root,List<Integer> record){
        if(root==null)
            return;
        inorder(root.left,record);
        record.add(root.val);
        inorder(root.right,record);
    }
    public int binarySearchGetGreatMin(List<Integer> record,int query){
        //查找第一个大于等于query的数的下标
        int left=0,right=record.size();
        while (left<right){
            int mid=left + (right - left) / 2;
            if(record.get(mid)>=query)
                right=mid;
            else
                left=mid+1;
        }
        return left;
    }

    public int getLeftMax(List<Integer> record,int query){
//        int index=0;
//        for(index=0;index<record.size();index++){
//            if(record.get(index)<=query)
//                continue;
//            else break;
//        }
//        if(index!=0)
//            return record.get(index-1);
        int left=0,right=record.size()-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(record.get(mid)>query)
                right=mid-1;
            else
                left=mid;
        }
        return right;
    }
    public int getGreatMin(List<Integer> record,int query){
//        int index=0;
//        for(index=0;index<record.size();index++){
//            if(record.get(index)<query)
//                continue;
//            else break;
//        }
//        if(index==record.size())
//            return -1;
//        return record.get(index);
        int left=0,right=record.size();
        while (left<=right){
            int mid=(left+right)/2;
            if(record.get(mid)<query)
                left=mid+1;
            else
                return record.get(left);
        }
        return -1;
    }
}
class ClosestNodesⅡ{
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries){
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<queries.size();i++){
            List<Integer> subResult=new ArrayList<>();
//            int leftMax = getLeftMax(root, queries.get(i));
//            int greatMin = getGreatMin(root, queries.get(i));
//            subResult.add(leftMax==Integer.MIN_VALUE?-1:leftMax);
//            subResult.add(greatMin==Integer.MAX_VALUE?-1:greatMin);
            int[] value = getValue(root, queries.get(i));
            subResult.add(value[0]==Integer.MIN_VALUE?-1:value[0]);
            subResult.add(value[1]==Integer.MAX_VALUE?-1:value[1]);
            result.add(subResult);
        }
        return result;
    }
    public int getLeftMax(TreeNode root,int query){
        int leftMax=Integer.MIN_VALUE;
        while (root!=null){
            if(query>root.val){
                if(root.val>leftMax)
                    leftMax=root.val;
                root=root.right;
            }
            else if(query<root.val){
                root=root.left;
            }
            else
                return query;
        }
        return leftMax;
    }
    public int getGreatMin(TreeNode root,int query){
        int greatMin=Integer.MAX_VALUE;
        while (root!=null){
            if(query<root.val){
                if(root.val<greatMin)
                    greatMin=root.val;
                root=root.left;
            }
            else if(query>root.val){
                root=root.right;
            }
            else
                return query;
        }
        return greatMin;
    }
    public int[] getValue(TreeNode root,int query){
        int[] r = new int[2];
        r[0]=Integer.MIN_VALUE;
        r[1]=Integer.MAX_VALUE;
        TreeNode leftRoot=root;
        TreeNode greatRoot=root;
        while (leftRoot!=null&&greatRoot!=null){
            if(leftRoot!=null&&query>leftRoot.val){
                if(leftRoot.val>r[0])
                    r[0]=leftRoot.val;
                leftRoot=leftRoot.right;
            }
            else if(leftRoot!=null&&query<leftRoot.val){
                leftRoot=leftRoot.left;
            }
            else if(leftRoot!=null&&query==leftRoot.val){
                r[0]=query;
                leftRoot=null;
            }
            if(greatRoot!=null&&query<greatRoot.val){
                if(greatRoot.val<r[1])
                    r[1]=greatRoot.val;
                greatRoot=greatRoot.left;
            }
            else if(greatRoot!=null&&query>greatRoot.val){
                greatRoot=greatRoot.right;
            }
            else if(greatRoot!=null&&query==greatRoot.val){
                r[1]=query;
                greatRoot=null;
            }
        }
        return r;
    }
}
