import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeTraversal {

    public static void preorder(TreeNode root,ArrayList<Integer> preorderResult){
        if (root == null) return ;

        preorderResult.add(root.data);
        preorder(root.left,preorderResult);
        preorder(root.right,preorderResult);
        
    }

    public static void inOrder(TreeNode root,ArrayList<Integer> inorderResult){
        if(root == null) return ;
        inOrder(root.left,inorderResult);
        inorderResult.add(root.data);
        inOrder(root.right, inorderResult);
    }

    public static void postOrder(TreeNode root, ArrayList<Integer> postorderResult){
        if (root == null) return ;
        postOrder(root.left,postorderResult);
        postOrder(root.right,postorderResult);
        postorderResult.add(root.data);
    }

    public static void levelOrder(TreeNode root, ArrayList<ArrayList<Integer>> levelorderResult){

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int n = queue.size();
            for(int i= 0;i<n;i++){
                TreeNode node = queue.poll();
                level.add(node.data);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            levelorderResult.add(level);
        }



    }

    public static TreeNode getTree(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left  = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = getTree();

        ArrayList<Integer> preorderRes = new ArrayList<>();
        preorder(root, preorderRes);
        System.out.println("Preorder: "+ preorderRes);

        ArrayList<Integer> inorderRes = new ArrayList<>();
        inOrder(root, inorderRes);
        System.out.println("Inorder: "+ inorderRes);

        ArrayList<Integer> postorderRes = new ArrayList<>();
        postOrder(root, postorderRes);
        System.out.println("Postorder: "+postorderRes);

        ArrayList<ArrayList<Integer>> levelorderRes = new ArrayList<>();
        levelOrder(root, levelorderRes);
        System.out.println("Levelorder: "+levelorderRes);

    }
}
