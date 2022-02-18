package ds.linked_list

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SortedListTest {
    //region head and count tests
    @Test
    fun `given empty list, the head the tail are null, and count is 0`() {
        val emptySortedList = SortedList<Int>()

        val expectedCount = 0
        assertNull(emptySortedList.head)
        assertNull(emptySortedList.tail)
        assertEquals(expectedCount, emptySortedList.count)
    }
    //endregion

    //region add tests
    @Test
    fun `given empty list, when add is called once, count is updated and head is equal to tail and not null`() {

        // GIVEN
        val valueToInsert = 5
        val emptySortedList = SortedList<Int>()

        // WHEN
        emptySortedList.add(valueToInsert)

        // THEN
        val expectedCount = 1
        assertNotNull(emptySortedList.head)
        assertNotNull(emptySortedList.tail)
        assertNull(emptySortedList.head!!.next)
        assertNull(emptySortedList.head!!.previous)
        assertNull(emptySortedList.tail!!.previous)
        assertEquals(emptySortedList.head, emptySortedList.tail)
        assertEquals(expectedCount, emptySortedList.count)
        assertEquals(valueToInsert, emptySortedList.head!!.value)
    }

    @Test
    fun `given one item-list, when add is called with bigger value, then value is added at tail and the count, head and tail are updated`() {

        // GIVEN
        val existingValue = 1
        val insertedValue = 5
        val sortedList = SortedList<Int>()
        sortedList.add(existingValue)

        // WHEN
        sortedList.add(insertedValue)

        // THEN
        val expectedCount = 2
        assertNotNull(sortedList.head)
        assertNotNull(sortedList.tail)
        assertEquals(expectedCount, sortedList.count)
        assertEquals(insertedValue, sortedList.head!!.next!!.value)
        assertEquals(insertedValue, sortedList.tail!!.value)
        assertEquals(existingValue, sortedList.head!!.value)
        assertEquals(existingValue, sortedList.tail!!.previous!!.value)
    }

    @Test
    fun `given one item-list, when add is called with smaller value, then value is added at head and the count, head and tail are updated`() {

        // GIVEN
        val existingValue = 5
        val insertedValue = 1
        val sortedList = SortedList<Int>()
        sortedList.add(existingValue)

        // WHEN
        sortedList.add(insertedValue)

        // THEN
        val expectedCount = 2
        assertNotNull(sortedList.head)
        assertNotNull(sortedList.tail)
        assertEquals(expectedCount, sortedList.count)
        assertEquals(existingValue, sortedList.head!!.next!!.value)
        assertEquals(existingValue, sortedList.tail!!.value)
        assertEquals(insertedValue, sortedList.head!!.value)
        assertEquals(insertedValue, sortedList.tail!!.previous!!.value)
    }

    @Test
    fun `given multiple item-list, when add is called with value smaller than head, then value is added at head and the count, head and tail are updated`() {

        // GIVEN
        val existingValues = listOf(3, 4, 5)
        val insertedValue = 1
        val sortedList = SortedList<Int>()
        existingValues.forEach { sortedList.add(it) }

        // WHEN
        sortedList.add(insertedValue)

        // THEN
        val expectedCount = 4
        assertNotNull(sortedList.head)
        assertNotNull(sortedList.tail)
        assertEquals(expectedCount, sortedList.count)
        assertEquals(insertedValue, sortedList.head!!.value)
    }

    @Test
    fun `given multiple item-list, when add is called with value greater than tail, then value is added at tail and the count, head and tail are updated`() {

        // GIVEN
        val existingValues = listOf(3, 4, 5)
        val insertedValue = 6
        val sortedList = SortedList<Int>()
        existingValues.forEach { sortedList.add(it) }

        // WHEN
        sortedList.add(insertedValue)

        // THEN
        val expectedCount = 4
        assertNotNull(sortedList.head)
        assertNotNull(sortedList.tail)
        assertEquals(expectedCount, sortedList.count)
        assertEquals(insertedValue, sortedList.tail!!.value)
    }

    @Test
    fun `given an empty list, when add is called with multiple values, the values are added in sort order`() {

        // GIVEN
        val valueToInsert = listOf(3, 5, 2, 1, 7, 4, 6)
        val emptySortedList = SortedList<Int>()

        // WHEN
        valueToInsert.forEach { emptySortedList.add(it) }

        // THEN
        val expectedCount = 7
        val expectedSortedList = listOf(1, 2, 3, 4, 5, 6, 7)
        assertNotNull(emptySortedList.head)
        assertNotNull(emptySortedList.tail)
        assertEquals(expectedCount, emptySortedList.count)
        assertEquals(7, emptySortedList.tail!!.value)
        assertEquals(1, emptySortedList.head!!.value)

        var current = emptySortedList.head
        expectedSortedList.forEach { expectedItem ->
            assertEquals(expectedItem, current!!.value)
            current = current!!.next
        }
    }
    //endregion

    //region remove tests
    @Test
    fun `given empty list, when remove is called with any value, return false`() {
        // GIVEN
        val emptyLinkedList = SortedList<Int>()

        // WHEN
        val result = emptyLinkedList.remove(5)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given one item list, when remove is called with existing value, return true and update the list`() {
        // GIVEN
        val oneItemSortedList = SortedList<Int>().also { it.add(1) }

        // WHEN
        val result = oneItemSortedList.remove(1)

        // THEN
        val expectedCount = 0
        assertTrue(result)
        assertNull(oneItemSortedList.head)
        assertNull(oneItemSortedList.tail)
        assertEquals(expectedCount, oneItemSortedList.count)
    }

    @Test
    fun `given one item list, when remove is called with non-existing value, return false and don't update the list`() {
        // GIVEN
        val oneItemSortedList = SortedList<Int>().also { it.add(1) }

        // WHEN
        val result = oneItemSortedList.remove(5)

        // THEN
        val expectedCount = 1
        assertFalse(result)
        assertNotNull(oneItemSortedList.head)
        assertNotNull(oneItemSortedList.tail)
        assertEquals(expectedCount, oneItemSortedList.count)
    }


    @Test
    fun `given multiple node-list, when remove is called with existing value, return true and update the list`() {
        // GIVEN
        val multiItemSortedList = SortedList<Int>().apply {
            add(3)
            add(2)
            add(1)
        }

        // WHEN
        val result = multiItemSortedList.remove(2)

        // THEN
        val expectedHeadValue = 1
        val expectedTailValue = 3
        val expectedCount = 2
        assertTrue(result)
        assertNotNull(multiItemSortedList.head)
        assertEquals(expectedCount, multiItemSortedList.count)
        assertEquals(expectedHeadValue, multiItemSortedList.head!!.value)
        assertEquals(expectedHeadValue, multiItemSortedList.tail!!.previous!!.value)
        assertEquals(expectedTailValue, multiItemSortedList.tail!!.value)
        assertEquals(expectedTailValue, multiItemSortedList.head!!.next!!.value)
    }

    @Test
    fun `given multiple node-list, when remove is called with existing value equal to head, return true and update the list`() {
        // GIVEN
        val multiItemSortedList = SortedList<Int>().apply {
            add(3)
            add(2)
            add(1)
        }

        // WHEN
        val result = multiItemSortedList.remove(1)

        // THEN
        val expectedHeadTailValue = 3
        val expectedHeadValue = 2
        val expectedCount = 2
        assertTrue(result)
        assertNotNull(multiItemSortedList.head)
        assertNotNull(multiItemSortedList.tail)
        assertEquals(expectedCount, multiItemSortedList.count)
        assertEquals(expectedHeadValue, multiItemSortedList.head!!.value)
        assertEquals(expectedHeadValue, multiItemSortedList.tail!!.previous!!.value)
        assertEquals(expectedHeadTailValue, multiItemSortedList.head!!.next!!.value)
        assertEquals(expectedHeadTailValue, multiItemSortedList.tail!!.value)
    }

    @Test
    fun `given multiple node-list, when remove is called with existing value equal to tail, return true and update the list`() {
        // GIVEN
        val multiItemSortedList = SortedList<Int>().apply {
            add(3)
            add(2)
            add(1)
        }

        // WHEN
        val result = multiItemSortedList.remove(3)

        // THEN
        val expectedHeadValue = 1
        val expectedTailValue = 2
        val expectedCount = 2
        assertTrue(result)
        assertNotNull(multiItemSortedList.head)
        assertNotNull(multiItemSortedList.tail)
        assertEquals(expectedCount, multiItemSortedList.count)
        assertEquals(expectedTailValue, multiItemSortedList.tail!!.value)
        assertEquals(expectedHeadValue, multiItemSortedList.head!!.value)
        assertEquals(expectedHeadValue, multiItemSortedList.tail!!.previous!!.value)
        assertEquals(expectedTailValue, multiItemSortedList.head!!.next!!.value)
    }

    @Test
    fun `given multiple node-list, when remove is called with non-existing value, return false and don't update the list`() {
        // GIVEN
        val sortedList = SortedList<Int>().also {
            it.add(1)
            it.add(2)
        }

        // WHEN
        val result = sortedList.remove(5)

        // THEN
        val expectedCount = 2
        assertFalse(result)
        assertNotNull(sortedList.head)
        assertNotNull(sortedList.tail)
        assertEquals(expectedCount, sortedList.count)
    }
    //endregion

    //region contains tests
    @Test
    fun `given empty list, when contains is called with any value, then returns false`() {
        // GIVEN
        val emptySortedList = SortedList<Int>()

        // WHEN
        val result = emptySortedList.contains(5)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given a list with many nodes, when contains is called with value of head, then returns true`() {
        // GIVEN
        val sortedList = SortedList<Int>().also {
            it.add(1)
            it.add(2)
            it.add(3)
        }

        // WHEN
        val result = sortedList.contains(1)

        // THEN
        assertTrue(result)
    }

    @Test
    fun `given a list with many nodes, when contains is called with value of tail, then returns true`() {
        // GIVEN
        val sortedList = SortedList<Int>().also {
            it.add(1)
            it.add(2)
            it.add(3)
        }

        // WHEN
        val result = sortedList.contains(3)

        // THEN
        assertTrue(result)
    }

    @Test
    fun `given a list with many nodes, when contains is called with value in the middle, then returns true`() {
        // GIVEN
        val sortedList = SortedList<Int>().also {
            it.add(1)
            it.add(2)
            it.add(3)
        }

        // WHEN
        val result = sortedList.contains(2)

        // THEN
        assertTrue(result)
    }

    @Test
    fun `given a list with many nodes, when contains is called with non-exist value, then returns false`() {
        // GIVEN
        val sortedList = SortedList<Int>().also {
            it.add(1)
            it.add(2)
            it.add(3)
        }

        // WHEN
        val result = sortedList.contains(5)

        // THEN
        assertFalse(result)
    }
    //endregion

    //region find tests
    @Test
    fun `given empty list, when find is called with any value, then returns null`() {
        // GIVEN
        val emptySortedList = SortedList<Int>()

        // WHEN
        val result = emptySortedList.find(5)

        // THEN
        assertNull(result)
    }

    @Test
    fun `given a list with many nodes, when find is called with value of head, then returns head`() {
        // GIVEN
        val sortedList = SortedList<Int>().also {
            it.add(1)
            it.add(2)
            it.add(3)
        }

        // WHEN
        val nodeToFind = SortedListNode<Int>(1)
        val result = sortedList.find(nodeToFind)

        // THEN
        assertEquals(result, sortedList.head)
    }

    @Test
    fun `given a list with many nodes, when find is called with value of the tail, then returns tail node`() {
        // GIVEN
        val sortedList = SortedList<Int>().also {
            it.add(1)
            it.add(2)
            it.add(3)
        }

        // WHEN
        val nodeToFind = SortedListNode<Int>(3)
        val result = sortedList.find(nodeToFind)

        // THEN
        assertEquals(result, sortedList.tail)
        assertNull(result!!.next)
    }

    @Test
    fun `given a list with many nodes, when find is called with value in the middle, then return the correct node`() {
        // GIVEN
        val sortedList = SortedList<Int>().also {
            it.add(1)
            it.add(2)
            it.add(3)
        }

        // WHEN
        val result = sortedList.find(2)

        // THEN
        val actualMiddleValue = sortedList.head!!.next
        assertEquals(result, actualMiddleValue)
    }

    @Test
    fun `given a list with many nodes, when find is called with non-exist value, then returns null`() {
        // GIVEN
        val sortedList = SortedList<Int>().also {
            it.add(1)
            it.add(2)
            it.add(3)
        }

        // WHEN
        val result = sortedList.find(5)

        // THEN
        assertNull(result)
    }
    //endregion

    //region indexOf tests
    @Test
    fun `given empty list, when indexOf is called with any value, then returns -1`() {
        // GIVEN
        val emptySortedList = SortedList<Int>()

        // WHEN
        val result = emptySortedList.indexOf(5)

        // THEN
        val expectedValue = -1
        assertEquals(expectedValue, result)
    }

    @Test
    fun `given a list with many nodes, when indexOf is called with value of head, then returns 0`() {
        // GIVEN
        val sortedList = SortedList<Int>().also {
            it.add(1)
            it.add(2)
            it.add(3)
        }

        // WHEN
        val result = sortedList.indexOf(1)

        // THEN
        val expectedValue = 0
        assertEquals(expectedValue, result)
    }

    @Test
    fun `given a list with many nodes, when indexOf is called with value of tail, then returns the index which is equal to count - 1`() {
        // GIVEN
        val sortedList = SortedList<Int>().also {
            it.add(1)
            it.add(2)
            it.add(3)
        }

        // WHEN
        val result = sortedList.indexOf(3)

        // THEN
        val expectedValue = 2
        assertEquals(expectedValue, result)
        assertEquals(expectedValue, sortedList.count - 1)
    }

    @Test
    fun `given a list with many nodes, when indexOf is called with value in the middle, then return the correct index`() {
        // GIVEN
        val sortedList = SortedList<Int>().also {
            it.add(1)
            it.add(2)
            it.add(3)
        }

        // WHEN
        val result = sortedList.indexOf(2)

        // THEN
        val expectedValue = 1
        assertEquals(expectedValue, result)
    }

    @Test
    fun `given a list with many nodes, when indexOf is called with non-exist value, then returns -1`() {
        // GIVEN
        val sortedList = SortedList<Int>().also {
            it.add(1)
            it.add(2)
            it.add(3)
        }

        // WHEN
        val result = sortedList.indexOf(5)

        // THEN
        val expectedValue = -1
        assertEquals(expectedValue, result)
    }
    //endregion

    //region clear tests
    @Test
    fun `given an empty list, when clear is called, count is 0 and head is null`() {
        // GIVEN
        val emptySortedList = SortedList<Int>()

        // WHEN
        emptySortedList.clear()

        // THEN
        val expectedCount = 0
        assertEquals(expectedCount, emptySortedList.count)
        assertNull(emptySortedList.head)
        assertNull(emptySortedList.tail)
    }

    @Test
    fun `given a list, when clear is called, count is 0 and head is null`() {
        // GIVEN
        val sortedList = SortedList<Int>().also {
            it.add(1)
            it.add(2)
            it.add(3)
        }

        // WHEN
        sortedList.clear()

        // THEN
        val expectedCount = 0
        assertEquals(expectedCount, sortedList.count)
        assertNull(sortedList.head)
    }
    //endregion

    //region Iterable tests
    @Test
    fun `given an empty list, when iterated through, number of iterations is zero`() {
        // GIVEN
        val singlyLinkedList = SortedList<Int>()

        // WHEN
        var numberOfIterations = 0
        singlyLinkedList.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 0
        assertEquals(expectedIterations, numberOfIterations)
    }

    @Test
    fun `given a list, when iterated through, number of iterations is correct`() {
        // GIVEN
        val singlyLinkedList = SortedList<Int>()
        val range = 1..5
        range.forEach {
            singlyLinkedList.add(it)
        }

        // WHEN
        var numberOfIterations = 0
        singlyLinkedList.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 5
        assertEquals(expectedIterations, numberOfIterations)
    }

    @Test
    fun `given a list, when iterated through twice, number of iterations is correct`() {
        // GIVEN
        val singlyLinkedList = SortedList<Int>()
        val range = 1..5
        range.forEach {
            singlyLinkedList.add(it)
        }

        // WHEN
        var numberOfIterations = 0
        singlyLinkedList.forEach { numberOfIterations++ }
        singlyLinkedList.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 10
        assertEquals(expectedIterations, numberOfIterations)
    }

    @Test
    fun `given a list, when iterated through twice and return in the middle, number of iterations is correct`() {
        // GIVEN
        val singlyLinkedList = SortedList<Int>()
        val range = 1..5
        range.forEach {
            singlyLinkedList.add(it)
        }

        // WHEN
        var numberOfIterations = 0
        singlyLinkedList.forEach {
            if (it == 3) return
            numberOfIterations++
        }
        singlyLinkedList.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 7
        assertEquals(expectedIterations, numberOfIterations)
    }
    //endregion
}
