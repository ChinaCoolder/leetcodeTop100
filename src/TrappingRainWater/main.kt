package TrappingRainWater


/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 * Constraints:
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */

fun main() {
    println(
        trap(
            intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)
        )
    )
}

fun trap(height: IntArray): Int {
    var start = 0
    var end = height.size - 1
    var leftMax = height[0]
    var rightMax = height[height.size - 1]
    var result = 0
    while (start < end) {
        if (leftMax < rightMax) {
            start ++
            leftMax = Math.max(leftMax, height[start])
            result += leftMax - height[start]
        } else {
            end --
            rightMax = Math.max(rightMax, height[end])
            result += rightMax - height[end]
        }
    }

    return result
}