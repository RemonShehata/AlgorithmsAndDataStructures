package ds.tree

interface IBinarySearchTree<T> {

    fun add(data: T)
    fun add(bstNode: BSTNode<T>)

    fun remove(data: T): Boolean
    fun remove(bstNode: BSTNode<T>): Boolean

    fun search(data: T): BSTNode<T>?
    fun search(bstNode: BSTNode<T>): BSTNode<T>?

    fun findParent(data: T): BSTNode<T>?
    fun findParent(bstNode: BSTNode<T>): BSTNode<T>?

    fun preOrderTraversal(action: (t: T) -> Unit)
    fun postOrderTraversal(action: (t: T) -> Unit)
    fun inOrderTraversal(action: (t: T) -> Unit)

    fun clear()
}
