package ds.hashtable

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class HashTableTest {

    //region put and set tests
    @Test
    fun `given empty hashtable, when put is called and not at maximum capacity, value is added to the same array`() {
        // GIVEN
        val hashTable = HashTable<Int, String>(2)

        // WHEN
        hashTable.put(1, "1")

        //THEN
        val expectedCount = 1
        val expectedValue = "1"
        assertEquals(expectedCount, hashTable.count)
        assertFalse(hashTable.isEmpty())
        assertEquals(expectedValue, hashTable.getValue(1))
    }

    @Test
    fun `given a hashtable, when put is called and is at maximum capacity, value is added to a new array`() {
        // GIVEN
        val hashTable = HashTable<Int, String>(5)
        val range = 1..4
        range.forEach {
            hashTable.put(it, it.toString())
        }

        // WHEN
        hashTable[5] = "5"

        //THEN
        val expectedCount = 5
        val expectedValue = "5"
        assertEquals(expectedCount, hashTable.count)
        assertFalse(hashTable.isEmpty())
        range.forEach {
            assertEquals(it.toString(), hashTable.getValue(it))
        }
        assertEquals(expectedValue, hashTable.getValue(5))
    }

    @Test
    fun `given a hashtable, when put is called and there is a conflict, value is added to the same index`() {
        // GIVEN
        // Aa and BB has the same hash value
        // https://stackoverflow.com/questions/12925988/how-to-generate-strings-that-share-the-same-hashcode-in-java
        val hashTable = HashTable<String, Int>(null)
        hashTable.put("Aa", 1)


        // WHEN
        hashTable.put("BB", 2)

        //THEN
        val expectedCount = 2
        val expectedValue = 2
        assertEquals(expectedCount, hashTable.count)
        assertFalse(hashTable.isEmpty())
        assertEquals(expectedValue, hashTable.getValue("BB"))
    }

    @Test
    fun `given a hashtable, when put is called with existing key, value is updated`() {
        // GIVEN
        val hashTable = HashTable<Int, String>(null)
        hashTable.put(1, "1")


        // WHEN
        hashTable.put(1, "2")

        //THEN
        val expectedCount = 2
        val expectedValue = "2"
        assertEquals(expectedCount, hashTable.count)
        assertFalse(hashTable.isEmpty())
        assertEquals(expectedValue, hashTable.getValue(1))
    }
    //endregion

    //region get tests
    @Test
    fun `given empty hash table, when get is called with any key, return null`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)

        // WHEN
        val result = hashTable[1]
        val result2 = hashTable.getValue(1)

        // THEN
        assertNull(result)
        assertNull(result2)
    }

    @Test
    fun `given a hash table, when get is called with non-existent key, return null`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)
        hashTable[2] = 2

        // WHEN
        val result = hashTable[1]
        val result2 = hashTable.getValue(1)

        // THEN
        assertNull(result)
        assertNull(result2)
    }

    @Test
    fun `given a hash table, when get is called with existent key, return the value`() {
        // GIVEN
        val hashTable = HashTable<Int, String>(null)
        hashTable[2] = "2"
        hashTable[3] = "3"

        // WHEN
        val result = hashTable[2]
        val result2 = hashTable.getValue(2)

        // THEN
        assertEquals(result, "2")
        assertEquals(result2, "2")
    }
    //endregion

    // region contains tests
    @Test
    fun `given empty hash table, when contains is called with any hashtable entry, return false`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)

        // WHEN
        val result = hashTable.contains(HashTableEntry(1, 2))

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given hash table, when contains is called with non-existent hashtable entry, return false`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)
        hashTable.put(3, 4)

        // WHEN
        val result = hashTable.contains(HashTableEntry(1, 2))

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given hash table, when contains is called with right key and wrong value, return false`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)
        hashTable.put(1, 4)

        // WHEN
        val result = hashTable.contains(HashTableEntry(1, 2))

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given hash table, when contains is called with right value and wrong key, return false`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)
        hashTable.put(4, 2)

        // WHEN
        val result = hashTable.contains(HashTableEntry(1, 2))

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given hash table, when contains is called with existent hashtable entry, return true`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)
        hashTable.put(1, 2)

        // WHEN
        val result = hashTable.contains(HashTableEntry(1, 2))

        // THEN
        assertTrue(result)
    }

    @Test
    fun `given hash table, when contains is called with existent hashtable entry with the same index, return true`() {
        // Aa and BB has the same hash value
        // https://stackoverflow.com/questions/12925988/how-to-generate-strings-that-share-the-same-hashcode-in-java
        val hashTable = HashTable<String, Int>(null)
        hashTable.put("Aa", 1)
        hashTable.put("BB", 2)


        // WHEN

        val result = hashTable.contains(HashTableEntry("Aa", 1))
        val result2 = hashTable.contains(HashTableEntry("BB", 2))

        // THEN
        assertTrue(result)
        assertTrue(result2)
    }


    //endregion

    // region addIfAbsent tests
    @Test
    fun `given empty hash table, when addIfAbsent is called with any hashtable entry, return true`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)

        // WHEN
        val result = hashTable.addIfAbsent(HashTableEntry(1, 2))

        // THEN
        assertTrue(result)
        val expectedCount = 1
        assertEquals(expectedCount, hashTable.count)
    }

    @Test
    fun `given hash table, when addIfAbsent is called with non-existent hashtable entry, return true`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)
        hashTable.put(3, 4)

        // WHEN
        val result = hashTable.addIfAbsent(HashTableEntry(1, 2))

        // THEN
        assertTrue(result)
        val expectedCount = 2
        assertEquals(expectedCount, hashTable.count)
    }

    @Test
    fun `given hash table, when addIfAbsent is called with existing key and non-existing value, return true`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)
        hashTable.put(1, 4)

        // WHEN
        val result = hashTable.addIfAbsent(HashTableEntry(1, 2))

        // THEN
        assertTrue(result)
        // make sure new value is replaced for the same key
        assertEquals(2, hashTable[1])
        val expectedCount = 2
        assertEquals(expectedCount, hashTable.count)
    }

    @Test
    fun `given hash table, when addIfAbsent is called with existing value and non-existing key, return true`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)
        hashTable.put(4, 2)

        // WHEN
        val result = hashTable.addIfAbsent(HashTableEntry(1, 2))

        // THEN
        val expectedCount = 2
        assertTrue(result)
        assertEquals(expectedCount, hashTable.count)
    }

    @Test
    fun `given hash table, when addIfAbsent is called with existent hashtable entry, return false`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)
        hashTable.put(1, 2)

        // WHEN
        val result = hashTable.addIfAbsent(HashTableEntry(1, 2))

        // THEN
        assertFalse(result)
        val expectedCount = 1
        assertEquals(expectedCount, hashTable.count)
    }

    @Test
    fun `given hash table, when addIfAbsent is called with existent hashtable entry with the same index, return false`() {
        // Aa and BB has the same hash value
        // https://stackoverflow.com/questions/12925988/how-to-generate-strings-that-share-the-same-hashcode-in-java
        val hashTable = HashTable<String, Int>(null)
        hashTable.put("Aa", 1)
        hashTable.put("BB", 2)


        // WHEN

        val result = hashTable.addIfAbsent(HashTableEntry("Aa", 1))
        val result2 = hashTable.addIfAbsent(HashTableEntry("BB", 2))

        // THEN
        assertFalse(result)
        assertFalse(result2)
        val expectedCount = 2
        assertEquals(expectedCount, hashTable.count)
    }
    //endregion

    // region containsKey tests
    @Test
    fun `given empty hash table, when containsKey is called with any key, return false`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)

        // WHEN
        val result = hashTable.containsKey(1)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given hash table, when containsKey is called with non-existent key, return false`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)
        hashTable.put(3, 4)

        // WHEN
        val result = hashTable.containsKey(1)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given hash table, when containsKey is called with existent key, return true`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)
        hashTable.put(1, 2)

        // WHEN
        val result = hashTable.containsKey(1)

        // THEN
        assertTrue(result)
    }

    @Test
    fun `given hash table, when containsKey is called with existent key with the same index, return true`() {
        // Aa and BB has the same hash value
        // https://stackoverflow.com/questions/12925988/how-to-generate-strings-that-share-the-same-hashcode-in-java
        val hashTable = HashTable<String, Int>(null)
        hashTable.put("Aa", 1)
        hashTable.put("BB", 2)


        // WHEN

        val result = hashTable.containsKey("Aa")
        val result2 = hashTable.containsKey("BB")

        // THEN
        assertTrue(result)
        assertTrue(result2)
    }
    //endregion

    // region containsValue tests
    @Test
    fun `given empty hash table, when containsValue is called with any value, return false`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)

        // WHEN
        val result = hashTable.containsValue(1)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given hash table, when containsValue is called with non-existent value, return false`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)
        hashTable.put(3, 4)

        // WHEN
        val result = hashTable.containsValue(1)

        // THEN
        assertFalse(result)
    }

    @Test
    fun `given hash table, when containsValue is called with existent value, return true`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)
        hashTable.put(1, 2)

        // WHEN
        val result = hashTable.containsValue(2)

        // THEN
        assertTrue(result)
    }

    @Test
    fun `given hash table, when containsValue is called with existent key with the same index, return true`() {
        // Aa and BB has the same hash value
        // https://stackoverflow.com/questions/12925988/how-to-generate-strings-that-share-the-same-hashcode-in-java
        val hashTable = HashTable<String, Int>(null)
        hashTable.put("Aa", 1)
        hashTable.put("BB", 2)


        // WHEN

        val result = hashTable.containsValue(1)
        val result2 = hashTable.containsValue(2)

        // THEN
        assertTrue(result)
        assertTrue(result2)
    }
    //endregion

    //region remove tests
    @Test
    fun `given an empty hashtable, when remove is called with any key, return false`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)

        // WHEN
        val result = hashTable.remove(1)

        // THEN
        assertFalse(result)
        val expectedCount = 0
        assertEquals(expectedCount, hashTable.count)
    }

    @Test
    fun `given a hashtable, when remove is called with non-existing key, return false`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)
        hashTable.put(2, 3)

        // WHEN
        val result = hashTable.remove(1)

        // THEN
        assertFalse(result)
        val expectedCount = 1
        assertEquals(expectedCount, hashTable.count)
    }

    @Test
    fun `given a hashtable, when remove is called with existing key, return true`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)
        hashTable.put(2, 3)

        // WHEN
        val result = hashTable.remove(2)

        // THEN
        assertTrue(result)
        val expectedCount = 0
        assertEquals(expectedCount, hashTable.count)
    }

    @Test
    fun `given hash table, when remove is called with existent key with the same index, return true`() {
        // Aa and BB has the same hash value
        // https://stackoverflow.com/questions/12925988/how-to-generate-strings-that-share-the-same-hashcode-in-java
        val hashTable = HashTable<String, Int>(null)
        hashTable.put("Aa", 1)
        hashTable.put("BB", 2)


        // WHEN
        val result = hashTable.remove("Aa")
        val result2 = hashTable.remove("BB")

        // THEN
        assertTrue(result)
        assertTrue(result2)
        val expectedCount = 0
        assertEquals(expectedCount, hashTable.count)
    }
    //endregion

    //region clear and isEmpty tests
    @Test
    fun `given an empty hashtable, when clear is called, reset everything`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)

        // WHEN
        hashTable.clear()
        var numberOfIteration = 0

        // THEN
        val expectedCount = 0
        assertEquals(expectedCount, hashTable.count)
        hashTable.forEach { numberOfIteration++ }
        assertEquals(numberOfIteration, hashTable.count)
        assertTrue(hashTable.isEmpty())
    }

    @Test
    fun `given a hashtable, when clear is called, reset everything`() {
        // GIVEN
        val hashTable = HashTable<Int, Int>(null)
        hashTable.put(2, 3)

        // WHEN
        hashTable.clear()
        var numberOfIteration = 0

        // THEN
        val expectedCount = 0
        assertEquals(expectedCount, hashTable.count)
        hashTable.forEach { numberOfIteration++ }
        assertEquals(numberOfIteration, hashTable.count)
        assertTrue(hashTable.isEmpty())
    }

    @Test
    fun `given hash table with collision, when clear is called, reset everything`() {
        // Aa and BB has the same hash value
        // https://stackoverflow.com/questions/12925988/how-to-generate-strings-that-share-the-same-hashcode-in-java
        val hashTable = HashTable<String, Int>(null)
        hashTable.put("Aa", 1)
        hashTable.put("BB", 2)


        // WHEN
        hashTable.clear()
        var numberOfIteration = 0

        // THEN
        val expectedCount = 0
        assertEquals(expectedCount, hashTable.count)
        hashTable.forEach { numberOfIteration++ }
        assertEquals(numberOfIteration, hashTable.count)
        assertTrue(hashTable.isEmpty())
    }
    //endregion

    //region Iterable tests
    @Test
    fun `given an empty hashtable, when iterated through, number of iterations is zero`() {
        // GIVEN
        val hashTableArray = HashTable<Int, Int>(null)

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
        val hashTableArray = HashTable<Int, String>(null)
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
        val hashTableArray = HashTable<Int, String>(null)
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
        val hashTableArray = HashTable<Int, String>(null)
        val range = 1..5
        range.forEach {
            hashTableArray.put(it, it.toString())
        }

        // WHEN
        var numberOfIterations = 0
        hashTableArray.forEach {
            if (it.key == 3) return
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
        val hashTable = HashTable<String, Int>(null)
        hashTable.put("Aa", 1)
        hashTable.put("BB", 2)


        // WHEN
        var numberOfIterations = 0
        hashTable.forEach {
            numberOfIterations++
        }

        // THEN
        val expectedIterations = 2
        assertEquals(expectedIterations, numberOfIterations)
    }
    //endregion
}