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

    //region indexOf tests
    @Test
    fun `given an empty stack, when indexOf is called with any value, -1 is returned`() {
        // GIVEN
        val stack = Stack<Int>()

        // WHEN
        val result = stack.indexOf(5)

        //THEN
        val expectedResult = -1
        assertEquals(expectedResult, result)
    }

    @Test
    fun `given a stack, when indexOf is called with top value, 0 is returned`() {
        // GIVEN
        val stack = Stack<Int>().apply {
            push(1)
            push(2)
            push(3)
            push(4)
            push(5)
        }

        // WHEN
        val result = stack.indexOf(5)

        //THEN
        val expectedResult = 0
        assertEquals(expectedResult, result)
    }

    @Test
    fun `given a stack, when indexOf is called with bottom value, count -1 is returned`() {
        // GIVEN
        val stack = Stack<Int>().apply {
            push(1)
            push(2)
            push(3)
            push(4)
            push(5)
        }

        // WHEN
        val result = stack.indexOf(1)

        //THEN
        val expectedResult = 4
        assertEquals(expectedResult, result)
        assertEquals(expectedResult, stack.count -1)
    }

    @Test
    fun `given a stack, when indexOf is called with a value in the middle, correct index is returned`() {
        // GIVEN
        val stack = Stack<Int>().apply {
            push(1)
            push(2)
            push(3)
            push(4)
            push(5)
        }

        // WHEN
        val result1 = stack.indexOf(2)
        val result2 = stack.indexOf(3)
        val result3 = stack.indexOf(4)

        //THEN
        val expectedResult1 = 3
        val expectedResult2 = 2
        val expectedResult3 = 1
        assertEquals(expectedResult1, result1)
        assertEquals(expectedResult2, result2)
        assertEquals(expectedResult3, result3)
    }

    //endregion

    //region Iterable tests
    @Test
    fun `given an empty stack, when iterated through, number of iterations is zero`() {
        // GIVEN
        val stack = Stack<Int>()

        // WHEN
        var numberOfIterations = 0
        stack.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 0
        assertEquals(expectedIterations, numberOfIterations)
    }

    @Test
    fun `given a stack, when iterated through, number of iterations is correct`() {
        // GIVEN
        val stack = Stack<Int>()
        val range = 1..5
        range.forEach {
            stack.push(it)
        }

        // WHEN
        var numberOfIterations = 0
        stack.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 5
        assertEquals(expectedIterations, numberOfIterations)
    }

    @Test
    fun `given a stack, when iterated through twice, number of iterations is correct`() {
        // GIVEN
        val stack = Stack<Int>()
        val range = 1..5
        range.forEach {
            stack.push(it)
        }

        // WHEN
        var numberOfIterations = 0
        stack.forEach { numberOfIterations++ }
        stack.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 10
        assertEquals(expectedIterations, numberOfIterations)
    }

    @Test
    fun `given a stack, when iterated through twice and return in the middle, number of iterations is correct`() {
        // GIVEN
        val stack = Stack<Int>()
        val range = 1..5
        range.forEach {
            stack.push(it)
        }

        // WHEN
        var numberOfIterations = 0
        stack.forEach {
            if (it == 3) return
            numberOfIterations++
        }
        stack.forEach { numberOfIterations++ }

        // THEN
        val expectedIterations = 7
        assertEquals(expectedIterations, numberOfIterations)
    }
    //endregion
}
