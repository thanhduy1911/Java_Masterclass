package dev.duyhvt.section_11.AbstractExercise;

public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem node);
    boolean removeItem(ListItem node);
    void traverse(ListItem root);
}
