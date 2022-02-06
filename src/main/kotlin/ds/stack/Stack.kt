package ds.stack

class Stack<E>: IStack<E> {
    /**
     * Pushes an item onto the top of this stack.
     *
     * @param   item   the item to be pushed onto this stack.
     * @return  the <code>item</code> argument.
     */
    override fun push(item: E) {
        TODO("Not yet implemented")
    }

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return  The object at the top of this stack.
     * @throws  IllegalStateException  if this stack is empty.
     */
    override fun pop(): E {
        TODO("Not yet implemented")
    }

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return  the object at the top of this stack.
     * @throws  IllegalStateException  if this stack is empty.
     */
    override fun peek(): E {
        TODO("Not yet implemented")
    }

    /**
     * Tests if this stack is empty.
     *
     * @return  <code>true</code> if and only if this stack contains
     *          no items; <code>false</code> otherwise.
     */
    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Returns the 1-based position where an object is on this stack.
     * If the object <tt>o</tt> occurs as an item in this stack, this
     * method returns the distance from the top of the stack of the
     * occurrence nearest the top of the stack; the topmost item on the
     * stack is considered to be at distance <tt>1</tt>. The <tt>equals</tt>
     * method is used to compare <tt>o</tt> to the
     * items in this stack.
     *
     * @param   o   the desired object.
     * @return  the 1-based position from the top of the stack where
     *          the object is located; the return value <code>-1</code>
     *          indicates that the object is not on the stack.
     */
    override fun indexOf(item: E): Int {
        TODO("Not yet implemented")
    }
}