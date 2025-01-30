import java.util.*;
public class NaryTraversal {

    public static void preOrder(TreeNode root,ArrayList<Integer> preorderResult) {
        if (root == null)
            return;

        preorderResult.add(root.data);

        for (int index = 0; index < root.children.size(); index++) {
            preOrder(root.children.get(index),preorderResult);
        }
    }

    public static void postOrder(TreeNode root,ArrayList<Integer> postorderResult) {
        if (root == null)
            return;
        int length = root.children.size();
        for (int index = 0; index < length; index++) {
            postOrder(root.children.get(index),postorderResult);
        }

        postorderResult.add(root.data);
    }

    public static void inOrder(TreeNode root,ArrayList<Integer> inorderResult) {
        if (root == null)
            return;
        int length = root.children.size();

        for (int index = 0; index < length - 1; index++) {
            inOrder(root.children.get(index),inorderResult);
        }

        inorderResult.add(root.data);
        if (length > 0)
            inOrder(root.children.get(length - 1),inorderResult);

    }

    /*public int depth(TreeNode root) {
        for (int index = 0; index < root.children.size(); index++) {
            depth(root);
        }

    }*/

    public static void levelOrder(TreeNode root,ArrayList<ArrayList<Integer>> leverorderResult){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int s = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i= 0;i<s;i++){
                TreeNode node = queue.poll();
                level.add(node.data);
                
                for(TreeNode eachNode: node.children){
                    queue.offer(eachNode);
                }
            }
            leverorderResult.add(level);
        }
    }
    private static void reverseList(ArrayList<Integer> list){
        Collections.reverse(list);
    }

    public static void zigzagLevelOrderTraversal(TreeNode root,ArrayList<ArrayList<Integer>> leverorderResult){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level_count = 0;
        while(!queue.isEmpty()){
            int s = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i= 0;i<s;i++){
                TreeNode node = queue.poll();
                level.add(node.data);
                
                for(TreeNode eachNode: node.children){
                    queue.offer(eachNode);
                }
            }
            if (level_count%2!= 0){
                reverseList(level);
                leverorderResult.add(level);
            }
            else{
                leverorderResult.add(level);
            }
            level_count+=1;
        }
    }

    

    public static void main(String[] args) {
        NAryTree tree = new NAryTree();

        tree.constructTree();

        TreeNode root = tree.getRoot();
        ArrayList<Integer> preorder = new ArrayList<>();
        preOrder(root,preorder);
        System.out.println("Preorder: "+preorder);

        ArrayList<Integer> postorder = new ArrayList<>();
        postOrder(root,postorder);
        System.out.println("Postorder: "+postorder);

        ArrayList<Integer> inorder = new ArrayList<>();
        inOrder(root,inorder);
        System.out.println("Inorder: "+inorder);


        ArrayList<ArrayList<Integer>> levelorderResult = new ArrayList<>();
        levelOrder(root,levelorderResult);
        System.out.println("Level order: "+levelorderResult);

        ArrayList<ArrayList<Integer>> zigzaglevelorderResult = new ArrayList<>();
        zigzagLevelOrderTraversal(root,zigzaglevelorderResult);
        System.out.println("ZigZag Level order: "+zigzaglevelorderResult);

    }
}
