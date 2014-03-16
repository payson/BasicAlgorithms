package binaryTrees;
import java.util.LinkedList;
/**
 * Created by Payson Wu on 15/03/14.
 * Serialization and Deserialization
 * A binary tree example
 *     _30_
      /    \
    10    20
   /     /  \
 50    45  35
 */
public class Serialization {
    private int index = 0;

    /**
     * will construct a tree like above
     * @param serializedTree pass in a string get from serializeBFS(root)
     * @return
     */
    public TreeNode deserializeBFS(String serializedTree) {
        if (serializedTree.equals("")) return null;
        String[] strings = serializedTree.split(" ");
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
     * return a tree's root by passing in a string
     * the string format is defined as the way in serializePreOrder(TreeNode root)
     * @param serializedTree, a string
     * @return a Tree's root
     */
    public TreeNode deserializePreOrder(String serializedTree) {
        String[] stringArray = serializedTree.split(" ");
        this.index = 0;
        return deserializePreOrder(stringArray, null);
    }

    /**
     * if two tree are in the same structure and contains the same val
     * @param t1
     * @param t2
     * @return
     */
    public static boolean sameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val && sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
    }

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
     * The return string is actually the pre-order traverse of the tree
     * added # as null
     * returned string will be "30 10 50 # # # 20 45 # # 35 # # " for the above example tree
     * @param root, passing in the root of a tree
     */
    public String serializePreOrder(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializePreOrder(root, sb);
        return new String(sb);
    }

    /**
     * @param root
     * @param sb
     */
    private void serializePreOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }
        sb.append(root.val);
        sb.append(" ");
        serializePreOrder(root.left, sb);
        serializePreOrder(root.right, sb);
    }

    /**
     * @param strings
     * @param node
     * @return
     */
    private TreeNode deserializePreOrder(String[] strings, TreeNode node) {
        if (index >= strings.length) {
            return null;
        }
        if (strings[index].equals("#")) {
            index++;
            return null;
        }
        node = new TreeNode(Integer.parseInt(strings[index]));
        index++;
        node.left = deserializePreOrder(strings, null);
        node.right = deserializePreOrder(strings, null);
        return node;
    }
}
