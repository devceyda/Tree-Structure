package Q2;

public class Node {
    Employee employee;
    Node left;
    Node right;

    Node(Employee employee) {
        this.employee = employee;
        left = null;
        right = null;
    }
}
