package ds.linked_list

interface IDoublyLinkedList<T> {
    fun addHead(value: T)
    fun addHead(node: DoublyLinkedListNode<T>)
    fun addTail(value: T)
    fun addTail(node: DoublyLinkedListNode<T>)
    fun addAtIndex(index: Int, value: T)
    fun addAtIndex(index: Int, node: DoublyLinkedListNode<T>)

    fun removeHead(): Boolean
    fun removeTail(): Boolean
    fun removeAtIndex(index: Int): Boolean

    fun contains(value: T): Boolean
    fun contains(node: DoublyLinkedListNode<T>): Boolean

    fun indexOf(value: T): Int
    fun indexOf(node: DoublyLinkedListNode<T>): Int

    fun clear()
}