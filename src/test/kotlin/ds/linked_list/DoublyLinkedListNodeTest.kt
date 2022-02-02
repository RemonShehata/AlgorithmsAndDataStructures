package ds.linked_list

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class DoublyLinkedListNodeTest {

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
}