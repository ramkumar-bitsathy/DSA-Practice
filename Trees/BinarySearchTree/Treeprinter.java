import java.util.*;;
class TreePrinter {
    public static void printTree(TreeNode root) {
        List<List<String>> lines = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>(), next = new ArrayList<>();
        level.add(root);
        int nodeCount = 1, widest = 0;

        while (nodeCount != 0) {
            List<String> line = new ArrayList<>();
            nodeCount = 0;
            for (TreeNode n : level) {
                if (n == null) {
                    line.add(" ");
                    next.add(null);
                    next.add(null);
                } else {
                    String val = Integer.toString(n.data);
                    line.add(val);
                    if (val.length() > widest) widest = val.length();
                    next.add(n.left);
                    next.add(n.right);
                    if (n.left != null) nodeCount++;
                    if (n.right != null) nodeCount++;
                }
            }
            lines.add(line);
            level = next;
            next = new ArrayList<>();
        }

        int height = lines.size(), width = (int) Math.pow(2, height) - 1;
        for (int i = 0; i < height; i++) {
            int indent = (width / (int) Math.pow(2, i + 1));
            for (int j = 0; j < lines.get(i).size(); j++) {
                if (j == 0) {
                    System.out.print(" ".repeat(indent));
                } else {
                    System.out.print(" ".repeat(indent * 2));
                }
                System.out.print(lines.get(i).get(j));
            }
            System.out.println();
        }
    }
}
