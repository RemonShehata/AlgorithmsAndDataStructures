package ds.queue

interface IQueue<E> {
    fun enqueue(element: E)
    fun dequeue(): E
    fun peek(): E
    fun isEmpty(): Boolean
}