package TwoSum

fun main() {
    println(
        twoSum(
            intArrayOf(
                2, 7, 11, 15
            ),
            9
        ).contentToString()
    )

    println(
        twoSum(
            intArrayOf(
                3, 2, 4
            ),
            6
        ).contentToString()
    )
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    for (i in nums.indices) {
        for (j in (i + 1) until nums.size) {
            if (nums[j] == target - nums[i]) {
                return intArrayOf(i, j)
            }
        }
    }
    throw IllegalArgumentException()
}