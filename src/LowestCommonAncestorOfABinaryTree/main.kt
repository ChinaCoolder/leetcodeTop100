package LowestCommonAncestorOfABinaryTree

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * Example 2:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 * Example 3:
 *
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 */
fun main() {
    val nodeq = TreeNode(4)
    val nodep = TreeNode(5).apply {
        left = TreeNode(6)
        right = TreeNode(2).apply {
            left = TreeNode(7)
            right = nodeq
        }
    }


    val result = lowestCommonAncestor(
        TreeNode(3).apply {
            left = nodep
            right = TreeNode(1).apply {
                left = TreeNode(0)
                right = TreeNode(8)
            }
        },
        nodep,
        nodeq
    )
    println(
        result
    )
}

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }

    if (root == p || root == q) {
        return root
    }
    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)
    return when {
        left == null -> right
        right == null -> left
        else -> root
    }
}

fun lowestCommonAncestor1(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    var set: MutableSet<TreeNode>? = null
    var result: TreeNode? = null
    fun find(node: TreeNode?, find: TreeNode?, list: MutableList<TreeNode>) {
        if (node == null) {
            return
        }
        if (node == find) {
            if (set != null) {
                list.add(node)
                for (i in list.lastIndex downTo 0) {
                    if (set!!.contains(list[i])) {
                        result = list[i]
                        break
                    }
                }
            } else {
                set = list.apply {
                    add(node)
                }.toHashSet()
            }
        } else {
            list.add(node)
            find(node.left, find, list)
            list.remove(node)

            list.add(node)
            find(node.right, find, list)
            list.remove(node)
        }
    }
    find(root, p, mutableListOf())
    find(root, q, mutableListOf())
    return result
}

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}