package DecodeString

import java.util.*

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 *
 * The test cases are generated so that the length of the output will never exceed 105.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 */
fun main() {
    println(
        decodeString(
            "3[z]2[2[y]pq4[2[jk]e1[f]]]ef"
        )
    )
}

fun decodeString(s: String): String {
    if(s.isEmpty()) {
        return ""
    }
    var num = 0
    val numStack = Stack<Int>()
    val wordStack = Stack<StringBuilder>()
    var word = StringBuilder()
    for (c in s) {
        when(c) {
            in '0'..'9' -> {
                num = num * 10 + (c - '0')
            }
            '[' -> {
                numStack.push(num)
                num = 0
                wordStack.push(word)
                word = StringBuilder()
            }
            ']' -> {
                val numTemp = numStack.pop()
                val wordTemp = wordStack.pop()
                for(i in 0 until numTemp) {
                    wordTemp.append(word)
                }
                word = wordTemp
            }
            else -> {
                word.append(c)
            }
        }
    }
    return word.toString()
}

fun decodeString1(s: String): String {
    var result = ""
    val intChar = charArrayOf(
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    )
    val stack = Stack<Char>()
    var left = 0
    var number = ""
    for (i in s.indices) {
        if (s[i] == '[') {
            number.forEach {
                stack.push(it)
            }
            stack.push(s[i])
            number = ""
            left ++
        }else if(s[i] == ']') {
            var sub = ""
            while (stack.peek() != '[') {
                sub = stack.pop() + sub
            }
            stack.pop()
            var subNumber = ""
            while (stack.isNotEmpty() && stack.peek() in intChar) {
                subNumber = stack.pop() + subNumber
            }
            for (j in 0 until subNumber.toInt()){
                sub.forEach { subChar ->
                    stack.push(subChar)
                }
            }
            left --
            if (left == 0) {
                var resultTemp = ""
                while (stack.isNotEmpty()) {
                    resultTemp = stack.pop() + resultTemp
                }
                result += resultTemp
            }
        } else {
            if (s[i] in intChar) {
                number += s[i]
            } else if (left != 0) {
                stack.push(s[i])
            } else {
                result += s[i]
            }
        }
    }
    return result
}