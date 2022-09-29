package algo

//fun <T : Comparable<T>> bubbleSort(collection: Collection<T>): Collection<T> {
//    val sortedCollection: Collection<T> = Collection<T>()
//    collection.forEach {
//
//    }
//}

// TODO: implement generic function
fun bubbleSort(list: Array<Int>) {
    var swapsMade: Boolean

    do {
        swapsMade = false
        for (i in 0 until list.size - 1) {
            if (list[i] > list[i + 1]) {
                val temp = list[i]
                list[i] = list[i + 1]
                list[i + 1] = temp
                swapsMade = true
            }
        }
    } while (swapsMade)
}

fun bubbleSort2(array: Array<Int>) {
    for (i in array.indices) {
        for (j in 0 until array.size - i - 1) {
            if (array[j + 1] < array[j]) {
                val temp = array[j + 1]
                array[j + 1] = array[j]
                array[j] = temp
            }
        }
    }
}

fun insertionSort(array: Array<Int>) {
    for (i in 1 until array.size) {
        val currentValue = array[i]
        var j = i - 1
        while (j >= 0 && array[j] > currentValue) {
            array[j + 1] = array[j]
            j--
        }
        array[j + 1] = currentValue
    }
}

fun mergeSort(array: Array<Int>) {

    if (array.size < 2) return

    // split the array into 2 half
    val middle = array.size / 2
    val leftHalf = Array<Int>(middle) { 0 }
    val rightHalf = Array<Int>(array.size - middle) { 0 }

    for (i in 0 until middle) {
        leftHalf[i] = array[i]
    }

    for (i in middle until array.size) {
        rightHalf[i - middle] = array[i]
    }

    // call mergeSort recursively
    mergeSort(leftHalf)
    mergeSort(rightHalf)

    // merge the sorted halfs
    merge(array, leftHalf, rightHalf)
    println()
}

private fun merge(mergedArray: Array<Int>, leftHalf: Array<Int>, rightHalf: Array<Int>) {
//    val mergedArray = Array<Int>(leftHalf.size + rightHalf.size) { 0 }
    var leftIndex = 0
    var rightIndex = 0
    var mergedIndex = 0

    while (leftIndex < leftHalf.size && rightIndex < rightHalf.size) {
        if (leftHalf[leftIndex] < rightHalf[rightIndex]) {
            mergedArray[mergedIndex] = leftHalf[leftIndex]
            leftIndex++
        } else {
            mergedArray[mergedIndex] = rightHalf[rightIndex]
            rightIndex++
        }
        mergedIndex++
    }

    // in case one of the arrays didn't reach the end
    while (leftIndex < leftHalf.size) {
        mergedArray[mergedIndex] = leftHalf[leftIndex]
        leftIndex++
        mergedIndex++
    }

    while (rightIndex < rightHalf.size) {
        mergedArray[mergedIndex] = rightHalf[rightIndex]
        rightIndex++
        mergedIndex++
    }
}