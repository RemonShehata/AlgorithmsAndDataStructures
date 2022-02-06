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
        assertThrows<IllegalStateException> { dequeue.dequeueHead()}
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
}