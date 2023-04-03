package LongestPalindrome

fun main() {
    println(longestPalindrome("cbbd"))
}

fun longestPalindrome(s: String): String {
    if(s.length == 1) {
        return s
    }
    var result = ""
    fun expandPalindrome(i: Int, j: Int) {
        var left = i
        var right = j
        while (left >= 0 && right < s.length && s[left] == s[right]) {
            left --
            right ++
        }
        if (right - left - 1 > result.length) {
            result = s.substring(left + 1, right)
        }
    }

    for (i in 0 until s.length - 1) {
        expandPalindrome(i, i)
        expandPalindrome(i, i + 1)
    }
    return result
}