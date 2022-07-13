package ds.tree

/**
 * a node that contains a single data item and pointers to the left and right child.
 */
data class BinarySearchTreeNode<T : Comparable<T>>(
    val data: T,
    var left: BinarySearchTreeNode<T>? = null,
    var right: BinarySearchTreeNode<T>? = null
) : Comparable<T> {
    // implementation can be done without this function
    override fun compareTo(other: T): Int {
        return this.data.compareTo(other)
    }

    // provide comparing to the node itself instead of the value.
    fun compareTo(other: BinarySearchTreeNode<T>): Int {
        return this.data.compareTo(other.data)
    }
}

/**
 * binary tree where nodes with less value are stored on the left.
 * And, greater than or equal to values are stores on the right.
 */
class BinarySearchTree<T : Comparable<T>> : IBinarySearchTree<T> {

    var root: BinarySearchTreeNode<T>? = null
        private set

    var count: Int = 0
        private set(value) {
            field = value
            ensureCountIsCorrect()
        }


    /**
     * add [data] to [IBinarySearchTree] in sort order.
     */
    override fun add(data: T) {
        val bstNode = BinarySearchTreeNode(data)
        add(bstNode)
    }

    /**
     * add [bstNode] to [IBinarySearchTree] in sort order.
     */
    override fun add(bstNode: BinarySearchTreeNode<T>) {
        root?.let { addTo(it, bstNode) } ?: run { root = bstNode }
        count++
    }

    // Recursive add algorithm
    private fun addTo(rootNode: BinarySearchTreeNode<T>, nodeToAdd: BinarySearchTreeNode<T>) {
        // Case 1: Value is less than the current node value
        if (nodeToAdd.compareTo(rootNode) < 0) {
            // if there is no left child make this the new left
            // else add it to the left node
            rootNode.left?.let { addTo(it, nodeToAdd) } ?: kotlin.run { rootNode.left = nodeToAdd }

            // Case 2: Value is equal to or greater than the current value
        } else {
            // If there is no right, add it to the right
            // else add it to the right node
            rootNode.right?.let { addTo(it, nodeToAdd) }
                ?: kotlin.run { rootNode.right = nodeToAdd }
        }
    }

    /**
     * remove [data] from the tree, While maintaining sort order.
     * @return <code>true</code> if the removal was successful,
     * And <code>false</code> if the [data] didn't exist.
     */
    override fun remove(data: T): Boolean {
        val bstNode = BinarySearchTreeNode(data)
        return remove(bstNode)
    }

    /**
     * remove [bstNode] from the tree, While maintaining sort order.
     * @return <code>true</code> if the removal was successful,
     * And <code>false</code> if the [bstNode] value didn't exist.
     */
    override fun remove(bstNode: BinarySearchTreeNode<T>): Boolean {

        val nodeToRemove = search(bstNode) ?: return false

        val parentOfNodeToRemove = findParent(nodeToRemove) //if null then I am removing root
        parentOfNodeToRemove?.let { parentNode ->

            if (nodeToRemove.isLeaf()) {
                if (nodeToRemove isRightChildOf parentNode) parentNode.right = null
                else parentNode.left = null

            } else if (nodeToRemove.hasTwoChildren()) { //TODO: right -> left is null. what to do?
                val nodeToPromote = nodeToRemove.right!!.left
                //nodeToRemove.right!!.left = null
                if (nodeToRemove isRightChildOf parentNode) parentNode.right = nodeToPromote
                else parentNode.left = nodeToPromote

                nodeToPromote!!.right = nodeToRemove.right
                nodeToPromote.left = nodeToRemove.left

                nodeToRemove.right = null
                nodeToRemove.left = null

            } else if (nodeToRemove.hasOneChild()) {
                val child = if (nodeToRemove.hasRightChild()) nodeToRemove.right
                else nodeToRemove.left
                if (nodeToRemove isRightChildOf parentNode) parentOfNodeToRemove.right = child
                else parentOfNodeToRemove.left = child
            }

        } ?: run {
            // parent node is null means I am removing root
            if (nodeToRemove.isLeaf()) {
                // root && is leaf means I am the only node in the tree
                root = null
            } else if (nodeToRemove.hasTwoChildren()) { //TODO: right -> left is null. what to do?
                val nodeToPromote = nodeToRemove.right!!.left
                nodeToRemove.right!!.left = null
                root = nodeToPromote
//                if (nodeToRemove isRightChildOf parentNode) parentNode.right = nodeToPromote
//                else parentNode.left = nodeToPromote

                nodeToPromote!!.right = nodeToRemove.right
                nodeToPromote.left = nodeToRemove.left

                nodeToRemove.right = null
                nodeToRemove.left = null
            } else {
                // root but with one child
                root = if (nodeToRemove.hasRightChild()) root!!.right
                else root!!.left
            }
        }
        count--
        return true
    }

    /**
     * search the [IBinarySearchTree] for [data].
     * @return [BinarySearchTreeNode] if the node existed, And <code>null</code> otherwise.
     */
    override fun search(data: T): BinarySearchTreeNode<T>? {
        val bstNode = BinarySearchTreeNode(data)
        return search(bstNode)
    }

    /**
     * search the [IBinarySearchTree] for [bstNode].
     * @return [BinarySearchTreeNode] if the node existed, And <code>null</code> otherwise.
     */
    override fun search(bstNode: BinarySearchTreeNode<T>): BinarySearchTreeNode<T>? {
        return root?.let { search(it, bstNode) }
    }

    private fun search(
        rootNode: BinarySearchTreeNode<T>,
        searchedFor: BinarySearchTreeNode<T>
    ): BinarySearchTreeNode<T>? {
        return when {
            searchedFor.compareTo(rootNode) == 0 -> rootNode
//            rootNode.isLeaf() -> null
            // searched for value is less than root, go left
            searchedFor.compareTo(rootNode) < 0 -> {
                rootNode.left?.let { search(it, searchedFor) }
            }
            else -> {
                rootNode.right?.let { search(it, searchedFor) }
            }
        }
    }

    /**
     * find parent for the first node with value [data].
     *  @return [BinarySearchTreeNode] if the node with that value has a parent, And <code>null</code> otherwise.
     */
    private fun findParent(data: T): BinarySearchTreeNode<T>? {
        val bstNode = BinarySearchTreeNode(data)
        return findParent(data)
    }

    /**
     * find parent for the first node with value equal to value of [childNode].
     *  @return [BinarySearchTreeNode] if the node with that value has a parent, And <code>null</code> otherwise.
     */
    private fun findParent(childNode: BinarySearchTreeNode<T>): BinarySearchTreeNode<T>? {
        var parent: BinarySearchTreeNode<T>? = null
        var current = root

        while (current != null) {
            val result = childNode.compareTo(current)
            if (result < 0) {
                parent = current
                current = current.left
            } else if (result > 0) {
                parent = current
                current = current.right
            } else {
                break
            }
        }

        return parent
    }

    /**
     * traverse this [IBinarySearchTree] in the following order
     * current node -> left node -> right node
     *
     * @param [action] the action to be performed on each node.
     */
    override fun preOrderTraversal(action: (t: T) -> Unit) {
        root?.let { preOrderTraversal(it, action) }
    }

    private fun preOrderTraversal(node: BinarySearchTreeNode<T>, action: (t: T) -> Unit) {
        action(node.data)
        node.left?.let { preOrderTraversal(it, action) }
        node.right?.let { preOrderTraversal(it, action) }
    }

    /**
     * traverse this [IBinarySearchTree] in the following order
     * left node -> right node -> current node
     *
     * @param [action] the action to be performed on each node.
     */
    override fun postOrderTraversal(action: (t: T) -> Unit) {
        root?.let { postOrderTraversal(it, action) }
    }

    private fun postOrderTraversal(node: BinarySearchTreeNode<T>, action: (t: T) -> Unit) {
        node.left?.let { postOrderTraversal(it, action) }
        node.right?.let { postOrderTraversal(it, action) }
        action(node.data)
    }

    /**
     * traverse this [IBinarySearchTree] in the following order
     * left node -> current node -> right node
     *
     * @param [action] the action to be performed on each node.
     */
    override fun inOrderTraversal(action: (t: T) -> Unit) {
        root?.let { inOrderTraversal(it, action) }
    }

    private fun inOrderTraversal(node: BinarySearchTreeNode<T>, action: (t: T) -> Unit) {
        node.left?.let { inOrderTraversal(it, action) }
        action(node.data)
        node.right?.let { inOrderTraversal(it, action) }

    }

    /**
     * clear the tree, And reset everything.
     */
    override fun clear() {
        root = null
        count = 0
    }

    private fun ensureCountIsCorrect() {
        check(this.count >= 0) { "Count can't be less than 0. count is ${this.count}" }
    }
}

fun <T : Comparable<T>> BinarySearchTreeNode<T>.isLeaf() = this.left == null && this.right == null
fun <T : Comparable<T>> BinarySearchTreeNode<T>.hasRightChild() = this.right != null
fun <T : Comparable<T>> BinarySearchTreeNode<T>.hasLeftChild() = this.left != null
fun <T : Comparable<T>> BinarySearchTreeNode<T>.hasOneChild() = this.left != null || this.right != null
fun <T : Comparable<T>> BinarySearchTreeNode<T>.hasTwoChildren() = this.left != null && this.right != null

infix fun <T : Comparable<T>> BinarySearchTreeNode<T>.isRightChildOf(parentNode: BinarySearchTreeNode<T>): Boolean =
    parentNode.right?.compareTo(this) == 0
