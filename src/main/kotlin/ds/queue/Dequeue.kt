package ds.queue

class Dequeue<E> : IDequeue<E> {

    /**
     * adds an item to the beginning of this dequeue.
     * @param [item] the element to be added into this dequeue.
     */
    override fun enqueueHead(item: E) {
        TODO("Not yet implemented")
    }

    /**
     * adds an item to the end of this dequeue.
     * @param [item] the element to be added into this dequeue.
     */
    override fun enqueueTail(item: E) {
        TODO("Not yet implemented")
    }

    /**
     * Remove the object at the beginning of this dequeue and returns that
     * object as a value of this function.
     *
     * * @return  The object at the beginning of this dequeue.
     * @throws  IllegalStateException  if this queue is empty.
     */
    override fun dequeueHead(): E {
        TODO("Not yet implemented")
    }

    /**
     * Remove the object at the end of this dequeue and returns that
     * object as a value of this function.
     *
     * * @return  The object at the end of this dequeue.
     * @throws  IllegalStateException  if this queue is empty.
     */
    override fun dequeueTail(): E {
        TODO("Not yet implemented")
    }

    /**
     * Retrieves, but does not remove, the first element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the head of this deque.
     *  * @throws  IllegalStateException  if this queue is empty.
     */
    override fun peekHead(): E {
        TODO("Not yet implemented")
    }

    /**
     * Retrieves, but does not remove, the last element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the tail of this deque.
     *  * @throws  IllegalStateException  if this queue is empty.
     */
    override fun peekTail(): E {
        TODO("Not yet implemented")
    }

    /**
     * Tests if this dequeue is empty.
     *
     * @return  <code>true</code> if and only if this queue contains
     * no items; <code>false</code> otherwise.
     */
    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }
}
