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

    //region get tests
    @Test
    fun `given an empty hashtable, when get is called with any value, return null`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()

        // WHEN
        val result = hashTableArray.get(1)

        // THEN
        assertNull(result)
    }

    @Test
    fun `given a hashtable, when get is called with non-existent value, return null`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..10
        range.forEach {
            hashTableArray[it] = it.toString()
        }

        // WHEN
        val result = hashTableArray.get(12)

        // THEN
        assertNull(result)
    }

    @Test
    fun `given a hashtable, when get is called with existent value, return the value`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..10
        range.forEach {
            hashTableArray[it] = it.toString()
        }

        // WHEN
        val result = hashTableArray.get(9)

        // THEN
        val expectedValue = "9"
        assertNotNull(result)
        assertEquals(expectedValue, result)
    }
    //endregion

    //region remove tests
    @Test
    fun `given empty hashtable, when remove is called with any value, return false`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()

        // WHEN
        val result = hashTableArray.remove(5)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given hashtable, when remove is called with non-existent value, return false`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..10
        range.forEach {
            hashTableArray[it] = it.toString()
        }

        // WHEN
        val result = hashTableArray.remove(12)

        // THEN
        assertFalse(result)
        assertNull(hashTableArray.getValue(12))
    }

    @Test
    fun `given hashtable, when remove is called with existent value, value is removed return true`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..10
        range.forEach {
            hashTableArray[it] = it.toString()
        }

        // WHEN
        val result = hashTableArray.remove(9)

        // THEN
        assertTrue(result)
        assertNull(hashTableArray.getValue(9))
    }
    //endregion

    //region contains tests
    @Test
    fun `given an empty hashtable, when contains is called with any value, return false`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()

        // WHEN
        val entry = HashTableEntry(1, "1")
        val result = hashTableArray.contains(entry)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given a hashtable, when contains is called with non-existent value, return false`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..10
        range.forEach {
            hashTableArray[it] = it.toString()
        }

        // WHEN
        val entry = HashTableEntry(11, "11")
        val result = hashTableArray.contains(entry)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given a hashtable, when contains is called with correct key and wrong value, return false`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..10
        range.forEach {
            hashTableArray[it] = it.toString()
        }

        // WHEN
        val entry = HashTableEntry(1, "11")
        val result = hashTableArray.contains(entry)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given a hashtable, when contains is called with correct value and wrong key, return false`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..10
        range.forEach {
            hashTableArray[it] = it.toString()
        }

        // WHEN
        val entry = HashTableEntry(15, "1")
        val result = hashTableArray.contains(entry)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given a hashtable, when contains is called with existent value, return the true`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..10
        range.forEach {
            hashTableArray[it] = it.toString()
        }

        // WHEN
        val result = hashTableArray.get(9)

        // THEN
        val expectedValue = "9"
        assertNotNull(result)
        assertEquals(expectedValue, result)
    }
    //endregion

    //region containsKey tests
    @Test
    fun `given empty hashtable, when containsKey is called with any value, return false`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()

        // WHEN
        val result = hashTableArray.containsKey(5)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given hashtable, when containsKey is called with non-existent value, return false`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..10
        range.forEach {
            hashTableArray[it] = it.toString()
        }

        // WHEN
        val result = hashTableArray.containsKey(12)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given hashtable, when containsKey is called with existent value, return true`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..10
        range.forEach {
            hashTableArray[it] = it.toString()
        }

        // WHEN
        val result = hashTableArray.containsKey(9)

        // THEN
        assertTrue(result)
    }
    //endregion

    //region containsValue tests
    @Test
    fun `given empty hashtable, when containsValue is called with any value, return false`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()

        // WHEN
        val result = hashTableArray.containsValue("5")

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given hashtable, when containsValue is called with non-existent value, return false`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..10
        range.forEach {
            hashTableArray[it] = it.toString()
        }

        // WHEN
        val result = hashTableArray.containsValue("12")

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given hashtable, when containsValue is called with existent value, return true`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..10
        range.forEach {
            hashTableArray[it] = it.toString()
        }

        // WHEN
        val result = hashTableArray.containsValue("9")

        // THEN
        assertTrue(result)
    }
    //endregion

}