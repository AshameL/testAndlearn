package leetcode;

import offerJianZhi.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No102_LevelOrder {
    class Pair {
        TreeNode treeNode;
        int num;

        Pair(TreeNode treeNode, int num) {
            this.treeNode = treeNode;
            this.num = num;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.remove();
            if (res.size()==p.num)
                res.add(new LinkedList<>());
            res.get(p.num).add(p.treeNode.val);

            if (p.treeNode.left != null) {
                q.offer(new Pair(p.treeNode.left, p.num + 1));
            }
            if (p.treeNode.right != null) {
                q.offer(new Pair(p.treeNode.right, p.num + 1));
            }
        }

        return res;
    }
}
