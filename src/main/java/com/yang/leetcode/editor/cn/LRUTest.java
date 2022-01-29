package com.yang.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class LRUTest {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode(){}

        public DLinkedNode(int _key, int _value){
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkedNode> map = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;

    public LRUTest(int capacity){
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        DLinkedNode node = map.get(key);
        if (node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value){
        DLinkedNode node = map.get(key);
        if (node == null){
            DLinkedNode dLinkedNode = new DLinkedNode(key, value);
            map.put(key, dLinkedNode);
            addToHead(dLinkedNode);
            ++size;
            if (size > capacity){
                DLinkedNode tail = removeTail();
                map.remove(tail.key);
                --size;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }

    }

    private void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
