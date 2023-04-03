package FindMedianSortedArrays

fun main() {
    println(
        findMedianSortedArrays(
            intArrayOf(1,2),
            intArrayOf(3, 4)
        )
    )
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val fullSize = nums1.size + nums2.size
    val mid: Float = (fullSize.toFloat() / 2)
    val odd = fullSize % 2 == 1
    val end = mid.toInt()
    var p = 0
    var p1 = 0
    var p2 = 0
    var endValue1 = 0
    var endValue2 = 0
    while (p <= end) {
        val value1 = if (nums1.size > p1) nums1[p1] else Int.MAX_VALUE
        val value2 = if (nums2.size > p2) nums2[p2] else Int.MAX_VALUE
        if (value1 < value2) {
            endValue1 = endValue2
            endValue2 = value1
            p1 += 1
        } else {
            endValue1 = endValue2
            endValue2 = value2
            p2 += 1
        }
        p += 1
    }

    return if (odd) endValue2.toDouble() else (endValue1 + endValue2).toDouble() / 2
}