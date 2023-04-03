package MaximumProductSubarray

/**
 * Given an integer array nums, find a
 * subarray
 *  that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
fun main() {
    println(
        maxProduct(
            intArrayOf(
                2,3,-2,4
            )
        )
    )
}

fun maxProduct(nums: IntArray): Int {
    // 初始化最大值和最小值
    var maxProduct = nums[0]
    var minProduct = nums[0]
    var result = maxProduct

    for (i in 1 until nums.size) {
        val current = nums[i]
        // 如果当前数是负数，最大值和最小值需要互换
        if (current < 0) {
            val temp = maxProduct
            maxProduct = minProduct
            minProduct = temp
        }
        // 计算最大值和最小值
        maxProduct = maxOf(current, maxProduct * current)
        minProduct = minOf(current, minProduct * current)
        // 更新结果
        result = maxOf(result, maxProduct)
    }
    return result
}