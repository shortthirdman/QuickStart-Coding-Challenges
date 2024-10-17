package com.shortthirdman.quickstart.hackerrank;

import com.shortthirdman.quickstart.common.TreeNode;

public class BinaryTree {

    /**
     * Given a binary tree, find its minimum depth.
     * <br></br>
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     * A leaf is a node with no children.
     *
     * @param root the node with its leaves
     * @return the minimum depth
     * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">Minimum Depth of Binary Tree</a>
     */
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0; // Base case: if the tree is empty
        }

        // If the node is a leaf node
        if (root.getLeft() == null && root.getRight() == null) {
            return 1; // Count this node
        }

        // If the left child is null, we only consider the right child
        if (root.getLeft() == null) {
            return 1 + minDepth(root.getRight());
        }

        // If the right child is null, we only consider the left child
        if (root.getRight() == null) {
            return 1 + minDepth(root.getLeft());
        }

        // If both children are present, return the minimum depth of both subtrees
        return 1 + Math.min(minDepth(root.getLeft()), minDepth(root.getRight()));
    }

    /**
     * Given the root of a binary tree, return its maximum depth.
     * <br></br>
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     * @param root the node with its leaves
     * @return the maximum depth
     * @see <a href="https://leetcode.com/problems/minimum-depth-of-binary-tree/">Minimum Depth of Binary Tree</a>
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Calculate depth recursively for left and right subtrees
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
