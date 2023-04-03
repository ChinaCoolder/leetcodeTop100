package BinaryTreeLevelOrderTraversal

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 * Example 1:
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 *
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 *
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */

fun main() {
    println(
        levelOrder(
            TreeNode(3).apply {
                left = TreeNode(9)
                right = TreeNode(20).apply {
                    left = TreeNode(15)
                    right = TreeNode(7)
                }
            }
        )
    )
}

fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) {
        return listOf()
    }
    if (root.left == null && root.right == null) {
        return mutableListOf<List<Int>>().apply {
            this.add(listOf(root.`val`))
        }
    }

    val result = mutableListOf<MutableList<Int>>()
    fun into(node: TreeNode?, level: Int) {
        if (node == null) {
            return
        }
        if (result.size == level) {
            result.add(mutableListOf())
        }
        result[level].add(node.`val`)
        into(node.left, level + 1)
        into(node.right, level + 1)
    }
    into(root, 0)
    return result
}

fun levelOrder1(root: TreeNode?): List<List<Int>> {
    if (root == null) {
        return listOf()
    }
    if (root.left == null && root.right == null) {
        return mutableListOf<List<Int>>().apply {
            this.add(listOf(root.`val`))
        }
    }
    val result = hashMapOf<Int, List<Int>>()
    fun into(node: TreeNode?, deep: Int) {
        if (node == null) {
            return
        }
        if (!result.contains(deep)) {
            result[deep] = listOf()
        }
        result[deep] = result[deep]!!.toMutableList().apply {
            add(node.`val`)
        }
        into(node.left, deep + 1)
        into(node.right, deep + 1)
    }
    into(root, 0)
    return result.map {
        it.value
    }
}

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}