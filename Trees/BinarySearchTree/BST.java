import java.util.*;



class BinarySearchTree {
    TreeNode root;

    BinarySearchTree(int data) {
        this.root = new TreeNode(data);
    }

    public TreeNode getRoot() {
        return root;
    }

    private void inOrder(TreeNode root, List<Integer> inorderList) {
        if (root == null)
            return;
        inOrder(root.left, inorderList);
        inorderList.add(root.data);
        inOrder(root.right, inorderList);
    }

    private TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    private TreeNode search(TreeNode root, int data) {
        if (root == null || root.data == data) {
            return root;
        }
        if (data < root.data)
            return search(root.left, data);
        else
            return search(root.right, data);
    }

    private int min(TreeNode root){
        if(root.left==null) return root.data;
        return min(root.left);
    }
    

    private TreeNode delete(TreeNode root, int data) {
        if (root == null)
            return root;

        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.right == null)
                return root.left;
            else if (root.left == null)
                return root.right;
            else {
                root.data = min(root.right);
                root.right = delete(root.right, root.data);
            }
        }
        return root;
    }

    public TreeNode insert(int data) {
        return insert(root, data);
    }

    public TreeNode search(int data) {
        return search(root, data);
    }

    public List<Integer> inOrder() {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    public TreeNode delete(int data) {
        return delete(root, data);
    }
}

public class BST {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(100);

        bst.insert(50);
        bst.insert(200);
        bst.insert(45);

        List<Integer> inorder = new ArrayList<>();
        inorder = bst.inOrder();
        System.out.println("Inorder(sorted): " + inorder);

        TreeNode search = bst.search(100);
        System.out.println(search);

    }
}
