package ConstructBinaryTreePreorderInorderTraversal

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 *
 * Example 1:
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * Example 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */

fun main() {
    val result = buildTree(
        intArrayOf(3,9,20,15,7),
        intArrayOf(9,3,15,20,7)
    )
    println(
        result
    )
}

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    fun build(preStart: Int, preEnd: Int, inStart: Int, inEnd: Int): TreeNode? {
        if (preStart > preEnd) {
            return null
        }
        val treeNode = TreeNode(preorder[preStart])
        var index = 0
        for (i in inStart .. inEnd) {
            if (inorder[i] == treeNode.`val`) {
                index = i
                break
            }
        }
        val leftTreeSize = index - inStart
        treeNode.left = build(preStart + 1, preStart + leftTreeSize, inStart, index - 1)
        treeNode.right = build(preStart + 1 + leftTreeSize, preEnd, index + 1, inEnd)

        return treeNode
    }
    return build(0, preorder.size - 1, 0, inorder.size - 1)
}

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}