package ContainerWithMostWater

fun main() {
    println(
        maxArea(
            intArrayOf(
                9,8,6,2,5,4,8,3,9
            )
        )
    )
}

fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var result = 0
    while (left < right) {
        val leftVal = height[left]
        val rightVal = height[right]
        result = result.coerceAtLeast((right - left) * Math.min(leftVal, rightVal))
        if (leftVal == rightVal) {
            left ++
            right --
        } else if (leftVal < rightVal) {
            left ++
        } else {
            right --
        }
    }
    return result
}