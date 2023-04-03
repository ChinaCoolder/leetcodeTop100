package MoveZeroes

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * Example 1:
 *
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [0]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 */
fun main() {
    val array = intArrayOf(0,1,0,3,12)
    println(
        array.contentToString()
    )
    moveZeroes(
        array
    )
    println(
        array.contentToString()
    )
}

fun moveZeroes(nums: IntArray) {
    if (nums.size == 1){
        return
    }
    fun swap(i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
    var zero = 0
    for (i in nums.indices) {
        if (nums[i] == 0) {
            zero ++
        } else if(zero != 0) {
            swap(i, i - zero)
        }
    }
}

fun moveZeroes1(nums: IntArray) {
    if (nums.size == 1){
        return
    }
    for (i in nums.indices) {
        if (nums[i] != 0) {
            var j = i
            while (j - 1 >= 0 && nums[j - 1] == 0){
                nums[j - 1] = nums[j]
                nums[j] = 0
                j --
            }
        }
    }
}