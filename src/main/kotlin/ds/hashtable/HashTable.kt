package ds.hashtable

import ds.linked_list.SinglyLinkedList
import java.util.logging.Level
import java.util.logging.Logger

class HashTable<K, V>(initialCapacity: Int?) : IHashTable<K, V> {
    companion object {
        private const val defaultCapacity = 16
        private const val fillFactor: Double = 0.80
        private const val growthFactor: Double = 1.50
    }

    private var arraySize: Int = initialCapacity ?: defaultCapacity
    private var entries: Array<SinglyLinkedList<HashTableEntry<K, V>?>?> =
        arrayOfNulls(arraySize)

    var count = 0
        private set

    private fun calculateHashCode(key: K): Int {
        return key.hashCode() % arraySize
    }

    override fun put(key: K, value: V) {
        val entry = HashTableEntry(key, value)
        put(entry)
    }

    override fun put(entry: HashTableEntry<K, V>) {
        if (atMaximumCapacity) {
            allocateLargerArray()
        }

        add(entry)
    }

    private fun add(entry: HashTableEntry<K, V>) {
        val index = calculateHashCode(entry.key)

        entries[index]?.let {
            // not null means we already have a linked list here
            if (it keyExist entry.key) {
                // replace the value
                // TODO: MAKE THIS ONE LINER?
                val successfulRemoval = it.remove(entry)
                if (!successfulRemoval)
                    DsLogger.loge(message = "failed to remove entry from linked list")
            }
            it.addHead(entry)
        } ?: run {
            // null means we don't have a linked list yet
            // Thus, we are sure that the key doesn't exist
            val singlyLinkedList = SinglyLinkedList<HashTableEntry<K, V>?>()
            singlyLinkedList.addHead(entry)
            entries[index] = singlyLinkedList
        }
        count++

//        if (!keyExist(entries[index], entry.key)) {
//            val singlyLinkedList = SinglyLinkedList<HashTableEntry<K, V>?>()
//            singlyLinkedList.addHead(entry)
//            entries[index] = singlyLinkedList
//            entries[index]?.let {
//                it.addHead(entry)
//                count++
//            } ?: kotlin.run { Logger.getAnonymousLogger().log(Level.SEVERE, "linked list is null") }
//        } else {
//            entries[index]?.let {
//                val index2 = it.indexOf(entry)
//                it.removeAtIndex(index2)
//                it.addHead(entry)
//            }
//        }
    }

    private fun put(key: K, value: V, localEntries: Array<SinglyLinkedList<HashTableEntry<K, V>>>) {
//        val index = calculateHashCode(key)
//        val listAtArraySlot = localEntries[index]
//
//        val newEntry = HashTableEntry(key, value)
//
//        // Check if the key already exists in the LinkedList entries
//        val indexOfEntryInList = listAtArraySlot.contains(newEntry)
//        if (indexOfEntryInList >= 0) {
//            listAtArraySlot[indexOfEntryInList] = newEntry
//        } else {
//            listAtArraySlot.offer(newEntry)
//        }
    }

    private val atMaximumCapacity: Boolean
        get() = count >= arraySize * fillFactor
    private val largerArraySize: Int
        get() = (arraySize * growthFactor).toInt()

    private fun allocateLargerArray() {
        val temp = entries
        val largerArray: Array<SinglyLinkedList<HashTableEntry<K, V>?>?> = arrayOfNulls(largerArraySize)
        entries = largerArray

        temp.forEach { singleListItem ->
            singleListItem?.forEach { entry ->
                if (entry != null) {
                    add(entry)
                }
            }
        }

        arraySize = largerArraySize
    }


    override fun get(key: K): V? {
        return getValue(key)
    }

    override fun set(key: K, value: V) {
        put(key, value)
    }

    override fun getValue(key: K): V? {
        val index = calculateHashCode(key)
        return entries[index]?.head?.value?.value
    }

    override fun addIfAbsent(entry: HashTableEntry<K, V>): Boolean {
//        if (entries.contains(entry)) put(entry)
        return true
    }

    override fun contains(entry: HashTableEntry<K, V>): Boolean {
//        return entries.contains(entry)
        return true
    }

    override fun containsKey(key: K): Boolean {
        entries.forEach { entry ->
            if (entry != null) {
//                if (entry.key == key) return true
            }
        }

        return false
    }

    override fun containsValue(value: V): Boolean {
        entries.forEach { entry ->
            if (entry != null) {
//                if (entry.value == value) return true
            }
        }

        return false
    }

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

    override fun clear() {
        for (i in 0..entries.size)
            entries[i] = null

        count = 0
    }

    override fun isEmpty(): Boolean = count == 0
}

//fun <K, V> keyExist(linkedList: SinglyLinkedList<HashTableEntry<K, V>?>?, key: K): Boolean {
//    if (linkedList == null || linkedList.count == 0) return false
//    var current = linkedList.head
//    while (current != null) {
//        if (current.value?.key == key) return true
//        current = current.next
//    }
//    return false
//}

infix fun <K, V> SinglyLinkedList<HashTableEntry<K, V>?>.keyExist(key: K): Boolean {
    if (this.count == 0) return false

    var current = this.head
    while (current != null) {
        if (current.value?.key == key) return true
        current = current.next
    }
    return false
}

infix fun <K, V> SinglyLinkedList<HashTableEntry<K, V>?>.getValueForKey(key: K): V? {
    if (this.count == 0) return null
    var current = this.head
    while (current != null) {
        if (current.value?.key == key) return current.value?.value
        current = current.next
    }
    return null
}


object DsLogger {
    fun loge(tag: String = "Remon", message: String) {
        Logger.getAnonymousLogger().log(Level.SEVERE, "linked list is null")
    }
}
