package ds.queue

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class QueueTest {
    //region count
    @Test
    fun `given empty queue, when count is called, it is zero`() {
        val queue = Queue<Int>()

        assertEquals(0, queue.count)
    }
    //endregion

    //region enqueue
    @Test
    fun `given empty queue, when enqueue is called once, count is updated`() {

        // GIVEN
        val valueToInsert = 5
        val queue = Queue<Int>()

        // WHEN
        queue.enqueue(valueToInsert)

        // THEN
        val expectedCount = 1
        assertEquals(expectedCount, queue.count)
    }

    @Test
    fun `given queue with one item, when enqueue is called once, count is updated`() {

        // GIVEN
        val valueToInsert = 5
        val queue = Queue<Int>()
        queue.enqueue(1)

        // WHEN
        queue.enqueue(valueToInsert)

        // THEN
        val expectedCount = 2
        assertEquals(expectedCount, queue.count)
    }
    //endregion

    //region dequeue
    @Test
    fun `given empty queue, when dequeue is called, exception is thrown`() {

        // GIVEN
        val queue = Queue<Int>()

        // THEN
        assertThrows<IllegalStateException> { queue.dequeue() }
    }

    @Test
    fun `given queue with one item, when dequeue is called, count is updated`() {

        // GIVEN
        val queue = Queue<Int>()
        queue.enqueue(1)

        // WHEN
        queue.dequeue()

        // THEN
        val expectedCount = 0
        assertEquals(expectedCount, queue.count)
    }
    //endregion

    //region peek
    @Test
    fun `given empty queue, when peek is called, exception is thrown`() {

        // GIVEN
        val queue = Queue<Int>()

        // THEN
        assertThrows<IllegalStateException> { queue.peek() }
    }

    @Test
    fun `given queue with one item, when peek is called, the head value is returned and count is the same`() {

        // GIVEN
        val queue = Queue<Int>()
        queue.enqueue(10)

        // WHEN
        val result = queue.peek()

        // THEN
        val expectedCount = 1
        val expectedHeadValue = 10
        assertEquals(expectedCount, queue.count)
        assertEquals(expectedHeadValue, result)
    }

    @Test
    fun `given a multi item-queue, when peek is called, the head value is returned and count is the same`() {

        // GIVEN
        val queue = Queue<Int>()
        queue.enqueue(10)
        queue.enqueue(20)

        // WHEN
        val result = queue.peek()

        // THEN
        val expectedCount = 2
        val expectedHeadValue = 10
        assertEquals(expectedCount, queue.count)
        assertEquals(expectedHeadValue, result)
    }
    //endregion

    //region isEmpty
    @Test
    fun `given empty queue, when isEmpty is called, it returns true`() {

        // GIVEN
        val queue = Queue<Int>()

        // WHEN
        val result = queue.isEmpty()

        // THEN
        assertTrue(result)
    }

    @Test
    fun `given non-empty queue, when isEmpty is called, it returns false`() {

        // GIVEN
        val queue = Queue<Int>()
        queue.enqueue(1)

        // WHEN
        val result = queue.isEmpty()

        // THEN
        assertFalse(result)
    }
    //endregion

    //region Iterable tests
    @Test
    fun `given an empty list, when iterated through, number of iterations is zero`() {
        // GIVEN
        val queue = Queue<Int>()

        // WHEN
        var numberOfIterations = 0
        queue.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 0
        assertEquals(expectedIterations, numberOfIterations)
    }

    @Test
    fun `given a list, when iterated through, number of iterations is correct`() {
        // GIVEN
        val queue = Queue<Int>()
        val range = 1..5
        range.forEach {
            queue.enqueue(it)
        }

        // WHEN
        var numberOfIterations = 0
        queue.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 5
        assertEquals(expectedIterations, numberOfIterations)
    }

    @Test
    fun `given a list, when iterated through twice, number of iterations is correct`() {
        // GIVEN
        val queue = Queue<Int>()
        val range = 1..5
        range.forEach {
            queue.enqueue(it)
        }

        // WHEN
        var numberOfIterations = 0
        queue.forEach { numberOfIterations++ }
        queue.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 10
        assertEquals(expectedIterations, numberOfIterations)
    }

    @Test
    fun `given a list, when iterated through twice and return in the middle, number of iterations is correct`() {
        // GIVEN
        val queue = Queue<Int>()
        val range = 1..5
        range.forEach {
            queue.enqueue(it)
        }

        // WHEN
        var numberOfIterations = 0
        queue.forEach {
            if (it == 3) return
            numberOfIterations++
        }
        queue.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 7
        assertEquals(expectedIterations, numberOfIterations)
    }
    //endregion
}