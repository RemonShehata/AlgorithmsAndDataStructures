package ds.hashtable

class HashTableArray<K, V> : IHashTable<K, V> {

    private val arraySize = 16
    private val entries: Array<HashTableEntry<K, V>?> = arrayOfNulls(arraySize)
    var count = 0
        private set

    private fun calculateHashCode(key: K): Int {
        return key.hashCode() % arraySize
    }

    /**
     * Maps the specified key to the specified value in this hashtable.
     */
    override fun put(key: K, value: V) {
        val entry = HashTableEntry(key, value)
        put(entry)
    }

    /**
     * adds the [entry] to this hashtable.
     */
    override fun put(entry: HashTableEntry<K, V>) {
        val index = calculateHashCode(entry.key)
        entries[index] = entry
        count++
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    override fun getValue(key: K): V? {
        val index = calculateHashCode(key)
        return entries[index]?.value
    }

    /**
     * Removes the value of the first key in the hashtable
     * @return <code>true</code> if successful or <code>false</code> if the key didn't exist.
     */
    override fun remove(key: K): Boolean {
        val index = calculateHashCode(key)

        entries[index]?.let {
            entries[index] = null
            count--
            return true
        } ?: run {
            return false
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    override fun get(key: K): V? {
        return getValue(key)
    }

    /**
     * Maps the specified key to the specified value in this hashtable.
     */
    override fun set(key: K, value: V) {
        put(key, value)
    }

    /**
     * Returns true if this hashtable maps one or more keys to this value.
     */
    override fun contains(entry: HashTableEntry<K, V>): Boolean {
        return entries.contains(entry)
    }

    /**
     * Tests if the specified object is a key in this hashtable.
     */
    override fun containsKey(key: K): Boolean {
        entries.forEach { entry ->
            if (entry != null) {
                if (entry.key == key) return true
            }
        }

        return false
    }

    /**
     * Returns true if this hashtable maps one or more keys to this value.
     */
    override fun containsValue(value: V): Boolean {
        entries.forEach { entry ->
            if (entry != null) {
                if (entry.value == value) return true
            }
        }

        return false
    }

    /**
     * Adds [entry] if and only if the entry didn't exist.
     * @return <code>true</code> if successful or <code>false</code> if the value existed.
     */
    override fun addIfAbsent(entry: HashTableEntry<K, V>): Boolean {
        return if (entries.contains(entry)) false
        else {
            put(entry)
            true
        }
    }

    /**
     * Tests if this hashtable maps no keys to values.
     */
    override fun isEmpty(): Boolean = count == 0

    /**
     * Clears this hashtable so that it contains no keys.
     */
    override fun clear() {
        for (i in entries.indices)
            entries[i] = null

        count = 0
    }

}
