package KthLargestElementInAnArray


/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * You must solve it in O(n) time complexity.
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 *
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
fun main() {
    println(
        findKthLargest(
            intArrayOf(
                3,2,3,1,2,4,5,5,6
            ),
            4
        )
    )
}

fun findKthLargest(nums: IntArray, k: Int): Int {
    fun quickSelect(low: Int, high: Int, k: Int): Int {
        var pivot = low

        fun swap(nums: IntArray, i: Int, j: Int) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        }

        for (j in low until high) {
            if (nums[j] <= nums[high]) {
                swap(nums, pivot++, j)
            }
        }
        swap(nums, pivot, high)

        val count = high - pivot + 1
        if (count == k) return nums[pivot]
        return if (count > k) quickSelect(pivot + 1, high, k)
        else quickSelect(low, pivot - 1, k - count)
    }
    return quickSelect(0, nums.lastIndex, k)
}

fun findKthLargest1(nums: IntArray, k: Int): Int {
    return nums.let {
        it.sortDescending()
        it[k - 1]
    }
}