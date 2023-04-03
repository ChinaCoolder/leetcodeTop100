package Permutations

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 *
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */

fun main() {
    println(
        permute(
            intArrayOf(1,2,3,4,5,6)
        )
    )
}

fun permute(nums: IntArray): List<List<Int>> {
    if (nums.size == 1) {
        return listOf(
            listOf(
                nums[0]
            )
        )
    }
    val list = permute(nums.drop(1).toIntArray())
    val first = nums[0]
    val result = mutableListOf<List<Int>>()
    list.forEach {ints ->
        for (i in 0 .. ints.size) {
            ints.toMutableList().apply {
                add(i, first)
                result.add(this.toList())
            }
        }
    }

    return result
}