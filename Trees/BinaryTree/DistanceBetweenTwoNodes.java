import java.util.*;
public class DistanceBetweenTwoNodes {

    public static  boolean isNodeExist(TreeNode root,TreeNode p){
        if(root == null) return false;
        if(root == p ) return true;
        return isNodeExist(root.left,p) || isNodeExist(root.right, p);
    }

    public static int findDistance(TreeNode root,TreeNode p, TreeNode q){
        if (root == null) return -1;
        if(root==p || root == q) return 1;

        int left = findDistance(root.left, p, q);
        int right = findDistance(root.right,p,q);

        if (left!=0 && right!=0){
            return 1+left+right;
        }

        return (left!=0)? 1+left : 1+right;
    }
    public static void main(String[] args) {
        List<Integer> levelOrderOfTree = Arrays.asList(50,20,79,10,25,60,90,9,11,null,null,55,null,80);
        BinaryTree tree = new BinaryTree(levelOrderOfTree);

        TreeNode root = tree.getTree();

        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        BinaryTreeTraversal.levelOrder(root, levels);
        System.out.println(levels);
        System.out.println(findDistance(root, root.left.left.left, root.left.right));
    }

    
}
