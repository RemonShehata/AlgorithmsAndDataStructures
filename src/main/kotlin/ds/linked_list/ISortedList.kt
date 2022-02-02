package ds.linked_list

/**
 * Doubly linked list where items on the left are lesser than items on the right.
 */
interface ISortedList<T : Comparable<T>>: Iterator<T> {

    /**
     * adds [value] in sort order in [ISortedList].
     */
    fun add(value: T)

    /**
     * adds [SortedListNode] in sort order in [ISortedList].
     */
    fun add(node: SortedListNode<T>)

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
    fun remove(node: SortedListNode<T>): Boolean

    /**
     * check the [ISortedList] contains a specific value.
     * @return true if the value exist.
     * @return false if the value doesn't exist.
     */
    fun contains(value: T): Boolean

    /**
     * check the [ISortedList] contains a specific node with value equal to [node]'s value.
     * @return true if the value exist.
     * @return false if the value doesn't exist.
     */
    fun contains(node: SortedListNode<T>): Boolean

    /**
     * finds [value] in the [ISortedList].
     * @return the first [SortedListNode] if it existed.
     * @return null if it doesn't exist.
     */
    fun find(value: T): SortedListNode<T>?

    /**
     * finds the value of [node] in the [ISortedList].
     * @return the first [SortedListNode] if it existed.
     * @return null if it doesn't exist.
     */
    fun find(node: SortedListNode<T>): SortedListNode<T>?

    /**
     * Returns the index of the first occurrence of the specified element in the list,
     * or -1 if the specified element is not contained in the [ISortedList].
     * note that we are a zero index based list.
     */
    fun indexOf(value: T): Int

    /**
     * Returns the index of the first occurrence of the specified element in the list,
     * or -1 if the specified element is not contained in the [ISortedList].
     * note that we are a zero index based list.
     */
    fun indexOf(node: SortedListNode<T>): Int

    /**
     * reset everything.
     */
    fun clear()
}
