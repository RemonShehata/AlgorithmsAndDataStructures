package ds.tree

interface IBinarySearchTree<T : Comparable<T>> {

    /**
     * add [data] to [IBinarySearchTree] in sort order.
     */
    fun add(data: T)

    /**
     * add [bstNode] to [IBinarySearchTree] in sort order.
     */
    fun add(bstNode: BinarySearchTreeNode<T>)

    /**
     * remove [data] from the tree, While maintaining sort order.
     * @return <code>true</code> if the removal was successful,
     * And <code>false</code> if the [data] didn't exist.
     */
    fun remove(data: T): Boolean

    /**
     * remove [bstNode] from the tree, While maintaining sort order.
     * @return <code>true</code> if the removal was successful,
     * And <code>false</code> if the [bstNode] value didn't exist.
     */
    fun remove(bstNode: BinarySearchTreeNode<T>): Boolean

    /**
     * search the [IBinarySearchTree] for [data].
     * @return [BinarySearchTreeNode] if the node existed, And <code>null</code> otherwise.
     */
    fun search(data: T): BinarySearchTreeNode<T>?

    /**
     * search the [IBinarySearchTree] for [bstNode].
     * @return [BinarySearchTreeNode] if the node existed, And <code>null</code> otherwise.
     */
    fun search(bstNode: BinarySearchTreeNode<T>): BinarySearchTreeNode<T>?

    /**
     * find parent for the first node with value [data].
     *  @return [BinarySearchTreeNode] if the node with that value has a parent, And <code>null</code> otherwise.
     */
    fun findParent(data: T): BinarySearchTreeNode<T>?

    /**
     * find parent for the first node with value equal to value of [bstNode].
     *  @return [BinarySearchTreeNode] if the node with that value has a parent, And <code>null</code> otherwise.
     */
    fun findParent(bstNode: BinarySearchTreeNode<T>): BinarySearchTreeNode<T>?

    /**
     * traverse this [IBinarySearchTree] in the following order
     * current node -> left node -> right node
     *
     * @param [action] the action to be performed on each node.
     */
    fun preOrderTraversal(action: (t: T) -> Unit)

    /**
     * traverse this [IBinarySearchTree] in the following order
     * left node -> right node -> current node
     *
     * @param [action] the action to be performed on each node.
     */
    fun postOrderTraversal(action: (t: T) -> Unit)

    /**
     * traverse this [IBinarySearchTree] in the following order
     * left node -> current node -> right node
     *
     * @param [action] the action to be performed on each node.
     */
    fun inOrderTraversal(action: (t: T) -> Unit)

    /**
     * clear the tree, And reset everything.
     */
    fun clear()
}
