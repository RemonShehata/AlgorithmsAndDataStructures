package ds.queue

import ds.linked_list.DoublyLinkedList

class Dequeue<E> : IDequeue<E> {

    private val store = DoublyLinkedList<E>()

    var count: Int = store.count
        private set
        get() = store.count


    /**
     * adds an item to the beginning of this dequeue.
     * @param [item] the element to be added into this dequeue.
     */
    override fun enqueueHead(item: E) {
        store.addHead(item)
    }

    /**
     * adds an item to the end of this dequeue.
     * @param [item] the element to be added into this dequeue.
     */
    override fun enqueueTail(item: E) {
        store.addTail(item)
    }

    /**
     * Remove the object at the beginning of this dequeue and returns that
     * object as a value of this function.
     *
     * * @return  The object at the beginning of this dequeue.
     * @throws  IllegalStateException  if this queue is empty.
     */
    override fun dequeueHead(): E {
        val head = store.head ?: throw IllegalStateException("Dequeue is empty")
        store.removeHead()
        return head.value
    }

    /**
     * Remove the object at the end of this dequeue and returns that
     * object as a value of this function.
     *
     * * @return  The object at the end of this dequeue.
     * @throws  IllegalStateException  if this queue is empty.
     */
    override fun dequeueTail(): E {
        val tail = store.tail ?: throw IllegalStateException("Dequeue is empty")
        store.removeHead()
        return tail.value
    }

    /**
     * Retrieves, but does not remove, the first element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the head of this deque.
     *  * @throws  IllegalStateException  if this queue is empty.
     */
    override fun peekHead(): E {
        store.head?.let {
            return it.value
        } ?: throw IllegalStateException("Dequeue is empty")
    }

    /**
     * Retrieves, but does not remove, the last element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the tail of this deque.
     *  * @throws  IllegalStateException  if this queue is empty.
     */
    override fun peekTail(): E {
        store.tail?.let {
            return it.value
        } ?: throw IllegalStateException("Dequeue is empty")
    }

    /**
     * Tests if this dequeue is empty.
     *
     * @return  <code>true</code> if and only if this queue contains
     * no items; <code>false</code> otherwise.
     */
    override fun isEmpty(): Boolean {
        return store.count == 0
    }
}
