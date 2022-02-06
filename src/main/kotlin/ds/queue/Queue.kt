package ds.queue

class Queue<E> : IQueue<E> {

    private val store = Dequeue<E>()

    var count: Int = store.count
        private set
        get() = store.count

    /**
     * adds an item to the end of this queue.
     * @param [element] the element to be added into this queue.
     */
    override fun enqueue(element: E) {
        store.enqueueTail(element)
    }

    /**
     * Removed the object at the beginning of this queue and returns that
     * object as a value of this function.
     *
     * * @return  The object at the beginning of this queue.
     * @throws  IllegalStateException  if this queue is empty.
     */
    override fun dequeue(): E {
        return store.dequeueHead()
    }

    /**
     * Looks at the object at the start of this queue without removing it
     * from the queue.
     *
     * @return  the object at the beginning of this queue.
     * @throws  IllegalStateException  if this stack is empty.
     */
    override fun peek(): E {
        return store.peekHead()
    }

    /**
     * Tests if this Queue is empty.
     *
     * @return  <code>true</code> if and only if this queue contains
     * no items; <code>false</code> otherwise.
     */
    override fun isEmpty(): Boolean {
        return count == 0
    }
}
