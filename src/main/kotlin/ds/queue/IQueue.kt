package ds.queue

interface IQueue<E> : Iterable<E> {

    /**
     * adds an item to the end of this queue.
     * @param [element] the element to be added into this queue.
     */
    fun enqueue(element: E)

    /**
     * Removed the object at the beginning of this queue and returns that
     * object as a value of this function.
     *
     * * @return  The object at the beginning of this queue.
     * @throws  IllegalStateException  if this queue is empty.
     */
    fun dequeue(): E

    /**
     * Looks at the object at the start of this queue without removing it
     * from the queue.
     *
     * @return  the object at the beginning of this queue.
     * @throws  IllegalStateException  if this stack is empty.
     */
    fun peek(): E

    /**
     * Tests if this Queue is empty.
     *
     * @return  <code>true</code> if and only if this queue contains
     * no items; <code>false</code> otherwise.
     */
    fun isEmpty(): Boolean
}