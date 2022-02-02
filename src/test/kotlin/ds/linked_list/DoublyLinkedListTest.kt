package ds.linked_list

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class DoublyLinkedListTest {

    //region head and count tests
    @Test
    fun `given empty list, the head the tail are null, and count is 0`() {
        val emptyDoublyLinkedList = DoublyLinkedList<Int>()

        val expectedCount = 0
        assertNull(emptyDoublyLinkedList.head)
        assertNull(emptyDoublyLinkedList.tail)
        assertEquals(expectedCount, emptyDoublyLinkedList.count)
    }
    //endregion

    //region addHead tests
    @Test
    fun `given empty list, when add head is called once, count is updated and head is equal to tail and not null`() {

        // GIVEN
        val valueToInsert = 5
        val emptyDoublyLinkedList = DoublyLinkedList<Int>()

        // WHEN
        emptyDoublyLinkedList.addHead(valueToInsert)

        // THEN
        val expectedCount = 1
        assertNotNull(emptyDoublyLinkedList.head)
        assertNotNull(emptyDoublyLinkedList.tail)
        assertNull(emptyDoublyLinkedList.head!!.next)
        assertNull(emptyDoublyLinkedList.head!!.previous)
        assertNull(emptyDoublyLinkedList.tail!!.previous)
        assertEquals(emptyDoublyLinkedList.head, emptyDoublyLinkedList.tail)
        assertEquals(expectedCount, emptyDoublyLinkedList.count)
        assertEquals(valueToInsert, emptyDoublyLinkedList.head!!.value)
    }

    @Test
    fun `given list with one item, when add head is called, count, head and tail are updated`() {

        // GIVEN
        val valueToInsert = 5
        val doublyLinkedList = DoublyLinkedList<Int>()
        doublyLinkedList.addHead(1)

        // WHEN
        doublyLinkedList.addHead(valueToInsert)

        // THEN
        val expectedCount = 2
        assertNotNull(doublyLinkedList.head)
        assertNotNull(doublyLinkedList.tail)
        assertEquals(expectedCount, doublyLinkedList.count)
        assertEquals(valueToInsert, doublyLinkedList.head!!.value)
        assertEquals(1, doublyLinkedList.tail!!.value)
    }
    //endregion

    //region addTail tests
    @Test
    fun `given empty list, when addTail is called once, count is updated and head is equal to tail and not null`() {

        // GIVEN
        val valueToInsert = 5
        val emptyDoublyLinkedList = DoublyLinkedList<Int>()

        // WHEN
        emptyDoublyLinkedList.addTail(valueToInsert)

        // THEN
        val expectedCount = 1
        assertNotNull(emptyDoublyLinkedList.head)
        assertNotNull(emptyDoublyLinkedList.tail)
        assertNull(emptyDoublyLinkedList.head!!.next)
        assertNull(emptyDoublyLinkedList.head!!.previous)
        assertNull(emptyDoublyLinkedList.tail!!.previous)
        assertEquals(emptyDoublyLinkedList.head, emptyDoublyLinkedList.tail)
        assertEquals(expectedCount, emptyDoublyLinkedList.count)
        assertEquals(valueToInsert, emptyDoublyLinkedList.head!!.value)
    }

    @Test
    fun `given list with one item, when addTail is called, count, head and tail are updated`() {

        // GIVEN
        val valueToInsert = 5
        val doublyLinkedList = DoublyLinkedList<Int>()
        doublyLinkedList.addHead(1)

        // WHEN
        doublyLinkedList.addTail(valueToInsert)

        // THEN
        val expectedCount = 2
        assertNotNull(doublyLinkedList.head)
        assertNotNull(doublyLinkedList.tail)
        assertEquals(expectedCount, doublyLinkedList.count)
        assertEquals(valueToInsert, doublyLinkedList.tail!!.value)
        assertEquals(1, doublyLinkedList.head!!.value)
    }
    //endregion

    //region addAtIndex tests
    @Test
    fun `given list and node, when addAtIndex is called with index -1, exception is thrown`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>()
        val nodeValue = 5

        // WHEN
        val index = -1

        // THEN
        assertThrows<IllegalArgumentException> {
            doublyLinkedList.addAtIndex(
                index,
                nodeValue
            )
        }
    }

    @Test
    fun `given list and node, when addAtIndex is called with index greater than count, exception is thrown`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>()
        val nodeValue = 5

        // WHEN
        val index = 2

        // THEN
        assertThrows<IllegalArgumentException> {
            doublyLinkedList.addAtIndex(
                index,
                nodeValue
            )
        }
    }

    @Test
    fun `given list with one node, when addAtIndex is called with index 1, the value is added after head`() {
        // GIVEN
        val oneItemDoublyLinkedList = DoublyLinkedList<Int>().also { it.addHead(1) }
        val nodeValue = 5
        val expectedCount = 2

        // WHEN
        val index = 1
        oneItemDoublyLinkedList.addAtIndex(index, nodeValue)

        // THEN
        assertEquals(nodeValue, oneItemDoublyLinkedList.head!!.next!!.value)
        assertEquals(nodeValue, oneItemDoublyLinkedList.tail!!.value)
        assertEquals(expectedCount, oneItemDoublyLinkedList.count)
    }

    @Test
    fun `given list with one node, when addAtIndex is called with index 0, the value is added at head`() {
        // GIVEN
        val oneItemDoublyLinkedList = DoublyLinkedList<Int>()
        val nodeValue = 5
        val expectedCount = 1

        // WHEN
        val index = 0
        oneItemDoublyLinkedList.addAtIndex(index, nodeValue)

        // THEN
        assertEquals(nodeValue, oneItemDoublyLinkedList.head!!.value)
        assertEquals(nodeValue, oneItemDoublyLinkedList.tail!!.value)
        assertEquals(expectedCount, oneItemDoublyLinkedList.count)
    }

    @Test
    fun `given list, when addAtIndex is called with index equal count, the value is added at tail`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
        }

        val nodeValue = 5
        val expectedCount = 3

        // WHEN
        val index = 2
        doublyLinkedList.addAtIndex(index, nodeValue)

        // THEN
        assertEquals(nodeValue, doublyLinkedList.tail!!.value)
        assertEquals(expectedCount, doublyLinkedList.count)
    }

    @Test
    fun `given list, when addAtIndex is called with index equal count -1, the value is added before tail`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
        }

        val nodeValue = 5
        val expectedCount = 3

        // WHEN
        val index = 1
        doublyLinkedList.addAtIndex(index, nodeValue)

        // THEN
        assertEquals(nodeValue, doublyLinkedList.tail!!.previous!!.value)
        assertEquals(expectedCount, doublyLinkedList.count)
    }

    @Test
    fun `given list with multiple items, when addAtIndex is called with index in the middle, the value is added in the correct index`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
            it.addHead(4)
            it.addHead(5)
        }

        val nodeValue = 7
        val expectedCount = 6

        // WHEN
        val index = 2
        doublyLinkedList.addAtIndex(index, nodeValue)

        // THEN
        assertEquals(nodeValue, doublyLinkedList.head!!.next!!.next!!.value)
        assertEquals(nodeValue, doublyLinkedList.tail!!.previous!!.previous!!.previous!!.value)
        assertEquals(expectedCount, doublyLinkedList.count)
    }
    //endregion

    //region removeHead tests
    @Test
    fun `given empty list, when removeHead is called, return false`() {
        // GIVEN
        val emptyLinkedList = DoublyLinkedList<Int>()

        // WHEN
        val result = emptyLinkedList.removeHead()

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given one item list, when removeHead is called, return true and remove the head and tail`() {
        // GIVEN
        val oneItemDoublyLinkedList = DoublyLinkedList<Int>().also { it.addHead(1) }

        // WHEN
        val result = oneItemDoublyLinkedList.removeHead()

        // THEN
        val expectedCount = 0
        assertTrue(result)
        assertEquals(expectedCount, oneItemDoublyLinkedList.count)
        assertNull(oneItemDoublyLinkedList.head)
        assertNull(oneItemDoublyLinkedList.tail)
    }

    @Test
    fun `given multiple node-list, when removeHead is called, return true and update head and count`() {
        // GIVEN
        val multiItemDoublyLinkedList = DoublyLinkedList<Int>().apply {
            addHead(3)
            addHead(2)
            addHead(1)
        }

        // WHEN
        val result = multiItemDoublyLinkedList.removeHead()

        // THEN
        val expectedCount = 2
        val expectedHeadNodeValue = 2
        assertTrue(result)
        assertEquals(expectedCount, multiItemDoublyLinkedList.count)
        assertEquals(expectedHeadNodeValue, multiItemDoublyLinkedList.head!!.value)
    }
    //endregion

    //region removeTail tests
    @Test
    fun `given empty list, when removeTail is called, return false`() {
        // GIVEN
        val emptyLinkedList = DoublyLinkedList<Int>()

        // WHEN
        val result = emptyLinkedList.removeTail()

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given one item list, when removeTail is called, return true and remove the head and tail`() {
        // GIVEN
        val oneItemDoublyLinkedList = DoublyLinkedList<Int>().also { it.addHead(1) }

        // WHEN
        val result = oneItemDoublyLinkedList.removeTail()

        // THEN
        val expectedCount = 0
        assertTrue(result)
        assertEquals(expectedCount, oneItemDoublyLinkedList.count)
        assertNull(oneItemDoublyLinkedList.head)
        assertNull(oneItemDoublyLinkedList.tail)
    }

    @Test
    fun `given multiple node-list, when removeTail is called, return true and update tail and count`() {
        // GIVEN
        val multiItemDoublyLinkedList = DoublyLinkedList<Int>().apply {
            addHead(3)
            addHead(2)
            addHead(1)
        }

        // WHEN
        val result = multiItemDoublyLinkedList.removeTail()

        // THEN
        val expectedCount = 2
        val expectedHeadNodeValue = 2
        assertTrue(result)
        assertEquals(expectedCount, multiItemDoublyLinkedList.count)
        assertEquals(expectedHeadNodeValue, multiItemDoublyLinkedList.tail!!.value)
    }
    //endregion

    //region removeAtIndex
    @Test
    fun `given list and node value, when removeAtIndex is called with index -1, exception is thrown`() {
        // GIVEN
        val emptyDoublyLinkedList = DoublyLinkedList<Int>()

        // WHEN
        val index = -1

        // THEN
        assertThrows<IllegalArgumentException> { emptyDoublyLinkedList.removeAtIndex(index) }
    }

    @Test
    fun `given list and node, when removeAtIndex is called with index greater than count, exception is thrown`() {
        // GIVEN
        val emptyDoublyLinkedList = DoublyLinkedList<Int>().also { it.addHead(1) }

        // WHEN
        val index = 2

        // THEN
        assertThrows<IllegalArgumentException> { emptyDoublyLinkedList.removeAtIndex(index) }
    }

    @Test
    fun `given a multiple node-list, when removeAtIndex is called with index 1, the value after head is removed`() {
        // GIVEN
        val oneItemDoublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val index = 1
        oneItemDoublyLinkedList.removeAtIndex(index)

        // THEN
        val expectedCount = 2
        val expectedValueAfterHead = 1
        assertEquals(expectedValueAfterHead, oneItemDoublyLinkedList.head!!.next!!.value)
        assertEquals(expectedCount, oneItemDoublyLinkedList.count)
    }

    @Test
    fun `given a multiple node-list, when removeAtIndex is called with index equal count - 1, the value at tail is removed`() {
        // GIVEN
        val oneItemDoublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val index = 2
        oneItemDoublyLinkedList.removeAtIndex(index)

        // THEN
        val expectedCount = 2
        val expectedValueForTail = 2
        assertEquals(expectedValueForTail, oneItemDoublyLinkedList.tail!!.value)
        assertEquals(expectedCount, oneItemDoublyLinkedList.count)
    }

    @Test
    fun `given list with one node, when removeAtIndex is called with index 0, head and tail are removed`() {
        // GIVEN
        val oneItemDoublyLinkedList = DoublyLinkedList<Int>().also { it.addHead(1) }

        // WHEN
        val index = 0
        val result = oneItemDoublyLinkedList.removeAtIndex(index)

        // THEN
        val expectedCount = 0
        assertTrue(result)
        assertEquals(expectedCount, oneItemDoublyLinkedList.count)
        assertNull(oneItemDoublyLinkedList.head)
        assertNull(oneItemDoublyLinkedList.tail)
    }
    //endregion

    //region remove tests
    @Test
    fun `given empty list, when remove is called with any value, return false`() {
        // GIVEN
        val emptyLinkedList = DoublyLinkedList<Int>()

        // WHEN
        val result = emptyLinkedList.remove(5)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given one item list, when remove is called with existing value, return true and update the list`() {
        // GIVEN
        val oneItemDoublyLinkedList = DoublyLinkedList<Int>().also { it.addHead(1) }

        // WHEN
        val result = oneItemDoublyLinkedList.remove(1)

        // THEN
        val expectedCount = 0
        assertTrue(result)
        assertNull(oneItemDoublyLinkedList.head)
        assertNull(oneItemDoublyLinkedList.tail)
        assertEquals(expectedCount, oneItemDoublyLinkedList.count)
    }

    @Test
    fun `given one item list, when remove is called with non-existing value, return false and don't update the list`() {
        // GIVEN
        val oneItemDoublyLinkedList = DoublyLinkedList<Int>().also { it.addHead(1) }

        // WHEN
        val result = oneItemDoublyLinkedList.remove(5)

        // THEN
        val expectedCount = 1
        assertFalse(result)
        assertNotNull(oneItemDoublyLinkedList.head)
        assertNotNull(oneItemDoublyLinkedList.tail)
        assertEquals(expectedCount, oneItemDoublyLinkedList.count)
    }


    @Test
    fun `given multiple node-list, when remove is called with existing value, return true and update the list`() {
        // GIVEN
        val multiItemDoublyLinkedList = DoublyLinkedList<Int>().apply {
            addHead(3)
            addHead(2)
            addHead(1)
        }

        // WHEN
        val result = multiItemDoublyLinkedList.remove(2)

        // THEN
        val expectedHeadNextValue = 3
        val expectedCount = 2
        assertTrue(result)
        assertNotNull(multiItemDoublyLinkedList.head)
        assertEquals(expectedCount, multiItemDoublyLinkedList.count)
        assertEquals(expectedHeadNextValue, multiItemDoublyLinkedList.head!!.next!!.value)
        assertEquals(expectedHeadNextValue, multiItemDoublyLinkedList.tail!!.value)
    }

    @Test
    fun `given multiple node-list, when remove is called with existing value equal to head, return true and update the list`() {
        // GIVEN
        val multiItemDoublyLinkedList = DoublyLinkedList<Int>().apply {
            addHead(3)
            addHead(2)
            addHead(1)
        }

        // WHEN
        val result = multiItemDoublyLinkedList.remove(1)

        // THEN
        val expectedHeadNextValue = 3
        val expectedHeadValue = 2
        val expectedCount = 2
        assertTrue(result)
        assertNotNull(multiItemDoublyLinkedList.head)
        assertNotNull(multiItemDoublyLinkedList.tail)
        assertEquals(expectedCount, multiItemDoublyLinkedList.count)
        assertEquals(expectedHeadValue, multiItemDoublyLinkedList.head!!.value)
        assertEquals(expectedHeadNextValue, multiItemDoublyLinkedList.head!!.next!!.value)
        assertEquals(expectedHeadNextValue, multiItemDoublyLinkedList.tail!!.value)
    }

    @Test
    fun `given multiple node-list, when remove is called with existing value equal to tail, return true and update the list`() {
        // GIVEN
        val multiItemDoublyLinkedList = DoublyLinkedList<Int>().apply {
            addHead(3)
            addHead(2)
            addHead(1)
        }

        // WHEN
        val result = multiItemDoublyLinkedList.remove(3)

        // THEN
        val expectedHeadNextValue = 2
        val expectedTailValue = 2
        val expectedCount = 2
        assertTrue(result)
        assertNotNull(multiItemDoublyLinkedList.head)
        assertNotNull(multiItemDoublyLinkedList.tail)
        assertEquals(expectedCount, multiItemDoublyLinkedList.count)
        assertEquals(expectedTailValue, multiItemDoublyLinkedList.tail!!.value)
        assertEquals(expectedHeadNextValue, multiItemDoublyLinkedList.head!!.next!!.value)
    }

    @Test
    fun `given multiple node-list, when remove is called with non-existing value, return false and don't update the list`() {
        // GIVEN
        val oneItemDoublyLinkedList = DoublyLinkedList<Int>().also { it.addHead(1) }

        // WHEN
        val result = oneItemDoublyLinkedList.remove(5)

        // THEN
        val expectedCount = 1
        assertFalse(result)
        assertNotNull(oneItemDoublyLinkedList.head)
        assertNotNull(oneItemDoublyLinkedList.tail)
        assertEquals(expectedCount, oneItemDoublyLinkedList.count)
    }
    //endregion

    //region contains tests
    @Test
    fun `given empty list, when contains is called with any value, then returns false`() {
        // GIVEN
        val emptyDoublyLinkedList = DoublyLinkedList<Int>()

        // WHEN
        val result = emptyDoublyLinkedList.contains(5)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given a list with many nodes, when contains is called with value of head, then returns true`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = doublyLinkedList.contains(3)

        // THEN
        assertTrue(result)
    }

    @Test
    fun `given a list with many nodes, when contains is called with value of tail, then returns true`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = doublyLinkedList.contains(1)

        // THEN
        assertTrue(result)
    }

    @Test
    fun `given a list with many nodes, when contains is called with value in the middle, then returns true`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = doublyLinkedList.contains(2)

        // THEN
        assertTrue(result)
    }

    @Test
    fun `given a list with many nodes, when contains is called with non-exist value, then returns false`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = doublyLinkedList.contains(5)

        // THEN
        assertFalse(result)
    }
    //endregion

    //region find tests
    @Test
    fun `given empty list, when find is called with any value, then returns null`() {
        // GIVEN
        val emptyDoublyLinkedList = DoublyLinkedList<Int>()

        // WHEN
        val result = emptyDoublyLinkedList.find(5)

        // THEN
        assertNull(result)
    }

    @Test
    fun `given a list with many nodes, when find is called with value of head, then returns head`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val nodeToFind = DoublyLinkedListNode<Int>(3)
        val result = doublyLinkedList.find(nodeToFind)

        // THEN
        assertEquals(result, doublyLinkedList.head)
    }

    @Test
    fun `given a list with many nodes, when find is called with value of the tail, then returns tail node`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val nodeToFind = DoublyLinkedListNode<Int>(1)
        val result = doublyLinkedList.find(nodeToFind)

        // THEN
        assertEquals(result, doublyLinkedList.tail)
        assertNull(result!!.next)
    }

    @Test
    fun `given a list with many nodes, when find is called with value in the middle, then return the correct node`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = doublyLinkedList.find(2)

        // THEN
        val actualMiddleValue = doublyLinkedList.head!!.next
        assertEquals(result, actualMiddleValue)
    }

    @Test
    fun `given a list with many nodes, when find is called with non-exist value, then returns null`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = doublyLinkedList.find(5)

        // THEN
        assertNull(result)
    }
    //endregion

    //region indexOf tests
    @Test
    fun `given empty list, when indexOf is called with any value, then returns -1`() {
        // GIVEN
        val emptyDoublyLinkedList = DoublyLinkedList<Int>()

        // WHEN
        val result = emptyDoublyLinkedList.indexOf(5)

        // THEN
        val expectedValue = -1
        assertEquals(expectedValue, result)
    }

    @Test
    fun `given a list with many nodes, when indexOf is called with value of head, then returns 0`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = doublyLinkedList.indexOf(3)

        // THEN
        val expectedValue = 0
        assertEquals(expectedValue, result)
    }

    @Test
    fun `given a list with many nodes, when indexOf is called with value of tail, then returns the index which is equal to count - 1`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = doublyLinkedList.indexOf(1)

        // THEN
        val expectedValue = 2
        assertEquals(expectedValue, result)
        assertEquals(expectedValue, doublyLinkedList.count - 1)
    }

    @Test
    fun `given a list with many nodes, when indexOf is called with value in the middle, then return the correct index`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = doublyLinkedList.indexOf(2)

        // THEN
        val expectedValue = 1
        assertEquals(expectedValue, result)
    }

    @Test
    fun `given a list with many nodes, when indexOf is called with non-exist value, then returns -1`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val result = doublyLinkedList.indexOf(5)

        // THEN
        val expectedValue = -1
        assertEquals(expectedValue, result)
    }
    //endregion

    //region clear tests
    @Test
    fun `given an empty list, when clear is called, count is 0 and head is null`() {
        // GIVEN
        val emptyDoublyLinkedList = DoublyLinkedList<Int>()

        // WHEN
        emptyDoublyLinkedList.clear()

        // THEN
        val expectedCount = 0
        assertEquals(expectedCount, emptyDoublyLinkedList.count)
        assertNull(emptyDoublyLinkedList.head)
        assertNull(emptyDoublyLinkedList.tail)
    }

    @Test
    fun `given a list, when clear is called, count is 0 and head is null`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        doublyLinkedList.clear()

        // THEN
        val expectedCount = 0
        assertEquals(expectedCount, doublyLinkedList.count)
        assertNull(doublyLinkedList.head)
    }
    //endregion

    //region combine indexOf and addAtIndex tests
    @Test
    fun `given a list, when addAtIndex is called with value, then indexOf return the same index to that value`() {
        // GIVEN
        val doublyLinkedList = DoublyLinkedList<Int>().also {
            it.addHead(1)
            it.addHead(2)
            it.addHead(3)
        }

        // WHEN
        val addedValue = 5
        val indexOfAddedValue = 1
        doublyLinkedList.addAtIndex(indexOfAddedValue, addedValue)

        // THEN
        val expectedValue = doublyLinkedList.indexOf(addedValue)
        assertEquals(expectedValue, indexOfAddedValue)
    }
    //endregion
}
