package algorithm.offerJianZhi.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import algorithm.util.TreeNode;

public class 之字打印tree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        if (root == null)
            return null;

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            if (res.size() == p.level)
                res.add(new ArrayList<>());
            if (p.level % 2 == 0)
                res.get(p.level).add(p.root.val);
            else
                res.get(p.level).add(0, p.root.val);
            if (p.root.left != null)
                queue.offer(new Pair(p.root.left, p.level + 1));
            if (p.root.right != null)
                queue.offer(new Pair(p.root.right, p.level + 1));
        }
        return res;

    }

    class Pair {
        TreeNode root;
        int level;

        Pair(TreeNode root, int level) {
            this.root = root;
            this.level = level;
        }
    }

}
