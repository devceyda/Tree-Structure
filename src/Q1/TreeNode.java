package Q1;

public class TreeNode {
    private String name;
    private int id;
    private TreeNode parent;
    private TreeNode leftChild;
    private TreeNode rightSibling;

    public TreeNode(String name, int id) {
        this.name = name;
        this.id = id;
        this.parent = null;
        this.leftChild = null;
        this.rightSibling = null;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public TreeNode getParent() {
        return parent;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public TreeNode getRightSibling() {
        return rightSibling;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightSibling(TreeNode rightSibling) {
        this.rightSibling = rightSibling;
    }
}