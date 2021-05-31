package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        val size = sadArray.size
        if(size < 3){
            return sadArray
        }

        val happyIndices = ArrayList<Int>()
        happyIndices.add(0)

        for(i in 1..size - 2) {
            if(sadArray[i-1] + sadArray[i+1] >= sadArray[i]) {
                happyIndices.add(i)
            }
        }

        happyIndices.add(size-1)

        val result = sadArray.sliceArray(happyIndices)

        if(happyIndices.size == size) {
            return result
        }

        return convertToHappy(result)
    }
}