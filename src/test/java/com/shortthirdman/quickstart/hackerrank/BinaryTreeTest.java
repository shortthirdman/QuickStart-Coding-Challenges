package com.shortthirdman.quickstart.hackerrank;

import com.shortthirdman.quickstart.common.TreeNode;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    BinaryTree app;

    @BeforeEach
    void setUp() {
        app = new BinaryTree();
    }

    @Test
    void minDepth_SingleLeaf() {
        TreeNode root = new TreeNode(1);
        assertEquals(1, app.minDepth(root), "Expected min depth for single node to be 1.");
    }

    @Test
    void minDepth_TwoLevels() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        assertEquals(2, app.minDepth(root), "Expected min depth for single child tree to be 2.");
    }

    @Test
    void minDepth_ThreeLevels() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), new TreeNode(4));
        assertEquals(2, app.minDepth(root), "Expected min depth for balanced tree with three levels to be 2.");
    }

    @Test
    void minDepth_BalancedTree() {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertEquals(2, app.minDepth(root), "Expected min depth for balanced tree to be 2.");
    }

    // Negative test cases
    @Test
    void minDepth_EmptyTree() {
        TreeNode root = null;
        assertEquals(0, app.minDepth(root), "Expected min depth for null tree to be 0.");
    }

    // Edge cases
    @Test
    void minDepth_LeftHeavyTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        assertEquals(3, app.minDepth(root));
    }

    @Test
    void minDepth_RightHeavyTree() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        assertEquals(3, app.minDepth(root));
    }

    // Parameterized test cases
    static Object[][] provideMinDepthCases() {
        return new Object[][] {
                {null, 0}, // empty tree
                {new TreeNode(1), 1}, // single node
                {new TreeNode(1, new TreeNode(2), null), 2}, // left child only
                {new TreeNode(1, null, new TreeNode(3)), 2}, // right child only
                {new TreeNode(1, new TreeNode(2), new TreeNode(3)), 2}, // balanced tree
                {new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3)), 2} // left heavy
        };
    }

    @ParameterizedTest
    @MethodSource("provideMinDepthCases")
    void minDepth_Parameterized(TreeNode root, int expectedDepth) {
        assertEquals(expectedDepth, app.minDepth(root));
    }

    // Test for a large balanced tree
    @Test
    void minDepth_LargeBalancedTree() {
        TreeNode root = createBalancedTree(1, 17); // height of 17, so depth should be 17
        assertEquals(17, app.minDepth(root));
    }

    // Test for a large skewed tree (left-heavy)
    @Test
    void minDepth_LargeLeftHeavyTree() {
        TreeNode root = createLeftHeavyTree(100000); // 100000 nodes deep
        assertEquals(100000, app.minDepth(root));
    }

    // Helper method to create a balanced binary tree
    private TreeNode createBalancedTree(int value, int height) {
        if (height <= 0) return null;
        TreeNode node = new TreeNode(value);
        node.left = createBalancedTree(value, height - 1);
        node.right = createBalancedTree(value, height - 1);
        return node;
    }

    // Helper method to create a left-heavy tree
    private TreeNode createLeftHeavyTree(int nodes) {
        if (nodes <= 0) return null;
        TreeNode root = new TreeNode(1);
        TreeNode current = root;
        for (int i = 2; i <= nodes; i++) {
            current.left = new TreeNode(i);
            current = current.left;
        }
        return root;
    }

    @Test
    public void minDepth_ComplexTree() {
        // Test case for a more complex tree
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(7),
                                null),
                        new TreeNode(5)),
                new TreeNode(3));
        assertEquals(3, app.minDepth(root), "Expected min depth for complex tree to be 3."); // Shortest path to leaf 3
    }

    @Test
    public void minDepth_ExceptionCase() {
        assertThrows(IllegalArgumentException.class, () -> app.minDepth(null));
    }

    @Test
    public void maxDepth_NullTree() {
        // Test case for an empty tree
        assertEquals(0, app.maxDepth(null), "Expected max depth for null tree to be 0.");
    }

    @Test
    public void maxDepth_LeafNode() {
        // Test case for a single leaf node
        TreeNode root = new TreeNode(1);
        assertEquals(1, app.maxDepth(root), "Expected max depth for single node to be 1.");
    }

    @Test
    public void maxDepth_SingleChildTree() {
        // Test case where the tree has one child
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        assertEquals(2, app.maxDepth(root), "Expected max depth for single child tree to be 2.");
    }

    @Test
    public void maxDepth_BalancedTree() {
        // Test case for a balanced tree
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3));
        assertEquals(3, app.maxDepth(root), "Expected max depth for balanced tree to be 3.");
    }

    @Test
    public void maxDepth_ComplexTree() {
        // Test case for a more complex tree
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4,
                                new TreeNode(7),
                                null),
                        new TreeNode(5)),
                new TreeNode(3));
        assertEquals(4, app.maxDepth(root), "Expected max depth for complex tree to be 4.");
    }

    @Test
    public void maxDepth_OnlyLeftChildren() {
        // Test case for a tree with only left children
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4),
                                null),
                        null),
                null);
        assertEquals(4, app.maxDepth(root), "Expected max depth for left-only tree to be 4.");
    }

    @Test
    public void maxDepth_OnlyRightChildren() {
        // Test case for a tree with only right children
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2,
                        null,
                        new TreeNode(3,
                                null,
                                new TreeNode(4))));
        assertEquals(4, app.maxDepth(root), "Expected max depth for right-only tree to be 4.");
    }

    @ParameterizedTest
    @MethodSource("provideTreesForParameterizedTest")
    public void maxDepth_Parameterized(TreeNode root, int expectedDepth) {
        assertEquals(expectedDepth, app.maxDepth(root), "Expected max depth does not match.");
    }

    private static Object[][] provideTreesForParameterizedTest() {
        return new Object[][] {
                { null, 0 }, // Empty tree
                { new TreeNode(1), 1 }, // Single node
                { new TreeNode(1, new TreeNode(2), null), 2 }, // One left child
                { new TreeNode(1, null, new TreeNode(2)), 2 }, // One right child
                { new TreeNode(1,
                        new TreeNode(2, new TreeNode(3), null),
                        new TreeNode(4)), 3 }, // Mixed tree
                { new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3,
                                        new TreeNode(4),
                                        null),
                                null),
                        null), 4 } // All left children
        };
    }

    @Test
    public void maxDepth_ExceptionCase() {
        assertThrows(IllegalArgumentException.class, () -> app.maxDepth(null));
    }
}