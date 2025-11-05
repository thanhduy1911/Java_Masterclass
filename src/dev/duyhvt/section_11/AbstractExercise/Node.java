package dev.duyhvt.section_11.AbstractExercise;

public class Node extends ListItem {
    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return rightLink;
    }

    @Override
    ListItem setNext(ListItem rightLink) {
        return this.rightLink = rightLink;
    }

    @Override
    ListItem previous() {
        return leftLink;
    }

    @Override
    ListItem setPrevious(ListItem leftLink) {
        return this.leftLink = leftLink;
    }

    /* If this value is greater than the value that was passed in, then it
    should return a number greater than zero. If vice versa, then it
    should return a number less than zero, and zero if equal. */
    @Override
    int compareTo(ListItem otherList) {
        int x = Integer.parseInt(String.valueOf(value));
        int y = Integer.parseInt(String.valueOf(otherList.value));
        if (x == y) {
            return 0;
        }

        return x > y ? 1 : -1;
    }
}
