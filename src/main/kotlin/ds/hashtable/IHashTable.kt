package ds.hashtable

data class HashTableEntry<K, V>(val key: K, val value: V)

// TODO: implement iterator
interface IHashTable<K, V> {
    fun put(key: K, value: V)
    fun put(entry: HashTableEntry<K, V>)
    fun getValue(key: K): V?
    fun remove(key: K)

    operator fun get(key: K): V?
    operator fun set(key: K, value: V)

    fun contains(entry: HashTableEntry<K, V>): Boolean
    fun containsKey(key: K): Boolean
    fun containsValue(value: V): Boolean

    //TODO: add a collection/ list / map
    //fun putAll()
    fun addIfAbsent(entry: HashTableEntry<K, V>)

    fun isEmpty(): Boolean
    fun clear()
}
