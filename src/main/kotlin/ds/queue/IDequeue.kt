package ds.queue

interface IDequeue<E> {

    /**
     * adds an item to the beginning of this dequeue.
     * @param [item] the element to be added into this dequeue.
     */
    fun enqueueHead(item: E)

    /**
     * adds an item to the end of this dequeue.
     * @param [item] the element to be added into this dequeue.
     */
    fun enqueueTail(item: E)

    /**
     * Remove the object at the beginning of this dequeue and returns that
     * object as a value of this function.
     *
     * * @return  The object at the beginning of this dequeue.
     * @throws  IllegalStateException  if this queue is empty.
     */
    fun dequeueHead(): E

    /**
     * Remove the object at the end of this dequeue and returns that
     * object as a value of this function.
     *
     * * @return  The object at the end of this dequeue.
     * @throws  IllegalStateException  if this queue is empty.
     */
    fun dequeueTail(): E

    /**
     * Retrieves, but does not remove, the first element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the head of this deque.
     *  * @throws  IllegalStateException  if this queue is empty.
     */
    fun peekHead(): E

    /**
     * Retrieves, but does not remove, the last element of this deque,
     * or returns {@code null} if this deque is empty.
     *
     * @return the tail of this deque.
     *  * @throws  IllegalStateException  if this queue is empty.
     */
    fun peekTail(): E

    /**
     * Tests if this dequeue is empty.
     *
     * @return  <code>true</code> if and only if this queue contains
     * no items; <code>false</code> otherwise.
     */
    fun isEmpty(): Boolean
}
