package offerJianZhi.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import util.*;

public class test {
    ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        if (root == null)
            return null;
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        Queue<Tuple> q = new LinkedList();
        q.offer(new Tuple(root, 0));
        while (!q.isEmpty()) {
            Tuple t = q.remove();
            TreeNode node = t.node;
            int level = t.level;
            if (res.get(level) == null)
                res.add(new ArrayList<>());
            ArrayList<Integer> cur = res.get(level);
            cur.add(node.val);
            if (root.left != null)
                q.offer(new Tuple(root.left, level + 1));
            if (root.right != null)
                q.offer(new Tuple(root.right, level + 1));

        }

        return res;
    }

    class Tuple {
        TreeNode node;
        int level;

        Tuple(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
