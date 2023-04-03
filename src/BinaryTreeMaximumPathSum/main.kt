package BinaryTreeMaximumPathSum

import kotlin.math.max

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 * Example 1:
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 *
 * Example 2:
 *
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -1000 <= Node.val <= 1000
 *
 */

fun main() {
    println(
        maxPathSum(
            TreeNode(1).apply {
                left = TreeNode(2)
            }
        )
    )

    println(
        maxPathSum(
            TreeNode(-10).apply {
                left = TreeNode(9)
                right = TreeNode(20).apply {
                    left = TreeNode(15)
                    right = TreeNode(7)
                }
            }
        )
    )

    println(
        maxPathSum(
            TreeNode(1).apply {
                left = TreeNode(-2).apply {
                    left = TreeNode(1).apply {
                        left = TreeNode(-1)
                    }
                    right = TreeNode(3)
                }
                right = TreeNode(-3).apply {
                    left = TreeNode(-2)
                }
            }
        )
    )
}

fun maxPathSum(root: TreeNode?): Int {
    if (root?.left == null && root?.right == null) {
        return root!!.`val`
    }
    var result = Int.MIN_VALUE
    fun add(node: TreeNode?): TreeNode? {
        if (node == null) {
            return null
        }
        if(node.left == null && node.right == null) {
            result = result.coerceAtLeast(node.`val`)
            return node
        }
        val left = add(node.left)
        val right = add(node.right)
        var max = Int.MIN_VALUE
        max = max.coerceAtLeast(node.`val`)
        var leftRightMax = Int.MIN_VALUE
        if (left != null) {
            max = max.coerceAtLeast(left.`val`)
            max = max.coerceAtLeast(node.`val` + left.`val`)
            leftRightMax = leftRightMax.coerceAtLeast(left.`val`)
        }
        if (right != null) {
            max = max.coerceAtLeast(right.`val`)
            max = max.coerceAtLeast(node.`val` + right.`val`)
            leftRightMax = leftRightMax.coerceAtLeast(right.`val`)
        }
        if (left != null && right != null) {
            max = max.coerceAtLeast(node.`val` + left.`val` + right.`val`)
        }
        result = result.coerceAtLeast(max)
        if (leftRightMax > 0) {
            node.`val` += leftRightMax
        }
        return node
    }
    add(root)
    return result
}

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}