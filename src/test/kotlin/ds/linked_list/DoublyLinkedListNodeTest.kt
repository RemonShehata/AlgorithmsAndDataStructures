package ds.linked_list

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

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

}