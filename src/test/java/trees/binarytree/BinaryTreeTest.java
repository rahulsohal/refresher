package trees.binarytree;

import common.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BinaryTreeTest {

    BinaryTree tree;
    @BeforeAll
    public void setup(){
        tree = new BinaryTree();
    }

    @Test
    public void testInsertion(){
        tree.add(5);
        tree.add(4);
        tree.add(8);
        tree.add(7);

        Assertions.assertEquals(tree.root.data, 5);
        Assertions.assertEquals(tree.root.left.data , 4);
    }

    @Test
    public void givenBinaryTree_containsTheseElements() {
        tree.add(4);
        tree.add(7);
        tree.add(9);
        Assertions.assertFalse(tree.containsNode(10));
        Assertions.assertTrue(tree.containsNode(7));
    }
    @Test
    public void givenBinaryTree_deleteElement() {
        tree.add(4);
        tree.add(5);
        tree.add(7);
        tree.add(9);
        tree.delete(5);
        tree.traverse("inorder");
        Assertions.assertFalse(tree.containsNode(5));
        tree.traverse("preorder");
    }
}
