package MaximumDepthBinaryTree

/**
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
fun main() {
    println(
        maxDepth(
            null
        )
    )
}

fun maxDepth(root: TreeNode?): Int {
    return if (root == null) {
        0
    } else if (root.left == null && root.right == null) 1
    else {
        val leftDepth = maxDepth(root.left)
        val rightDepth = maxDepth(root.right)
        1 + if (leftDepth > rightDepth) leftDepth else rightDepth
    }
}

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}