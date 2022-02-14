package ds.hashtable

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class HashTableArrayTest {

    //region count tests
    @Test
    fun `given empty hashtable, count is 0`() {
        val hashTableArray = HashTableArray<Int, Int>()

        assertEquals(0, hashTableArray.count)
        assertTrue(hashTableArray.isEmpty())
    }
    //endregion

    //region put tests
    @Test
    fun `given empty hashtable, when put is called with list of integers, values are added and count is updated`() {

        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..16

        // WHEN
        range.forEach {
            hashTableArray.put(it, it.toString())
        }

        // THEN
        val expectedCount = 16
        assertEquals(expectedCount, hashTableArray.count)
        range.forEach {
            val result = hashTableArray.getValue(it)
            assertEquals(result, it.toString())
        }
    }

    @Test
    fun `given empty hashtable, when set is called with list of integers, values are added and count is updated`() {

        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..16

        // WHEN
        range.forEach {
            hashTableArray[it] = it.toString()
        }

        // THEN
        val expectedCount = 16
        assertEquals(expectedCount, hashTableArray.count)
        range.forEach {
            val result = hashTableArray[it]
            assertEquals(result, it.toString())
        }
    }
    //endregion

}