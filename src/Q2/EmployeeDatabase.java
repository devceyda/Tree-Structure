package Q2;

public class EmployeeDatabase {
    private Node root;

    public void insertEmployee(int id, String name, boolean gender) {
        Employee newEmployee = new Employee(id, name, gender);
        root = insertNodeToDatabase(root, newEmployee);
    }

    private Node insertNodeToDatabase(Node root, Employee employee) {
        if (root == null) {
            root = new Node(employee);
            return root;
        }

        if (employee.id < root.employee.id)
            root.left = insertNodeToDatabase(root.left, employee);
        else if (employee.id > root.employee.id)
            root.right = insertNodeToDatabase(root.right, employee);

        return root;
    }

    public void deleteEmployee(int id) {
        root = deleteNodeFromDatabase(root, id);
    }

    private Node deleteNodeFromDatabase(Node root, int id) {
        if (root == null)
            return root;

        if (id < root.employee.id)
            root.left = deleteNodeFromDatabase(root.left, id);
        else if (id > root.employee.id)
            root.right = deleteNodeFromDatabase(root.right, id);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.employee = findMinValueInTree(root.right).employee;
            root.right = deleteNodeFromDatabase(root.right, root.employee.id);
        }

        return root;
    }

    private Node findMinValueInTree(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    public void searchEmployee(int id) {
        Node result = searchNodeInDatabase(root, id);
        if (result == null) {
            System.out.println("No record found.");
        } else {
            String gender;
            if (result.employee.gender == true) {
                gender = "Female";
            } else {
                gender = "Male";
            }
            System.out.println(result.employee.id + " " + result.employee.name + " " + gender);
        }
    }

    private Node searchNodeInDatabase(Node root, int id) {
        if (root == null || root.employee.id == id)
            return root;

        if (id < root.employee.id)
            return searchNodeInDatabase(root.left, id);

        return searchNodeInDatabase(root.right, id);
    }

    public void listAllEmployees() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root != null) {
            traverseInOrder(root.left);
            String gender;
            if (root.employee.gender == true) {
                gender = "Female";
            } else {
                gender = "Male";
            }
            System.out.println(root.employee.id + " " + root.employee.name + " " + gender);
            traverseInOrder(root.right);
        }
    }

    public void listAllEmployeesWithRange(int minId, int maxId) {
        boolean found = traverseInOrderWithRange(root, minId, maxId);
        if (!found) {
            System.out.println("No record found.");
        }
    }

    private boolean traverseInOrderWithRange(Node root, int minId, int maxId) {
        if (root != null) {
            boolean found = false;

            if (root.employee.id > minId)
                found = traverseInOrderWithRange(root.left, minId, maxId);

            if (root.employee.id >= minId && root.employee.id <= maxId) {
                String gender;
                if (root.employee.gender == true) {
                    gender = "Female";
                } else {
                    gender = "Male";
                }
                System.out.println(root.employee.id + " " + root.employee.name + " " + gender);
                found = true;
            }

            if (root.employee.id < maxId)
                found = found || traverseInOrderWithRange(root.right, minId, maxId);

            return found;
        }
        return false;
    }
}
