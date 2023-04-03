package TopKFrequentElements

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 */
fun main() {
    println(
        topKFrequent(
            intArrayOf(
                4,1,-1,2,-1,2,3
            ),
            2
        ).contentToString()
    )
}

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    nums.forEach {
        map[it] = if (map.contains(it)) map[it]!! + 1 else 1
    }
    return map.keys.sortedBy {
        -map[it]!!
    }.subList(0, k).toIntArray()
}