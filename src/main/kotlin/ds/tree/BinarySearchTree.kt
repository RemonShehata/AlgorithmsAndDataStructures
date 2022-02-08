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
    /**
     * add [data] to [IBinarySearchTree] in sort order.
     */
    override fun add(data: T) {
        TODO("Not yet implemented")
    }

    /**
     * add [bstNode] to [IBinarySearchTree] in sort order.
     */
    override fun add(bstNode: BinarySearchTreeNode<T>) {
        TODO("Not yet implemented")
    }

    /**
     * remove [data] from the tree, While maintaining sort order.
     * @return <code>true</code> if the removal was successful,
     * And <code>false</code> if the [data] didn't exist.
     */
    override fun remove(data: T): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * remove [bstNode] from the tree, While maintaining sort order.
     * @return <code>true</code> if the removal was successful,
     * And <code>false</code> if the [bstNode] value didn't exist.
     */
    override fun remove(bstNode: BinarySearchTreeNode<T>): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * search the [IBinarySearchTree] for [data].
     * @return [BinarySearchTreeNode] if the node existed, And <code>null</code> otherwise.
     */
    override fun search(data: T): BinarySearchTreeNode<T>? {
        TODO("Not yet implemented")
    }

    /**
     * search the [IBinarySearchTree] for [bstNode].
     * @return [BinarySearchTreeNode] if the node existed, And <code>null</code> otherwise.
     */
    override fun search(bstNode: BinarySearchTreeNode<T>): BinarySearchTreeNode<T>? {
        TODO("Not yet implemented")
    }

    /**
     * find parent for the first node with value [data].
     *  @return [BinarySearchTreeNode] if the node with that value has a parent, And <code>null</code> otherwise.
     */
    override fun findParent(data: T): BinarySearchTreeNode<T>? {
        TODO("Not yet implemented")
    }

    /**
     * find parent for the first node with value equal to value of [bstNode].
     *  @return [BinarySearchTreeNode] if the node with that value has a parent, And <code>null</code> otherwise.
     */
    override fun findParent(bstNode: BinarySearchTreeNode<T>): BinarySearchTreeNode<T>? {
        TODO("Not yet implemented")
    }

    /**
     * traverse this [IBinarySearchTree] in the following order
     * current node -> left node -> right node
     *
     * @param [action] the action to be performed on each node.
     */
    override fun preOrderTraversal(action: (t: T) -> Unit) {
        TODO("Not yet implemented")
    }

    /**
     * traverse this [IBinarySearchTree] in the following order
     * left node -> right node -> current node
     *
     * @param [action] the action to be performed on each node.
     */
    override fun postOrderTraversal(action: (t: T) -> Unit) {
        TODO("Not yet implemented")
    }

    /**
     * traverse this [IBinarySearchTree] in the following order
     * left node -> current node -> right node
     *
     * @param [action] the action to be performed on each node.
     */
    override fun inOrderTraversal(action: (t: T) -> Unit) {
        TODO("Not yet implemented")
    }

    /**
     * clear the tree, And reset everything.
     */
    override fun clear() {
        TODO("Not yet implemented")
    }
}