package SlidingWindowMaximum

import java.util.*


/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *  Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
fun main() {
    println(
        maxSlidingWindow(
            intArrayOf(
                1,3,1,2,0,5
            ),
            3
        ).contentToString()
    )
}

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    if (nums.size == 1) {
        return nums
    }
    val result = IntArray(nums.size - k + 1)
    var pResult = 0
    val queue = ArrayDeque<Int>()
    for (i in nums.indices) {
        while (queue.isNotEmpty() && queue.peek() < (i - k + 1)) {
            queue.poll()
        }
        while (queue.isNotEmpty() && nums[queue.peekLast()] < nums[i]) {
            queue.pollLast()
        }
        queue.offer(i)
        if (i >= k - 1) {
            result[pResult ++] = nums[queue.peek()]
        }
    }

    return result
}