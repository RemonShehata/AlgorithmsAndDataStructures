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

    //region add tests
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

    @Test()
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

    @Test()
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

    @Test()
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

    @Test()
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
}