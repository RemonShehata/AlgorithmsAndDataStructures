package ds.linked_list

// TODO: make optimization for addAtIndex / removeAtIndex
// see if the index is closer to the head or tail and start from there.
class DoublyLinkedListNode<T>(var value: T) {
    var previous: DoublyLinkedListNode<T>? = null
    var next: DoublyLinkedListNode<T>? = null
}

class DoublyLinkedList<T> : IDoublyLinkedList<T> {
    var tail: DoublyLinkedListNode<T>? = null
        private set

    var head: DoublyLinkedListNode<T>? = null
        private set(value) {
            cursor = value
            field = value
        }

    var count: Int = 0
        private set

    // This is needed for iterator functionality.
    private var cursor: DoublyLinkedListNode<T>? = null

    /**
     * adds value to the beginning of the [IDoublyLinkedList].
     */
    override fun addHead(value: T) {
        val node = DoublyLinkedListNode<T>(value)
        addHead(node)
    }

    /**
     * adds [DoublyLinkedListNode] to the beginning of the [IDoublyLinkedList].
     */
    override fun addHead(node: DoublyLinkedListNode<T>) {
        val temp = head
        head = node
        head!!.next = temp

        if (count == 0) tail = head
        else temp!!.previous = head
        count++
    }

    /**
     * adds value to the end of the [IDoublyLinkedList].
     */
    override fun addTail(value: T) {
        val node = DoublyLinkedListNode<T>(value)
        addTail(node)
    }


    /**
     * adds [DoublyLinkedListNode] to the end of the [IDoublyLinkedList].
     */
    override fun addTail(node: DoublyLinkedListNode<T>) {
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

    /**
     * adds value at the specified index of the [IDoublyLinkedList].
     * if @param[index] == 0, add the @param[value] to the head.
     * note that we are a zero index based list.
     */
    override fun addAtIndex(index: Int, value: T) {
        val node = DoublyLinkedListNode<T>(value)
        addAtIndex(index, node)
    }

    /**
     * adds [DoublyLinkedListNode] at the specified index of the [IDoublyLinkedList].
     * if @param[index] == 0, add the @param[node] to the head.
     * note that we are a zero index based list.
     */
    override fun addAtIndex(index: Int, node: DoublyLinkedListNode<T>) {
        if (index > count || index < 0)
            throw IllegalArgumentException("index must be between 0 and count")

        if (index == 0) {
            addHead(node)
            return
        } else if (index == count) {
            addTail(node)
            return
        }

        var counter = 0
        var current = head
        while (counter != index - 1) {
            current = current!!.next
            counter++
        }

        node.next = current!!.next
        node.previous = current
        current.next!!.previous = node
        current.next = node

        count++
    }

    /**
     * removes the first node in the [IDoublyLinkedList].
     * @return true if the value was removed.
     * @return false if the value did not exist.
     */
    override fun removeHead(): Boolean {
        if (count == 0) return false

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
     * removes the last node in the [IDoublyLinkedList].
     * @return true if the value was removed.
     * @return false if the value did not exist.
     */
    override fun removeTail(): Boolean {
        if (count == 0) return false

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
     * removes the node at the specified index of the [IDoublyLinkedList].
     * @return true if the value was removed.
     * @return false if the value did not exist.
     * note that we are a zero index based list.
     */
    override fun removeAtIndex(index: Int): Boolean {
        if (index > count || index < 0)
            throw IllegalArgumentException("index must be between 0 and count")

        return when (index) {
            1 -> removeHead()
            count - 1 -> removeTail()
            else -> {
                var current = head
                var counter = 0

                while (counter != index) {
                    current = current!!.next
                    counter++
                }

                current!!.next!!.previous = current.previous
                current.previous!!.next = current.next
                count--
                true
            }
        }
    }

    /**
     * removes the first node that contains [value].
     * @param [value] the value to be removed.
     * @return true if the value was removed.
     * @return false if the value did not exist.
     */
    override fun remove(value: T): Boolean {
        if (count == 0) return false
        else if (value == head!!.value) {
            removeHead()
            return true
        } else if (value == tail!!.value){
            removeTail()
            return true
        }

        var current = head
        while (current!!.next != null) {
            if (current.next!!.value == value) {
                current.next = current.next!!.next
                count--
                return true
            }
            current = current.next
        }
        return false
    }

    /**
     * removes the first node that contains value equal to [node].
     * @param [node] the node to be removed.
     * @return true if the value was removed.
     * @return false if the value did not exist.
     */
    override fun remove(node: DoublyLinkedListNode<T>): Boolean {
        return remove(node.value)
    }


    /**
     * check the [IDoublyLinkedList] contains a specific value.
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
     * check the [IDoublyLinkedList] contains a specific node with value equal to [node]'s value.
     * @return true if the value exist.
     * @return false if the value doesn't exist.
     */
    override fun contains(node: DoublyLinkedListNode<T>): Boolean {
        return contains(node.value)
    }

    /**
     * finds the value of [node] in the [IDoublyLinkedList].
     * @return the first [DoublyLinkedListNode] if it existed.
     * @return null if it doesn't exist.
     */
    override fun find(node: DoublyLinkedListNode<T>): DoublyLinkedListNode<T>? {
        return find(node.value)
    }

    /**
     * finds [value] in the [IDoublyLinkedList].
     * @return the first [DoublyLinkedListNode] if it existed.
     * @return null if it doesn't exist.
     */
    override fun find(value: T): DoublyLinkedListNode<T>? {
        if (count == 0) return null

        var current = head
        while (current != null) {
            if (current.value == value) return current
            current = current.next
        }

        return null
    }

    /**
     * Returns the index of the first occurrence of the specified element in the list,
     * or -1 if the specified element is not contained in the [IDoublyLinkedList].
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
     * or -1 if the specified element is not contained in the [IDoublyLinkedList].
     * note that we are a zero index based list.
     */
    override fun indexOf(node: DoublyLinkedListNode<T>): Int {
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

    override fun hasNext() = cursor != null
    override fun next(): T {
        val temp = cursor
        cursor = cursor!!.next
        return temp!!.value
    }
}