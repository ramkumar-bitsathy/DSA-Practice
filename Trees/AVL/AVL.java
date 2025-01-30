public class AVL {
    TreeNode root;
    AVL(){
        this.root = null;
    }

    public TreeNode getRoot() {
        return root;
    }


    private int height(TreeNode root){
        if(root == null) return -1;

        int left = height(root.left);
        int right = height(root.right);

        return 1+Math.max(left,right);
    }

    TreeNode rotateRight(TreeNode p){
        if (p == null || p.left == null) return p;
        TreeNode c = p.left;
        TreeNode t = c.right;
        p.left = t;
        c.right = p;
        

        return c;
    }

    TreeNode rotateLeft(TreeNode c){
        if (c == null || c.right == null) return c;
        TreeNode p = c.right;
        TreeNode t = p.left;
        c.right = t;
        p.left = c;
        return p;
    }

    TreeNode rotate(TreeNode root){
        if(height(root.left)-height(root.right)>1){
            TreeNode child = root.left; 
            if(height(child.left)-height(child.right) <0){
                return rotateRight(root);
            }
            else{
                root.left = rotateLeft(root.left);
                return rotateRight(root);
            }
        }

        else if (height(root.left)-height(root.right)<-1){
            TreeNode child = root.right; 
            if(height(child.left)-height(child.right) >0){
                return rotateLeft(root);
            }
            else{
                root.right = rotateRight(root.right);
                return rotateLeft(root);
            }
        }
        return root;

    }
    private TreeNode insert(TreeNode root,int data){
        if(root == null) return new TreeNode(data);

        if (data<root.data){
            root.left = insert(root.left,data);
        }
        if(data>root.data){
            root.right = insert(root.right,data);
        }
        return root;
    }

    public void insert(int data){
        root = insert(root,data);
    }
    public int height(){
        return height(root);
    }

}
