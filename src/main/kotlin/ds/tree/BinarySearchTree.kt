package ds.tree

/**
 * a node that contains a single data item and pointers to the left and right child.
 */
class BinarySearchTreeNode<T : Comparable<T>>(
    val data: T,
    var left: BinarySearchTreeNode<T>? = null,
    var right: BinarySearchTreeNode<T>? = null
)

/**
 * binary tree where nodes with less value are stored on the left.
 * And, greater than or equal to values are stores on the right.
 */
class BinarySearchTree<T> : IBinarySearchTree<T> {
}