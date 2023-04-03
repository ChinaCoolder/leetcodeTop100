package FindFirstAndLastPositionOfElementInSortedArray

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
fun main() {
    println(
        searchRange(
            intArrayOf(
                5,7,7,8,8,10
            ),
            8
        ).contentToString()
    )
}

fun searchRange(nums: IntArray, target: Int): IntArray {
    val result = intArrayOf(-1, -1)
    if (nums.isNotEmpty()) {
        var left = 0
        var right = nums.lastIndex
        while (left <= right) {
            if (result[0] != -1 && result[1] != -1) {
                break
            }
            if (nums[left] == target) {
                result[0] = left
            }
            if (nums[right] == target) {
                result[1] = right
            }

            if (result[0] == -1) {
                left ++
            }
            if (result[1] == -1) {
                right --
            }
        }
    }

    return result
}