package FindMinimuminRotatedSortedArray

fun main() {
    println(
        findMin(
            intArrayOf(
                3,4,5,1,2
            )
        )
    )
}

fun findMin(nums: IntArray): Int {
    if (nums[nums.lastIndex] > nums[0]) {
        return nums[0]
    }
    for (i in nums.lastIndex downTo 1) {
        if (nums[i] < nums[i - 1]) {
            return nums[i]
        }
    }
    return nums[0]
}