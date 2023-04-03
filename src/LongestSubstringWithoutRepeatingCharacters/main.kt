package LongestSubstringWithoutRepeatingCharacters


fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
}

fun lengthOfLongestSubstring(s: String): Int {
    var store = ""
    var windowLeft = 0
    var longest = 0
    for (windowRight in s.indices) {
        val target = s[windowRight]
        while (store.contains(target)) {
            store = store.drop(1)
            windowLeft += 1
        }
        store += target
        longest = longest.coerceAtLeast(windowRight - windowLeft + 1)
    }
    return longest
}