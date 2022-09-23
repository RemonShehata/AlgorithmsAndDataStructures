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