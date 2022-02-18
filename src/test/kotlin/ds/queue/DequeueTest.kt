package ds.queue

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

internal class DequeueTest {

    //region count
    @Test
    fun `given empty dequeue, when count is called, it is zero`() {
        val dequeue = Dequeue<Int>()

        assertEquals(0, dequeue.count)
    }
    //endregion

    //region enqueueHead
    @Test
    fun `given empty dequeue, when enqueueHead is called once, count is updated`() {

        // GIVEN
        val valueToInsert = 5
        val dequeue = Dequeue<Int>()

        // WHEN
        dequeue.enqueueHead(valueToInsert)

        // THEN
        val expectedCount = 1
        assertEquals(expectedCount, dequeue.count)
    }

    @Test
    fun `given dequeue with one item, when enqueueHead is called once, count is updated`() {

        // GIVEN
        val valueToInsert = 5
        val dequeue = Dequeue<Int>()
        dequeue.enqueueHead(1)

        // WHEN
        dequeue.enqueueHead(valueToInsert)

        // THEN
        val expectedCount = 2
        assertEquals(expectedCount, dequeue.count)
    }
    //endregion

    //region enqueueTail
    @Test
    fun `given empty dequeue, when enqueueTail is called once, count is updated`() {

        // GIVEN
        val valueToInsert = 5
        val dequeue = Dequeue<Int>()

        // WHEN
        dequeue.enqueueTail(valueToInsert)

        // THEN
        val expectedCount = 1
        assertEquals(expectedCount, dequeue.count)
    }

    @Test
    fun `given dequeue with one item, when enqueueTail is called once, count is updated`() {

        // GIVEN
        val valueToInsert = 5
        val dequeue = Dequeue<Int>()
        dequeue.enqueueHead(1)

        // WHEN
        dequeue.enqueueTail(valueToInsert)

        // THEN
        val expectedCount = 2
        assertEquals(expectedCount, dequeue.count)
    }
    //endregion

    //region dequeueHead
    @Test
    fun `given empty dequeue, when dequeueHead is called, exception is thrown`() {

        // GIVEN
        val dequeue = Dequeue<Int>()

        // THEN
        assertThrows<IllegalStateException> { dequeue.dequeueHead() }
    }

    @Test
    fun `given dequeue with one item, when dequeueHead is called once, count is updated`() {

        // GIVEN
        val dequeue = Dequeue<Int>()
        dequeue.enqueueHead(1)

        // WHEN
        dequeue.dequeueHead()

        // THEN
        val expectedCount = 0
        assertEquals(expectedCount, dequeue.count)
    }
    //endregion

    //region dequeueTail
    @Test
    fun `given empty dequeue, when dequeueTail is called, exception is thrown`() {

        // GIVEN
        val dequeue = Dequeue<Int>()

        // THEN
        assertThrows<IllegalStateException> { dequeue.dequeueTail() }
    }

    @Test
    fun `given dequeue with one item, when dequeueTail is called once, count is updated`() {

        // GIVEN
        val dequeue = Dequeue<Int>()
        dequeue.enqueueHead(1)

        // WHEN
        dequeue.dequeueTail()

        // THEN
        val expectedCount = 0
        assertEquals(expectedCount, dequeue.count)
    }
    //endregion

    //region peekHead
    @Test
    fun `given empty dequeue, when peekHead is called, exception is thrown`() {

        // GIVEN
        val dequeue = Dequeue<Int>()

        // THEN
        assertThrows<IllegalStateException> { dequeue.peekHead() }
    }

    @Test
    fun `given dequeue with one item, when peekHead is called, the head value is returned and count is the same`() {

        // GIVEN
        val dequeue = Dequeue<Int>()
        dequeue.enqueueHead(10)

        // WHEN
        val result = dequeue.peekHead()

        // THEN
        val expectedCount = 1
        val expectedHeadValue = 10
        assertEquals(expectedCount, dequeue.count)
        assertEquals(expectedHeadValue, result)
    }

    @Test
    fun `given a multi item-dequeue, when peekHead is called, the head value is returned and count is the same`() {

        // GIVEN
        val dequeue = Dequeue<Int>()
        dequeue.enqueueHead(10)
        dequeue.enqueueHead(20)

        // WHEN
        val result = dequeue.peekHead()

        // THEN
        val expectedCount = 2
        val expectedHeadValue = 20
        assertEquals(expectedCount, dequeue.count)
        assertEquals(expectedHeadValue, result)
    }
    //endregion

    //region peekTail
    @Test
    fun `given empty dequeue, when peekTail is called, exception is thrown`() {

        // GIVEN
        val dequeue = Dequeue<Int>()

        // THEN
        assertThrows<IllegalStateException> { dequeue.peekTail() }
    }

    @Test
    fun `given dequeue with one item, when peekTail is called, the tail value is returned and count is the same`() {

        // GIVEN
        val dequeue = Dequeue<Int>()
        dequeue.enqueueHead(10)

        // WHEN
        val result = dequeue.peekTail()

        // THEN
        val expectedCount = 1
        val expectedHeadValue = 10
        assertEquals(expectedCount, dequeue.count)
        assertEquals(expectedHeadValue, result)
    }

    @Test
    fun `given a multi item-dequeue, when peekTail is called, the tail value is returned and count is the same`() {

        // GIVEN
        val dequeue = Dequeue<Int>()
        dequeue.enqueueHead(10)
        dequeue.enqueueHead(20)

        // WHEN
        val result = dequeue.peekHead()

        // THEN
        val expectedCount = 2
        val expectedHeadValue = 20
        assertEquals(expectedCount, dequeue.count)
        assertEquals(expectedHeadValue, result)
    }
    //endregion

    //region isEmpty
    @Test
    fun `given empty dequeue, when isEmpty is called, it returns true`() {

        // GIVEN
        val dequeue = Dequeue<Int>()

        // WHEN
        val result = dequeue.isEmpty()

        // THEN
        assertTrue(result)
    }

    @Test
    fun `given non-empty dequeue, when isEmpty is called, it returns false`() {

        // GIVEN
        val dequeue = Dequeue<Int>()
        dequeue.enqueueHead(1)

        // WHEN
        val result = dequeue.isEmpty()

        // THEN
        assertFalse(result)
    }
    //endregion

    //region Iterable tests
    @Test
    fun `given an empty dequeue, when iterated through, number of iterations is zero`() {
        // GIVEN
        val dequeue = Dequeue<Int>()

        // WHEN
        var numberOfIterations = 0
        dequeue.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 0
        assertEquals(expectedIterations, numberOfIterations)
    }

    @Test
    fun `given a dequeue, when iterated through, number of iterations is correct`() {
        // GIVEN
        val dequeue = Dequeue<Int>()
        val range = 1..5
        range.forEach {
            dequeue.enqueueHead(it)
        }

        // WHEN
        var numberOfIterations = 0
        dequeue.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 5
        assertEquals(expectedIterations, numberOfIterations)
    }

    @Test
    fun `given a dequeue, when iterated through twice, number of iterations is correct`() {
        // GIVEN
        val dequeue = Dequeue<Int>()
        val range = 1..5
        range.forEach {
            dequeue.enqueueHead(it)
        }

        // WHEN
        var numberOfIterations = 0
        dequeue.forEach { numberOfIterations++ }
        dequeue.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 10
        assertEquals(expectedIterations, numberOfIterations)
    }

    @Test
    fun `given a dequeue, when iterated through twice and return in the middle, number of iterations is correct`() {
        // GIVEN
        val dequeue = Dequeue<Int>()
        val range = 1..5
        range.forEach {
            dequeue.enqueueHead(it)
        }

        // WHEN
        var numberOfIterations = 0
        dequeue.forEach {
            if (it == 3) return
            numberOfIterations++
        }
        dequeue.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 7
        assertEquals(expectedIterations, numberOfIterations)
    }
    //endregion
}
