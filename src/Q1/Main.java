package Q1;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    FamilyTree familyTree = new FamilyTree();

    System.out.print("Enter filename: ");
    String filename = scanner.next();
    familyTree.createFamilyTree(filename);

    while (true) {
      System.out.println("Enter operation code:");
      /*
       * System.out.println("1 -> Print All Descendants");
       * System.out.println("2 -> Check Ancestor");
       * System.out.println("3 -> Check Descendant");
       * System.out.println("4 -> Check Sibling");
       * System.out.println("5 -> Find Oldest Common Relative");
       * System.out.println("6 -> Quit");
       */

      int code = scanner.nextInt();

      if (code == 1) {
        System.out.println("Enter ID: ");
        int ID = scanner.nextInt();
        familyTree.printAllDescendants(ID);
        System.out.println();
      } else if (code == 2) {
        System.out.println("Enter IDs: ");
        int ID1 = scanner.nextInt();
        int ID2 = scanner.nextInt();
        if (familyTree.checkAncestor(ID1, ID2) == true) {
          System.out.println("True");
        } else {
          System.out.println("False");
        }
      } else if (code == 3) {
        System.out.println("Enter IDs: ");
        int ID1 = scanner.nextInt();
        int ID2 = scanner.nextInt();
        if (familyTree.checkDescendant(ID1, ID2) == true) {
          System.out.println("True");
        } else {
          System.out.println("False");
        }
      } else if (code == 4) {
        System.out.println("Enter IDs: ");
        int ID1 = scanner.nextInt();
        int ID2 = scanner.nextInt();
        if (familyTree.checkSibling(ID1, ID2) == true) {
          System.out.println("True");
        } else {
          System.out.println("False");
        }
      } else if (code == 5) {
        System.out.println("Enter IDs: ");
        int ID1 = scanner.nextInt();
        int ID2 = scanner.nextInt();
        String oldestCommonRelative = familyTree.findFirstOldestCommonRelative(ID1, ID2);
        System.out.println(oldestCommonRelative);
      } else if (code == 6) {
        System.out.println("Stopped!");
        break;
      }
    }

    scanner.close();
  }

}
