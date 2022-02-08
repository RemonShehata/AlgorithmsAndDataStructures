package ds.tree

class BinarySearchTreeNode<T : Comparable<T>>(
    val data: T,
    var left: BinarySearchTreeNode<T>? = null,
    var right: BinarySearchTreeNode<T>? = null
)

class BinarySearchTree<T> : IBinarySearchTree<T> {
}