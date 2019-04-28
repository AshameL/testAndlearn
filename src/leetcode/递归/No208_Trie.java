package leetcode.递归;

public class No208_Trie {
    // Node
    private class Node {
        private int dumpli_num;////该字串的重复数目，  该属性统计重复次数的时候有用,取值为0、1、2、3、4、5……
        private int prefix_num;///以该字串为前缀的字串数， 应该包括该字串本身！！！！！
        private Node childs[];////此处用数组实现，当然也可以map或list实现以节省空间
        private boolean isLeaf;///是否为单词节点

        public Node() {
            dumpli_num = 0;
            prefix_num = 0;
            isLeaf = false;
            childs = new Node[26];
        }
    }

    private Node root;///树根

    /**
     * Initialize your data structure here.
     */
    public No208_Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        insert(root, word);
    }

    /**
     * 插入字串，用循环代替迭代实现
     *
     * @param root
     * @param words
     */
    private void insert(Node root, String words) {
        words = words.toLowerCase();////转化为小写
        char[] chrs = words.toCharArray();

        for (int i = 0, length = chrs.length; i < length; i++) {
            ///用相对于a字母的值作为下标索引，也隐式地记录了该字母的值
            int index = chrs[i] - 'a';
            if (root.childs[index] != null) {
                ////已经存在了，该子节点prefix_num++
                root.childs[index].prefix_num++;
            } else {
                ///如果不存在
                root.childs[index] = new Node();
                root.childs[index].prefix_num++;
            }

            ///如果到了字串结尾，则做标记
            if (i == length - 1) {
                root.childs[index].isLeaf = true;
                root.childs[index].dumpli_num++;
            }
            ///root指向子节点，继续处理
            root = root.childs[index];
        }

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] chs = word.toLowerCase().toCharArray();
        Node tmpRoot = root;
        int length = chs.length;
        for (int i = 0; i < length; i++) {
            int index = chs[i] - 'a';
            if (tmpRoot.childs[index] == null) {
                ///如果不存在，则查找失败
                return false;
            }
            tmpRoot = tmpRoot.childs[index];
        }

        // 不能有孩子了
        return tmpRoot.isLeaf;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chrs = prefix.toLowerCase().toCharArray();
        Node tmpRoot = root;
        for (int i = 0, length = chrs.length; i < length; i++) {
            int index = chrs[i] - 'a';
            if (tmpRoot.childs[index] == null) {
                return false;
            }
            tmpRoot = tmpRoot.childs[index];
        }
        return true;
    }
}
//https://www.cnblogs.com/acbingo/p/9391172.html