package ds.linked_list

//todo: implement remove(value)
interface IDoublyLinkedList<T> : Iterator<T> {

    /**
     * adds value to the beginning of the [IDoublyLinkedList].
     */
    fun addHead(value: T)

    /**
     * adds [DoublyLinkedListNode] to the beginning of the [IDoublyLinkedList].
     */
    fun addHead(node: DoublyLinkedListNode<T>)

    /**
     * adds value to the end of the [IDoublyLinkedList].
     */
    fun addTail(value: T)

    /**
     * adds [DoublyLinkedListNode] to the end of the [IDoublyLinkedList].
     */
    fun addTail(node: DoublyLinkedListNode<T>)

    /**
     * adds value at the specified index of the [IDoublyLinkedList].
     * if @param[index] == 0, add the @param[value] to the head.
     * note that we are a zero index based list.
     */
    fun addAtIndex(index: Int, value: T)

    /**
     * adds [DoublyLinkedListNode] at the specified index of the [IDoublyLinkedList].
     * if @param[index] == 0, add the @param[node] to the head.
     * note that we are a zero index based list.
     */
    fun addAtIndex(index: Int, node: DoublyLinkedListNode<T>)

    /**
     * removes the first node in the [IDoublyLinkedList].
     * @return true if the value was removed.
     * @return false if the value did not exist.
     */
    fun removeHead(): Boolean

    /**
     * removes the last node in the [IDoublyLinkedList].
     * @return true if the value was removed.
     * @return false if the value did not exist.
     */
    fun removeTail(): Boolean

    /**
     * removes the node at the specified index of the [IDoublyLinkedList].
     * @return true if the value was removed.
     * @return false if the value did not exist.
     * note that we are a zero index based list.
     */
    fun removeAtIndex(index: Int): Boolean

    /**
     * check the [IDoublyLinkedList] contains a specific value.
     * @return true if the value exist.
     * @return false if the value doesn't exist.
     */
    fun contains(value: T): Boolean

    /**
     * check the [IDoublyLinkedList] contains a specific node with value equal to [node]'s value.
     * @return true if the value exist.
     * @return false if the value doesn't exist.
     */
    fun contains(node: DoublyLinkedListNode<T>): Boolean

    /**
     * finds [value] in the [IDoublyLinkedList].
     * @return the first [DoublyLinkedListNode] if it existed.
     * @return null if it doesn't exist.
     */
    fun find(value: T): DoublyLinkedListNode<T>?

    /**
     * finds the value of [node] in the [IDoublyLinkedList].
     * @return the first [DoublyLinkedListNode] if it existed.
     * @return null if it doesn't exist.
     */
    fun find(node: DoublyLinkedListNode<T>): DoublyLinkedListNode<T>?

    /**
     * Returns the index of the first occurrence of the specified element in the list,
     * or -1 if the specified element is not contained in the [IDoublyLinkedList].
     * note that we are a zero index based list.
     */
    fun indexOf(value: T): Int

    /**
     * Returns the index of the first occurrence of the specified element in the list,
     * or -1 if the specified element is not contained in the [IDoublyLinkedList].
     * note that we are a zero index based list.
     */
    fun indexOf(node: DoublyLinkedListNode<T>): Int

    /**
     * reset everything.
     */
    fun clear()
}