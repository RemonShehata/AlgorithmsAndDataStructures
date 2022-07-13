package ds.linked_list

// TODO: we don't have to implement comparable? T already implements it.
class SortedListNode<T : Comparable<T>>(var value: T) : Comparable<T> {
    var previous: SortedListNode<T>? = null
    var next: SortedListNode<T>? = null

    /**
     * 0 -> this = other
     * - -> this < other
     * + -> this > other
     */
    override fun compareTo(other: T): Int {
        return this.value.compareTo(other)
    }

    fun compareTo(other: SortedListNode<T>): Int {
        return this.value.compareTo(other.value)
    }
}

// TODO: optimize contains & find & indexOf to work like binary search.
class SortedList<T : Comparable<T>> : ISortedList<T> {
    var count: Int = 0
        private set

    var head: SortedListNode<T>? = null
        private set

    var tail: SortedListNode<T>? = null
        private set

    /**
     * adds [SortedListNode] in sort order in [ISortedList].
     */
    override fun add(node: SortedListNode<T>) {
        /**
         * if empty add head
         * if head is greater than node, add to head
         * if node is greater than tail, add to tail
         * else find insertion point;
         * we find the first element bigger than our node value
         * insert our node before it
         */
        when {
            // list is empty or head is greater than node
            count == 0 ||  head!!.compareTo(node) >= 0 -> addHead(node)
            tail!!.compareTo(node) < 0 -> addTail(node) // node is greater than tail
            else -> {
                // find insertion point
                var insertBefore = head!! // at this point head can't be null
                while (insertBefore.compareTo(node) < 0) { // insertBefore > other
                    insertBefore = insertBefore.next!!
                }

                node.next = insertBefore
                node.previous = insertBefore.previous
                insertBefore.previous!!.next = node
                insertBefore.previous = node
                count++
            }
        }
    }

    /**
     * adds [value] in sort order in [ISortedList].
     */
    override fun add(value: T) {
        val node = SortedListNode(value)
        add(node)
    }

    private fun addHead(value: T) {
        val node = SortedListNode<T>(value)
        addHead(node)
    }

    private fun addHead(node: SortedListNode<T>) {
        val temp = head
        head = node
        head!!.next = temp

//        if (count == 0) tail = head
//        else temp!!.previous = head

        temp?.let { it.previous = head } ?: kotlin.run { tail = head }
        count++
    }

    private fun addTail(value: T) {
        val node = SortedListNode<T>(value)
        addTail(node)
    }

    private fun addTail(node: SortedListNode<T>) {
        // if list is empty we add to head
        tail!!.next = node
        node.previous = tail

        tail = node
        count++
    }

    /**
     * removes the first node that contains [value].
     * @param [value] the value to be removed.
     * @return true if the value was removed.
     * @return false if the value did not exist.
     */
    override fun remove(value: T): Boolean {
        val node = SortedListNode<T>(value)
        return remove(node)
    }

    /**
     * removes the first node that contains value equal to [node].
     * @param [node] the node to be removed.
     * @return true if the value was removed.
     * @return false if the value did not exist.
     */
    override fun remove(node: SortedListNode<T>): Boolean {
//        if (!contains(node)) return false // this adds time complexity
        if (count == 0) return false
        else if (head!!.compareTo(node) == 0) {
            removeHead()
            return true
        } else if (tail!!.compareTo(node) == 0) {
            removeTail()
            return true
        }

        var current = head
        while (current!!.next != null) {
            if (current.next!!.compareTo(node) == 0) {
                current.next!!.next!!.previous = current
                current.next = current.next!!.next
                count--
                return true
            }
            current = current.next
        }
        return false

//        val middle: Int = (count / 2) - 1
//        // skip head
//        var current = head!!.next
//        for (i in 1 until middle){
//            current = current!!.next
//        }
    }

    /**
     * removes the first node in the [ISortedList].
     * @return true if the value was removed.
     * @return false if the value did not exist.
     */
    private fun removeHead(): Boolean {
        head = head!!.next
        count--
        if (count == 0) {
            tail = null
        } else {
            head!!.previous = null
        }
        return true
    }

    /**
     * removes the last node in the [ISortedList].
     * @return true if the value was removed.
     * @return false if the value did not exist.
     */
    private fun removeTail(): Boolean {
        tail = tail!!.previous
        count--

        if (count == 0) {
            head = null
        } else {
            tail!!.next = null
        }

        return true
    }

    /**
     * check the [ISortedList] contains a specific value.
     * @return true if the value exist.
     * @return false if the value doesn't exist.
     */
    override fun contains(value: T): Boolean {
        if (count == 0) return false

        var current = head
        while (current != null) {
            if (current.value == value) return true
            current = current.next
        }
        return false
    }

    /**
     * check the [ISortedList] contains a specific node with value equal to [node]'s value.
     * @return true if the value exist.
     * @return false if the value doesn't exist.
     */
    override fun contains(node: SortedListNode<T>): Boolean {
        return contains(node.value)
    }

    /**
     * finds [value] in the [ISortedList].
     * @return the first [SortedListNode] if it existed.
     * @return null if it doesn't exist.
     */
    override fun find(value: T): SortedListNode<T>? {
        if (count == 0) return null

        var current = head
        while (current != null) {
            if (current.value == value) return current
            current = current.next
        }

        return null
    }

    /**
     * finds the value of [node] in the [ISortedList].
     * @return the first [SortedListNode] if it existed.
     * @return null if it doesn't exist.
     */
    override fun find(node: SortedListNode<T>): SortedListNode<T>? {
        return find(node.value)
    }

    /**
     * Returns the index of the first occurrence of the specified element in the list,
     * or -1 if the specified element is not contained in the [ISortedList].
     * note that we are a zero index based list.
     */
    override fun indexOf(value: T): Int {
        if (count == 0) return -1

        var current = head
        var index = 0
        while (current != null) {
            if (current.value == value) return index
            current = current.next
            index++
        }
        return -1
    }

    /**
     * Returns the index of the first occurrence of the specified element in the list,
     * or -1 if the specified element is not contained in the [ISortedList].
     * note that we are a zero index based list.
     */
    override fun indexOf(node: SortedListNode<T>): Int {
        return indexOf(node.value)
    }

    /**
     * reset everything.
     */
    override fun clear() {
        head = null
        tail = null
        count = 0
    }

    override fun iterator() = object : Iterator<T> {
        private var cursor: SortedListNode<T>? = head

        override fun hasNext() = cursor != null

        override fun next() = (cursor?.value ?: throw NoSuchElementException()).also {
            cursor = cursor?.next
        }
    }
}