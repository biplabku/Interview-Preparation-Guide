import com.sun.source.tree.Tree;

import java.util.Stack;

public class TreeProblems {

    public TreeNode buildTree(int[] preorder, int [] inorder) {
        TreeNode root = addNode(preorder, 0, preorder.length - 1, inorder,
                0, inorder.length - 1);
        System.out.println(" Height of the tree is  -- > " + treeHeight(root));
        TreeNode t = greaterTree(root, 0);
        inOrder(t);
        return root;
    }

    public TreeNode greaterTree(TreeNode root, int sum) {
        if(root != null) {
            greaterTree(root.rightChild, sum);
            sum += root.data;
            root.data = sum;
            greaterTree(root.leftChild, sum);
        }
        return root;
    }


    public int treeHeight(TreeNode root) {
        if(root == null) {
            return -1;
        }
        int left = 1 + treeHeight(root.leftChild);
        int right = 1 + treeHeight(root.rightChild);
        return Math.max(left, right);
    }

    public void inOrder(TreeNode root) {
        if(root != null) {
            inOrder(root.leftChild);
            System.out.println(root.data);
            inOrder(root.rightChild);
        }
    }


    public boolean isUnivalued(TreeNode root) {
        boolean left = (root.leftChild == null || (root.data == root.leftChild.data
        && isUnivalued(root.leftChild)));
        boolean right = (root.rightChild == null || (root.data == root.rightChild.data
        && isUnivalued(root.rightChild)));

        return left && right;
    }


    public TreeNode addNode(int[] preorder, int prestart, int preend, int[]
            inorder, int instart, int inend) {
        if(prestart > preend) {
            return  null;
        }
        if(prestart == preend) {
            return new TreeNode(preorder[prestart]);
        }
        int idx = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[prestart]) {
                idx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(inorder[idx]);
        root.leftChild = addNode(preorder, prestart + 1,
                idx - instart + prestart, inorder, instart, idx - 1);
        root.rightChild = addNode(preorder, idx - instart + prestart + 1, preend,
                inorder, idx + 1, inend);
        return root;
    }

    public int sum = 0;
    public int findTilt(TreeNode root) {
        getTilt(root);
        return sum;
    }

    public int getTilt(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = getTilt(root.leftChild);
        int right = getTilt(root.rightChild);

        sum += Math.abs(left - right);
        return left + right + root.data;
    }

    int depth = Integer.MAX_VALUE;
    public int minimumDepth(TreeNode root) {
        minDepth(root);
        return depth;
    }
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = 1 + minimumDepth(root.leftChild);
        int right = 1 + minimumDepth(root.rightChild);
        if(left == 1) {
            return right;
        }else if(right == 1) {
            return left;
        }
        depth = Math.min(left, right);
        return depth;
    }


    public int fibonacci(int number) {
        if(number == 0 || number == 1) {
            return 1;
        }
        return number * fibonacci(number - 1);
    }

    public int result = 0;
    public int evaluateBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.leftChild == null && root.rightChild != null) {
            return root.data;
        }
        int left = evaluateBinaryTree(root.leftChild);
        int right = evaluateBinaryTree(root.rightChild);
        if(root.data == '+') {
            result = left + right;
        }else if(root.data == '-') {
            result = left - right;
        }else if(root.data == '*') {
            result = left * right;
        }else if(root.data == '/') {
            result = left/ right;
        }
        return result;

    }


    public boolean isSymmetric(TreeNode root) {
        return checkSymetric(root, root);
    }

    public boolean checkSymetric(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        boolean left = checkSymetric(root1.leftChild, root2.rightChild);
        boolean right = checkSymetric(root1.rightChild, root2.leftChild);
        return (root1.data == root2.data) && left && right;
    }

    public boolean checkSameTree(TreeNode root1, TreeNode root2) {
        return isSameTree(root1, root2);
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if((root1 == null && root2 != null) || (root1 != null && root2 == null) ) {
            return false;
        }

        boolean left = isSameTree(root1.leftChild, root2.leftChild);
        boolean right = isSameTree(root1.rightChild, root2.rightChild);
        boolean value = root1.data == root2.data;
        return value && left && right;
    }

    public int res = 0;
    public int diameterBinary(TreeNode root) {
        getLength(root);
        return res;
    }

    public int getLength(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = 1 + getLength(root.leftChild);
        int right = 1 + getLength(root.rightChild);

        res = Math.max(left + right, res);
        return Math.max(left, right);
    }


    public boolean checkWord(char[][] grid, String word) {
        boolean isSeen = false;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(word.charAt(0) == grid[i][j]) {
                    isSeen = dfsSearch(grid, word, i, j, 0);
                    if(isSeen == true) {
                        return true;
                    }
                }
            }
        }
        return isSeen;
    }

    public boolean dfsSearch(char[][] grid, String word, int i, int j, int k) {
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }

        if(grid[i][j] == word.charAt(k)) {
            char temp = grid[i][j];
            grid[i][j] = '#';
            if(k == word.length() - 1) {
                return true;
            }else if(dfsSearch(grid, word, i - 1, j, k + 1)
                || dfsSearch(grid, word, i + 1, j, k  +1)
            || dfsSearch(grid, word, i,  j - 1, k + 1)
            || dfsSearch(grid, word, i, j + 1, k + 1)) {
                return true;
            }
            grid[i][j] = temp;
        }
        return false;
    }


    public TreeNode isIncreasing(TreeNode root) {
        TreeNode node = getIncrease();
        return node;
    }
    public TreeNode resnode;
    public TreeNode getIncrease(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode left = getIncrease(root.leftChild);
        TreeNode right = getIncrease(root.rightChild);

        TreeNode cur = left;
        while(cur != null && cur.rightChild != null) {
            cur = cur.rightChild;
        }
        if(cur != null) {
            cur.rightChild = root;
        }
        root.leftChild = null;
        root.rightChild = right;

        return left != null ? left:root;

    }


























    public static void main(String[] args) {
        int[] arr = {3,9,20,15,7};
        int[] arr2 = {9,3,15,20,7};
        TreeProblems ts = new TreeProblems();

        char[][] grid = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}, {'a', 'b', 'c', 'b'}};
        System.out.println(ts.checkWord(grid,"sadle"));
    }
}
