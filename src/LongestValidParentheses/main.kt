package LongestValidParentheses

import java.util.*

/**
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
 * substring
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 *
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 *
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 */

fun main() {
    println(
        longestValidParentheses("()(())")
    )
}

fun longestValidParentheses(s: String): Int {
    val stack = Stack<Int>()
    val list = mutableListOf<Int>()
    s.forEachIndexed { index, c ->
        if (c == '(') {
            stack.push(index)
        } else if (stack.isNotEmpty()) {
            list.add(stack.pop())
            list.add(index)
        }
    }
    list.sort()
    var result = 0
    var temp = 0
    for (i in list.indices) {
        if (i == 0 || list[i] == list[i - 1] + 1) {
            temp ++
        } else {
            result = result.coerceAtLeast(temp)
            temp = 1
        }
    }
    return result.coerceAtLeast(temp)

//    val leftParenthesesStack = LinkedList<Int>()
//    var max = 0
//    val prePairLeft = IntArray(s.length){-1}
//    val prePairRight = IntArray(s.length){-1}
//
//    for (i in s.indices){
//        if (s[i]=='(') leftParenthesesStack.offer(i)
//        else{
//            val idx = leftParenthesesStack.pollLast()
//            idx?.let {
//                prePairLeft[idx] = i
//                prePairRight[i] = idx
//                //right after pre pair
//                if (idx>0 && prePairRight[idx-1]>-1) {
//                    //concat two pairs
//                    prePairRight[i]=prePairRight[idx-1]
//                    max = Math.max(max, i-prePairRight[idx-1]+1)
//                }else if (prePairLeft[idx+1]>-1){
//                    //wrap around previous pair
//                    max = Math.max(max, i-idx+1)
//                }else{
//                    max = Math.max(max, i-idx+1)
//                }
//            }
//        }
//    }

//    return max
}

fun longestValidParentheses1(s: String): Int {
    if (s.isEmpty() || s.length == 1) return 0
    return if (isValid(s))
        s.length
    else {
        val left = longestValidParentheses1(s.drop(1))
        val right = longestValidParentheses1(s.dropLast(1))
        left.coerceAtLeast(right)
    }
}

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    s.forEach {
        if (it == '(') {
            stack.push(it)
        } else {
            if (stack.isEmpty()) {
                return false
            } else {
                stack.pop()
            }
        }
    }
    return stack.isEmpty()
}