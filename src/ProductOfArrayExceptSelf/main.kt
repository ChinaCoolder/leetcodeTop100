package ProductOfArrayExceptSelf

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */

fun main() {
    println(
        productExceptSelf(
            intArrayOf(-1,1,0,-3,3)
        ).contentToString()
    )
}

fun productExceptSelf(nums: IntArray): IntArray {
    val resultNext = IntArray(nums.size)
    resultNext[resultNext.lastIndex] = 1
    for (i in resultNext.lastIndex - 1 downTo 0) {
        resultNext[i] = nums[i + 1] * resultNext[i + 1]
    }
    val resultPre = IntArray(nums.size)
    resultPre[0] = 1
    for (i in 1 .. resultPre.lastIndex) {
        resultPre[i] = nums[i - 1] * resultPre[i - 1]
    }
    for (i in 0 .. resultNext.lastIndex) {
        resultNext[i] *= resultPre[i]
    }
    return resultNext
}