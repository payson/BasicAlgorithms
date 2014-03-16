package binaryTrees;
import java.util.LinkedList;
/**
 * Created by Payson Wu on 15/03/14.
 * Serialization and Deserialization
 *     _30_
      /    \
    10    20
   /     /  \
 50    45  35
 */
public class Serialization {
    /**
     * serializeBFS will give the a String like "30 10 20 50 # 45 35 # # # # # #" for the above tree
     * @param root
     * @return
     */
    public String serializeBFS(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return new String(sb);
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.removeFirst();
            if (p != null) {
                sb.append(p.val);
                sb.append(" ");
                queue.addLast(p.left);
                queue.addLast(p.right);
            } else {
                sb.append("# ");
            }
        }
        return new String(sb);
    }

    /**
     * will construct a tree like above
     * @param s pass in a string get from serializeBFS(root)
     * @return
     */
    public TreeNode deserializeBFS(String s) {
        if (s.equals("")) return null;
        String[] strings = s.split(" ");
        if (strings[0].equals("#")) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode result = new TreeNode(Integer.parseInt(strings[0]));
        TreeNode root = result;
        queue.addLast(root);
        int i = 1;
        while (!queue.isEmpty() && i < strings.length) {
            root = queue.removeFirst();
            if (!strings[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(strings[i]));
                queue.addLast(left);
                root.left = left;
            } else {
                root.left = null;
            }
            i++;
            if (i >= strings.length) break;
            if (!strings[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(strings[i]));
                queue.addLast(right);
                root.right = right;
            } else {
                root.right = null;
            }
            i++;
        }
        return result;
    }

    /**
     * should be used as
     * StringBuilder sb = new StringBuilder();
     * serialize(root, sb);
     * String result = new String(sb);
     * @param root, passing in the root of a tree
     * @param sb, passing in an empty StringBuilder sb
     */
    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }
        sb.append(root.val);
        sb.append(" ");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    /**
     * should be used as
     * deserialize(strings, null);
     */
    private int index = 0;
    public TreeNode deserialize(String[] strings, TreeNode node) {
        if (index >= strings.length) {
            return null;
        }
        if (strings[index].equals("#")) {
            index++;
            return null;
        }
        node = new TreeNode(Integer.parseInt(strings[index]));
        index++;
        node.left = deserialize(strings, null);
        node.right = deserialize(strings, null);
        return node;
    }

    public static boolean sameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val && sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
    }
}
