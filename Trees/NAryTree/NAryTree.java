import java.util.ArrayList;
import java.util.List;

class TreeNode{

    int data;

    List<TreeNode> children;

    public TreeNode left;

    public TreeNode right;
    TreeNode(int data){
        this.data = data;
        this.children = new ArrayList<>();
    }
}

public class NAryTree {
    
    TreeNode root;
    NAryTree(){
        this.root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    void constructTree(){
        this.root = new TreeNode(1);
        this.root.children.add(new TreeNode(2));
        this.root.children.get(0).children.add(new TreeNode(3));
        this.root.children.get(0).children.add(new TreeNode(4));
        this.root.children.get(0).children.add(new TreeNode(6));

        this.root.children.add(new TreeNode(5));
        this.root.children.get(1).children.add(new TreeNode(7));

        this.root.children.add(new TreeNode(8));
        this.root.children.get(2).children.add(new TreeNode(9));
        this.root.children.get(2).children.add(new TreeNode(11));
    }
}



