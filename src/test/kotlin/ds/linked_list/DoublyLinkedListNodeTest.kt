package ds.linked_list

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DoublyLinkedListNodeTest{

    //region head and count tests
    @Test
    fun `given empty list, the head is null, and count is 0`() {
        val emptySinglyLinkedList = DoublyLinkedList<Int>()

        val expectedCount = 0
        assertNull(emptySinglyLinkedList.head)
        assertEquals(expectedCount, emptySinglyLinkedList.count)
    }
    //endregion
}