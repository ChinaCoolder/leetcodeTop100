package ThreeSum

fun main() {
    println(threeSum(
        intArrayOf(-1,0,1,2,-1,-4)
    ))
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableSetOf<List<Int>>()
    nums.sort()
    for(i in 0 until nums.size - 2) {
        var j = i + 1
        var k = nums.size - 1
        while (j < k) {
            val sum = nums[i] + nums[j] + nums[k]
            if (sum == 0) {
                result.add(listOf(nums[i], nums[j ++], nums[k --]))
            } else if (sum < 0){
                j ++
            } else {
                k --
            }
        }
    }
    return result.toList()
}