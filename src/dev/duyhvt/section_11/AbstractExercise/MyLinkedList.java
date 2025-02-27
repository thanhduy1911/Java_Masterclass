package dev.duyhvt.section_11.AbstractExercise;

public class MyLinkedList implements NodeList {
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem node) {
        // the list is empty so the item becomes the head of the list
        if (root == null) {
            root = node;
            return true;
        }

        ListItem current = root;
        //while (true) {
            // if there is no next item, we insert this item at the end of the list
            if (current.next() == null) {
                current.setNext(node);
                node.setPrevious(current);
                return true;
            }
            /// if there is a next item and a new item is smaller, insert this
            // item before current
            if (current.compareTo(node) == 1) {
                root = node;
                root.setNext(node);
                current.setPrevious(root);
                return true;
            }
            return false;
        //}
    }

    @Override
    public boolean removeItem(ListItem node) {
        if (root == null || node == null) {
            return false;
        }
        while (true) {
            if (node.compareTo(root) == 0) {
                root.previous().setNext(null);
                return true;
            }
            root = root.next();
            if (root == null) {
                return false;
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.print("The list is empty");
        }
        while (root != null) {
            System.out.println(root.getValue());
            root = root.next();
        }
    }
}
