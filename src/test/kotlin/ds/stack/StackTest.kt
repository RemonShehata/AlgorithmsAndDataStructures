package ds.stack

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class StackTest {

    //region count test
    @Test
    fun `given empty stack, count is zero`() {
        // GIVEN
        val stack = Stack<Int>()

        // THEN
        assertEquals(0, stack.count)
    }
    //endregion

    //region push tests
    @Test
    fun `given empty stack, when push is called once, count is updated`() {
        // GIVEN
        val stack = Stack<Int>()

        // WHEN
        stack.push(5)

        // THEN
        val expectedCount = 1
        assertEquals(expectedCount, stack.count)
    }

    @Test
    fun `given a stack with one item, when push is called once, count is updated`() {
        // GIVEN
        val stack = Stack<Int>()
        stack.push(1)

        // WHEN
        stack.push(5)

        // THEN
        val expectedCount = 2
        assertEquals(expectedCount, stack.count)
    }
    //endregion

    //region pop tests
    @Test
    fun `given empty stack, when pop is called,exception is thrown`() {
        // GIVEN
        val stack = Stack<Int>()


        // THEN
        assertThrows<IllegalStateException> { stack.pop() }
    }

    @Test
    fun `given a stack with one item, when pop is called once, returns the correct value and count is updated`() {
        // GIVEN
        val stack = Stack<Int>()
        stack.push(1)

        // WHEN
        val result = stack.pop()

        // THEN
        val expectedCount = 0
        val expectedValue = 1
        assertEquals(expectedCount, stack.count)
        assertEquals(expectedValue, result)
    }
    //endregion

    //region peek tests
    @Test
    fun `given empty stack, when peek is called,exception is thrown`() {
        // GIVEN
        val stack = Stack<Int>()


        // THEN
        assertThrows<IllegalStateException> { stack.peek() }
    }

    @Test
    fun `given a stack with one item, when peek is called once,returns the correct value and count is not changed`() {
        // GIVEN
        val stack = Stack<Int>()
        stack.push(1)

        // WHEN
        val result = stack.peek()

        // THEN
        val expectedCount = 1
        val expectedValue = 1
        assertEquals(expectedCount, stack.count)
        assertEquals(expectedValue, result)
    }
    //endregion

    //region isEmpty tests
    @Test
    fun `given empty stack, when isEmpty is called, return true`() {
        // GIVEN
        val stack = Stack<Int>()

        // WHEN
        val result = stack.isEmpty()

        // THEN
        assertTrue(result)
    }

    @Test
    fun `given a stack with one item, when isEmpty is called,returns false`() {
        // GIVEN
        val stack = Stack<Int>()
        stack.push(1)

        // WHEN
        val result = stack.isEmpty()

        // THEN
        assertFalse(result)
    }
    //endregion
}
