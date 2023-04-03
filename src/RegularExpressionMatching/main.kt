package RegularExpressionMatching

import java.util.Arrays

fun main() {
    println(isMatch("sdadadasdadadasdadaddads", ".*"))
}

fun isMatch(s: String, p: String): Boolean {
    val dp = Array(s.length + 1) {
        BooleanArray(p.length + 1)
    }
    dp[0][0] = true
    for (i in p.indices) {
        if (p[i] == '*' && dp[0][i - 1]) {
            dp[0][i + 1] = true
        }
    }
    for (i in s.indices) {
        for (j in p.indices) {
            dp[i + 1][j + 1] = if (p[j] == s[i] || p[j] == '.') {
                dp[i][j]
            } else if(p[j] == '*') {
                if (p[j - 1] == s[i] || p[j - 1] == '.') {
                    dp[i + 1][j] || dp[i + 1][j - 1] || dp[i][j + 1]
                } else {
                    dp[i + 1][j - 1]
                }
            } else {
                false
            }
        }
    }

    return dp[s.length][p.length]
}

fun isMatch1(s: String, p: String): Boolean {
    if (p.isEmpty())
        return s.isEmpty()
    val fistMath = s.isNotEmpty() && (s[0] == p[0] || p[0] == '.')
    return if (p.length > 1 && p[1] == '*')
        isMatch1(s, p.substring(2)) || (fistMath && isMatch1(s.substring(1), p))
    else
        fistMath && isMatch1(s.substring(1), p.substring(1))
}
