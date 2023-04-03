package CourseSchedule

import java.util.*

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
fun main() {
    println(
        canFinish(
            100,
            arrayOf(
                intArrayOf(
                    1,0
                ),
                intArrayOf(
                    2,0
                ),
                intArrayOf(
                    2,1
                ),
                intArrayOf(
                    3,1
                ),
                intArrayOf(
                    3,2
                )
            )
        )
    )
}


fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    // 建立入度表
    val inDegree = IntArray(numCourses)
    // 建立图
    val graph = Array(numCourses) { mutableListOf<Int>() }
    for (pre in prerequisites) {
        inDegree[pre[0]]++
        graph[pre[1]].add(pre[0])
    }
    // 将所有入度为0的点加入队列中
    val queue = LinkedList<Int>()
    for (i in 0 until numCourses) {
        if (inDegree[i] == 0) {
            queue.offer(i)
        }
    }
    // 拓扑排序
    var count = 0
    while (queue.isNotEmpty()) {
        val course = queue.poll()
        count++
        for (next in graph[course]) {
            if (--inDegree[next] == 0) {
                queue.offer(next)
            }
        }
    }
    // 判断是否可以完成所有课程
    return count == numCourses
}

fun canFinish1(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    if (
        prerequisites.isEmpty() ||
        prerequisites.size == 1 ||
        numCourses == 1
    ) {
        return true
    }

    val hash = hashMapOf<Int, MutableList<Int>>()
    prerequisites.forEach {
        if (it[1] == it[0]) {
            return false
        }
        hash[it[0]] = (if (hash[it[0]] == null) mutableListOf() else hash[it[0]]!!).apply {
            add(it[1])
        }
    }

    fun dfs(pre: List<Int>, classSet: MutableSet<Int>): Boolean {
        var result = true
        pre.forEach {
            if (!result) {
                return false
            }
            if (classSet.contains(it)) {
                return false
            }
            if (hash[it] != null) {
                classSet.add(it)
                result = dfs(hash[it]!!, classSet)
                classSet.remove(it)
            }
        }
        return result
    }

    var result = true

    prerequisites.forEach {
        if (!result) {
            return false
        }
        result = dfs(listOf(it[1]), mutableSetOf(it[0]))
    }

    return true
}