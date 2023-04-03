package KthSmallestElementInABST

import com.sun.jmx.remote.internal.ArrayQueue

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 */
fun main() {
    println(
        kthSmallest(
            TreeNode(5).apply {
                left = TreeNode(3).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1)
                    }
                    right = TreeNode(4)
                }
                right = TreeNode(6)
            },
            6
        )
    )
}

fun kthSmallest(root: TreeNode?, k: Int): Int {
    var result = -1

    fun getCount(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }
        val left = getCount(node.left)
        val right = getCount(node.right)
        return left + right + 1
    }

    fun dfs(node: TreeNode?, index: Int) {
        if (node == null) {
            return
        } else if(result != -1) {
            return
        }
        val left = getCount(node.left)
        if (index + left + 1 == k) {
            result = node.`val`
        } else if(index + left + 1 > k) {
            dfs(node.left, index)
        } else {
            dfs(node.right, index + left + 1)
        }
    }
    dfs(root, 0)
    return result
}

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}