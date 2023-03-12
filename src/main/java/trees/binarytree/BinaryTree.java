package trees.binarytree;
import common.Node;
import common.TraversalOrder;

public class BinaryTree {
    Node root;
    private Node insertRecursive(Node current, int elem) {
        if(current == null) {
            return new Node(elem);
        }

        if(elem < current.data) { current.left =  insertRecursive(current.left, elem);}
        else if (elem > current.data) { current.right = insertRecursive(current.right, elem);}
        else { return current;}
        return current;
    }

    /**
    Searching if value is present in tree or not
     */
    private boolean containsNodeRecursive(Node current, int elem) {
        if(current == null)
            return false;

        if(elem == root.data)
            return true;

        return elem < current.data ? containsNodeRecursive(current.left, elem) : containsNodeRecursive(current.right, elem);
    }

    private Node deleteRecursive(Node current, int value) {
        if(current == null)
            return null;

        if(value == current.data) {
            removeNode(current);
        }

        if(value < current.data)
        {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private Node removeNode(Node current){
        if(current.left == null && current.right == null) {
            return null;
        }

        if(current.left == null)
            return current.left;
        if(current.right == null)
            return current.right;

        int smallestValue = findSmallest(current.right);
        current.data = smallestValue;
        current.right = deleteRecursive(current.right, smallestValue);
        return current;
    }

    private int findSmallest(Node root) {
        return root.left == null ? root.data : findSmallest(root.left);
    }

    /**
     * Depth first Search - Traversing the tree as much deep before traversing next sibling
     * InOrder , PreOrder, PostOrder
     */
    private void inOrderTraverse(Node current) {
        if(current != null){
            inOrderTraverse(current.left);
            System.out.println(current.data);
            inOrderTraverse(current.right);
        }
    }

    private void preOrderTraverse(Node current) {
        if(current != null){
            System.out.println(current.data);
            inOrderTraverse(current.left);
            inOrderTraverse(current.right);
        }
    }

    private void postOrderTraverse(Node current) {
        if(current != null){
            inOrderTraverse(current.left);
            inOrderTraverse(current.right);
            System.out.println(current.data);
        }
    }

    public void add(int value){
        root = insertRecursive(root, value);
    }
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    public void delete(int value) {
        root =  deleteRecursive(root, value);
    }

    public void traverse(String order){
        if(order.equalsIgnoreCase(TraversalOrder.IN_ORDER.getName()))
            inOrderTraverse(root);
        else if (order.equalsIgnoreCase(TraversalOrder.PRE_ORDER.getName()))
            preOrderTraverse(root);
        else if (order.equalsIgnoreCase(TraversalOrder.POST_ORDER.getName()))
            postOrderTraverse(root);
    }
}
