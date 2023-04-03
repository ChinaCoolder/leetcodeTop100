package LongestIncreasingSubsequence

/**
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * .
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 */

fun main() {
    println(
        lengthOfLIS(
            intArrayOf(
                7,7,7,7,7,7,7
            )
        )
    )
}

fun lengthOfLIS(nums: IntArray): Int {
    val dp = IntArray(nums.size)
    dp[0] = 1
    var result = 1
    for (i in 1 .. nums.lastIndex) {
        var longest = 1
        for(j in 0 until i) {
            if (nums[i] > nums[j]) {
                longest = longest.coerceAtLeast(dp[j] + 1)
            }
        }
        dp[i] = longest
        result = result.coerceAtLeast(longest)
    }
    return result
}