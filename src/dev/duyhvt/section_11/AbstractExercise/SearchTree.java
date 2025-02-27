package dev.duyhvt.section_11.AbstractExercise;

public class SearchTree implements NodeList {
    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem node) {
        // If the head of the tree is null, make the head refer to the item to be added.
        if (root == null) {
            root = node;
            return true;
        }

        ListItem current = root;
        while (true) {
            // equal
            if (current.compareTo(node) == 0) {
                return false;
            }
            // node is smaller, add the item before the current item
            else if (current.compareTo(node) == 1) {
                current.setPrevious(node);
                return true;
            }
            // node is greater and (if there is no next item, then that is where the new item belongs)
            else if (current.next() == null) {
                current.setNext(node);
                return true;
            }
            // node is greater and next not null, move onto the next item and compare again
            current = current.next();
        }
    }

    @Override
    public boolean removeItem(ListItem node) {
        if (node == null || root == null) {
            return false;
        }

        ListItem previous = null;
        while (true) {
            if (node.compareTo(root) == 0) {
                performRemoval(node, previous);
                return true;
            }

            if (root.next() == null) {
                return false;
            }
            previous = root;
            root = root.next();
        }
    }

    // Call performRemoval() from removeItem() when the item is found
    private void performRemoval(ListItem itemToRemove, ListItem parent) {
        // Item to remove has no right child
        if (itemToRemove.next() == null) {
            // itemToRemove is the right child of the parent
            if (parent.next() == itemToRemove) {
                parent.setNext(itemToRemove.previous());
            }
            // itemToRemove is the left child of the parent
            else if (parent.previous() == itemToRemove) {
                parent.setPrevious(itemToRemove.previous());
            }
            // itemToRemove is the root
            else {
                root = itemToRemove.previous();
            }
        }
        // Item to remove has no left child
        else if (itemToRemove.previous() == null) {
            // itemToRemove is the right child of the parent
            if (parent.next() == itemToRemove) {
                parent.setNext(itemToRemove.next());
            }
            // itemToRemove is the left child of the parent
            else if (parent.previous() == itemToRemove) {
                parent.setPrevious(itemToRemove.next());
            }
            // itemToRemove is the root
            else {
                root = itemToRemove.next();
            }
        }
        // Item to remove has both left and right children
        else {
            ListItem current = itemToRemove.next();
            ListItem leftMostParent = itemToRemove;

            while (current.previous() != null) {
                leftMostParent = current;
                current = current.previous();
            }

            itemToRemove.setValue(current.getValue());

            if (leftMostParent == itemToRemove) {
                itemToRemove.setNext(current.next());
            } else {
                leftMostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        // Inorder = left -> node -> right
        if (root == null) {
            return;
        }
        traverse(root.previous());
        System.out.println(root.getValue());
        traverse(root.next());
    }
}