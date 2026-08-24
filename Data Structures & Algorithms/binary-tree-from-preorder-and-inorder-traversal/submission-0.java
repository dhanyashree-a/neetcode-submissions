class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTree(
            preorder,
            0,
            preorder.length - 1,
            inorder,
            0,
            inorder.length - 1,
            inMap
        );
    }

    public TreeNode buildTree(
        int[] preorder,
        int preStart,
        int preEnd,
        int[] inorder,
        int inStart,
        int inEnd,
        Map<Integer, Integer> inMap
    ) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inMap.get(root.val);

        int numsLeft = inRoot - inStart;

        // LEFT
        root.left = buildTree(
            preorder,
            preStart + 1,
            preStart + numsLeft,
            inorder,
            inStart,
            inRoot - 1,
            inMap
        );

        // RIGHT
        root.right = buildTree(
            preorder,
            preStart + numsLeft + 1,
            preEnd,
            inorder,
            inRoot + 1,
            inEnd,
            inMap
        );

        return root;
    }
}