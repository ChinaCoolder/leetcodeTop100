package InvertBinaryTree

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Example 1:
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 *
 * Example 2:
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 *
 * Example 3:
 *
 * Input: root = []
 * Output: []
 */

fun main() {
    println(
        invertTree(
            TreeNode(2).apply {
                left = TreeNode(1)
                right = TreeNode(3)
            }
        )
    )
}

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    val left = invertTree(root.right)
    val right = invertTree(root.left)
    root.left = left
    root.right = right
    return root
}

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}