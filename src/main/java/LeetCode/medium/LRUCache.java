package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, DLL> mp;
    int capacity;
    DLL head;
    DLL tail;
    public LRUCache(int capacity) {
        mp = new HashMap<>();
        this.capacity = capacity;
        this.head = new DLL(-1, -1);
        this.tail = head;
    }

    public int get(int key) {
        final DLL dll = mp.get(key);
        if (dll != null) {
            deleteNode(dll);
            insertNode(dll);
        } else {
            return -1;
        }
        return dll.val;
    }

    private void insertNode(DLL node) {
        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
    }

    private void deleteNode(DLL node) {
        if (node == null || node == head) return;
        if (node == tail) {
            tail = node.prev;
        }
        DLL prevNode = node.prev;
        DLL nextNode = node.next;
        if (prevNode != null) prevNode.next = nextNode;
        if (nextNode != null) nextNode.prev = prevNode;
    }

    public void put(int key, int value) {
        final DLL dll = mp.get(key);
        if (dll != null) {
            deleteNode(dll);
            insertNode(dll);
            dll.val = value;
        } else {
            if (mp.size() == capacity) {
                DLL node = head.next;
                deleteNode(node);
                mp.remove(node.key);
            }
            DLL node = new DLL(key, value);
            insertNode(node);
            mp.put(key, node);
        }
    }

    class DLL {
        int key;
        int val;
        DLL prev;
        DLL next;

        DLL(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

// https://leetcode.com/problems/lru-cache
