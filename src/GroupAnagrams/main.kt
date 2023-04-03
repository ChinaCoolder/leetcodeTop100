package GroupAnagrams

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 *
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 */
fun main() {
    println(
        groupAnagrams(
            arrayOf(
                "eat","tea","tan","ate","nat","bat"
            )
        )
    )
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val result = mutableListOf<MutableList<String>>()
    val map = hashMapOf<String, Int>()
    for (i in strs.indices) {
        val key = String(
            strs[i].toCharArray().apply {
                sort()
            }
        )
        if (!map.contains(key)) {
            val list = mutableListOf(strs[i])
            result.add(list)
            map[key] = result.size - 1
        } else {
            result[map[key]!!].add(strs[i])
        }
    }

    return result
}

fun groupAnagrams1(strs: Array<String>): List<List<String>> {
    if (strs.isEmpty()) {
        return listOf()
    } else if(strs.size == 1) {
        return listOf(
            listOf(
                strs[0]
            )
        )
    }

    fun String.charCompare(other: String): Boolean {
        val array = this.toCharArray().sortedArray()
        val otherArray = other.toCharArray().sortedArray()
        if (array.size != otherArray.size) {
            return false
        } else {
            for (i in array.indices) {
                if (array[i] != otherArray[i]) {
                    return false
                }
            }
            return true
        }
    }

    val result = mutableListOf<MutableList<String>>()
    for(i in strs.indices) {
        val str = strs[i]

        var added = false
        for (j in result.indices) {
            if (result[j][0].length == str.length && result[j][0].charCompare(str)) {
                added = true
                result[j].add(str)
                break
            }
        }
        if (!added) {
            result.add(mutableListOf(str))
        }
    }

    return result
}