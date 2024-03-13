package Q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FamilyTree {
    private TreeNode root;

    public void createFamilyTree(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                String[] parentTokens = tokens[0].trim().split(" ");
                String[] childTokens = tokens[1].trim().split(" ");

                String parentName = parentTokens[0];
                int parentId = Integer.parseInt(parentTokens[1]);
                String childName = childTokens[0];
                int childId = Integer.parseInt(childTokens[1]);

                TreeNode parent = findOrCreateNode(parentName, parentId);
                TreeNode child = findOrCreateNode(childName, childId);

                if (parent != null && child != null) {
                    if (parent.getLeftChild() == null) {
                        parent.setLeftChild(child);
                    } else {
                        TreeNode sibling = parent.getLeftChild();
                        while (sibling.getRightSibling() != null) {
                            sibling = sibling.getRightSibling();
                        }
                        sibling.setRightSibling(child);
                    }
                    child.setParent(parent);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private TreeNode findOrCreateNode(String name, int id) {
        TreeNode node = findPersonById(id);
        if (node != null) {
            return node;
        } else {
            TreeNode newNode = new TreeNode(name, id);
            if (root == null) {
                root = newNode;
            }
            return newNode;
        }
    }

    private TreeNode findPersonById(int id) {
        return findPersonById(root, id);
    }

    private TreeNode findPersonById(TreeNode current, int id) {
        if (current == null) {
            return null;
        }
        if (current.getId() == id) {
            return current;
        }
        TreeNode child = findPersonById(current.getLeftChild(), id);
        if (child != null) {
            return child;
        }
        return findPersonById(current.getRightSibling(), id);
    }

    public void printAllDescendants(int id) {
        TreeNode person = findPersonById(id);
        if (person != null) {
            printDescendants(person.getLeftChild());
        }
    }

    private void printDescendants(TreeNode person) {
        if (person == null) {
            return;
        }

        System.out.print(person.getName());
        System.out.print(", ");

        printDescendants(person.getLeftChild());
        printDescendants(person.getRightSibling());
    }

    public boolean checkAncestor(int ancestorId, int descendantId) {
        TreeNode ancestor = findPersonById(ancestorId);
        TreeNode descendant = findPersonById(descendantId);

        if (ancestor == null || descendant == null) {
            return false;
        }

        // Check if the ancestor is a parent of the descendant or not
        while (descendant != null) {
            if (descendant.getParent() == ancestor) {
                return true;
            }
            descendant = descendant.getParent();
        }

        return false;
    }

    public boolean checkDescendant(int descendantId, int ancestorId) {
        TreeNode descendant = findPersonById(descendantId);
        TreeNode ancestor = findPersonById(ancestorId);

        if (descendant == null || ancestor == null) {
            return false;
        }

        // Check whether the descendant is a child or descendant of the ancestor or not
        while (descendant != null) {
            if (descendant.getParent() == ancestor) {
                return true;
            }
            descendant = descendant.getParent();
        }

        return false;
    }

    public boolean checkSibling(int id1, int id2) {
        TreeNode person1 = findPersonById(id1);
        TreeNode person2 = findPersonById(id2);

        if (person1 == null || person2 == null || person1 == person2) {
            return false;
        }

        TreeNode parent1 = person1.getParent();
        TreeNode parent2 = person2.getParent();

        if (parent1 != null && parent2 != null && parent1 == parent2) {
            return true;
        }
        return false;
    }

    public String findFirstOldestCommonRelative(int id1, int id2) {
        TreeNode person1 = findPersonById(id1);
        TreeNode person2 = findPersonById(id2);

        if (person1 == null || person2 == null) {
            return null;
        }

        TreeNode parent1 = person1.getParent();
        TreeNode parent2 = person2.getParent();

        while (parent1 != null) {
            TreeNode current = parent2;
            while (current != null) {
                if (parent1 == current) {
                    return parent1.getName();
                }
                current = current.getParent();
            }
            parent1 = parent1.getParent();
        }

        return null; // There is no common relative found
    }

}
