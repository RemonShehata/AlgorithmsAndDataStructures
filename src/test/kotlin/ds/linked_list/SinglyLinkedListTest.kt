package ds.linked_list

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


internal class SinglyLinkedListTest {

    //region head and count tests
    @Test
    fun `given empty list, the head is null, and count is 0`() {
        val emptySinglyLinkedList = SinglyLinkedList<Int>()

        val expectedCount = 0
        assertNull(emptySinglyLinkedList.head)
        assertEquals(expectedCount, emptySinglyLinkedList.count)
    }
    //endregion

    //region addHead tests
    @Test
    fun `given empty list, when add head is called, count is updated and head is not null`() {

        // GIVEN
        val valueToInsert = 5
        val emptySinglyLinkedList = SinglyLinkedList<Int>()

        // WHEN
        emptySinglyLinkedList.addHead(valueToInsert)

        // THEN
        val expectedCount = 1
        assertNotNull(emptySinglyLinkedList.head)
        assertNull(emptySinglyLinkedList.head!!.next)
        assertEquals(expectedCount, emptySinglyLinkedList.count)
        assertEquals(valueToInsert, emptySinglyLinkedList.head!!.value)
    }

    @Test
    fun `given list with one item, when add head is called, count and head are updated`() {

        // GIVEN
        val valueToInsert = 5
        val singlyLinkedList = SinglyLinkedList<Int>()
        singlyLinkedList.addHead(1)

        // WHEN
        singlyLinkedList.addHead(valueToInsert)

        // THEN
        val expectedCount = 2
        assertNotNull(singlyLinkedList.head)
        assertEquals(expectedCount, singlyLinkedList.count)
        assertEquals(valueToInsert, singlyLinkedList.head!!.value)
    }
    //endregion

    //region addAtIndex tests
    @Test
    fun `given list and node, when add at index is called with index -1, exception is thrown`() {
        // GIVEN
        val emptySinglyLinkedList = SinglyLinkedList<Int>()
        val nodeValue = 5

        // WHEN
        val index = -1

        // THEN
        assertThrows<IllegalArgumentException> {
            emptySinglyLinkedList.addAtIndex(
                index,
                nodeValue
            )
        }
    }

    @Test
    fun `given list and node, when add at index is called with index greater than count, exception is thrown`() {
        // GIVEN
        val emptySinglyLinkedList = SinglyLinkedList<Int>()
        val nodeValue = 5

        // WHEN
        val index = 2

        // THEN
        assertThrows<IllegalArgumentException> {
            emptySinglyLinkedList.addAtIndex(
                index,
                nodeValue
            )
        }
    }

    @Test
    fun `given list with one node, when add at index is called with index 1, the value is added after head`() {
        // GIVEN
        val oneItemSinglyLinkedList = SinglyLinkedList<Int>().also { it.addHead(1) }
        val nodeValue = 5
        val expectedCount = 2

        // WHEN
        val index = 1
        oneItemSinglyLinkedList.addAtIndex(index, nodeValue)

        // THEN
        assertEquals(nodeValue, oneItemSinglyLinkedList.head!!.next!!.value)
        assertEquals(expectedCount, oneItemSinglyLinkedList.count)
    }

    @Test
    fun `given list with one node, when add at index is called with index 0, the value is added at head`() {
        // GIVEN
        val oneItemSinglyLinkedList = SinglyLinkedList<Int>()
        val nodeValue = 5
        val expectedCount = 1

        // WHEN
        val index = 0
        oneItemSinglyLinkedList.addAtIndex(index, nodeValue)

        // THEN
        assertEquals(nodeValue, oneItemSinglyLinkedList.head!!.value)
        assertEquals(expectedCount, oneItemSinglyLinkedList.count)
    }
    //endregion

    // region removeHead tests
    @Test
    fun `given empty list, when removeHead is called, return false`() {
        // GIVEN
        val emptyLinkedList = SinglyLinkedList<Int>()

        // WHEN
        val result = emptyLinkedList.removeHead()

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given one item list, when removeHead is called, return true and remove the head`() {
        // GIVEN
        val oneItemSinglyLinkedList = SinglyLinkedList<Int>().also { it.addHead(1) }

        // WHEN
        val result = oneItemSinglyLinkedList.removeHead()

        // THEN
        val expectedCount = 0
        assertTrue(result)
        assertEquals(expectedCount, oneItemSinglyLinkedList.count)
        assertNull(oneItemSinglyLinkedList.head)
    }

    @Test
    fun `given multiple node-list, when removeHead is called, return true and update head and count`() {
        // GIVEN
        val multiItemSinglyLinkedList = SinglyLinkedList<Int>().apply {
            addHead(3)
            addHead(2)
            addHead(1)
        }

        // WHEN
        val result = multiItemSinglyLinkedList.removeHead()

        // THEN
        val expectedCount = 2
        val expectedHeadNodeValue = 2
        assertTrue(result)
        assertEquals(expectedCount, multiItemSinglyLinkedList.count)
        assertEquals(expectedHeadNodeValue, multiItemSinglyLinkedList.head!!.value)
    }

    //endregion

    //region remove tests
    @Test
    fun `given empty list, when remove is called with any value, return false`() {
        // GIVEN
        val emptyLinkedList = SinglyLinkedList<Int>()

        // WHEN
        val result = emptyLinkedList.remove(5)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given one item list, when remove is called with existing value, return true and update the list`() {
        // GIVEN
        val oneItemSinglyLinkedList = SinglyLinkedList<Int>().also { it.addHead(1) }

        // WHEN
        val result = oneItemSinglyLinkedList.remove(1)

        // THEN
        val expectedCount = 0
        assertTrue(result)
        assertNull(oneItemSinglyLinkedList.head)
        assertEquals(expectedCount, oneItemSinglyLinkedList.count)
    }

    @Test
    fun `given one item list, when remove is called with non-existing value, return false and don't update the list`() {
        // GIVEN
        val oneItemSinglyLinkedList = SinglyLinkedList<Int>().also { it.addHead(1) }

        // WHEN
        val result = oneItemSinglyLinkedList.remove(5)

        // THEN
        val expectedCount = 1
        assertFalse(result)
        assertNotNull(oneItemSinglyLinkedList.head)
        assertEquals(expectedCount, oneItemSinglyLinkedList.count)
    }


    @Test
    fun `given multiple node-list, when remove is called with existing value, return true and update the list`() {
        // GIVEN
        val multiItemSinglyLinkedList = SinglyLinkedList<Int>().apply {
            addHead(3)
            addHead(2)
            addHead(1)
        }

        // WHEN
        val result = multiItemSinglyLinkedList.remove(2)

        // THEN
        val expectedHeadNextValue = 3
        val expectedCount = 2
        assertTrue(result)
        assertNotNull(multiItemSinglyLinkedList.head)
        assertEquals(expectedCount, multiItemSinglyLinkedList.count)
        assertEquals(expectedHeadNextValue, multiItemSinglyLinkedList.head!!.next!!.value)
    }

    @Test
    fun `given multiple node-list, when remove is called with existing value equal to head, return true and update the list`() {
        // GIVEN
        val multiItemSinglyLinkedList = SinglyLinkedList<Int>().apply {
            addHead(3)
            addHead(2)
            addHead(1)
        }

        // WHEN
        val result = multiItemSinglyLinkedList.remove(1)

        // THEN
        val expectedHeadNextValue = 3
        val expectedHeadValue = 2
        val expectedCount = 2
        assertTrue(result)
        assertNotNull(multiItemSinglyLinkedList.head)
        assertEquals(expectedCount, multiItemSinglyLinkedList.count)
        assertEquals(expectedHeadValue, multiItemSinglyLinkedList.head!!.value)
        assertEquals(expectedHeadNextValue, multiItemSinglyLinkedList.head!!.next!!.value)
    }

    @Test
    fun `given multiple node-list, when remove is called with non-existing value, return false and don't update the list`() {
        // GIVEN
        val oneItemSinglyLinkedList = SinglyLinkedList<Int>().also { it.addHead(1) }

        // WHEN
        val result = oneItemSinglyLinkedList.remove(5)

        // THEN
        val expectedCount = 1
        assertFalse(result)
        assertNotNull(oneItemSinglyLinkedList.head)
        assertEquals(expectedCount, oneItemSinglyLinkedList.count)
    }

    //endregion

    //region removeAtIndex

    @Test
    fun `given list and node value, when removeAtIndex is called with index -1, exception is thrown`() {
        // GIVEN
        val emptySinglyLinkedList = SinglyLinkedList<Int>()

        // WHEN
        val index = -1

        // THEN
        assertThrows<IllegalArgumentException> { emptySinglyLinkedList.removeAtIndex(index) }
    }

    @Test
    fun `given list and node, when removeAtIndex is called with index greater than count, exception is thrown`() {
        // GIVEN
        val emptySinglyLinkedList = SinglyLinkedList<Int>()

        // WHEN
        val index = 2

        // THEN
        assertThrows<IllegalArgumentException> { emptySinglyLinkedList.removeAtIndex(index) }
    }

    @Test
    fun `given a multiple node-list with one node, when removeAtIndex is called with index 1, the value after head is removed`() {
        // GIVEN
        val oneItemSinglyLinkedList = SinglyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val index = 1
        oneItemSinglyLinkedList.removeAtIndex(index)

        // THEN
        val expectedCount = 2
        val expectedValueAfterHead = 1
        assertEquals(expectedValueAfterHead, oneItemSinglyLinkedList.head!!.next!!.value)
        assertEquals(expectedCount, oneItemSinglyLinkedList.count)
    }

    @Test
    fun `given list with one node, when removeAtIndex is called with index 0, head is removed`() {
        // GIVEN
        val oneItemSinglyLinkedList = SinglyLinkedList<Int>().also { it.addHead(1) }


        // WHEN
        val index = 0
        val result = oneItemSinglyLinkedList.removeAtIndex(index)

        // THEN
        val expectedCount = 0
        assertTrue(result)
        assertEquals(expectedCount, oneItemSinglyLinkedList.count)
        assertNull(oneItemSinglyLinkedList.head)
    }
    //endregion

    //region contains tests
    @Test
    fun `given empty list, when contains is called with any value, then returns false`() {
        // GIVEN
        val emptySinglyLinkedList = SinglyLinkedList<Int>()

        // WHEN
        val result = emptySinglyLinkedList.contains(5)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given a list with many nodes, when contains is called with value of head, then returns true`() {
        // GIVEN
        val singlyLinkedList = SinglyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = singlyLinkedList.contains(3)

        // THEN
        assertTrue(result)
    }

    @Test
    fun `given a list with many nodes, when contains is called with value of the last node, then returns true`() {
        // GIVEN
        val singlyLinkedList = SinglyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = singlyLinkedList.contains(1)

        // THEN
        assertTrue(result)
    }

    @Test
    fun `given a list with many nodes, when contains is called with value in the middle, then returns true`() {
        // GIVEN
        val singlyLinkedList = SinglyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = singlyLinkedList.contains(2)

        // THEN
        assertTrue(result)
    }

    @Test
    fun `given a list with many nodes, when contains is called with non-exist value, then returns false`() {
        // GIVEN
        val singlyLinkedList = SinglyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = singlyLinkedList.contains(5)

        // THEN
        assertFalse(result)
    }
    //endregion

    //region find tests
    @Test
    fun `given empty list, when find is called with any value, then returns null`() {
        // GIVEN
        val emptySinglyLinkedList = SinglyLinkedList<Int>()

        // WHEN
        val result = emptySinglyLinkedList.find(5)

        // THEN
        assertNull(result)
    }

    @Test
    fun `given a list with many nodes, when find is called with value of head, then returns head`() {
        // GIVEN
        val singlyLinkedList = SinglyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val nodeToFind = SinglyLinkedListNode<Int>(3)
        val result = singlyLinkedList.find(nodeToFind)

        // THEN
        assertEquals(result, singlyLinkedList.head)
    }

    @Test
    fun `given a list with many nodes, when find is called with value of the last node, then returns the correct node`() {
        // GIVEN
        val singlyLinkedList = SinglyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val nodeToFind = SinglyLinkedListNode<Int>(1)
        val result = singlyLinkedList.find(nodeToFind)

        // THEN
        assertEquals(result, singlyLinkedList.head!!.next!!.next)
        assertNull(result!!.next)
    }

    @Test
    fun `given a list with many nodes, when find is called with value in the middle, then return the correct node`() {
        // GIVEN
        val singlyLinkedList = SinglyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = singlyLinkedList.find(2)

        // THEN
        val actualMiddleValue = singlyLinkedList.head!!.next
        assertEquals(result, actualMiddleValue)
    }

    @Test
    fun `given a list with many nodes, when find is called with non-exist value, then returns null`() {
        // GIVEN
        val singlyLinkedList = SinglyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = singlyLinkedList.find(5)

        // THEN
        assertNull(result)
    }
    //endregion

    //region indexOf tests
    @Test
    fun `given empty list, when indexOf is called with any value, then returns -1`() {
        // GIVEN
        val emptySinglyLinkedList = SinglyLinkedList<Int>()

        // WHEN
        val result = emptySinglyLinkedList.indexOf(5)

        // THEN
        val expectedValue = -1
        assertEquals(expectedValue, result)
    }

    @Test
    fun `given a list with many nodes, when indexOf is called with value of head, then returns 0`() {
        // GIVEN
        val singlyLinkedList = SinglyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = singlyLinkedList.indexOf(3)

        // THEN
        val expectedValue = 0
        assertEquals(expectedValue, result)
    }

    @Test
    fun `given a list with many nodes, when indexOf is called with value of the last node, then returns the index which is equal to count - 1`() {
        // GIVEN
        val singlyLinkedList = SinglyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = singlyLinkedList.indexOf(1)

        // THEN
        val expectedValue = 2
        assertEquals(expectedValue, result)
        assertEquals(expectedValue, singlyLinkedList.count - 1)
    }

    @Test
    fun `given a list with many nodes, when indexOf is called with value in the middle, then return the correct index`() {
        // GIVEN
        val singlyLinkedList = SinglyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = singlyLinkedList.indexOf(2)

        // THEN
        val expectedValue = 1
        assertEquals(expectedValue, result)
    }

    @Test
    fun `given a list with many nodes, when indexOf is called with non-exist value, then returns -1`() {
        // GIVEN
        val singlyLinkedList = SinglyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = singlyLinkedList.indexOf(5)

        // THEN
        val expectedValue = -1
        assertEquals(expectedValue, result)
    }
    //endregion

    //region clear tests
    @Test
    fun `given an empty list, when clear is called, count is 0 and head is null`(){
        // GIVEN
        val emptySinglyLinkedList = SinglyLinkedList<Int>()

        // WHEN
        emptySinglyLinkedList.clear()

        // THEN
        val expectedCount = 0
        assertEquals(expectedCount, emptySinglyLinkedList.count)
        assertNull(emptySinglyLinkedList.head)
    }

    @Test
    fun `given a list, when clear is called, count is 0 and head is null`(){
        // GIVEN
        val singlyLinkedList = SinglyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        singlyLinkedList.clear()

        // THEN
        val expectedCount = 0
        assertEquals(expectedCount, singlyLinkedList.count)
        assertNull(singlyLinkedList.head)
    }
    //endregion
}