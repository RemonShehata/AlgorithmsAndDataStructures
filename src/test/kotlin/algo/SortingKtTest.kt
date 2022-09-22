package algo

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

internal class SortingKtTest {

    //region bubbleSort
    @Test
    fun ` given non sorted array when bubbleSort is called the array is sorted`() {
        // GIVEN
        val inputArray = arrayOf(5, 4, 3, 2, 1)
        val expected = arrayOf(1, 2, 3, 4, 5)

        // WHEN
        bubbleSort(inputArray)

        //THEN
        assert(inputArray.contentEquals(expected))
    }

    @Test
    fun ` given sorted array when bubbleSort is called the array is sorted`() {
        // GIVEN
        val inputArray = arrayOf(1, 2, 3, 4, 5)
        val expected = arrayOf(1, 2, 3, 4, 5)

        // WHEN
        bubbleSort(inputArray)

        //THEN
        assert(inputArray.contentEquals(expected))
    }

    @Test
    fun ` given half sorted array when bubbleSort is called the array is sorted`() {
        // GIVEN
        val inputArray = arrayOf(1, 2, 5, 4, 3)
        val expected = arrayOf(1, 2, 3, 4, 5)

        // WHEN
        bubbleSort(inputArray)

        //THEN
        assert(inputArray.contentEquals(expected))
    }
    //endregion
}
