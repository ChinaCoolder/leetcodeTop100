package JumpGame

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */

fun main() {
    println(
        canJump(
            intArrayOf(5,9,3,2,1,0,2,3,3,1,0,0)
        )
    )
}

fun canJump(nums: IntArray): Boolean {
    if (nums.size == 1) {
        return true
    }
    if (nums.size == 2) {
        return nums[0] >= 1
    }
    val nearesttrue = BooleanArray(nums.size - 1)

    val `val` = nums[nums.size - 2]
    var nearesttrueindex: Int = nums.size - 1

    if (`val` > 0) {
        nearesttrue[nums.size - 2] = true
        nearesttrueindex = nums.size - 2
    }
    val zz: Int = nums.size - 3
    for (i in zz downTo 0) {
        val temp = nums[i]
        val temp2 = temp + i
        if (temp2 >= nums.size - 1 || temp2 >= nearesttrueindex) {
            nearesttrue[i] = true
            nearesttrueindex = i
            continue
        }
    }
    return nearesttrue[0]
}

fun canJump1(nums: IntArray): Boolean {
    if (nums.size == 1) {
        return true
    }
    var position = 0
    while (position < nums.size) {
        if (position == nums.lastIndex) {
            return true
        }
        if (nums[position] > 0) {
            position += nums[position]
        } else {
            var jumped = false
            for (i in position - 1 downTo 0) {
                if (nums[i] + i > position) {
                    position = nums[i] + i
                    jumped = true
                    break
                }
            }
            if (!jumped) {
                return false
            }
        }
    }
    return true
}