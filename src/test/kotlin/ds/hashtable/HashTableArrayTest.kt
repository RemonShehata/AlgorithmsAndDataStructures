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

    //region addIfAbsent tests
    @Test
    fun `given empty hashtable, when addIfAbsent is called with any value, return true`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()

        // WHEN
        val entry = HashTableEntry(1, "1")
        val result = hashTableArray.addIfAbsent(entry)

        // THEN
        assertTrue(result)
    }

    @Test
    fun `given hashtable, when addIfAbsent is called with non-existent value, return true`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..10
        range.forEach {
            hashTableArray[it] = it.toString()
        }

        // WHEN
        val entry = HashTableEntry(12, "12")
        val result = hashTableArray.addIfAbsent(entry)

        // THEN
        assertTrue(result)
    }

    @Test
    fun `given hashtable, when addIfAbsent is called with existent value, return false`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..10
        range.forEach {
            hashTableArray[it] = it.toString()
        }

        // WHEN
        val entry = HashTableEntry(5, "5")
        val result = hashTableArray.addIfAbsent(entry)

        // THEN
        assertFalse(result)
    }
    //endregion

    //region clear tests
    @Test
    fun `given empty clear, when clear is called, the hashtable is empty`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()

        // WHEN
         hashTableArray.clear()

        // THEN
        assertTrue(hashTableArray.isEmpty())
    }

    @Test
    fun `given hashtable, when clear is called, the hashtable is empty`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..10
        range.forEach {
            hashTableArray[it] = it.toString()
        }

        // WHEN
        hashTableArray.clear()

        // THEN
        assertTrue(hashTableArray.isEmpty())
        range.forEach {
            val result = hashTableArray[it]
            assertNull(result)
        }
    }
    //endregion

    //region Iterable tests
    @Test
    fun `given an empty hashtable, when iterated through, number of iterations is zero`() {
        // GIVEN
       val hashTableArray = HashTableArray<Int, Int>()

        // WHEN
        var numberOfIterations = 0
        hashTableArray.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 0
        assertEquals(expectedIterations, numberOfIterations)
    }

    @Test
    fun `given a hashtable, when iterated through, number of iterations is correct`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..5
        range.forEach {
            hashTableArray.put(it, it.toString())
        }

        // WHEN
        var numberOfIterations = 0
        hashTableArray.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 5
        assertEquals(expectedIterations, numberOfIterations)
    }

    @Test
    fun `given a hashTableArray, when iterated through twice, number of iterations is correct`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..5
        range.forEach {
            hashTableArray.put(it, it.toString())
        }

        // WHEN
        var numberOfIterations = 0
        hashTableArray.forEach { numberOfIterations++ }
        hashTableArray.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 10
        assertEquals(expectedIterations, numberOfIterations)
    }

    @Test
    fun `given a list, when iterated through twice and return in the middle, number of iterations is correct`() {
        // GIVEN
        val hashTableArray = HashTableArray<Int, String>()
        val range = 1..5
        range.forEach {
            hashTableArray.put(it, it.toString())
        }

        // WHEN
        var numberOfIterations = 0
        hashTableArray.forEach {
            if (it != null) {
                if (it.key == 3) return
            }
            numberOfIterations++
        }
        hashTableArray.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 7
        assertEquals(expectedIterations, numberOfIterations)
    }

    @Test
    fun `given hash table with collision, when iterated through, number of iterations is correct`() {
        // Aa and BB has the same hash value
        // https://stackoverflow.com/questions/12925988/how-to-generate-strings-that-share-the-same-hashcode-in-java
        val hashTableArray = HashTableArray<String, Int>()
        hashTableArray.put("Aa", 1)
        hashTableArray.put("BB", 2)


        // WHEN
        var numberOfIterations = 0
        hashTableArray.forEach {
            numberOfIterations++
        }

        // THEN
        val expectedIterations = 1
        assertEquals(expectedIterations, numberOfIterations)
    }
    //endregion
}
