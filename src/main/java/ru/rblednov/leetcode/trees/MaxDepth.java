package ru.rblednov.leetcode.trees;

public class MaxDepth {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static int maxDepth = 0;

    public static int maxDepth(TreeNode root) {
        int depth = 0;
        checkNode(root, depth);
        return maxDepth;
    }

    private static int checkNode(TreeNode treeNode, int depth) {
        if (treeNode == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
            }
            return depth-1;
        }
        checkNode(treeNode.left, depth+1);
        checkNode(treeNode.right, depth+1);
        return depth-1;
    }

    public static void main(String[] args) {

        TreeNode treeNode =
                new TreeNode(3,
                        null,
                        new TreeNode(2));
        System.out.println(maxDepth(treeNode));
    }
}
