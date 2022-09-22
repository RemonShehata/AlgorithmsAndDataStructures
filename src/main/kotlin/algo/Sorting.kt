package algo

//fun <T : Comparable<T>> bubbleSort(collection: Collection<T>): Collection<T> {
//    val sortedCollection: Collection<T> = Collection<T>()
//    collection.forEach {
//
//    }
//}

// TODO: implement generic function
fun bubbleSort(list: Array<Int>){
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