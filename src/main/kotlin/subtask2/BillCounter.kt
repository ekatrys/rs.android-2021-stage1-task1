package subtask2

class BillCounter {

    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val annaNotEat = bill[k]
        val sum = bill.sum()
        val annaBill = (sum - annaNotEat) / 2

        return when {
            annaBill == b -> "Bon Appetit"
            annaBill < b -> (b - annaBill).toString()
            else -> "Brian not need return anythings"
        }

    }
}
