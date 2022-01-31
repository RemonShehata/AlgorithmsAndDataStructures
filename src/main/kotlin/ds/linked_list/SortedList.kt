package ds.linked_list


class SortedListNode<T : Comparable<T>>(var value: T) : Comparable<T> {
    var previous: SortedListNode<T>? = null
    var next: SortedListNode<T>? = null

    override fun compareTo(other: T): Int {
        return this.value.compareTo(other)
    }

    fun compareTo(other: SortedListNode<T>): Int {
        return this.value.compareTo(other.value)
    }
}

class SortedList<T : Comparable<T>> : ISortedList<T> {
    var count: Int = 0
        private set

    var head: SortedListNode<T>? = null
        private set

    var tail: SortedListNode<T>? = null
        private set

    /**
     * if empty add head
     * if head add head
     * if tail add tail
     * else find insertion point
     */
    override fun add(node: SortedListNode<T>) {
        when {
            count == 0 -> addHead(node)
            head!!.compareTo(node) >= 0 -> addHead(node)
            tail!!.compareTo(node) < 0 -> addTail(node)
            else -> {
                // find insertion point
                var insertBefore = head
                while (insertBefore!!.compareTo(node) < 0) {
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

        if (count == 0) tail = head
        else temp!!.previous = head
        count++
    }

    private fun addTail(value: T) {
        val node = SortedListNode<T>(value)
        addTail(node)
    }

    private fun addTail(node: SortedListNode<T>) {
        if (count == 0) {
            head = node
            tail = node // can be removed
        } else {
            tail!!.next = node
            node.previous = tail
        }

        tail = node
        count++
    }
}