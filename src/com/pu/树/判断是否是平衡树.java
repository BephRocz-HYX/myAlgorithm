package com.pu.树;

public class 判断是否是平衡树 {
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    public static class Res{
        boolean data;

        public Res(boolean data) {
            this.data = data;
        }
    }

    public static boolean isBalance2(Node head){
        Boolean res = new Boolean(true);//值传递，不会改变。
        int i = getHeight(head, 1, res);
        return res;
    }

    private static int getHeight(Node head, int level, Boolean res) {
        if(head == null){
            return level;
        }
        int lH = getHeight(head.left, level + 1 , res);
        if(!res){
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        if(!res){
            return level;
        }
        if(Math.abs(lH - rH) > 1){
            res = false;
        }

        return Math.max(lH, rH);
    }
    public static boolean isBalance1(Node head){
        Res dst = new Res(true);
        //res[0] = true;
        getHeight(head, 1, dst);
        return dst.data;
    }

    private static int getHeight(Node head, int level, Res res) {
        if(head == null){
            return level;
        }
        int lH = getHeight(head.left, level + 1 , res);
        //if(!res){
        if(!res.data){
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        //if(!res){
        if(!res.data){
            return level;
        }
        if(Math.abs(lH - rH) > 1){
            res.data = false;
        }

        return Math.max(lH, rH);
    }



    public static boolean isBalance(Node head){
        boolean[] res = new boolean[1];
        res[0] = true;
        int i = getHeight(head, 1, res);
        return res[0];
    }

    private static int getHeight(Node head, int level, boolean[] res) {
        if(head == null){
            return level;
        }
        int lH = getHeight(head.left, level + 1 , res);
        //if(!res){
        if(!res[0]){
            return level;
        }
        int rH = getHeight(head.right, level + 1, res);
        //if(!res){
        if(!res[0]){
            return level;
        }
        if(Math.abs(lH - rH) > 1){
            res[0] = false;
        }

        return Math.max(lH, rH);
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.left = node1;
        node1.left = node2;
        node2.left = node3;
        boolean a = isBalance(head);
        boolean b = isBalance1(head);
        boolean c = isBalance2(head);
        boolean d = isBalance3(head);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);


    }

    private static boolean isBalance3(Node head) {
        //注：空树也为avl
        return depth(head) != -1;

    }

    private static int depth(Node head) {
        if(head == null) return 0;
        int left = depth(head.left);
        if(left == -1) return -1;
        int right = depth(head.right);
        if(right == -1) return -1;
        if(Math.abs(left - right) > 1) return -1;
        else return 1 + (left > right ? left : right);
    }
}
