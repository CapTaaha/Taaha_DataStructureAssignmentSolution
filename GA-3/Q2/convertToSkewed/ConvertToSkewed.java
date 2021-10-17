public class ConvertToSkewed {

    static class Node {
        Node left;
        Node right;
        int data;
    };

    static Node newNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    public static Node node;
    static Node prevNode = null;
    static Node headNode = null;

    public static void main(String[] args) {

        Node root = newNode(50);
        root.left = newNode(30);
        root.right = newNode(60);
        root.left.left = newNode(10);
        root.right.left = newNode(40);

        int order = 0;
        skewed(node, order);
        traverseRightSkewed(headNode);
    }

    static void skewed(Node root, int order) {

        Node headNode = null;
        Node prevNode = null;

        // Base Case
        if (root == null)
            return;

        // To check the order in which the skewed tree should be made
        if (order > 0) {
            skewed(root.right, order);
        } else {
            skewed(root.left, order);
        }

        Node leftNode = root.left;
        Node rightNode = root.right;

        // To check if the root Node of the skewed tree is not defined
        if (headNode == null) {
            headNode = root;
            root.left = null;
            prevNode = root;
        } else {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }

        if (order > 0) {
            skewed(leftNode, order);
        } else {
            skewed(rightNode, order);
        }
    }

    static void traverseRightSkewed(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        traverseRightSkewed(root.right);
    }

}
