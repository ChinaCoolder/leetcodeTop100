package MajorityElement

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 */
fun main() {
    println(
        majorityElement(
            intArrayOf(
                2,2,1,1,1,2,2
            )
        )
    )
}

fun majorityElement(nums: IntArray): Int {
    val hash = hashMapOf<Int, Int>()
    var result = nums[0]
    var biggest = 1
    nums.forEach {
        if (hash[it] == null) {
            hash[it] = 1
        } else {
            hash[it] = hash[it]!! + 1
        }
        if (hash[it]!! > biggest) {
            biggest  = hash[it]!!
            result = it
        }
    }
    return result
}