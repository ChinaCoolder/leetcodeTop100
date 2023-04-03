package DiameterOfBinaryTree

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * Example 2:
 *
 * Input: root = [1,2]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -100 <= Node.val <= 100
 */
fun main() {
    println(
        diameterOfBinaryTree(
            TreeNode(1).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(4)
                    right = TreeNode(5)
                }
                right = TreeNode(3)
            }
        )
    )
}

fun diameterOfBinaryTree(root: TreeNode?): Int {
    var result = 0
    fun depth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val left = depth(root.left)
        val right = depth(root.right)
        result = result.coerceAtLeast(left + right)
        return left.coerceAtLeast(right) + 1
    }
    depth(root)
    return result
}

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}