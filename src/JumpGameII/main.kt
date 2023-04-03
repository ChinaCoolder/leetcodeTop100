package JumpGameII

import java.util.*

/**
 *  You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * It's guaranteed that you can reach nums[n - 1].
 */
fun main() {
    println(
        jump(
            intArrayOf(
                2,3,0,1,1,2
            )
        )
    )
}

fun jump(nums: IntArray): Int {
    if (nums.size == 1) {
        return 0
    }
    val visited = BooleanArray(nums.size)
    val queue = LinkedList<Int>()

    visited[0] = true
    queue.offer(0)
    var jumped = 0

    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val cur = queue.poll()
            for (j in 1 .. nums[cur]) {
                val target = cur + j
                if (target >= nums.lastIndex) {
                    return jumped + 1
                } else if(!visited[target]) {
                    queue.offer(target)
                    visited[target] = true
                }
            }
        }
        jumped ++
    }

    return jumped
}

fun jump1(nums: IntArray): Int {
    if (nums.size == 1) {
        return 0
    }

    var jumped = 0
    var position = 0
    while (position < nums.size) {
        if (position + nums[position] >= nums.lastIndex) {
            return jumped + 1
        }
        jumped ++
        val target = position + nums[position]
        var largeStepPosition = target
        for (i in target downTo position + 1) {
            val nextTarget = i + nums[i]
            if (nextTarget >= nums.lastIndex) {
                return jumped + 1
            } else if (nums[nextTarget] != 0 && nextTarget > (nums[largeStepPosition] + largeStepPosition)) {
                largeStepPosition = i
            }
        }
        position = largeStepPosition
    }
    return jumped
}