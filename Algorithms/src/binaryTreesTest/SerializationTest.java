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
    TreeNode treeTest;
    String stringBFS;
    String stringPreOrder;
    Serialization sl;
    @Before
    public void setUp() throws Exception {
        sl = new Serialization();
        stringBFS = "30 10 20 50 # 45 35 # # # # # # ";
        stringPreOrder = "30 10 50 # # # 20 45 # # 35 # # ";
        treeTest = new TreeNode(30);
        treeTest.left = new TreeNode(10);
        treeTest.right = new TreeNode(20);
        treeTest.left.left = new TreeNode(50);
        treeTest.right.left = new TreeNode(45);
        treeTest.right.right = new TreeNode(35);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSerializeBFS() throws Exception {
        String compareString1 = sl.serializeBFS(treeTest);
        Assert.assertEquals(stringBFS, compareString1);
    }

    @Test
    public void testDeserializeBFS() throws Exception {
        TreeNode treeBFSTest = sl.deserializeBFS(stringBFS);
        String compareString1 = sl.serializeBFS(treeBFSTest);
        Assert.assertEquals(stringBFS, compareString1);
        Assert.assertTrue(Serialization.sameTree(treeTest, treeBFSTest));
    }

    @Test
    public void testSerializePreOrder() throws Exception {
        String s = sl.serializePreOrder(treeTest);
        Assert.assertEquals(s, stringPreOrder);
    }

    @Test
    public void testDeserializePreOrder() throws Exception {
        TreeNode treePreOrderTest = sl.deserializePreOrder(stringPreOrder);
        String s = sl.serializePreOrder(treePreOrderTest);
        Assert.assertEquals(stringPreOrder, s);
        Assert.assertTrue(Serialization.sameTree(treeTest, treePreOrderTest));
    }
}
