package FlattenBinaryTreeToLinkedList

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 * Example 1:
 *
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 *
 * Example 2:
 *
 * Input: root = []
 * Output: []
 *
 * Example 3:
 *
 * Input: root = [0]
 * Output: [0]
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */

fun main() {
    val node = TreeNode(1).apply {
        left = TreeNode(2)
    }
    flatten(node)
    println(
        node
    )
}

fun flatten(root: TreeNode?) {
    fun flat(node: TreeNode?): TreeNode? {
        if (node == null) {
            return null
        } else if(node.left == null && node.right == null) {
            return node
        }
        val left = flat(node.left)
        val right = flat(node.right)
        if (left != null && right != null) {
            var p = left
            while (p?.right != null) {
                p = p.right
            }
            p?.right = right
            node.left = null
            node.right = left
        } else if (right == null) {
            node.right = left
            node.left = null
        }
        return node
    }
    flat(root)
}

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}