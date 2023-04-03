package ValidParentheses

import java.util.Stack

fun main() {
    println(isValid("()[]{}}"))
    println(isValid("{()[]{}}"))
}

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    s.forEach { c ->
        when(c) {
            '(', '[', '{' -> stack.push(c)
            ')' -> {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false
                } else {
                    stack.pop()
                }
            }
            ']' -> {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false
                } else {
                    stack.pop()
                }
            }
            '}' -> {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false
                } else {
                    stack.pop()
                }
            }
        }
    }
    return stack.isEmpty()
}