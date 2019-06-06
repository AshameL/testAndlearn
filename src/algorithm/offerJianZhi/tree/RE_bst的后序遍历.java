package algorithm.offerJianZhi.tree;

/**
 * 测试用例:
 * [5,4,3,2,1]
 *
 * 对应输出应该为:
 *
 * true
 *
 * 你的输出为:
 *
 * false
 * */
public class RE_bst的后序遍历 {
    public boolean VerifySquenceOfBST(int[] a) {
        if (a.length == 0)
            return true;
        return f(a, 0, a.length - 1);
    }

    private boolean f(int[] a, int l, int r) {
        if (l >= r)
            return true;
        int i = r;
        while (i > 1 && a[i - 1] > a[r])
            --i;
        for (int j = i - 1; j >= l; --j)
            if (a[j] > a[r])
                return false;
        return f(a, l, i - 1) && f(a, i, r - 1);
    }
}
