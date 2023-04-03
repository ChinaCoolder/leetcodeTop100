package SortColors

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 *
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 */

fun main() {
    val nums = intArrayOf(
        2,0,1
    )
    sortColors(nums)
    println(nums.contentToString())
}

fun sortColors(nums: IntArray) {
    fun swap(first: Int, second: Int) {
        val temp = nums[first]
        nums[first] = nums[second]
        nums[second] = temp
    }

    var p0 = 0
    var p1 = 0
    var p2 = nums.size - 1
    while (p1 <= p2) {
        if (nums[p1] == 0) {
            swap(p0, p1)
            p0 ++
            p1 ++
        } else if (nums[p1] == 1) {
            p1 ++
        } else {
            swap(p1, p2)
            p2 --
        }
    }
}