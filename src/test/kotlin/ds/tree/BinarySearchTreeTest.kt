package ds.tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinarySearchTreeTest {

    // region root and count tests
    @Test
    fun `given empty tree, root is null and count is 0`() {

        // GIVEN
        val bst = BinarySearchTree<Int>()

        // THEN
        val expectedCount = 0
        assertEquals(expectedCount, bst.count)
        assertNull(bst.root)
    }

    @Test
    fun `given a non-empty tree, root is not null and count is greater than 0`() {

        // GIVEN
        val bst = BinarySearchTree<Int>()
        bst.add(1)

        // THEN
        val expectedCount = 1
        assertEquals(expectedCount, bst.count)
        assertNotNull(bst.root)
    }
    //endregion

    //region add tests
    @Test
    fun `given empty tree, when add is called with a value, then the value is at root and count is updated`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()

        // WHEN
        val addedValue = 5
        bst.add(addedValue)

        // THEN
        val expectedCount = 1
        assertEquals(expectedCount, bst.count)
        assertNotNull(bst.root)
        assertEquals(addedValue, bst.root!!.data)
    }

    @Test
    fun `given tree with one node, when add is called with a value greater than root, then the value is added to the right and count is updated`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()
        bst.add(5)

        // WHEN
        val addedValue = 7
        bst.add(addedValue)

        // THEN
        val expectedCount = 2
        assertEquals(expectedCount, bst.count)
        assertNotNull(bst.root)
        assertEquals(addedValue, bst.root!!.right!!.data)
    }

    @Test
    fun `given tree with one node, when add is called with a value equal to root, then the value is added to the right and count is updated`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()
        bst.add(7)

        // WHEN
        val addedValue = 7
        bst.add(addedValue)

        // THEN
        val expectedCount = 2
        assertEquals(expectedCount, bst.count)
        assertNotNull(bst.root)
        assertEquals(addedValue, bst.root!!.right!!.data)
    }

    @Test
    fun `given tree with one node, when add is called with a value less than root, then the value is added to the left and count is updated`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()
        bst.add(7)

        // WHEN
        val addedValue = 5
        bst.add(addedValue)

        // THEN
        val expectedCount = 2
        assertEquals(expectedCount, bst.count)
        assertNotNull(bst.root)
        assertEquals(addedValue, bst.root!!.left!!.data)
    }

    /**
     *     root
     *       3
     *      /  \ right
     *   null   4
     *           \ right
     *            5
     */
    @Test
    fun `given empty tree, when add is called multiple times 3,4,5 , then the values are added in sort order and count is updated`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()

        // WHEN
        bst.add(3)
        bst.add(4)
        bst.add(5)

        // THEN
        val expectedCount = 3
        val expectedRoot = 3
        val expectedRight = 4
        val expectedRightRight = 5
        assertEquals(expectedCount, bst.count)
        assertNotNull(bst.root)
        assertEquals(expectedRoot, bst.root!!.data)
        assertEquals(expectedRight, bst.root!!.right!!.data)
        assertEquals(expectedRightRight, bst.root!!.right!!.right!!.data)
        assertNull(bst.root!!.left)
    }

    /**
     *     root
     *        5
     *      /  \ right
     *     3   null
     *    /
     *   2
     */
    @Test
    fun `given empty tree, when add is called multiple times 5,3,2 , then the values are added in sort order and count is updated`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()

        // WHEN
        bst.add(5)
        bst.add(3)
        bst.add(2)

        // THEN
        val expectedCount = 3
        val expectedRoot = 5
        val expectedLeft = 3
        val expectedLeftLeft = 2
        assertEquals(expectedCount, bst.count)
        assertNotNull(bst.root)
        assertEquals(expectedRoot, bst.root!!.data)
        assertEquals(expectedLeft, bst.root!!.left!!.data)
        assertEquals(expectedLeftLeft, bst.root!!.left!!.left!!.data)
        assertNull(bst.root!!.right)
    }
    //endregion

    //region remove tests
    @Test
    fun `given empty tree, when remove is called with any value, return false`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()

        // WHEN
        val result = bst.remove(5)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given a tree, when remove is called a non existent-value, return false`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()
        bst.add(2)

        // WHEN
        val result = bst.remove(5)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given a tree with one value, when remove is called value in the tree, return true and update count and root`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()
        bst.add(2)

        // WHEN
        val result = bst.remove(2)

        // THEN
        val expectedCount = 0
        assertTrue(result)
        assertEquals(expectedCount, bst.count)
        assertNull(bst.root)
    }

    /**
     *          3              3
     *         / \            / \
     *       null 4  ---->  null 4
     *             \              \
     *              5             null
     */
    @Test
    fun `given a tree, when remove is called with a leaf right node, return true and update count`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()
        bst.add(3)
        bst.add(4)
        bst.add(5)

        // WHEN
        val result = bst.remove(5)

        // THEN
        val expectedCount = 2
        val expectedRight = 4
        assertTrue(result)
        assertEquals(expectedCount, bst.count)
        assertEquals(expectedRight, bst.root!!.right!!.data)
        assertNotNull(bst.root)
        assertNull(bst.root!!.right!!.right)
        assertNull(bst.root!!.left)
    }

    /**
     *          5               5
     *         / \             / \
     *        3  null ---->   3  null
     *       /               /
     *      2              null
     */
    @Test
    fun `given a tree, when remove is called with a leaf left node, return true and update count`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()
        bst.add(5)
        bst.add(3)
        bst.add(2)

        // WHEN
        val result = bst.remove(2)

        // THEN
        val expectedCount = 2
        val expectedLeft = 3
        assertTrue(result)
        assertEquals(expectedCount, bst.count)
        assertEquals(expectedLeft, bst.root!!.left!!.data)
        assertNotNull(bst.root)
        assertNull(bst.root!!.left!!.left)
        assertNull(bst.root!!.right)
    }

    /**
     *          3                  3
     *         / \                / \
     *        2   4     ---->    2   5
     *       /     \            /     \
     *      null    5         null    null
     */
    @Test
    fun `given a multi-values tree, when remove is called with value that has one child, return true and update count and root`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()
        bst.add(3)
        bst.add(4)
        bst.add(2)
        bst.add(5)

        // WHEN
        val result = bst.remove(4)

        // THEN
        val expectedCount = 3
        val expectedRight = 5
        assertTrue(result)
        assertEquals(expectedCount, bst.count)
        assertEquals(expectedRight, bst.root!!.right!!.data)
        assertNotNull(bst.root)
        assertNull(bst.root!!.right!!.right)
    }

    /**
     *                  3                           3
     *                 / \                        /  \
     *               null 7                     null  8
     *                   / \                         / \
     *                 5     10                     5  10
     *               / \     / \
     *            null null  8 null
     */
    @Test
    fun `given a multi-values tree, when remove is called with value that has two children, return true and update count and root`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()
        bst.add(3)
        bst.add(7)
        bst.add(5)
        bst.add(10)
        bst.add(8)

        // WHEN
        val result = bst.remove(7)

        // THEN
        val expectedCount = 4
        val expectedRight = 8
        val expectedRightLeft = 5
        val expectedRightRight = 10

        assertTrue(result)
        assertEquals(expectedCount, bst.count)
        assertEquals(expectedRight, bst.root!!.right!!.data)
        assertEquals(expectedRightRight, bst.root!!.right!!.right!!.data)
        assertEquals(expectedRightLeft, bst.root!!.right!!.left!!.data)
        assertNotNull(bst.root)
        assertNull(bst.root!!.left)
    }
    //endregion

    //region search tests
    @Test
    fun `given empty tree, when search is called with any value, return null`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()

        // WHEN
        val result = bst.search(5)

        // THEN
        assertNull(result)
    }

    @Test
    fun `given tree, when search is called with a non-existent value, return null`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()
        bst.add(2)

        // WHEN
        val result = bst.search(5)

        // THEN
        assertNull(result)
    }

    @Test
    fun `given tree, when search is called with root value, return root`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()
        val addedNode = BinarySearchTreeNode(5)
        bst.add(addedNode)

        // WHEN
        val result = bst.search(addedNode)

        // THEN
        assertEquals(addedNode, result)
    }

    @Test
    fun `given tree, when search is called with right leaf value, return correct node`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()
        bst.add(3)
        bst.add(4)
        bst.add(5)

        // WHEN
        val searchedForNode = BinarySearchTreeNode(5)
        val result = bst.search(5)

        // THEN
        assertEquals(searchedForNode, result)
    }

    @Test
    fun `given tree, when search is called with left leaf value, return correct node`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()
        bst.add(3)
        bst.add(4)
        bst.add(2)

        // WHEN
        val searchedForNode = BinarySearchTreeNode(4)
        val result = bst.search(4)

        // THEN
        assertEquals(searchedForNode, result)
    }


    /**
     *                  3
     *                 / \
     *               null 7
     *                   / \
     *                 5     10
     *               / \     / \
     *            null null  8 null
     */
    @Test
    fun `given tree, when search is called with middle node value, return correct node`() {
        // GIVEN
        val bst = BinarySearchTree<Int>()
        bst.add(3)
        bst.add(7)
        bst.add(5)
        bst.add(10)
        bst.add(8)

        // WHEN
        val result = bst.search(7)

        // THEN
        val expectedNode = BinarySearchTreeNode(7).also { it ->
            it.right = BinarySearchTreeNode(10).also { it.left = BinarySearchTreeNode(8) }
            it.left = BinarySearchTreeNode(5)
        }
        assertEquals(expectedNode, result)
    }

    //endregion
}