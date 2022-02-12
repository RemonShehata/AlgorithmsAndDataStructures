package ds.hashtable

class HashTableArray<K, V> : IHashTable<K, V> {
    
    /**
     * Maps the specified key to the specified value in this hashtable.
     */
    override fun put(key: K, value: V) {
        TODO("Not yet implemented")
    }

    /**
     * adds the [entry] to this hashtable.
     */
    override fun put(entry: HashTableEntry<K, V>) {
        TODO("Not yet implemented")
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    override fun getValue(key: K): V? {
        TODO("Not yet implemented")
    }

    /**
     * Removes the value of the first key in the hashtable
     * @return <code>true</code> if successful or <code>false</code> if the key didn't exist.
     */
    override fun remove(key: K): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    override fun get(key: K): V? {
        TODO("Not yet implemented")
    }

    /**
     * Maps the specified key to the specified value in this hashtable.
     */
    override fun set(key: K, value: V) {
        TODO("Not yet implemented")
    }

    /**
     * Returns true if this hashtable maps one or more keys to this value.
     */
    override fun contains(entry: HashTableEntry<K, V>): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Tests if the specified object is a key in this hashtable.
     */
    override fun containsKey(key: K): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Returns true if this hashtable maps one or more keys to this value.
     */
    override fun containsValue(value: V): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Adds [entry] if and only if the entry didn't exist.
     * @return <code>true</code> if successful or <code>false</code> if the value existed.
     */
    override fun addIfAbsent(entry: HashTableEntry<K, V>): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Tests if this hashtable maps no keys to values.
     */
    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Clears this hashtable so that it contains no keys.
     */
    override fun clear() {
        TODO("Not yet implemented")
    }

}