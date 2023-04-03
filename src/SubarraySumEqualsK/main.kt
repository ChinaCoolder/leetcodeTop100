package SubarraySumEqualsK

/**
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
fun main() {
    println(
        subarraySum(
            intArrayOf(-1,-1,1),
            0
        )
    )
}

fun subarraySum(nums: IntArray, k: Int): Int {
    var count = 0
    var sum = 0
    val map = mutableMapOf<Int, Int>()
    map[0] = 1

    for (i in nums.indices) {
        sum += nums[i]
        if (map.containsKey(sum - k)) {
            count += map[sum - k]!!
        }
        map[sum] = map.getOrDefault(sum, 0) + 1
    }

    return count
}