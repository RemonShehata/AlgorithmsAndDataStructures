package ds.linked_list

class SinglyLinkedListNode<T>(var value: T) {
    var next: SinglyLinkedListNode<T>? = null
}

class SinglyLinkedList<T> : ISinglyLinkedList<T> {

    var head: SinglyLinkedListNode<T>? = null
        private set(value) {
            currentNode = value
            field = value
        }

    var count = 0
        private set

    // This is needed for iterator functionality.
    private var currentNode: SinglyLinkedListNode<T>? = null

    /**
     * adds value to the beginning of the [ISinglyLinkedList].
     */
    override fun addHead(value: T) {
        val node = SinglyLinkedListNode<T>(value)
        addHead(node)
    }

    /**
     * adds [SinglyLinkedListNode] to the beginning of the [ISinglyLinkedList].
     */
    override fun addHead(node: SinglyLinkedListNode<T>) {
        if (head != null) node.next = head
        head = node
        count++
    }

    /**
     * adds value at the specified index of the [ISinglyLinkedList].
     * if [ISinglyLinkedList] is empty, the value to the head.
     */
    override fun addAtIndex(index: Int, value: T) {
        val node = SinglyLinkedListNode<T>(value)
        addAtIndex(index, node)
    }

    /**
     * adds [SinglyLinkedListNode] at the specified index of the [ISinglyLinkedList].
     * if [ISinglyLinkedList] is empty, the node to the head.
     */
    override fun addAtIndex(index: Int, node: SinglyLinkedListNode<T>) {
        if (index > count || index < 0)
            throw IllegalArgumentException("index must be between 0 and count")

        if (index == 0) {
            addHead(node)
            return
        }

        var counter = 0
        var current = head
        while (counter != index - 1) {
            current = current!!.next
            counter++
        }

        node.next = current!!.next
        current.next = node

        count++
    }

    /**
     * removes the first node in the [ISinglyLinkedList].
     * @return true if the value was removed.
     * @return false if the value did not exist.
     */
    override fun removeHead(): Boolean {
        return if (count == 0) false
        else {
            head = head!!.next
            count--
            true
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
        else if (count == 1) {
            removeHead()
            return true
        }

        var current = head
        while (current!!.next != null) {
            if (current.next!!.value == value) {
                current.next = current.next!!.next
                count--
                break
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
    override fun remove(node: SinglyLinkedListNode<T>): Boolean {
        return remove(node.value)
    }

    /**
     * removes the node at the specified index of the [ISinglyLinkedList].
     * @return true if the value was removed.
     * @return false if the value did not exist.
     */
    override fun removeAtIndex(index: Int): Boolean {
        if (index > count || index < 0)
            throw IllegalArgumentException("index must be between 0 and count")

        if (index == 0) {
            removeHead()
            return true
        }

        var counter = 0
        var current = head
        var previous: SinglyLinkedListNode<T>? = null
        while (counter != index) {
            previous = current
            current = current!!.next
            counter++
        }

        previous!!.next = current!!.next

        count--
        return true
    }

    /**
     * check the [ISinglyLinkedList] contains a specific value.
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
     * check the [ISinglyLinkedList] contains a specific node with value equal to [node]'s value.
     * @return true if the value exist.
     * @return false if the value doesn't exist.
     */
    override fun contains(node: SinglyLinkedListNode<T>): Boolean {
        return contains(node.value)
    }

    /**
     * finds [value] in the [ISinglyLinkedList]
     * @return the first [SinglyLinkedListNode] if it existed.
     * @return null if it doesn't exist.
     */
    override fun find(value: T): SinglyLinkedListNode<T>? {
        if (count == 0) return null

        var current = head
        while (current != null) {
            if (current.value == value) return current
            current = current.next
        }

        return null
    }

    /**
     * finds [node] in the [ISinglyLinkedList].
     * @return the first [SinglyLinkedListNode] if it existed.
     * @return null if it doesn't exist.
     */
    override fun find(node: SinglyLinkedListNode<T>): SinglyLinkedListNode<T>? {
        return find(node.value)
    }

    /**
     * Returns the index of the first occurrence of the specified element in the list,
     * or -1 if the specified element is not contained in the [ISinglyLinkedList].
     */
    override fun indexOf(value: T): Int {
        var index = 0
        val current = head
        while (current!!.next != null) {
            if (current.value == value) return index
            index++
        }
        return -1
    }

    /**
     * Returns the index of the first occurrence of the specified element in the list,
     * or -1 if the specified element is not contained in the [ISinglyLinkedList].
     */
    override fun indexOf(node: SinglyLinkedListNode<T>): Int {
        return indexOf(node.value)
    }

    /**
     * reset everything.
     */
    override fun clear() {
        head = null
        count = 0
    }


    override fun hasNext() = currentNode != null
    override fun next(): T {
        val temp = currentNode
        currentNode = currentNode!!.next
        return temp!!.value
    }
}