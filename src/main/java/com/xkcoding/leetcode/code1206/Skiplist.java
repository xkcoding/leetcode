//package com.xkcoding.leetcode.code1206;
//
///**
// * <p>
// * https://leetcode.cn/problems/design-skiplist/
// * <p>
// * 感谢题解：https://leetcode.cn/problems/design-skiplist/solution/she-ji-tiao-biao-by-capital-worker-3vqk/
// * </p>
// *
// * @author yangkai.shen
// * @date Created in 2022-10-26 17:29
// */
//class Skiplist {
//
//    class Node {
//        int val;
//        Node[] next;
//
//        public Node(int val, int maxLevel) {
//            this.val = val;
//            this.next = new Node[maxLevel];
//        }
//    }
//
//    private static final int MAX_LEVEL = 32;
//    private static final double factor = 0.25;
//
//    private Node head;
//    private int currentLevel;
//
//    public Skiplist() {
//        this.head = new Node(-1, MAX_LEVEL);
//        this.currentLevel = 0;
//    }
//
//    public boolean search(int target) {
//
//    }
//
//    public void add(int num) {
//
//    }
//
//    public boolean erase(int num) {
//
//    }
//}
//
///**
// * Your Skiplist object will be instantiated and called as such:
// * Skiplist obj = new Skiplist();
// * boolean param_1 = obj.search(target);
// * obj.add(num);
// * boolean param_3 = obj.erase(num);
// */