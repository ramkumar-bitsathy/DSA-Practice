import java.util.*;
public class LockUnlock {
    
    static class Node{
        int data;
        boolean isLock;
        boolean isLockable;
        Node parent;
        List<Node> children;

        Node(int val){
            this.data = val;
            this.children = new ArrayList<>();
            this.isLock = false;
            this.isLockable = true;
        }
        Node(int val,Node parent){
            this.data = val;
            this.children = new ArrayList<>();
            this.isLock = false;
            this.isLockable = true;
            this.parent = parent;
        }

    }

    boolean isLock(Node root){
        return root.isLock;
    }

    void lock(Node root){
        //isLockable - is this node have locking capability
        // if ancestor nodes locked - return;
        //Lock the current node
        // inform all the parent about the current node lock

        if (root.isLockable == false) return;
        Node temp = root;

        while (temp!=null){
            if (temp.isLock == true) return;
            temp = temp.parent;
        }

        root.isLock = true;

        while(root!=null){
            root.isLockable = false;
            root = root.parent;
        }
    }


    public static void main(String[] args) {
        
    }


}