package MergeIntervals

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 *
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */

fun main() {
    val result = merge1(
        arrayOf(
            intArrayOf(
                2,3
            ),
            intArrayOf(
                5,5
            ),
            intArrayOf(
                2,2
            ),
            intArrayOf(
                3,4
            ),
            intArrayOf(
                3,4
            )
        )
    )
    println(
        result
    )
}

fun merge1(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.size == 1)
        return intervals

    intervals.sortBy {
        it[1]
    }

    val result = intervals.toMutableList()

    var working = result.last()
    var i = result.size - 2
    while (i >= 0) {
        val merge = result[i]
        if (
            (working[1] >= merge[0] && working[1] <= merge[1]) ||
            (merge[1] >= working[0] && merge[1] <= working[1])
        ) {
            working[0] = working[0].coerceAtMost(merge[0])
            working[1] = working[1].coerceAtLeast(merge[1])
            result.removeAt(i)
        } else {
            working = merge
        }
        i --
    }
    return result.toTypedArray()
}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.size == 1)
        return intervals

    val result = intervals.toMutableList()
    var i = 0
    while (i < result.size) {
        val working = result[i]
        var j = i + 1
        while (j < result.size) {
            val merge = result[j]
            if (
                (working[1] >= merge[0] && working[1] <= merge[1]) ||
                (merge[1] >= working[0] && merge[1] <= working[1])
            ) {
                working[0] = working[0].coerceAtMost(merge[0])
                working[1] = working[1].coerceAtLeast(merge[1])
                result.removeAt(j)
                j = i + 1
            } else {
                j ++
            }
        }
        i ++
    }
    return result.toTypedArray()
}