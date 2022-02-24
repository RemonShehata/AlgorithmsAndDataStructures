package ds.hashtable

import ds.linked_list.SinglyLinkedList
import ds.linked_list.SinglyLinkedListNode
import java.util.logging.Level
import java.util.logging.Logger

// TODO: add dokka
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
        val temp = entries.copyOf()
        clear()
        val largerArray: Array<SinglyLinkedList<HashTableEntry<K, V>?>?> = arrayOfNulls(largerArraySize)
        entries = largerArray

        temp.forEach { singleListItem ->
            singleListItem?.forEach { entry ->
                entry?.let { add(it) }
            }
        }

        arraySize = largerArraySize
    }


    override operator fun get(key: K): V? {
        return getValue(key)
    }

    override operator fun set(key: K, value: V) {
        put(key, value)
    }

    override fun getValue(key: K): V? {
        val index = calculateHashCode(key)
        entries[index]?.let {
            return it getValueForKey key
        }
        return null
    }

    override fun addIfAbsent(entry: HashTableEntry<K, V>): Boolean {
        return if (this.contains(entry)) false
        else {
            this.put(entry)
            true
        }
    }

    override fun contains(entry: HashTableEntry<K, V>): Boolean {
        entries.forEach { list ->
            list?.let {
                it.forEach { hashTableEntry ->
                    if (entry == hashTableEntry) return true
                }
            }
        }
        return false
    }

    override fun containsKey(key: K): Boolean {
        entries.forEach { list ->
            list?.let {
                if (it keyExist key) return true
            }
        }

        return false
    }

    override fun containsValue(value: V): Boolean {
        entries.forEach { list ->
            list?.let {
                if (it valueExist value) return true
            }
        }
        return false
    }

    override fun remove(key: K): Boolean {
        if (!containsKey(key)) return false
        val index = calculateHashCode(key)

        entries[index]?.let { list ->
            val removalResult = list removeEntryForKey key
            // should we throw exception here?
            if (!removalResult) DsLogger.loge(message = "value wasn't removed from LinkedList")
            // we removed the last item in the list
            if (list.count == 0) entries[index] = null
            count--
            return true
        } ?: run {
            return false
        }
    }

    override fun clear() {
        for (i in entries.indices) {
            entries[i] = null
        }
        count = 0
    }

    override fun isEmpty(): Boolean = count == 0

    override fun iterator() = object : Iterator<HashTableEntry<K, V>> {
        private var arrayIndex = 0
        private var linkedListIndex = 0
        private val nonNullList = entries.filterNotNull()
        private var currentSinglyLinkedListNode: SinglyLinkedListNode<HashTableEntry<K, V>?>? = null

        override fun hasNext(): Boolean {
            if (nonNullList.isEmpty() || arrayIndex !in nonNullList.indices) return false
            return linkedListIndex <= nonNullList[arrayIndex].count
        }

        override fun next(): HashTableEntry<K, V> {
            if (currentSinglyLinkedListNode == null) {
                currentSinglyLinkedListNode = nonNullList[arrayIndex].head
            }

            val temp = currentSinglyLinkedListNode
            currentSinglyLinkedListNode = currentSinglyLinkedListNode!!.next

            if (currentSinglyLinkedListNode == null) {
                // we reached the end of the linkedlist,
                // start from the next element in the array
                arrayIndex++
                linkedListIndex = 0
            } else {
                linkedListIndex++
            }

            return temp!!.value!!
        }
    }
}

infix fun <K, V> SinglyLinkedList<HashTableEntry<K, V>?>.keyExist(key: K): Boolean {
    if (this.count == 0) return false

    var current = this.head
    while (current != null) {
        if (current.value?.key == key) return true
        current = current.next
    }
    return false
}

infix fun <K, V> SinglyLinkedList<HashTableEntry<K, V>?>.valueExist(value: V): Boolean {
    if (this.count == 0) return false

    var current = this.head
    while (current != null) {
        if (current.value?.value == value) return true
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

infix fun <K, V> SinglyLinkedList<HashTableEntry<K, V>?>.removeEntryForKey(key: K): Boolean {
    if (this.count == 0) return false
    var current = this.head
    while (current != null) {
        if (current.value?.key == key) return this.remove(current)
        current = current.next
    }

    return false
}


object DsLogger {
    fun loge(tag: String = "Remon", message: String) {
        Logger.getAnonymousLogger().log(Level.SEVERE, "linked list is null")
    }
}
