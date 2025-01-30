public class AVLoperations {
    public static void main(String[] args) {
        {
            AVL avltree = new AVL();
            for(int i= 1;i<=100;i++){
                avltree.insert(i);
            }

            System.out.println(avltree.height());

        }
    }
}
