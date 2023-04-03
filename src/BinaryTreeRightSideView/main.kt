package BinaryTreeRightSideView

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example 1:
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 *
 * Example 2:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
 *
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
fun main() {
    println(
        rightSideView(
            TreeNode(1).apply {
                left = TreeNode(2).apply {
                    right = TreeNode(5)
                }
                right = TreeNode(3).apply {
                    right = TreeNode(4)
                }
            }
        )
    )
}

fun rightSideView(root: TreeNode?): List<Int> {
    if (root == null) {
        return listOf()
    } else if(root.left == null && root.right == null) {
        return listOf(root.`val`)
    }
    val left = rightSideView(root.left)
    val right = rightSideView(root.right)
    return if (left.size > right.size) {
        val result = left.toMutableList().apply {
            add(0, root.`val`)
        }
        right.forEachIndexed { index, i ->
            result[index + 1] = i
        }
        result
    } else {
        right.toMutableList().apply {
            add(0, root.`val`)
        }
    }
}

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}