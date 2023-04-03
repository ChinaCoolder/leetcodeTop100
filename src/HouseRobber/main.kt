package HouseRobber

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 *
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
fun main() {
    println(
        rob(
            intArrayOf(
                2,7,9,3,1
            )
        )
    )
}

fun rob(nums: IntArray): Int {
    val dp = IntArray(nums.size)
    dp[0] = nums[0]
    for (i in 1 .. nums.lastIndex) {
        var mostRob = nums[i]
        for (j in 0 until i - 1) {
            val rob = dp[j] + nums[i]
            if (rob > mostRob) {
                mostRob = rob
            }
        }
        if (mostRob > dp[i - 1]) {
            dp[i] = mostRob
        } else {
            dp[i] = dp[i - 1]
        }
    }
    return dp.last()
}