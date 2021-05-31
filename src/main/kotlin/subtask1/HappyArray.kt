package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        var array = sadArray.toMutableList()
        var isArrayHappy = false

        while (!isArrayHappy) {
            val arrayNext = createHappyArray(array)
            if (arrayNext.size != array.size) array = arrayNext
            else isArrayHappy = true
        }
        return array.toIntArray()
    }

    private fun createHappyArray(
        array: MutableList<Int>
    ): MutableList<Int> {
        val happyArray = mutableListOf<Int>()
        happyArray.add(array[0])
        for (i in 1 until array.size) {
            val summ = array[i - 1] + array[i + 1]
            if (array[i] > summ) happyArray.add(array[i])
        }
        happyArray.add(array.last())
        return happyArray
    }
}