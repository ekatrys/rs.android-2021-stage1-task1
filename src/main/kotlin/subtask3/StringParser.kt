package subtask3

class StringParser {

    fun getResult(inputString: String): Array<String> {
        val regex = Regex("\\<|\\[|\\(|\\>|\\]|\\)")
        var matchResult = regex.find(inputString)

        val result = ArrayList<String>()

        while (null != matchResult) {
            when (matchResult.value) {
                "<" -> addIfFound(inputString, matchResult, "<", ">", result)
                "[" -> addIfFound(inputString, matchResult, "[", "]", result)
                "(" -> addIfFound(inputString, matchResult, "(", ")", result)
            }
            matchResult = matchResult.next()
        }

        return result.toTypedArray()
    }

    private fun addIfFound(inputString: String, mr: MatchResult?, openBracket: String, closeBracket: String, result: ArrayList<String>) {
        var matchResult = mr?.next()
        var nesting = 0

        while (null != matchResult) {
            when (matchResult.value) {
                openBracket -> nesting++
                closeBracket -> if (0 == nesting) {
                    result.add(inputString.substring(mr!!.range.start + 1, matchResult.range.start))
                    return
                } else {
                    nesting--
                }
            }
            matchResult = matchResult.next()
        }
    }
}
