package ds.queue

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

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
}