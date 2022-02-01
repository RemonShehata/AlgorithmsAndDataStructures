package ds.linked_list

interface ISinglyLinkedList<T> : Iterator<T> {

    /**
     * adds value to the beginning of the [ISinglyLinkedList].
     */
    fun addHead(value: T)

    /**
     * adds [SinglyLinkedListNode] to the beginning of the [ISinglyLinkedList].
     */
    fun addHead(node: SinglyLinkedListNode<T>)

    /**
     * adds value at the specified index of the [ISinglyLinkedList].
     * if [ISinglyLinkedList] is empty, the value to the head.
     * note that we are a zero index based list.
     */
    fun addAtIndex(index: Int, value: T)

    /**
     * adds [SinglyLinkedListNode] at the specified index of the [ISinglyLinkedList].
     * if [ISinglyLinkedList] is empty, the node to the head.
     * note that we are a zero index based list.
     */
    fun addAtIndex(index: Int, node: SinglyLinkedListNode<T>)

    /**
     * removes the first node in the [ISinglyLinkedList].
     * @return true if the value was removed.
     * @return false if the value did not exist.
     */
    fun removeHead(): Boolean

    /**
     * removes the node at the specified index of the [ISinglyLinkedList].
     * @return true if the value was removed.
     * @return false if the value did not exist.
     * note that we are a zero index based list.
     */
    fun removeAtIndex(index: Int): Boolean

    /**
     * removes the first node that contains [value].
     * @param [value] the value to be removed.
     * @return true if the value was removed.
     * @return false if the value did not exist.
     */
    fun remove(value: T): Boolean

    /**
     * removes the first node that contains value equal to [node].
     * @param [node] the node to be removed.
     * @return true if the value was removed.
     * @return false if the value did not exist.
     */
    fun remove(node: SinglyLinkedListNode<T>): Boolean

    /**
     * check the [ISinglyLinkedList] contains a specific value.
     * @return true if the value exist.
     * @return false if the value doesn't exist.
     */
    fun contains(value: T): Boolean

    /**
     * check the [ISinglyLinkedList] contains a specific node with value equal to [node]'s value.
     * @return true if the value exist.
     * @return false if the value doesn't exist.
     */
    fun contains(node: SinglyLinkedListNode<T>): Boolean

    /**
     * finds [value] in the [ISinglyLinkedList]
     * @return the first [SinglyLinkedListNode] if it existed.
     * @return null if it doesn't exist.
     */
    fun find(value: T): SinglyLinkedListNode<T>?

    /**
     * finds [node] in the [ISinglyLinkedList].
     * @return the first [SinglyLinkedListNode] if it existed.
     * @return null if it doesn't exist.
     */
    fun find(node: SinglyLinkedListNode<T>): SinglyLinkedListNode<T>?

    /**
     * Returns the index of the first occurrence of the specified element in the list,
     * or -1 if the specified element is not contained in the [ISinglyLinkedList].
     * note that we are a zero index based list.
     */
    fun indexOf(value: T): Int

    /**
     * Returns the index of the first occurrence of the specified element in the list,
     * or -1 if the specified element is not contained in the [ISinglyLinkedList].
     * note that we are a zero index based list.
     */
    fun indexOf(node: SinglyLinkedListNode<T>): Int

    /**
     * reset everything.
     */
    fun clear()
}

