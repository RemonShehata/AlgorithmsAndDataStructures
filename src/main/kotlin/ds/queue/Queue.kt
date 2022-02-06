package ds.queue

class Queue<E>: IQueue<E> {

    /**
     * adds an item to the end of this queue.
     * @param [element] the element to be added into this queue.
     */
    override fun enqueue(element: E) {
        TODO("Not yet implemented")
    }

    /**
     * Removed the object at the beginning of this queue and returns that
     * object as a value of this function.
     *
     * * @return  The object at the beginning of this queue.
     * @throws  IllegalStateException  if this queue is empty.
     */
    override fun dequeue(): E {
        TODO("Not yet implemented")
    }

    /**
     * Looks at the object at the start of this queue without removing it
     * from the queue.
     *
     * @return  the object at the beginning of this queue.
     * @throws  IllegalStateException  if this stack is empty.
     */
    override fun peek(): E {
        TODO("Not yet implemented")
    }

    /**
     * Tests if this Queue is empty.
     *
     * @return  <code>true</code> if and only if this queue contains
     * no items; <code>false</code> otherwise.
     */
    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }
}
