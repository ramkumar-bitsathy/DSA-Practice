import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTree {
    TreeNode tree;

    /*public void formBinaryTree(TreeNode root,List<Integer> list,int i,int size){
        if (i >= size || list.get(i) == null) return; 

        root.data = list.get(i); 

        if (2 * i + 1 < size && list.get(2 * i + 1) != null) {
            root.left = new TreeNode(0); 
            formBinaryTree(root.left, list, 2 * i + 1, size);
        }
        if (2 * i + 2 < size && list.get(2 * i + 2) != null) {
            root.right = new TreeNode(0); 
            formBinaryTree(root.right, list, 2 * i + 2, size);
        }  
    }*/

    public void formBinaryTree(){

    }
    BinaryTree(List<Integer> list){
        
        
        if (list.isEmpty() || list.get(0) == null) return; // Handle empty or null root case

        tree = new TreeNode(list.get(0)); // Root node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        for (int i = 1; i < list.size(); i++) {
            TreeNode parent = queue.poll(); // Get the next parent node

            // Assign left child
            if (list.get(i) != null) {
                parent.left = new TreeNode(list.get(i));
                queue.offer(parent.left);
            }

            // Assign right child (ensure within bounds)
            if (++i < list.size() && list.get(i) != null) {
                parent.right = new TreeNode(list.get(i));
                queue.offer(parent.right);
            }
        }
    }


    public TreeNode getTree() {
        return tree;
    }
}
