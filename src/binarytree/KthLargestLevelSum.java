package binarytree;

import java.util.*;

/**
 * @Author:zxp
 * @Description:给你一棵二叉树的根节点 root 和一个正整数 k 。
 *
 * 树中的 层和 是指 同一层 上节点值的总和。
 *
 * 返回树中第 k 大的层和（不一定不同）。如果树少于 k 层，则返回 -1 。
 *
 * 注意，如果两个节点与根节点的距离相同，则认为它们在同一层。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [5,8,9,2,1,3,7,4,6], k = 2
 * 输出：13
 * 解释：树中每一层的层和分别是：
 * - Level 1: 5
 * - Level 2: 8 + 9 = 17
 * - Level 3: 2 + 1 + 3 + 7 = 13
 * - Level 4: 4 + 6 = 10
 * 第 2 大的层和等于 13 。
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,2,null,3], k = 1
 * 输出：3
 * 解释：最大的层和是 3 。
 * @Date:19:56 2024/2/23
 */
public class KthLargestLevelSum {
    public static void main(String[] args) {
        KthLargestLevelSum kthLargestLevelSum = new KthLargestLevelSum();
        TreeNode treeNode = new TreeNode();
        TreeNode treeNode1 = new TreeNode();
        TreeNode treeNode2 = new TreeNode();
        treeNode.val=1;
        treeNode1.val=2;
        treeNode2.val=3;
        treeNode.left=treeNode1;
        treeNode1.left=treeNode2;
        System.out.println(kthLargestLevelSum.kthLargestLevelSum(treeNode, 1));
    }
    public long kthLargestLevelSum(TreeNode root, int k){
//        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(new Comparator<Long>() {
//            @Override
//            public int compare(Long o1, Long o2) {
//                return (int)(o2-o1);
//            }
//        });
        List<Long> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            long count=0;
            for(int i=0;i<size;i++){
                TreeNode poll = queue.poll();
                if(poll.left!=null)
                    queue.offer(poll.left);
                if(poll.right!=null)
                    queue.offer(poll.right);
                count+=poll.val;
            }
//            priorityQueue.offer(count);
            list.add(count);
        }
//        if(priorityQueue.size()<k)
//            return -1;
        long result=0;
//        System.out.println(priorityQueue);
//        for(int i=0;i<k;i++){
//            result= priorityQueue.poll();
//        }
        Object[] objects = list.toArray();
        Long[] longs = new Long[objects.length];
        int index=0;
        for (Object o : list.toArray()) {
            longs[index++]=(long)o;
        }

        Arrays.sort(longs);
        if(objects.length<k)
            return -1;

        return longs[longs.length-k];
    }
}
