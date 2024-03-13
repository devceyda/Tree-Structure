package Q2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeDatabase empData = new EmployeeDatabase();
        boolean checker = true;

        while (checker) {
            System.out.println("Enter operation code:");
            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.println("Enter information:");
                    int id = scanner.nextInt();
                    String name = scanner.next();
                    String gender = scanner.next();
                    if (gender.equalsIgnoreCase("Male")) {
                        empData.insertEmployee(id, name, false);
                    } else if (gender.equalsIgnoreCase("Female")) {
                        empData.insertEmployee(id, name, true);
                    }
                    break;
                case 2:
                    System.out.println("Enter ID to be deleted:");
                    int idOfDeletedEmployee = scanner.nextInt();
                    empData.deleteEmployee(idOfDeletedEmployee);
                    break;
                case 3:
                    System.out.println("Enter ID to be searched:");
                    int searchId = scanner.nextInt();
                    empData.searchEmployee(searchId);
                    break;
                case 4:
                    empData.listAllEmployees();
                    break;
                case 5:
                    System.out.println("Enter bounds of range:");
                    int id1 = scanner.nextInt();
                    int id2 = scanner.nextInt();
                    empData.listAllEmployeesWithRange(id1, id2);
                    break;
                case 6:
                    System.out.println("Stopped!");
                    checker = false;
                    break;

                default:
                    break;
            }

        }
    }
}
