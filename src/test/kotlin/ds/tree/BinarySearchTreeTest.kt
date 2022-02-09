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
    //endregion
}