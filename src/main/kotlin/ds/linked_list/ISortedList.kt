package ds.linked_list

interface ISortedList<T : Comparable<T>> {
    fun add(value: T)
    fun add(node: SortedListNode<T>)

//    fun remove(value: T)
//    fun remove(node: SortedListNode<T>)
}
