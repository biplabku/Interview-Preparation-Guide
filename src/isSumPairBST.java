import java.util.HashSet;

public class isSumPairBST {

    public boolean findTarget(TreeNode root, int target) {
        HashSet<Integer> hset = new HashSet<>();
        return findSumPair(root, hset, target);
    }

    public boolean findSumPair(TreeNode root, HashSet<Integer> hset, int target) {
        if(root == null) {
            return false;
        }
        if(hset.contains(target - root.data)) {
            return true;
        }
        hset.add(root.data);
        return (findSumPair(root.leftChild, hset, target) || findSumPair(root.rightChild, hset, target));
    }

    public static void main(String[] args) {
        
    }
}
