package leetcode.LRU;

import java.util.HashMap;

public class LRUCache2 {
    class DLinkedNode {
        Integer key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
    }

    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();

    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache2(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.next = null;

        head.next = tail;
        tail.pre = head;

    }

    public int get(Integer key) {
        DLinkedNode node = cache.get(key);
        if (node == null)
            return -1;

        this.moveToHead(node);

        return node.value;
    }

    public void set(Integer key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }

    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode next = node.next;

        pre.next = next;
        next.pre = pre;
    }

    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }
}
