package LetterCombinations

fun main () {
    println(letterCombinations("23"))
}

fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty())
        return listOf()
    val map = hashMapOf<String, String>().apply {
        put("2", "abc")
        put("3", "def")
        put("4", "ghi")
        put("5", "jkl")
        put("6", "mno")
        put("7", "pqrs")
        put("8", "tuv")
        put("9", "wxyz")
    }
    val temp = map[digits[0].toString()]!!
    if (digits.length == 1) {
        return temp.toList().map { it.toString() }
    }
    val list = letterCombinations(digits.drop(1))
    val result = mutableListOf<String>()
    for (i in temp.indices) {
        list.forEach {
            result.add("${temp[i]}${it}")
        }
    }
    return result
}