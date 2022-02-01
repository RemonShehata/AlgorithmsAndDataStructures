package ds.linked_list


class DoublyLinkedListNode<T>(var value: T) {
    var previous: DoublyLinkedListNode<T>? = null
    var next: DoublyLinkedListNode<T>? = null
}

class DoublyLinkedList<T> : IDoublyLinkedList<T> {
    var tail: DoublyLinkedListNode<T>? = null
        private set

    var head: DoublyLinkedListNode<T>? = null
        private set(value) {
            currentNode = value
            field = value
        }

    var count: Int = 0
        private set

    // This is needed for iterator functionality.
    private var currentNode: DoublyLinkedListNode<T>? = null

    override fun addHead(value: T) {
        val node = DoublyLinkedListNode<T>(value)
        addHead(node)
    }

    override fun addHead(node: DoublyLinkedListNode<T>) {
        val temp = head
        head = node
        head!!.next = temp

        if (count == 0) tail = head
        else temp!!.previous = head
        count++
    }

    override fun addTail(value: T) {
        val node = DoublyLinkedListNode<T>(value)
        addTail(node)
    }

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

    override fun addAtIndex(index: Int, value: T) {
        val node = DoublyLinkedListNode<T>(value)
        addAtIndex(index, node)
    }

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

        tail!!.next = node
        node.previous = tail
        tail = node
        count++
    }

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

    override fun removeAtIndex(index: Int): Boolean {
        if (index > count || index < 0)
            throw IllegalArgumentException("index must be between 0 and count")

        return when (index) {
            0 -> false
            1 -> removeHead()
            count -> removeTail()
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

    override fun contains(value: T): Boolean {
        if (count == 0) return false
        var current = head
        while (current != null) {
            if (current.value == value) return true
            current = current.next
        }
        return false
    }

    override fun contains(node: DoublyLinkedListNode<T>): Boolean {
        return contains(node.value)
    }

    override fun indexOf(value: T): Int {
        var current = head
        var index = 0
        while (current!!.next != null) {
            if (current.value == value) return index
            current = current.next
            index++
        }
        return -1
    }

    override fun indexOf(node: DoublyLinkedListNode<T>): Int {
        return indexOf(node.value)
    }

    override fun clear() {
        head = null
        tail = null
        count = 0
    }

    override fun hasNext() = currentNode != null
    override fun next(): T {
        val temp = currentNode
        currentNode = currentNode!!.next
        return temp!!.value
    }
}