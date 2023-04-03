package FindMedianFromDataStream

import java.util.*

/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 *
 * Example 1:
 *
 * Input
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * Output
 * [null, null, null, 1.5, null, 2.0]
 *
 * Explanation
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 */

fun main() {
    val medianFinder = MedianFinder()
    medianFinder.addNum(1)
    medianFinder.addNum(2)
    println(medianFinder.findMedian())
    medianFinder.addNum(3)
    println(medianFinder.findMedian())
}

class MedianFinder() {
    private val maxHeap = PriorityQueue<Int>(Collections.reverseOrder()) // 最大堆
    private val minHeap = PriorityQueue<Int>() // 最小堆

    fun addNum(num: Int) {
        maxHeap.offer(num) // 将元素加入最大堆

        minHeap.offer(maxHeap.poll()) // 将最大堆的堆顶元素加入最小堆
        if (maxHeap.size < minHeap.size) {
            maxHeap.offer(minHeap.poll()) // 如果最小堆元素数量多于最大堆，将最小堆的堆顶元素加入最大堆
        }
    }

    fun findMedian(): Double {
        return if (maxHeap.size == minHeap.size) {
            (maxHeap.peek() + minHeap.peek()) / 2.0 // 如果元素数量为偶数，返回两个堆的堆顶元素的平均值
        } else {
            maxHeap.peek().toDouble() // 如果元素数量为奇数，返回最大堆的堆顶元素
        }
    }

}