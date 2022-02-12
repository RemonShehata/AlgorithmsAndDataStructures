package ds.hashtable

/**
 * represents a single value that can be used in [IHashTable].
 */
data class HashTableEntry<K, V>(val key: K, val value: V)

// TODO: implement iterator
interface IHashTable<K, V> {

    /**
     * Maps the specified key to the specified value in this hashtable.
     */
    fun put(key: K, value: V)

    /**
     * adds the [entry] to this hashtable.
     */
    fun put(entry: HashTableEntry<K, V>)

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    fun getValue(key: K): V?

    /**
     * Removes the value of the first key in the hashtable
     * @return <code>true</code> if successful or <code>false</code> if the key didn't exist.
     */
    fun remove(key: K): Boolean

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    operator fun get(key: K): V?

    /**
     * Maps the specified key to the specified value in this hashtable.
     */
    operator fun set(key: K, value: V)

    /**
     * Returns true if this hashtable maps one or more keys to this value.
     */
    fun contains(entry: HashTableEntry<K, V>): Boolean

    /**
     * Tests if the specified object is a key in this hashtable.
     */
    fun containsKey(key: K): Boolean

    /**
     * Returns true if this hashtable maps one or more keys to this value.
     */
    fun containsValue(value: V): Boolean

    //TODO: add a collection/ list / map
    //fun putAll()

    /**
     * Adds [entry] if and only if the entry didn't exist.
     * @return <code>true</code> if successful or <code>false</code> if the value existed.
     */
    fun addIfAbsent(entry: HashTableEntry<K, V>): Boolean

    /**
     * Tests if this hashtable maps no keys to values.
     */
    fun isEmpty(): Boolean

    /**
     * Clears this hashtable so that it contains no keys.
     */
    fun clear()
}
