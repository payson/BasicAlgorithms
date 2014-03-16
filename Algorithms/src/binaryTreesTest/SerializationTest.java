package binaryTreesTest;
import binaryTrees.Serialization;
import binaryTrees.TreeNode;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by Payson Wu on 15/03/14.
 */
public class SerializationTest {
    TreeNode tree1;
    String stringBFS;
    String string2;
    Serialization sl;
    @Before
    public void setUp() throws Exception {
        sl = new Serialization();
        stringBFS = "30 10 20 50 # 45 35 # # # # # # ";
        string2 = "30 10 50 # # # 20 45 # # 35 # # ";
        tree1 = new TreeNode(30);
        tree1.left = new TreeNode(10);
        tree1.right = new TreeNode(20);
        tree1.left.left = new TreeNode(50);
        tree1.right.left = new TreeNode(45);
        tree1.right.right = new TreeNode(35);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSerializeBFS() throws Exception {
        String compareString1 = sl.serializeBFS(tree1);
        Assert.assertEquals(stringBFS, compareString1);
    }

    @Test
    public void testDeserializeBFS() throws Exception {
        TreeNode tree2 = sl.deserializeBFS(stringBFS);
        String compareString1 = sl.serializeBFS(tree2);
        Assert.assertEquals(stringBFS, compareString1);
        Assert.assertTrue(Serialization.sameTree(tree1, tree2));
    }

    @Test
    public void testSerialize() throws Exception {
        StringBuilder sb = new StringBuilder();
        sl.serialize(tree1, sb);
        Assert.assertEquals(new String(sb), string2);
    }

    @Test
    public void testDeserialize() throws Exception {
        TreeNode tree3 = sl.deserialize(string2.split(" "), null);
        StringBuilder sb = new StringBuilder();
        sl.serialize(tree3, sb);
        Assert.assertEquals(string2, new String(sb));
        Assert.assertTrue(Serialization.sameTree(tree1, tree3));
    }
}
